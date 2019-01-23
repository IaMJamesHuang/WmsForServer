package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.ItemMapper;
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
            // 从网络获取
        }
        return result;
    }

}
