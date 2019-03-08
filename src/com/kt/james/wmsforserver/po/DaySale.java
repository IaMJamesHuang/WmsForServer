package com.kt.james.wmsforserver.po;


import java.sql.Date;

public class DaySale {

    private int id;

    private int item_id;

    private int company_id;

    private float day_sale;

    private Date cdate;

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

    public float getDay_sale() {
        return day_sale;
    }

    public void setDay_sale(float day_sale) {
        this.day_sale = day_sale;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
