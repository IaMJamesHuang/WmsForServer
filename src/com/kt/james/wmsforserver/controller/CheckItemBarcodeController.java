package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.CheckBarcodeBean;
import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.dto.CheckItemBarcodeDto;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.util.StringUtil;

public class CheckItemBarcodeController {

    public static CheckItemBarcodeDto checkItemBarcode(String barcode, String company_id) {
        CheckItemBarcodeDto dto = new CheckItemBarcodeDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        if (realCompanyId == null) {
            dto.setResult(null);
            dto.setResponseMsg("公司ID不合法");
            dto.setResponseCode(404);
            return dto;
        }
        if (StringUtil.isEmpty(barcode)) {
            dto.setResult(null);
            dto.setResponseMsg("条码不能为空");
            dto.setResponseCode(404);
            return dto;
        }
        Company company = CompanyDao.getCompanyById(realCompanyId);
        //todo:后面改为用token验证
        if (company == null) {
            dto.setResult(null);
            dto.setResponseMsg("未验证的登陆态");
            dto.setResponseCode(404);
            return dto;
        }
        Item item = ItemDao.getItemByBarcode(barcode);
        if (item == null) {
            dto.setResult(null);
            dto.setResponseMsg("找不到对应的商品信息");
            dto.setResponseCode(404);
            return dto;
        }
        CheckBarcodeBean bean = new CheckBarcodeBean();
        bean.setId(item.getId());
        bean.setBarcode(item.getBarcode());
        bean.setFactory(item.getFactory());
        bean.setName(item.getName());
        bean.setImg_path(item.getImg_path());
        bean.setSpec(item.getSpec());
        dto.setResult(bean);
        dto.setResponseMsg("请求成功");
        dto.setResponseCode(200);
        return dto;
    }

}
