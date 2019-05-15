package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.PluginDao;
import com.kt.james.wmsforserver.dto.PluginAccessDto;
import com.kt.james.wmsforserver.util.StringUtil;

public class PluginAccessController {

    public static PluginAccessDto queryPluginAccessList(String companyId) {
        PluginAccessDto dto = new PluginAccessDto();
        Integer realCompanyId = StringUtil.parseInt(companyId);
        if (realCompanyId == null) {
            dto.setResponseMsg("公司ID错误");
            dto.setResponseCode(404);
            return dto;
        }
        dto.setResult(PluginDao.queryPluginAccessList(realCompanyId));
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
