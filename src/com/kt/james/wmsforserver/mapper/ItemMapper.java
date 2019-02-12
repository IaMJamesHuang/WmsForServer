package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Item;

import java.io.IOException;
import java.util.List;

public interface ItemMapper {

    Item findItemByBarcode(String barcode) throws IOException;

    void insertItem(Item item) throws IOException;

    List<Item> findCompanyItems(int companyId) throws IOException;

}
