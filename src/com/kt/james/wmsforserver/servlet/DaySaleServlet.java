package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.DaySaleController;
import com.kt.james.wmsforserver.dto.DaySaleDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="daySale",urlPatterns="/daySale")
public class DaySaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = req.getHeader("company_id");
        String user_id = req.getHeader("user_id");
        String item_id = req.getParameter("item_id");
        DaySaleDto dto = new DaySaleController().getSale(company_id, user_id, item_id);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }



}
