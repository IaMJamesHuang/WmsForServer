package com.kt.james.wmsforserver.po;

public class ItemLoc {

    private int id;

    private int company_id;

    private int item_id;

    private int loc_id;

    private float stock_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }

    public float getStock_count() {
        return stock_count;
    }

    public void setStock_count(float stock_count) {
        this.stock_count = stock_count;
    }
}
