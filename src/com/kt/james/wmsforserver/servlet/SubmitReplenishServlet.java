package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.SubmitReplenishController;
import com.kt.james.wmsforserver.dto.SubmitReplenishDto;
import com.kt.james.wmsforserver.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="submitReplenishInfo",urlPatterns="/submitReplenishInfo")
public class SubmitReplenishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonInfo = StringUtil.ReadAsChars(req);
        String company_id = req.getHeader("company_id");
        String user_id = req.getHeader("user_id");
        SubmitReplenishDto dto = new SubmitReplenishController().submitReplenish(company_id, user_id, jsonInfo);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }

}
