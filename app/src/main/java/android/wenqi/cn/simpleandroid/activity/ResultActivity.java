package android.wenqi.cn.simpleandroid.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.wenqi.cn.simpleandroid.R;
import android.widget.Toast;

/**
 * Created by DiyFin-Java on 2016/11/29.
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        String id=getIntent().getStringExtra("msdId");
        Toast.makeText(this,"MsgID"+id,Toast.LENGTH_LONG).show();
    }
}
