package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.UserBean;
import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.UserDao;
import com.kt.james.wmsforserver.dto.LoginDto;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.User;

public class RegisterController {

    public static LoginDto doRegister(String companyName, String account,
                                      String nick, String password) {
        LoginDto loginDto = new LoginDto();
        if (companyName == null || account == null || nick == null || password == null) {
            loginDto.setUserBean(null);
            loginDto.setResponseCode(404);
            loginDto.setResponseMsg("存在为空的信息");
            return loginDto;
        }
        Company company = CompanyDao.getCompany(companyName);
        if (company == null) {
            loginDto.setUserBean(null);
            loginDto.setResponseCode(404);
            loginDto.setResponseMsg("公司不存在");
            return loginDto;
        }
        User user = UserDao.getUser(account);
        if (user != null) {
            loginDto.setUserBean(null);
            loginDto.setResponseCode(404);
            loginDto.setResponseMsg("该账号已经存在");
            return loginDto;
        }
        User insertUser = new User();
        insertUser.setAccount(account);
        insertUser.setPassword(password);
        insertUser.setNick(nick);
        insertUser.setCompany_id(company.getId());
        boolean result = UserDao.insertUser(insertUser);
        if (result) {
            UserBean userBean = new UserBean();
            userBean.setUsername(insertUser.getNick());
            userBean.setCompany_id(insertUser.getCompany_id());
            loginDto.setUserBean(userBean);
            loginDto.setResponseCode(200);
            loginDto.setResponseMsg("注册成功");
        } else {
            loginDto.setUserBean(null);
            loginDto.setResponseCode(404);
            loginDto.setResponseMsg("注册失败");
        }
        return loginDto;
    }

}
