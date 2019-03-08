package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.bean.DaySaleItemBean;
import com.kt.james.wmsforserver.po.DaySale;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface DaySaleMapper {

    List<DaySaleItemBean> getDaySaleInfos(int companyId, int itemId) throws IOException;

    void insertDaySale(DaySale daySale) throws IOException;

    DaySale findSingleDaySale(int companyId, int itemId, Date date) throws IOException;

    void updateDaySale(DaySale daySale) throws IOException;

}
