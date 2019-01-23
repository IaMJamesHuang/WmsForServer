package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.CompanyMapper;
import com.kt.james.wmsforserver.po.Company;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class CompanyDao {

    public static Company getCompany(String companyName) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        CompanyMapper userMapper = sqlSession.getMapper(CompanyMapper.class);
        Company company = null;
        try {
            company = userMapper.findCompanyByName(companyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return company;
    }

    public static Company getCompanyById(int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        CompanyMapper userMapper = sqlSession.getMapper(CompanyMapper.class);
        Company company = null;
        try {
            company = userMapper.findCompanyById(company_id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return company;
    }

}
