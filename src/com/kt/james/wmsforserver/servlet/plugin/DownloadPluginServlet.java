package com.kt.james.wmsforserver.servlet.plugin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "downloadPlugin", urlPatterns = "/downloadPlugin")
public class DownloadPluginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("filename");
        String savePath = "D:\\plugin";
        String filePath = savePath + "\\" + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        //设置响应头，控制浏览器下载该文件
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream in = new FileInputStream(filePath);
        OutputStream out = resp.getOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
