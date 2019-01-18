package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.dao.UserDao;
import com.kt.james.wmsforserver.po.User;
import com.kt.james.wmsforserver.dto.LoginDto;
import com.kt.james.wmsforserver.bean.UserBean;

public class LoginController {

    public static LoginDto doLogin(String account, String password) {
        if (account == null || password == null) {
            return null;
        }
        LoginDto loginDto = new LoginDto();
        User user = UserDao.getUser(account);
        if (user == null || !password.equals(user.getPassword())) {
            loginDto.setUserBean(null);
            loginDto.setResponseCode(404);
            loginDto.setResponseMsg("账号/密码错误");
            return loginDto;
        }
        UserBean userBean = new UserBean(user.getNick());
        loginDto.setUserBean(userBean);
        loginDto.setResponseMsg("登陆成功");
        loginDto.setResponseCode(200);
        return loginDto;
    }

}
