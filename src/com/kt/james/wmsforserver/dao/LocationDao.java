package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.LocationMapper;
import com.kt.james.wmsforserver.po.Location;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class LocationDao {

    public static Location getLocation(String locCode, int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        LocationMapper mapper = sqlSession.getMapper(LocationMapper.class);
        Location location = null;
        try {
            location = mapper.findLocation(locCode, company_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return location;
    }

}
