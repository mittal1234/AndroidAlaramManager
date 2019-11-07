package com.example.alarammanagerexample.AlaramManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlaramToastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"THis is my Alaram",Toast.LENGTH_LONG).show();

    }
}
