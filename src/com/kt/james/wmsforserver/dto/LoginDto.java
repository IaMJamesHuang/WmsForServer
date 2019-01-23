package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.bean.UserBean;

public class LoginDto extends BaseDto{

    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

}
