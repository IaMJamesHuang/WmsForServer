package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.po.Company;

import java.util.List;

public class GetCompanyListDto extends BaseDto{

    private List<Company> result;

    public List<Company> getResult() {
        return result;
    }

    public void setResult(List<Company> result) {
        this.result = result;
    }
}
