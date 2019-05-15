package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.bean.UserAccessBean;

import java.util.List;

public class PluginAccessDto extends BaseDto {

    private List<UserAccessBean> result;

    public List<UserAccessBean> getResult() {
        return result;
    }

    public void setResult(List<UserAccessBean> result) {
        this.result = result;
    }
}
