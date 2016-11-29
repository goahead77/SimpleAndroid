package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.wenqi.cn.simpleandroid.R;
import android.wenqi.cn.simpleandroid.service.ListenerService;

/**
 * Created by DiyFin-Java on 2016/11/29.
 */

public class ServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);
        Intent service=new Intent(this.getApplicationContext(), ListenerService.class);
        startService(service);
    }

    public void stopService(View view){
        Intent service=new Intent(this.getApplicationContext(), ListenerService.class);
        stopService(service);
    }
}
