package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.BuyItemController;
import com.kt.james.wmsforserver.dto.BuyItemDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="buyItem",urlPatterns="/buyItem")
public class BuyItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = req.getHeader("company_id");
        String user_id = req.getHeader("user_id");
        String barcode = req.getParameter("barcode");
        String amount = req.getParameter("amount");
        String loc = req.getParameter("loc");
        BuyItemDto dto = new BuyItemController().buyItem(company_id, user_id, barcode, amount, loc);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
