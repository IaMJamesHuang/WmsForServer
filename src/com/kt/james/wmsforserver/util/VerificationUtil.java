package com.kt.james.wmsforserver.util;

import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.UserDao;
import com.kt.james.wmsforserver.po.Company;
import com.kt.james.wmsforserver.po.User;

public class VerificationUtil {


    public static boolean verifityLogin(int companyId, int userId) {
        Company company = CompanyDao.getCompanyById(companyId);
        User user = UserDao.findUserById(userId);
        if (company == null || user == null) {
            return false;
        }
        return true;
    }

}
