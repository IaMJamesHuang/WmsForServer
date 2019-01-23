package com.kt.james.wmsforserver.po;

public class Location {

    private int id;

    private int company_id;

    private String name;

    private float loc_x;

    private float loc_y;

    private float available_num;

    private float total_num;

    public int getId() {
        return id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public String getName() {
        return name;
    }

    public float getLoc_x() {
        return loc_x;
    }

    public float getLoc_y() {
        return loc_y;
    }

    public float getAvailable_num() {
        return available_num;
    }

    public float getTotal_num() {
        return total_num;
    }
}
