package test;


import com.kt.james.wmsforserver.core.RecommendCore;
import com.kt.james.wmsforserver.dao.DaySaleDao;
import com.kt.james.wmsforserver.dao.ItemDao;
import com.kt.james.wmsforserver.po.DaySale;
import com.kt.james.wmsforserver.po.Item;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestRecommend {

    private int companyId;

    private int itemId;

    private String barcode;


    @Before
    public void init() {
        companyId = 1;
        itemId = 1;
        barcode = "6903653028657";
    }

    @Test
    public void testGetItemMonthSale() {
        List<DaySale> monthSale = DaySaleDao.getItemMonthSale(companyId, itemId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (DaySale daySale : monthSale) {
            System.out.println("商品Id: " + daySale.getId()
                    + "日期：" + format.format(daySale.getCdate())
                    + "销量：" + daySale.getDay_sale());
        }
    }

    @Test
    public void testRecommendReplenish() {
        Item item = ItemDao.getItemByBarcode(barcode);
        System.out.println("推荐补货数量：" + RecommendCore.getRecommendReplenish(item, companyId));
    }

}
