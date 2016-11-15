package android.wenqi.cn.simpleandroid.service;

import android.util.Log;
import android.wenqi.cn.simpleandroid.utils.MD5Util;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.UUID;

/**
 * Created by DiyFin-Java on 2016/11/15.
 */

public class LoginService {

    private String ip1="192.168.1.105";//home
    private String ip2="192.168.0.128";//company

    public String login(String userName,String pwd) throws IOException {
        OkHttpClient client=new OkHttpClient();
        String json="{\"userName\":\""+userName+"\",\"pwd\":\""+pwd+"\"}";
        String url="http://"+ip1+":8080/android/login";
        Log.d("json",json);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        String msg=MD5Util.string2MD5(userName+","+"fawzi77");
        Log.i("加密后信息",msg);
        Log.i("解密后信息",MD5Util.md52String(msg));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("user-authority", msg)
                .header("apiKey", UUID.randomUUID().toString())
                .header("Content-Safety",String.valueOf(new Date().getTime()))
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
