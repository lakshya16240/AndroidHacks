package com.cb.android.changetext;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static android.R.id.message;
import static android.content.ContentValues.TAG;
import static android.os.Build.VERSION_CODES.M;

public class MyService extends Service {
    public MyService() {
        Log.d("SRV", "MyService: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SRV", "onStartCommand: ");
        String message = "nothing";
        if (intent != null) {
            message = intent.getStringExtra("hello");
        }
        Log.d("SRV", "onStartCommand:  " + String.valueOf(message));
        Toast.makeText(this, "onStartCommand" +" " +  message, Toast.LENGTH_SHORT).show();
        Intent i =new Intent(MyService.this,MyService2.class);
        i.putExtra("hello2","Started from MyService");
        startService(i);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
