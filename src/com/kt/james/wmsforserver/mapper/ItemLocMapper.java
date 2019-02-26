package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.ItemLoc;
import com.kt.james.wmsforserver.po.Location;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface ItemLocMapper {

    void insertItemLoc(int company_id, int item_id, int loc_id, float stock_count) throws IOException;

    ItemLoc findItemLoc(int company_id, int item_id, int loc_id) throws IOException;

    void updateItemLoc(int company_id, int item_id, int loc_id, float stock_count) throws IOException;

    void deleteItemLoc(int id) throws IOException;

    List<Location> findItemLocList(int company_id, int item_id) throws IOException;

}
