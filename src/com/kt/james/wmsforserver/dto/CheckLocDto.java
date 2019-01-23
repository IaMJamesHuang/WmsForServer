package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.bean.CheckLocBean;

public class CheckLocDto extends BaseDto{

    private CheckLocBean location;

    public CheckLocBean getLocation() {
        return location;
    }

    public void setLocation(CheckLocBean location) {
        this.location = location;
    }
}
