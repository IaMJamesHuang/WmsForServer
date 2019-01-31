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

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLoc_x() {
        return loc_x;
    }

    public void setLoc_x(float loc_x) {
        this.loc_x = loc_x;
    }

    public float getLoc_y() {
        return loc_y;
    }

    public void setLoc_y(float loc_y) {
        this.loc_y = loc_y;
    }

    public float getAvailable_num() {
        return available_num;
    }

    public void setAvailable_num(float available_num) {
        this.available_num = available_num;
    }

    public float getTotal_num() {
        return total_num;
    }

    public void setTotal_num(float total_num) {
        this.total_num = total_num;
    }
}
