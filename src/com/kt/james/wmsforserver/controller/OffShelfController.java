package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.dao.ItemLocDao;
import com.kt.james.wmsforserver.dao.LocationDao;
import com.kt.james.wmsforserver.dto.OffShelfDto;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.po.ItemLoc;
import com.kt.james.wmsforserver.po.Location;
import com.kt.james.wmsforserver.util.StringUtil;

public class OffShelfController {


    public static OffShelfDto doOffShelf(String company_id, String barcode, String loc, String amount) {
        OffShelfDto dto = new OffShelfDto();
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
        //校验该库位是否存在对应商品
        ItemLoc itemLoc = ItemLocDao.findItemLoc(realCompanyId, item.getId(), location.getId());
        if (itemLoc == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("该库位不存在对应的商品");
            return dto;
        }
        //校验该库位的库存是否足够扣除
        float locNum = itemLoc.getStock_count();
        float dif = locNum - realAmount;
        if (dif < 0) {
            dto.setResponseCode(404);
            dto.setResponseMsg("该库位对应商品库存不足");
            return dto;
        } else if (dif == 0) {
            //删除此记录
            ItemLocDao.deleteItemLoc(itemLoc.getId());
        } else {
            ItemLocDao.updateItemLoc(realCompanyId, item.getId(), location.getId(), dif);
        }
        dto.setResponseCode(200);
        dto.setResponseMsg("请求成功");
        return dto;
    }

}
