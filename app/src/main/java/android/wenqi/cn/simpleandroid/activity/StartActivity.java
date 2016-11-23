package android.wenqi.cn.simpleandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.wenqi.cn.simpleandroid.R;

/**
 * Created by DiyFin-Java on 2016/11/17.
 */

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }
}
