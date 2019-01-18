package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Company;

import java.io.IOException;

public interface CompanyMapper {

    public Company findCompanyById(int id) throws IOException;

    public Company findCompanyByName(String company_name) throws IOException;

}
