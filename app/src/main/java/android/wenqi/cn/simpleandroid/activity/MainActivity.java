package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.wenqi.cn.simpleandroid.R;
import android.wenqi.cn.simpleandroid.service.ListenerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        this.setTitle("恭喜" + userName+"登录成功");
        Intent service=new Intent();
        intent.setClass(this.getApplicationContext(), ListenerService.class);
        startService(service);
    }
}
