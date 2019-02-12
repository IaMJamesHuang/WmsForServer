package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.dto.GetItemDto;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.util.StringUtil;
import com.kt.james.wmsforserver.util.VerificationUtil;

import java.util.List;

public class GetItemController {

    public GetItemDto getAllItem(String company_id, String user_id) {
        Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        GetItemDto dto = new GetItemDto();
        if (realCompanyId == null || realUserId == null) {
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
        List<Item> results = ItemDao.getAllItem(realCompanyId);
        if (results == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("该公司没有商品");
            return dto;
        }
        dto.setResult(results);
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
