package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.ReplensihBean;
import com.kt.james.wmsforserver.core.RecommendCore;
import com.kt.james.wmsforserver.dao.DaySaleDao;
import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.dto.ReplenishDto;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.util.StringUtil;
import com.kt.james.wmsforserver.util.VerificationUtil;

import java.util.ArrayList;
import java.util.List;

public class ReplenishController {

    public ReplenishDto getReplenishInfo(String company_id, String user_id) {
        final Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        ReplenishDto dto = new ReplenishDto();
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
        List<Item> itemList = ItemDao.getAllItem(realCompanyId);
        List<ReplensihBean.ReplenishItem> replenishInfos = new ArrayList<>();
        itemList.forEach((item) -> {
            ReplensihBean.ReplenishItem replenishItem =
                    new ReplensihBean.ReplenishItem();
            replenishItem.setItemId(item.getId());
            replenishItem.setItemName(item.getName());
            //获取推荐数量
            replenishItem.setRecommend(RecommendCore.getRecommendReplenish(item, realCompanyId));
            //获取最近7天销量
            replenishItem.setRecentlySale(DaySaleDao.getSevenDaySum(realCompanyId, item.getId()));
            replenishInfos.add(replenishItem);
        });
        ReplensihBean result = new ReplensihBean();
        result.setItems(replenishInfos);
        dto.setResult(result);
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }


}
