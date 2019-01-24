package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.bean.GetBarcodePOJO;
import com.kt.james.wmsforserver.mapper.ItemMapper;
import com.kt.james.wmsforserver.okhttp.ApiManagement;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ItemDao {

    public static Item getItemByBarcode(String barcode) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item result =  null;
        try {
            result = mapper.findItemByBarcode(barcode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        if (result == null || StringUtil.isEmpty(result.getBarcode())) {
            GetBarcodePOJO remoteData = ApiManagement.requestBarcode(barcode);
            if (remoteData != null) {
                GetBarcodePOJO.DataBean.ShowapiResBodyBean dataBean
                        = remoteData.getData().getShowapi_res_body();
                result = new Item();
                result.setBarcode(dataBean.getCode());
                result.setName(dataBean.getGoodsName());
                result.setSpec(dataBean.getSpec());
                result.setFactory(dataBean.getManuName());
                //字符串太长了，后面图片调试再改数据库
//                result.setImg_path(dataBean.getImg());
                insertItem(result);
            }
        }
        return result;
    }

    public static boolean insertItem(Item item) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        boolean result = false;
        try {
            mapper.insertItem(item);
            sqlSession.commit();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

}
