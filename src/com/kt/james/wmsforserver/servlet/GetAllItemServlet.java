package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.GetItemController;
import com.kt.james.wmsforserver.dto.GetItemDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="getAllItem",urlPatterns="/getAllItem")
public class GetAllItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = req.getHeader("company_id");
        String user_id = req.getHeader("user_id");
        GetItemDto dto = new GetItemController().getAllItem(company_id, user_id);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
