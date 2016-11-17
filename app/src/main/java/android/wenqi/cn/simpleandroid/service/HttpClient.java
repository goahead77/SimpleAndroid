package android.wenqi.cn.simpleandroid.service;

import android.wenqi.cn.simpleandroid.utils.DES;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author wenqi
 */

public class HttpClient {

    private OkHttpClient client=new OkHttpClient();

    /**
     * get 请求
     * @param url 请求地址
     * @return 接口返回
     * @throws IOException 异常
     */
    public String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .header("user-authority", DES.encryptDES(UUID.randomUUID().toString().replace("-","")+",fawzi77"))
                .header("apiKey", UUID.randomUUID().toString())
                .header("Content-Safety",String.valueOf(new Date().getTime()))
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post 请求
     * @param url 请求地址
     * @param json 消息体
     * @return 接口返回
     * @throws IOException 异常
     */
    public String post(String url,String json) throws Exception {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("user-authority", DES.encryptDES(UUID.randomUUID().toString().replace("-","")+",fawzi77"))
                .header("apiKey", UUID.randomUUID().toString())
                .header("Content-Safety",String.valueOf(new Date().getTime()))
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
