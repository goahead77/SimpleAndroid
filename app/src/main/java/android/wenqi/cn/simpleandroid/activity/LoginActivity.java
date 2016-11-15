package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.os.Bundle;
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

        @Override
        public void onClick(View view) {
            EditText userNameEditText= (EditText) findViewById(R.id.userNameEditText);
            EditText userPwdEditText= (EditText) findViewById(R.id.userPwdEditText);
            String userName=userNameEditText.getText().toString();
            String pwd=userPwdEditText.getText().toString();
            LoginService loginService=new LoginService();
            try {
                String result=loginService.login(userName,pwd);
                Toast.makeText(getApplicationContext(),"登录结果："+result,Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
