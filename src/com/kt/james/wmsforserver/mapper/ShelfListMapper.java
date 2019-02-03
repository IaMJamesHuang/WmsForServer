package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.bean.UpShelfBean;
import com.kt.james.wmsforserver.po.ShelfItem;
import com.kt.james.wmsforserver.po.ShelfList;

import java.io.IOException;
import java.util.List;

public interface ShelfListMapper {

    ShelfList findShelfListById(int id) throws IOException;

    List<UpShelfBean> findShelfItemList(int shelfListId) throws IOException;

    void updateShelfList(ShelfList shelfList) throws IOException;

    void updateShelfItem(ShelfItem shelfItem) throws IOException;

}
