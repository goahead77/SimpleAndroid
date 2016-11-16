package android.wenqi.cn.simpleandroid.service;

import android.util.Log;
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
 * Created by DiyFin-Java on 2016/11/15.
 */

public class LoginService {

    private String ip1="192.168.1.105";//home
    private String ip2="192.168.0.128";//company

    public String login(String userName,String pwd) throws Exception {
        OkHttpClient client=new OkHttpClient();
        String json="{\"userName\":\""+userName+"\",\"pwd\":\""+pwd+"\"}";
        String url="http://"+ip2+":8080/android/login";
        Log.d("json",json);
        HttpClient httpClient=new HttpClient();
        return httpClient.post(url,json);
    }

}
