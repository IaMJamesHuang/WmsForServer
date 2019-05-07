package com.kt.james.wmsforserver.servlet.plugin;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.plugin.UploadController;
import com.kt.james.wmsforserver.dto.UploadPluginDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name="uploadPlugin",urlPatterns="/uploadPlugin")
public class UploadPluginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UploadPluginDto dto = UploadController.uploadPlugin(req);
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
