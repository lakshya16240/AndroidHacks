package com.cb.android.changetext;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService2 extends Service {
    public MyService2() {
        Log.d("SRV", "MyService: 2");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SRV", "onStartCommand: 2");
        String message = "nothing 2";
        if (intent != null) {
             message = intent.getStringExtra("hello2");
        }
        Toast.makeText(this, "onStartCommand2" +" "+ message, Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
