package com.kt.james.wmsforserver.dao;

import com.kt.james.wmsforserver.SqlManagement;
import com.kt.james.wmsforserver.bean.UpShelfBean;
import com.kt.james.wmsforserver.mapper.ShelfListMapper;
import com.kt.james.wmsforserver.po.ShelfItem;
import com.kt.james.wmsforserver.po.ShelfList;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class ShelfListDao {

    public static boolean updateShelfItem(ShelfItem shelfItem) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        boolean result = false;
        try {
            mapper.updateShelfItem(shelfItem);
            sqlSession.commit();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static ShelfList findShelfListById(int id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        ShelfList shelfList = null;
        try {
            shelfList = mapper.findShelfListById(id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return shelfList;
    }

    public static List<UpShelfBean> findShelfItemListByListId(int shelfListId) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        List<UpShelfBean> list = null;
        try {
            list = mapper.findShelfItemList(shelfListId);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public static boolean updateShelfList(ShelfList shelfList) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        boolean result = false;
        try {
            mapper.updateShelfList(shelfList);
            sqlSession.commit();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static boolean createShelfList(int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        boolean result = false;
        try {
            mapper.createShelfList(company_id);
            sqlSession.commit();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static boolean createShelfItems(List<ShelfItem> items) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        boolean result = false;
        try {
            for (ShelfItem item : items) {
                mapper.createShelfItem(item);
            }
            sqlSession.commit();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public static ShelfList getMaxShelfList(int company_id) {
        SqlSession sqlSession = SqlManagement.getInstance().openSession();
        ShelfListMapper mapper = sqlSession.getMapper(ShelfListMapper.class);
        ShelfList result = null;
        try {
            result = mapper.findMaxShelfList(company_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }

}
