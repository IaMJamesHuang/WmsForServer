package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.LocationMapper;
import com.kt.james.wmsforserver.po.Location;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

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

    public static List<Location> getLocationList(int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        LocationMapper mapper = sqlSession.getMapper(LocationMapper.class);
        List<Location> locationList = null;
        try {
            locationList = mapper.findLocationList(company_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return locationList;
    }

    public static Boolean insertLayoutInfos(List<Location> infos) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        LocationMapper mapper = sqlSession.getMapper(LocationMapper.class);
        Boolean result = false;
        try {
            result = mapper.insertOrUpdateList(infos);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            sqlSession.close();
        }
        return result;
    }

}
