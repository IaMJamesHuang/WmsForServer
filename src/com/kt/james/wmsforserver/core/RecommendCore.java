package com.kt.james.wmsforserver.core;

import com.kt.james.wmsforserver.dao.DaySaleDao;
import com.kt.james.wmsforserver.dao.StockDao;
import com.kt.james.wmsforserver.po.DaySale;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.po.Stock;
import com.kt.james.wmsforserver.util.TimeUtils;

import java.util.List;

public class RecommendCore {

    public static float getRecommendReplenish(Item item, int companyId) {
        List<DaySale> monthSaleList = DaySaleDao.getItemMonthSale(item.getId(), companyId);
        //这个月没有销量
        if (monthSaleList == null || monthSaleList.size() == 0) {
            return 0f;
        }
        Stock stock = StockDao.getStock(companyId, item.getId());
        float stockNum = stock.getAvailable_num();
        float monthSale = 0f;
        for (DaySale daySale : monthSaleList) {
            monthSale += daySale.getDay_sale();
        }
        //设置基准
        float benchmark = monthSale * 1.1f - stockNum;
        //上个月今天的销量
        List<DaySale> lastMonthSaleList = DaySaleDao.getItemSaleBetween(companyId, item.getId()
                , TimeUtils.getFirstDayLastMonth(),TimeUtils.getCurrentDayLastMonth());
        float lastMonthSale = 0f;
        if (lastMonthSaleList != null && lastMonthSaleList.size() != 0) {
            for (DaySale daySale : lastMonthSaleList) {
                lastMonthSale += daySale.getDay_sale();
            }
        }
        //趋势
        float trend = lastMonthSale == 0 ? 1.0f : (monthSale - lastMonthSale) / lastMonthSale + 1;
        return (int)(benchmark * trend);
    }

}
