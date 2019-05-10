package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.PluginMapper;
import com.kt.james.wmsforserver.po.Plugin;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class PluginDao {

    public static List<Plugin> queryPlugins() {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        PluginMapper mapper = sqlSession.getMapper(PluginMapper.class);
        List<Plugin> list = null;
        try {
            list = mapper.queryPlugins();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void updatePlugin(Plugin plugin) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        PluginMapper mapper = sqlSession.getMapper(PluginMapper.class);
        try {
            mapper.updatePlugin(plugin);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
