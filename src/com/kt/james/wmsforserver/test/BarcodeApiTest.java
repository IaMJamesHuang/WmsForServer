package com.kt.james.wmsforserver.test;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.bean.GetBarcodePOJO;
import com.kt.james.wmsforserver.okhttp.CommonOkHttpClient;
import com.kt.james.wmsforserver.okhttp.request.CommonRequest;
import com.kt.james.wmsforserver.okhttp.request.RequestParams;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BarcodeApiTest {

    @Before
    public void init() {

    }

    @Test
    public void TestBarcodeApi() {
        String url = "https://api.shenjian.io/showapi/barcode";
        RequestParams params = new RequestParams();
        params.put("appid", "1571c6ff5e49667f3a0c1a257aa5d5e5");
        params.put("code", "6938166920785");
        Request request = CommonRequest.createGetRequest(url, params);
        try {
            Response response = CommonOkHttpClient.getSync(request);
            if (response.isSuccessful()) {
                String result = response.body().string();
                Gson gson = new Gson();
                GetBarcodePOJO subject = gson.fromJson(result, GetBarcodePOJO.class);
                System.out.println(result);
                System.out.println(subject.getData().getShowapi_res_body().getGoodsName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
