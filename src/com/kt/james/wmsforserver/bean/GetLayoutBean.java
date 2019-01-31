package com.kt.james.wmsforserver.bean;

import com.kt.james.wmsforserver.po.Location;

import java.util.List;

public class GetLayoutBean {

    private List<Location> infos;

    public List<Location> getInfos() {
        return infos;
    }

    public void setInfos(List<Location> infos) {
        this.infos = infos;
    }
}
