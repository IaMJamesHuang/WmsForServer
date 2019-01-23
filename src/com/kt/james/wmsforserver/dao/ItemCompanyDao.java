package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.ItemCompanyMapper;
import com.kt.james.wmsforserver.po.ItemCompany;
import com.kt.james.wmsforserver.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ItemCompanyDao {

    public static ItemCompany getBarcode(String barcode, int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemCompanyMapper mapper = sqlSession.getMapper(ItemCompanyMapper.class);
        ItemCompany result = null;
        try {
            result = mapper.findItemBarcode(barcode, company_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static boolean insertItemCompany(int item_id, int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemCompanyMapper mapper = sqlSession.getMapper(ItemCompanyMapper.class);
        try {
            mapper.insertItemCompany(item_id, company_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
        return true;
    }

}
