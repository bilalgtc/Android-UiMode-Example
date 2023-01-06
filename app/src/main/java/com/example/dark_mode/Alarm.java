package com.example.dark_mode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {
    SwitchCompat sw1, sw2, sw3, sw4;
    AlarmManager alarmManager;
    PendingIntent pendingIntent, pendingIntent2, pendingIntent3;
    NotificationManager manager, manager2;
    TextView txt1, txt2, txt3, txt4;
    Calendar calendar;
    MaterialTimePicker picker,picker2,picker3,picker4;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        sw1 = findViewById(R.id.s1);
        sw2 = findViewById(R.id.s2);
        sw3 = findViewById(R.id.s3);
        sw4 = findViewById(R.id.s4);

        txt1 = findViewById(R.id.textView4);
        txt2 = findViewById(R.id.textView5);
        txt3 = findViewById(R.id.textView6);
        txt4 = findViewById(R.id.textView7);

        b1=findViewById(R.id.start_btn);
        b2=findViewById(R.id.stop_btn);

        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .setHour(12)
                        .setTitleText("Alarm Time")
                        .build();

                picker.show(getSupportFragmentManager(), "Notify");

                picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt1.setText(picker.getHour() +":"+picker.getMinute());
                    }
                });

            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker2 = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .setHour(12)
                        .setTitleText("Alarm Time")
                        .build();

                picker2.show(getSupportFragmentManager(), "Notify");

                picker2.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt2.setText(picker2.getHour() +":"+picker2.getMinute());
                    }
                });

            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker3 = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .setHour(12)
                        .setTitleText("Alarm Time")
                        .build();

                picker3.show(getSupportFragmentManager(), "Notify");

                picker3.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt3.setText(picker3.getHour() +":"+picker3.getMinute());
                    }
                });

            }
        });


        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker4 = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .setHour(12)
                        .setTitleText("Alarm Time")
                        .build();

                picker4.show(getSupportFragmentManager(), "Notify");

                picker4.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt4.setText(picker4.getHour() +":"+picker4.getMinute());
                    }
                });

            }
        });


        sw1.setOnCheckedChangeListener((buttonView, isChecked) -> {

            calendar.set(Calendar.HOUR_OF_DAY, picker.getHour());
            calendar.set(Calendar.MINUTE, picker.getMinute());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Alarm";
                String desc = "Got the Notification";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel = new NotificationChannel("Notified", name, importance);
                channel.setDescription(desc);

                manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }


            if (sw1.isChecked()) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent i = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Alarm.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(Alarm.this, "alarm set successfully", Toast.LENGTH_SHORT).show();


            } else {
                Intent i = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Alarm.this, 0, i, 0);
                if (alarmManager == null) {
                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                }
                alarmManager.cancel(pendingIntent);
                Toast.makeText(Alarm.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });


        sw2.setOnCheckedChangeListener((buttonView, isChecked) -> {

            calendar.set(Calendar.HOUR_OF_DAY, picker2.getHour());
            calendar.set(Calendar.MINUTE, picker2.getMinute());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name2 = "Alarm2";
                String desc = "Got the Notification again";
                int importance2 = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel2 = new NotificationChannel("Notified Again", name2, importance2);
                channel2.setDescription(desc);

                manager2 = getSystemService(NotificationManager.class);
                manager2.createNotificationChannel(channel2);
            }


            if (sw2.isChecked()) {


                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent i2 = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent2 = PendingIntent.getBroadcast(Alarm.this, 1, i2, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent2);
                Toast.makeText(Alarm.this, "alarm set successfully", Toast.LENGTH_SHORT).show();


            } else {
                Intent i = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Alarm.this, 1, i, 0);
                if (alarmManager == null) {
                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                }
                alarmManager.cancel(pendingIntent2);
                Toast.makeText(Alarm.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });


        sw3.setOnCheckedChangeListener((buttonView, isChecked) -> {

            calendar.set(Calendar.HOUR_OF_DAY, picker3.getHour());
            calendar.set(Calendar.MINUTE, picker3.getMinute());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name2 = "Alarm3";
                String desc = "Got the Notification again";
                int importance2 = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel3 = new NotificationChannel("Notified once again", name2, importance2);
                channel3.setDescription(desc);

                manager2 = getSystemService(NotificationManager.class);
                manager2.createNotificationChannel(channel3);
            }


            if (sw3.isChecked()) {


                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent i3 = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent3 = PendingIntent.getBroadcast(Alarm.this, 2, i3, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent3);
                Toast.makeText(Alarm.this, "alarm set successfully", Toast.LENGTH_SHORT).show();


            } else {
                Intent i = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent3 = PendingIntent.getBroadcast(Alarm.this, 1, i, 0);
                if (alarmManager == null) {
                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                }
                alarmManager.cancel(pendingIntent3);
                Toast.makeText(Alarm.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        sw4.setOnCheckedChangeListener((buttonView, isChecked) -> {

            calendar.set(Calendar.HOUR_OF_DAY, picker4.getHour());
            calendar.set(Calendar.MINUTE, picker4.getMinute());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name2 = "Alarm3";
                String desc = "Got the Notification again";
                int importance2 = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel3 = new NotificationChannel("Notified once again", name2, importance2);
                channel3.setDescription(desc);

                manager2 = getSystemService(NotificationManager.class);
                manager2.createNotificationChannel(channel3);
            }


            if (sw4.isChecked()) {


                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent i3 = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent3 = PendingIntent.getBroadcast(Alarm.this, 4, i3, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent3);
                Toast.makeText(Alarm.this, "alarm set successfully", Toast.LENGTH_SHORT).show();


            } else {
                Intent i = new Intent(Alarm.this, AlarmReceiver.class);
                pendingIntent3 = PendingIntent.getBroadcast(Alarm.this, 1, i, 0);
                if (alarmManager == null) {
                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                }
                alarmManager.cancel(pendingIntent3);
                Toast.makeText(Alarm.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),BackService.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),BackService.class));
            }
        });
    }


}