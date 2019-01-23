package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Item;

import java.io.IOException;

public interface ItemMapper {

    public Item findItemByBarcode(String barcode) throws IOException;

}
