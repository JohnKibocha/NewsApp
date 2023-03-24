package com.news.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Notification extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        relativeLayout=(RelativeLayout)findViewById(R.id.notificationCard);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueNotification();
            }
        });
    }
    public void issueNotification(){
        NotificationChannel mchannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            mchannel = new NotificationChannel("1","notification", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(mchannel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Scientists discover new planet with life")
                    .setContentText("A team of scientists has discovered a new planet that could potentially support life.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            Intent notificationIntent = new Intent(this, Notification.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);
            NotificationManager manager1 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager1.createNotificationChannel(mchannel);
            manager1.notify(0, builder.build());
        }

    }
}