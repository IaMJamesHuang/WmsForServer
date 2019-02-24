package com.kt.james.wmsforserver.bean;

import java.util.List;

public class ReplensihBean {


    private List<ReplenishItem> items;

    public List<ReplenishItem> getItems() {
        return items;
    }

    public void setItems(List<ReplenishItem> items) {
        this.items = items;
    }

    public static class ReplenishItem {
        private String itemName;

        private float recentlySale;

        private float recommend;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public float getRecentlySale() {
            return recentlySale;
        }

        public void setRecentlySale(float recentlySale) {
            this.recentlySale = recentlySale;
        }

        public float getRecommend() {
            return recommend;
        }

        public void setRecommend(float recommend) {
            this.recommend = recommend;
        }
    }


}
