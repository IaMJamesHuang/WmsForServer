package com.kt.james.wmsforserver.okhttp;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.app.Constans;
import com.kt.james.wmsforserver.bean.GetBarcodePOJO;
import com.kt.james.wmsforserver.okhttp.request.CommonRequest;
import com.kt.james.wmsforserver.okhttp.request.RequestParams;
import okhttp3.Request;
import okhttp3.Response;

/*
 * 外部请求同一放这里处理，同步获取
 */
public class ApiManagement {

    public static GetBarcodePOJO requestBarcode(String code) {
        RequestParams params = new RequestParams();
        params.put("appid", Constans.GET_BARCODE_APPID);
        params.put("code", code);
        Request request = CommonRequest.createGetRequest(Constans.GET_BARCODE_API, params);
        GetBarcodePOJO subject = null;
        try {
            Response response = CommonOkHttpClient.getSync(request);
            if (response.isSuccessful()) {
                String result = response.body().string();
                Gson gson = new Gson();
                subject = gson.fromJson(result, GetBarcodePOJO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回数据错误，直接砍掉
        if (subject != null && subject.getError_code() != 0) {
            subject = null;
        }
        return subject;
    }

}
