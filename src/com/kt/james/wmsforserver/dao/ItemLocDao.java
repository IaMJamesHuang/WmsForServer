package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.mapper.ItemLocMapper;
import com.kt.james.wmsforserver.po.ItemLoc;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ItemLocDao {

    public static ItemLoc findItemLoc(int company_id, int item_id, int loc_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemLocMapper mapper = sqlSession.getMapper(ItemLocMapper.class);
        ItemLoc result = null;
        try {
            result = mapper.findItemLoc(company_id, item_id, loc_id);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public static boolean insertItemLoc(int company_id, int item_id, int loc_id,
                                        float stock_count) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemLocMapper mapper = sqlSession.getMapper(ItemLocMapper.class);
        try {
            mapper.insertItemLoc(company_id, item_id, loc_id, stock_count);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
        return true;
    }

    public static boolean updateItemLoc(int company_id, int item_id, int loc_id,
                                        float stock_count) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemLocMapper mapper = sqlSession.getMapper(ItemLocMapper.class);
        try {
            mapper.updateItemLoc(company_id, item_id, loc_id, stock_count);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
        return true;
    }

    public static boolean deleteItemLoc(int id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ItemLocMapper mapper = sqlSession.getMapper(ItemLocMapper.class);
        try {
            mapper.deleteItemLoc(id);
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
