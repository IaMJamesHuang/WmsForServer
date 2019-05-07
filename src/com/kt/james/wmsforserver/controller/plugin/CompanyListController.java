package com.kt.james.wmsforserver.controller.plugin;

import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dto.GetCompanyListDto;
import com.kt.james.wmsforserver.po.Company;

import java.util.List;

public class CompanyListController {

    public static GetCompanyListDto getCompanyList() {
        List<Company> companyList = CompanyDao.getCompanyList();
        GetCompanyListDto dto = new GetCompanyListDto();
        dto.setResult(companyList);
        return dto;
    }

}
