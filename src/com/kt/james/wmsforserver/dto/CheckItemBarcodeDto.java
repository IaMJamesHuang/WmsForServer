package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.bean.CheckBarcodeBean;

public class CheckItemBarcodeDto extends BaseDto {

    private CheckBarcodeBean result;

    public CheckBarcodeBean getResult() {
        return result;
    }

    public void setResult(CheckBarcodeBean result) {
        this.result = result;
    }
}
