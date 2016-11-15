package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.wenqi.cn.simpleandroid.R;
import android.widget.EditText;
import android.widget.Toast;

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
            if("admin".equals(userName) &&"admin".equals(pwd)){
                Intent intent=new Intent();
                intent.putExtra("userName",userName);
                intent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"账号或密码输入错误",Toast.LENGTH_LONG).show();
            }
        }
    }
}
