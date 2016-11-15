package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.wenqi.cn.simpleandroid.R;
import android.wenqi.cn.simpleandroid.pojo.ApiResult;
import android.wenqi.cn.simpleandroid.service.LoginService;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * @author wenqi
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        findViewById(R.id.loginSubmitBtn).setOnClickListener(new ClickListener());

    }
    class ClickListener implements View.OnClickListener{

        private String userName;

        private String pwd;

        private Handler handler;

        @Override
        public void onClick(View view) {
            EditText userNameEditText= (EditText) findViewById(R.id.userNameEditText);
            EditText userPwdEditText= (EditText) findViewById(R.id.userPwdEditText);
            userName=userNameEditText.getText().toString();
            pwd=userPwdEditText.getText().toString();
            new Thread(runnable).start();
        }

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                handler=new Handler();
                LoginService loginService=new LoginService();

                String result= null;
                try {
                    result = loginService.login(userName,pwd);
                } catch (IOException e) {
                    Log.e("Exception",e.getMessage());
                }
                Log.d("loginResult",result);
                    Message message=new Message();
                    Bundle bundle=new Bundle();
                    bundle.putString("result",result);
                    message.setData(bundle);
                    handler.handleMessage(message);
                    Gson gson=new Gson();
                    ApiResult apiResult=gson.fromJson(result, ApiResult.class);
                    if(apiResult.getCode()==200){
                        Intent intent=new Intent();
                        intent.setClass(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else if(apiResult.getCode()==500){
                        Toast.makeText(getApplicationContext(),apiResult.getMsg(),Toast.LENGTH_LONG).show();
                    }
            }
        };

    }

}
