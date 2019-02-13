package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.bean.DaySaleItemBean;

import java.io.IOException;
import java.util.List;

public interface DaySaleMapper {

    List<DaySaleItemBean> getDaySaleInfos(int companyId, int itemId) throws IOException;

}
