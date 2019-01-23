package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.ItemMapper;
import com.kt.james.wmsforserver.po.Item;
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
        return result;
    }

}
