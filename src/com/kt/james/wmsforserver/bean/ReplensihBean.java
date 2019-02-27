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

        private int itemId;

        private String itemName;

        private float recentlySale;

        private float recommend;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

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
