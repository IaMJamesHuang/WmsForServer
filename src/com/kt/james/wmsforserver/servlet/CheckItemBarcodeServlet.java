package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.CheckItemBarcodeController;
import com.kt.james.wmsforserver.dto.CheckItemBarcodeDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="checkItemBarcode",urlPatterns="/checkItemBarcode")
public class CheckItemBarcodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String barcode = req.getParameter("barcode");
        String company_id = req.getParameter("company_id");
        CheckItemBarcodeDto dto = CheckItemBarcodeController.checkItemBarcode(barcode, company_id);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
