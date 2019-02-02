package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.LayoutAJustController;
import com.kt.james.wmsforserver.dto.GetLayoutDto;
import com.kt.james.wmsforserver.dto.InsertLayoutsDto;
import com.kt.james.wmsforserver.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="layoutAJust",urlPatterns="/layoutAJust")
public class LayoutAJustServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = req.getParameter("company_id");
        GetLayoutDto dto = new LayoutAJustController().getLayoutInfo(company_id);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonInfo = StringUtil.ReadAsChars(req);
        String company_id = req.getHeader("company_id");
        InsertLayoutsDto dto = new LayoutAJustController().insertLayoutInfo(company_id, jsonInfo);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
