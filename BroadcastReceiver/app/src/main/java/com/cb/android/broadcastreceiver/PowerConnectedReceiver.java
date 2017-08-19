package com.cb.android.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerConnectedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()==Intent.ACTION_POWER_CONNECTED)
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
    }
}
