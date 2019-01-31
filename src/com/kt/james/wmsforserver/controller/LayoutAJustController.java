package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.GetLayoutBean;
import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.LocationDao;
import com.kt.james.wmsforserver.dto.GetLayoutDto;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.Location;
import com.kt.james.wmsforserver.util.StringUtil;

import java.util.List;

public class LayoutAJustController {

    public GetLayoutDto getLayoutInfo(String company_id) {
        GetLayoutDto dto = new GetLayoutDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        if (realCompanyId == null) {
            dto.setResult(null);
            dto.setResponseMsg("公司ID不合法");
            dto.setResponseCode(404);
            return dto;
        }
        Company company = CompanyDao.getCompanyById(realCompanyId);
        if (company == null) {
            dto.setResult(null);
            dto.setResponseMsg("未验证的登陆态");
            dto.setResponseCode(404);
            return dto;
        }
        List<Location> locationList = LocationDao.getLocationList(realCompanyId);
        GetLayoutBean bean = new GetLayoutBean();
        bean.setInfos(locationList);
        dto.setResult(bean);
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

}
