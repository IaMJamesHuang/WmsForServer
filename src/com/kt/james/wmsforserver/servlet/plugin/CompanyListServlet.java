package com.kt.james.wmsforserver.servlet.plugin;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.plugin.CompanyListController;
import com.kt.james.wmsforserver.dto.GetCompanyListDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="getCompanyList",urlPatterns="/getCompanyList")
public class CompanyListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetCompanyListDto dto = CompanyListController.getCompanyList();
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
