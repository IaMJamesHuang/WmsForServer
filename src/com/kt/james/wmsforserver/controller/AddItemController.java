package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.dao.*;
import com.kt.james.wmsforserver.dto.AddItemDto;
import com.kt.james.wmsforserver.po.*;
import com.kt.james.wmsforserver.util.StringUtil;

public class AddItemController {

    public static AddItemDto addItem(String barcode, String company_id, String amount, String loc) {
        AddItemDto dto = new AddItemDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        Float realAmount = StringUtil.parseFloat(amount);
        //校验数据合法性
        if (realCompanyId == null || StringUtil.isEmpty(barcode) || StringUtil.isEmpty(loc)
                || realAmount == null || realAmount <= 0) {
            dto.setResponseCode(404);
            dto.setResponseMsg("数据不合法");
            return dto;
        }
        //校验公司是否存在
        Company company = CompanyDao.getCompanyById(realCompanyId);
        if (company == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("公司不存在");
            return dto;
        }
        //校验商品是否存在
        Item item = ItemDao.getItemByBarcode(barcode);
        if (item == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("商品不存在");
            return dto;
        }
        //校验库位是否存在
        Location location = LocationDao.getLocation(loc, realCompanyId);
        if (location == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("库位不存在");
            return dto;
        }
        //校验库位是否有足够的容量
        float available_num = location.getAvailable_num();
        if (available_num < realAmount) {
            dto.setResponseCode(404);
            dto.setResponseMsg("库位容量不足");
            return dto;
        }
        //1.公司-商品表：没有记录则插入
        ItemCompany itemCompany = ItemCompanyDao.getBarcode(barcode, realCompanyId);
        if (itemCompany == null) {
            ItemCompanyDao.insertItemCompany(item.getId(), company.getId());
        }
        //2.商品-库位表：没有记录则插入，否则更新
        ItemLoc itemLoc = ItemLocDao.findItemLoc(company.getId(), item.getId(), location.getId());
        if (itemLoc == null) {
            ItemLocDao.insertItemLoc(company.getId(), item.getId(), location.getId(), realAmount);
        } else {
            ItemLocDao.updateItemLoc(company.getId(), item.getId(), location.getId(), itemLoc.getStock_count() + realAmount);
        }
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
