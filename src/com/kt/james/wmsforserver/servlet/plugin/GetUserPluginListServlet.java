package com.kt.james.wmsforserver.servlet.plugin;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.controller.plugin.UserPluginController;
import com.kt.james.wmsforserver.dto.UserPluginsDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getUserPluginList", urlPatterns = "/getUserPluginList")
public class GetUserPluginListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getHeader("user_id");
        UserPluginsDto dto = UserPluginController.queryUserPlugins(Integer.valueOf(user_id));
        String result = new Gson().toJson(dto);
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(result);
        pw.flush();
    }
}
