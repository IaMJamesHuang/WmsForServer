package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.bean.UserAccessBean;
import com.kt.james.wmsforserver.mapper.UserPluginMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserPluginDao {

    public static UserAccessBean queryUserAccess(int user_id, int plugin_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        UserPluginMapper mapper = sqlSession.getMapper(UserPluginMapper.class);
        UserAccessBean result = null;
        try {
            result = mapper.queryUserSingAccess(user_id, plugin_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static void updateUserAccess(UserAccessBean bean) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        UserPluginMapper mapper = sqlSession.getMapper(UserPluginMapper.class);
        try {
            mapper.updateUserAccess(bean);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public static void insertUserAccess(UserAccessBean bean) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        UserPluginMapper mapper = sqlSession.getMapper(UserPluginMapper.class);
        try {
            mapper.insertUserAccess(bean);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
