package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.bean.DaySaleItemBean;
import com.kt.james.wmsforserver.mapper.DaySaleMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class DaySaleDao {

    public static List<DaySaleItemBean> getDaySaleInfos(int companyId, int itemId) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        DaySaleMapper mapper = sqlSession.getMapper(DaySaleMapper.class);
        List<DaySaleItemBean> result = null;
        try {
            result = mapper.getDaySaleInfos(companyId, itemId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

}
