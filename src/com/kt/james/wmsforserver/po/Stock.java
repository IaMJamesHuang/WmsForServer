package com.kt.james.wmsforserver.po;

public class Stock {

    private int id;

    private int item_id;

    private int company_id;

    private float month_sale;

    private float day_sale;

    private float history_num;

    private float available_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

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

    public float getHistory_num() {
        return history_num;
    }

    public void setHistory_num(float history_num) {
        this.history_num = history_num;
    }

    public float getAvailable_num() {
        return available_num;
    }

    public void setAvailable_num(float available_num) {
        this.available_num = available_num;
    }
}
