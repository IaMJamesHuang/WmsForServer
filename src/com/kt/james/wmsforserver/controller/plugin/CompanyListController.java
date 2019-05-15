package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dto.GetCompanyUserDto;
import com.kt.james.wmsforserver.dto.GetCompanyListDto;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.User;
import com.kt.james.wmsforserver.util.StringUtil;

import java.util.List;

public class CompanyListController {

    public static GetCompanyListDto getCompanyList() {
        List<Company> companyList = CompanyDao.getCompanyList();
        GetCompanyListDto dto = new GetCompanyListDto();
        dto.setResult(companyList);
        return dto;
    }

    public static GetCompanyUserDto queryCompanyUserList(String companyId) {
        GetCompanyUserDto dto = new GetCompanyUserDto();
        Integer realCompanyId = StringUtil.parseInt(companyId);
        if (realCompanyId == null) {
            dto.setResponseMsg("公司ID错误");
            dto.setResponseCode(404);
            return dto;
        }
        List<User> userList = CompanyDao.getCompanyUser(realCompanyId);
        dto.setResult(userList);
        dto.setResponseMsg("调用成功");
        dto.setResponseCode(200);
        return dto;
    }

}
