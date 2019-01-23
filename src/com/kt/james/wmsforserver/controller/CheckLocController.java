package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.CheckLocBean;
import com.kt.james.wmsforserver.dao.LocationDao;
import com.kt.james.wmsforserver.dto.CheckLocDto;
import com.kt.james.wmsforserver.po.Location;
import com.kt.james.wmsforserver.util.StringUtil;

public class CheckLocController {

    public static CheckLocDto checkLoc(String locCode, String company_id) {
        CheckLocDto dto = new CheckLocDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        if (realCompanyId == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("公司ID不合法");
            return dto;
        }
        if (StringUtil.isEmpty(locCode)) {
            dto.setResponseCode(404);
            dto.setResponseMsg("库位编码不能为空");
            return dto;
        }
        Location location = LocationDao.getLocation(locCode, realCompanyId);
        if (location == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("找不到对应的库位");
            return dto;
        }
        CheckLocBean bean = new CheckLocBean();
        bean.setCompany_id(location.getCompany_id());
        bean.setName(location.getName());
        dto.setLocation(bean);
        dto.setResponseCode(200);
        dto.setResponseMsg("请求成功");
        return dto;
    }

}
