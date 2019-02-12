package com.kt.james.wmsforserver.bean;

public class DaySaleBean {

    private float month_sale;

    private float day_sale;

    private int item_id;

    private float available_num;

    public float getMonth_sale() {
        return month_sale;
    }

    public void setMonth_sale(float month_sale) {
        this.month_sale = month_sale;
    }

    public float getDay_sale() {
        return day_sale;
    }

    public void setDay_sale(float day_sale) {
        this.day_sale = day_sale;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public float getAvailable_num() {
        return available_num;
    }

    public void setAvailable_num(float available_num) {
        this.available_num = available_num;
    }
}
