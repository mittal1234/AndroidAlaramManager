package com.example.alarammanagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.alarammanagerexample.AlaramManager.AlaramNotificationReciver;
import com.example.alarammanagerexample.AlaramManager.AlaramToastReceiver;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RadioButton rdNotification, rdiToast;
        Button btnoneTime, btnRepeating;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdNotification = findViewById(R.id.rd_Notification);
        rdiToast = findViewById(R.id.rd_Toast);
        btnoneTime = findViewById(R.id.btn_one_time_alarm);
        btnRepeating = findViewById(R.id.btn_repeat_alaram);

        btnoneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (rdNotification.isChecked())
                    startAlarm(true,false);
                else
                    startAlarm(false,true);

            }
        });
        btnRepeating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdNotification.isChecked())
                    startAlarm(true,true);
                else
                    startAlarm(false,false);
            }
        });


    }
    private void startAlarm(boolean isNotification,boolean isRepeat){
        AlarmManager manager= (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;
        if (!isNotification){
            myIntent = new Intent(AlarmManagerActivity.this, AlaramToastReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

        }
        else {
            myIntent= new Intent(AlarmManagerActivity.this, AlaramNotificationReciver.class);
            pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);
        }
        if (!isRepeat)
            manager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,pendingIntent);
        else
            manager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,3000,pendingIntent);

    }
}
