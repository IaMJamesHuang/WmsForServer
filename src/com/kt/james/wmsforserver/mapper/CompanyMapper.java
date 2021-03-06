package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.User;

import java.io.IOException;
import java.util.List;

public interface CompanyMapper {

    public Company findCompanyById(int id) throws IOException;

    public Company findCompanyByName(String company_name) throws IOException;

    List<Company> getCompanyList() throws IOException;

    List<User> queryCompanyUserList(int companyId) throws IOException;

}
