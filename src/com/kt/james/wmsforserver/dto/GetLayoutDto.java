package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.bean.GetLayoutBean;

public class GetLayoutDto extends BaseDto {

    private GetLayoutBean result;

    public GetLayoutBean getResult() {
        return result;
    }

    public void setResult(GetLayoutBean result) {
        this.result = result;
    }
}
