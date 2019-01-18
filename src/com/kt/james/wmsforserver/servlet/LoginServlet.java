package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.LoginController;
import com.kt.james.wmsforserver.dto.LoginDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="login",urlPatterns="/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginDto loginDto = LoginController.doLogin(username, password);
//        LoginDto loginDto = new LoginDto();
//        UserBean userBean = new UserBean("123456");
//        loginDto.setUserBean(userBean);
//        boolean pass;
//        pass = username.equals("123456") && password.equals("123456");
//        if (pass) {
//            loginDto.setUserBean(userBean);
//            loginDto.setResponseCode(200);
//            loginDto.setResponseMsg("登陆成功");
//        } else {
//            loginDto.setUserBean(null);
//            loginDto.setResponseCode(404);
//            loginDto.setResponseMsg("账号/密码错误");
//        }
        String result = new Gson().toJson(loginDto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
