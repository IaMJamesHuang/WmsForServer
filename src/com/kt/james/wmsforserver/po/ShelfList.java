package com.kt.james.wmsforserver.po;

public class ShelfList {

    public static final int STATE_INIT = 0;

    public static final int STATE_PROC = 1;

    public static final int STATE_FINISH = 2;

    private int id;

    private int company_id;

    private int oper_id;

    private int state;

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

    public int getOper_id() {
        return oper_id;
    }

    public void setOper_id(int oper_id) {
        this.oper_id = oper_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
