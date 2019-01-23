package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Location;

import java.io.IOException;

public interface LocationMapper {

    public Location findLocation(String locCode, int company_id) throws IOException;

}
