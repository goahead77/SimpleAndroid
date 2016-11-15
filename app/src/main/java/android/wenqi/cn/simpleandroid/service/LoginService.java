package android.wenqi.cn.simpleandroid.service;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * Created by DiyFin-Java on 2016/11/15.
 */

public class LoginService {
    public String login(String userName,String pwd) throws IOException {
        OkHttpClient client=new OkHttpClient();
        String json="{\"userName\":\""+userName+"\",\"pwd\":\""+pwd+"\"}";
        String url="http://192.168.0.128:8080/android/login";
        Log.d("json",json);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        Log.d("response",response.body().toString());
        return response.body().string();
    }

}
