package com.kt.james.wmsforserver.okhttp.listener;

/**
 * Created by James on 2018/10/2.
 */
public class DisposeDataHandle {

    public DisposeDataListener mListener = null;
    public Class<?> mClass = null;
    public String mSource = null;

    public DisposeDataHandle(DisposeDataListener listener)
    {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz)
    {
        this.mListener = listener;
        this.mClass = clazz;
    }

    public DisposeDataHandle(DisposeDataListener listener, String source)
    {
        this.mListener = listener;
        this.mSource = source;
    }

}
