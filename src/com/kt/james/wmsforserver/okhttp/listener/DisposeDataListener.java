package com.kt.james.wmsforserver.okhttp.listener;

/**
 * Created by James on 2018/10/2.
 */
public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     */
    void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     */
    void onFailure(Object reasonObj);

}
