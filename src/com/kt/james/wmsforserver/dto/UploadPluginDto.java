package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.po.Plugin;

public class UploadPluginDto extends BaseDto {

    private Plugin result;

    public Plugin getResult() {
        return result;
    }

    public void setResult(Plugin result) {
        this.result = result;
    }
}
