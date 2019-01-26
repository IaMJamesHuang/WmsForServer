package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.ItemLoc;

import java.io.IOException;

public interface ItemLocMapper {

    void insertItemLoc(int company_id, int item_id, int loc_id, float stock_count) throws IOException;

    ItemLoc findItemLoc(int company_id, int item_id, int loc_id) throws IOException;

    void updateItemLoc(int company_id, int item_id, int loc_id, float stock_count) throws IOException;

    void deleteItemLoc(int id) throws IOException;

}
