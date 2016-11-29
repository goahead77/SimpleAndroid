package android.wenqi.cn.simpleandroid.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
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
    }

    public void gotoServiceActivity(View view){
        Intent intent=new Intent(this,ServiceActivity.class);
        startActivity(intent);
    }

    public void sendNotification(View view){
        Bundle bundle=new Bundle();
        bundle.putString("msdId","id");
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                .setAutoCancel(true)
                .setExtras(bundle);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ResultActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(10086, mBuilder.build());
    }
}
