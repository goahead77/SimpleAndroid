package android.wenqi.cn.simpleandroid.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * @author wenqi
 */

public class ListenerService extends IntentService {

    public ListenerService() {
        super("ListenerService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("执行次数："+i);
            if(i==10){
                stopSelf();
                break;
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"服务已启动",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"服务已关闭",Toast.LENGTH_LONG).show();
        Log.d("SERVICE","服务已关闭");
        super.onDestroy();
    }
}
