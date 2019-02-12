package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.StcokMapper;
import com.kt.james.wmsforserver.po.Stock;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class StockDao {

    public static Stock getStock(int companyId, int itemId) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        StcokMapper mapper = sqlSession.getMapper(StcokMapper.class);
        Stock stock = null;
        try {
            stock = mapper.getStockByItemId(companyId, itemId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return stock;
    }

}
