package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.wenqi.cn.simpleandroid.R;
import android.wenqi.cn.simpleandroid.service.LoginService;
import android.widget.EditText;
import android.widget.Toast;

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
                try {
                    loginService.login(userName,pwd);
                    String result=loginService.login(userName,pwd);
                    Message message=new Message();
                    Bundle bundle=new Bundle();
                    bundle.putString("result",result);
                    message.setData(bundle);
                    handler.handleMessage(message);
                    Toast.makeText(getApplicationContext(),"登录结果："+result,Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"登录异常",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        };

    }

}
