package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.ItemCompany;

import java.io.IOException;

public interface ItemCompanyMapper {

    public ItemCompany findItemBarcode(String barcode, int company_id) throws IOException;

    public void insertItemCompany(int item_id, int company_id) throws IOException;

}
