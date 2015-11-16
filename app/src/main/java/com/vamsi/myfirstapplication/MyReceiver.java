package com.vamsi.myfirstapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by m1033421 on 15/11/15.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.vamsi.hello")) {
            Toast.makeText(context, "Received Broadcast", Toast.LENGTH_SHORT).show();
        } else if(intent.getAction().equals("understoodBR")) {
            Toast.makeText(context, "Understood broadcast receivers", Toast.LENGTH_SHORT).show();
        }
    }
}
