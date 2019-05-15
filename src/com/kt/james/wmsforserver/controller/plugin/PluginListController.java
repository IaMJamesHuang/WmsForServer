package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.PluginDao;
import com.kt.james.wmsforserver.dto.PluginListDto;

public class PluginListController {

    public static PluginListDto getAllPlugins() {
        PluginListDto dto = new PluginListDto();
        dto.setResult(PluginDao.queryPlugins());
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
