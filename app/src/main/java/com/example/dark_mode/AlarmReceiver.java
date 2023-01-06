package com.example.dark_mode;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.img4, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();

        Intent i =new Intent(context,Alarm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"Notified")
                .setSmallIcon(R.drawable.searchicon)
                .setContentTitle("Alarm")
                .setContentText("Got the notification")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(2, builder.build());


//nofitication2
        Intent i2 =new Intent(context,Alarm.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 1, i2, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(context,"Notified again")
                .setLargeIcon(largeicon)
                .setSmallIcon(R.drawable.searchicon)
                .setContentTitle("Alarm2")
                .setContentText("Got the notification again")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent2);

        NotificationManagerCompat notificationManagerCompat2 = NotificationManagerCompat.from(context);
        notificationManagerCompat2.notify(1, builder2.build());


        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(context.getResources(),R.drawable.img5,null))).getBitmap())
                .bigLargeIcon(largeicon)
                .setBigContentTitle("Notfiy")
                .setSummaryText("notified again");




            Intent i3 = new Intent(context, Alarm.class);
            PendingIntent pendingIntent3 = PendingIntent.getActivity(context, 2, i3, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder3 = new NotificationCompat.Builder(context, "Notified once again")
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.searchicon)
                    .setContentTitle("Alarm3")
                    .setContentText("Got the notification again ")
                    .setAutoCancel(true)
                    .setStyle(bigPictureStyle)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent3);

            NotificationManagerCompat notificationManagerCompat3 = NotificationManagerCompat.from(context);
            notificationManagerCompat3.notify(3, builder3.build());



        Intent i4 = new Intent(context, Alarm.class);
        PendingIntent pendingIntent4 = PendingIntent.getActivity(context, 4, i4, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent likeIntent = new Intent(context,Alarm.class);
        PendingIntent likePIntent = PendingIntent.getActivity(context, 4, likeIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent dislikeIntent = new Intent(context,Alarm.class);
        PendingIntent dislikePIntent = PendingIntent.getActivity(context, 4, dislikeIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder4 = new NotificationCompat.Builder(context, "Notified once again")
                .setLargeIcon(largeicon)
                .setSmallIcon(R.drawable.searchicon)
                .setContentTitle("Alarm4")
                .setContentText("Show Comments")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent4)
                .addAction(R.drawable.like,"Like",likePIntent)
                .addAction(R.drawable.dislike,"Dislike",dislikePIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent4);

        NotificationManagerCompat notificationManagerCompat4 = NotificationManagerCompat.from(context);
        notificationManagerCompat4.notify(4, builder4.build());



    }



}
