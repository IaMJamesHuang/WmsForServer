package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.po.User;
import com.kt.james.wmsforserver.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserDao {

    public static User getUser(String account) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try {
            user = userMapper.findUserByAccount(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
