package com.kt.james.wmsforserver;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlManagement {

    private static final String RESOURCE_PATH = "SqlMapConfig.xml";
    private static SqlManagement sInstance;

    private SqlSessionFactory sqlSessionFactory;


    private SqlManagement() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(RESOURCE_PATH);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlManagement getInstance() {
        if (sInstance == null) {
            sInstance = SqlManagementHolder.INSTANCE;
        }
        return sInstance;
    }

    public SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }


    private static class SqlManagementHolder {
        private static SqlManagement INSTANCE = new SqlManagement();
    }

}
