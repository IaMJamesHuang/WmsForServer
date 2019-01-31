package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Location;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface LocationMapper {

    Location findLocation(String locCode, int company_id) throws IOException;

    List<Location> findLocationList(int company_id) throws IOException;

    Boolean insertOrUpdateList(List<Location> infos) throws IOException;

    void insertOrUpdateSingle(Location location) throws IOException;

}
