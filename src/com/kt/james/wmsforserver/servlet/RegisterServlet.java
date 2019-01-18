package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.LoginController;
import com.kt.james.wmsforserver.controller.RegisterController;
import com.kt.james.wmsforserver.dto.LoginDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="register",urlPatterns="/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String companyName = req.getParameter("companyName");
        String account = req.getParameter("account");
        String nick = req.getParameter("nick");
        String password = req.getParameter("password");
        LoginDto loginDto = RegisterController.doRegister(companyName, account, nick, password);
        String result = new Gson().toJson(loginDto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
