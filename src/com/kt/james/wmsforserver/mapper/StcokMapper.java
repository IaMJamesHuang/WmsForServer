package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Stock;

import java.io.IOException;

public interface StcokMapper {


    Stock getStockByItemId(int companyId, int itemId) throws IOException;

    void updateStock(Stock stock) throws IOException;

}
