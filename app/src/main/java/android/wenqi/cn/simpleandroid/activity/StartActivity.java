package android.wenqi.cn.simpleandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.wenqi.cn.simpleandroid.R;

/**
 * Created by DiyFin-Java on 2016/11/17.
 */

public class StartActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        this.onRestart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        try {
            Thread.sleep(5000);
            Intent intent=new Intent();
            intent.setClass(this,LoginActivity.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
