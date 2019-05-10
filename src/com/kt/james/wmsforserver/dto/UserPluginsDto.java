package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.po.Plugin;

import java.util.List;

public class UserPluginsDto extends BaseDto{

    private int user_id;

    private String user_name;

    private List<Plugin> result;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Plugin> getResult() {
        return result;
    }

    public void setResult(List<Plugin> result) {
        this.result = result;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
