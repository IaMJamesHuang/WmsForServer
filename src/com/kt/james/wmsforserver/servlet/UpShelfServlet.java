package com.kt.james.wmsforserver.servlet;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.UpShelfController;
import com.kt.james.wmsforserver.dto.UpShelfDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="upShelf",urlPatterns="/upShelf")
public class UpShelfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = req.getHeader("company_id");
        String user_id = req.getHeader("user_id");
        String shelfListId = req.getParameter("shelf_list_id");
        String pos_x = req.getParameter("pos_X");
        String pox_Y = req.getParameter("pos_y");
        String item_id = req.getParameter("item_id");
        String loc_id = req.getParameter("loc_id");
        String num = req.getParameter("num");
        UpShelfDto dto = new UpShelfController().doUpShelf(company_id, user_id, shelfListId,
                pos_x, pox_Y, item_id, loc_id, num);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
