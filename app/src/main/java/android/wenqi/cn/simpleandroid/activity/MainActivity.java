package android.wenqi.cn.simpleandroid.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.wenqi.cn.simpleandroid.R;
import android.wenqi.cn.simpleandroid.service.ListenerService;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        TextView textView= (TextView) findViewById(R.id.textView3);
        textView.setText("恭喜" + userName+"登录成功");
        Button button= (Button) findViewById(R.id.shareBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
//                Uri uri=Uri.parse("content://contacts/people/17706525961");
//                sendIntent.setData(uri);
                startActivity(sendIntent);
            }
        });
//        Intent service=new Intent();
//        intent.setClass(this.getApplicationContext(), ListenerService.class);
//        startService(service);
    }
}
