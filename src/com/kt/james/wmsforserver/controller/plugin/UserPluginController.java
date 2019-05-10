package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.PluginDao;
import com.kt.james.wmsforserver.dao.UserDao;
import com.kt.james.wmsforserver.dto.UserPluginsDto;
import com.kt.james.wmsforserver.po.Plugin;
import com.kt.james.wmsforserver.po.User;

import java.util.List;

public class UserPluginController {

    public static UserPluginsDto queryUserPlugins(int userId) {
        UserPluginsDto dto = new UserPluginsDto();
        User user = UserDao.findUserById(userId);
        if (user == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("用户不存在");
            return dto;
        }
        List<Plugin> plugins = PluginDao.queryPluginsByUser(userId);
        dto.setResult(plugins);
        dto.setUser_id(userId);
        dto.setUser_name(user.getNick());
        return dto;
    }

}
