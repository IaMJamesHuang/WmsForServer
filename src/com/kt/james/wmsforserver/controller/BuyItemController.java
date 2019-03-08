package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.dao.DaySaleDao;
import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.dto.BuyItemDto;
import com.kt.james.wmsforserver.dto.OffShelfDto;
import com.kt.james.wmsforserver.po.DaySale;
import com.kt.james.wmsforserver.po.Item;
import com.kt.james.wmsforserver.util.StringUtil;
import com.kt.james.wmsforserver.util.VerificationUtil;

import java.sql.Date;


public class BuyItemController {

    public BuyItemDto buyItem(String company_id, String user_id, String barcode, String amount, String loc) {
        BuyItemDto dto = new BuyItemDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        Float realSaleNum = StringUtil.parseFloat(amount);
        if (realCompanyId == null || realUserId == null || barcode == null || realSaleNum == null || loc == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("参数不合法");
            return dto;
        }
        if (!VerificationUtil.verifityLogin(realCompanyId, realUserId)) {
            dto.setResponseCode(404);
            dto.setResponseMsg("未验证的登陆态");
            return dto;
        }

        //使用下架代码实现
        Item item = ItemDao.getItemByBarcode(barcode);
        int realItemId = item.getId();
        OffShelfDto offShelfResult = OffShelfController.doOffShelf(company_id, barcode, loc, amount);
        if (offShelfResult.getResponseCode() == 404) {
            dto.setResponseCode(404);
            dto.setResponseMsg(offShelfResult.getResponseMsg());
            return dto;
        }
//        //扣库存
//        Stock stock = StockDao.getStock(realCompanyId, realItemId);
//        if (stock == null) {
//            dto.setResponseCode(404);
//            dto.setResponseMsg("该商品没有库存信息");
//            return dto;
//        }
//        float itemANum = stock.getAvailable_num();
//        if (itemANum > realSaleNum) {
//            stock.setAvailable_num(itemANum - realSaleNum);
//        } else {
//            //库存不足的情况,直接取消交易，便于数据统计
//            dto.setResponseCode(404);
//            dto.setResponseMsg("该商品库存不足");
//            return dto;
//        }
//        boolean stockResult = StockDao.updateStock(stock);
//        if (!stockResult) {
//            dto.setResponseCode(404);
//            dto.setResponseMsg("库存更新失败");
//            return dto;
//        }

        //更改日销
        DaySale daySale = new DaySale();
        daySale.setCompany_id(realCompanyId);
        daySale.setItem_id(realItemId);
        daySale.setDay_sale(realSaleNum);
        daySale.setCdate(new Date(System.currentTimeMillis()));
        boolean daySaleResult = DaySaleDao.insertOrUpdateDaySaleRecord(daySale);
        //没有开事务，但是无所谓了
        if (!daySaleResult) {
            dto.setResponseCode(404);
            dto.setResponseMsg("日销量更新失败");
            return dto;
        }
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
