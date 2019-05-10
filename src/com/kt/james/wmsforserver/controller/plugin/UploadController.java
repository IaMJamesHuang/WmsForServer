package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.PluginDao;
import com.kt.james.wmsforserver.dto.UploadPluginDto;
import com.kt.james.wmsforserver.po.Plugin;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class UploadController {

    public static UploadPluginDto uploadPlugin(HttpServletRequest req) {
        String savePath = "D:\\plugin";
        File file = new File(savePath);
        UploadPluginDto dto = new UploadPluginDto();
        String message = "";
        String pluginName = "default";
        String version = "1";
        String fileName = "";
        if (!file.exists() && !file.mkdir()) {
            message = "服务器创建文件夹失败";
            dto.setResponseMsg(message);
            dto.setResponseCode(500);
            return dto;
        }
        try {
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //3、判断提交上来的数据是否是上传表单的数据
            boolean isMultipart= ServletFileUpload.isMultipartContent(req);  //enctype属性是否是multipart/form-data
            if (isMultipart) {
                //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                List<FileItem> list = upload.parseRequest(req);
                for (FileItem item : list) {
                    //如果fileitem中封装的是普通输入项的数据
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        //解决普通输入项的数据的中文乱码问题
                        String value = item.getString("UTF-8");
                        if("pluginName".equals(name)) {
                            pluginName = value;
                        } else if("version".equals(name)) {
                            version = value;
                        }
                    } else {//如果fileitem中封装的是上传文件
                        String filename = item.getName();
                        if (filename == null || filename.trim().equals("")) {
                            continue;
                        }
                        //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                        //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                        filename = filename.substring(filename.lastIndexOf("\\") + 1);
                        fileName = filename;

                        //获取item中的上传文件的输入流
                        InputStream in = item.getInputStream();
                        //创建一个文件输出流
                        FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                        //创建一个缓冲区
                        byte buffer[] = new byte[1024];
                        //判断输入流中的数据是否已经读完的标识
                        int len = 0;
                        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                        while ((len = in.read(buffer)) > 0) {
                            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                            out.write(buffer, 0, len);
                        }
                        //关闭输入流
                        in.close();
                        //关闭输出流
                        out.close();
                        //删除处理文件上传时生成的临时文件
                        item.delete();
                        message = "文件上传成功！";
                    }
                }
            } else {
                message = "不是表单";
            }
        } catch (Exception e) {
            message= "文件上传失败！";
        }
        File target = new File(savePath + File.separator + fileName);
        if (target.exists()) {
            long time = System.currentTimeMillis();
            String[] arr = fileName.split("\\.");
            //删除原有的插件
            File dir = new File(savePath);
            for (File child : dir.listFiles()) {
                String name = child.getName();
                if (name.startsWith(pluginName + "_")) {
                    child.delete();
                }
            }
            //更新数据库信息
            Plugin plugin = new Plugin();
            plugin.setName(pluginName);
            plugin.setVersion(version);
            plugin.setTime(System.currentTimeMillis());
            PluginDao.updatePlugin(plugin);

            //重命名
            String realName = pluginName + "_" + time + "." + arr[1];
            target.renameTo(new File(savePath + File.separator + realName));
        }
        dto.setResponseMsg(message);
        dto.setResponseCode(200);
        return dto;
    }

}
