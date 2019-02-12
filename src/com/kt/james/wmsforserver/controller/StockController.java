package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.DaySaleBean;
import com.kt.james.wmsforserver.dao.StockDao;
import com.kt.james.wmsforserver.dto.DaySaleDto;
import com.kt.james.wmsforserver.po.Stock;
import com.kt.james.wmsforserver.util.StringUtil;
import com.kt.james.wmsforserver.util.VerificationUtil;

public class StockController {

    public DaySaleDto getSale(String company_id, String user_id, String item_id) {

        Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        Integer realItemId = StringUtil.parseInt(item_id);
        DaySaleDto dto = new DaySaleDto();
        if (realCompanyId == null || realUserId == null || realItemId == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("参数不合法");
            return dto;
        }
        if (!VerificationUtil.verifityLogin(realCompanyId, realUserId)) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("未验证的登陆态");
            return dto;
        }
        Stock stock = StockDao.getStock(realCompanyId, realItemId);
        if (stock == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("找不到该商品信息");
            return dto;
        }
        DaySaleBean bean = new DaySaleBean();
        bean.setItem_id(stock.getItem_id());
        bean.setAvailable_num(stock.getAvailable_num());
        bean.setDay_sale(stock.getMonth_sale());
        bean.setMonth_sale(stock.getMonth_sale());
        dto.setResult(bean);
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
