package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.CompanyMapper;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CompanyDao {

    public static List<User> getCompanyUser(int companyId) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        CompanyMapper userMapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            return userMapper.queryCompanyUserList(companyId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }

    public static List<Company> getCompanyList() {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        CompanyMapper userMapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            return userMapper.getCompanyList();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }

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
