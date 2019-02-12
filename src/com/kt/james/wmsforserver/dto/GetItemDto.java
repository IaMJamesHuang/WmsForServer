package com.kt.james.wmsforserver.dto;

import com.kt.james.wmsforserver.po.Item;

import java.util.List;

public class GetItemDto extends BaseDto {

    private List<Item> result;

    public List<Item> getResult() {
        return result;
    }

    public void setResult(List<Item> result) {
        this.result = result;
    }
}
