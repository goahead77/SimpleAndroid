package android.wenqi.cn.simpleandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.wenqi.cn.simpleandroid.R;
import android.widget.Toast;

/**
 * Created by DiyFin-Java on 2016/11/17.
 */

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity);
        String msg=stringFromJNI();
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    static {
        System.loadLibrary("hello-jni");

    }

    public native String stringFromJNI();
}
