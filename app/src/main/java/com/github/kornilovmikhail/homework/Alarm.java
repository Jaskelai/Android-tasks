package com.github.kornilovmikhail.homework;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class Alarm extends BroadcastReceiver {

    private final String CHANNEL_ID = "777";
    private final int ALARM_NOTIF_ID = 666;
    private NotificationManager notificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri sound = Uri.parse("android.resource://" + context.getApplicationContext().getPackageName() + "/" + R.raw.pivko);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_local_drink_black_24dp)
                        .setContentTitle("Yo!")
                        .setContentText("Wake up!")
                        .setVisibility(Notification.VISIBILITY_PUBLIC)
                        .setSound(sound)
                        .setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (sound != null) {
                AudioAttributes attributes = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build();
                int importance = NotificationManager.IMPORTANCE_HIGH;
                String nameChannel = "Alarm channel";
                String description = "Channel for alarm";
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, nameChannel, importance);
                channel.setDescription(description);
                channel.setShowBadge(false);
                channel.setSound(sound, attributes);
                notificationManager.createNotificationChannel(channel);
            }
        }
        builder.setContentIntent(notifOnClick(context));
        notificationManager.notify(ALARM_NOTIF_ID, builder.build());
    }

    private PendingIntent notifOnClick(Context context) {
        Intent resIntent = new Intent(context, WakeUpActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(resIntent);
        return stackBuilder.getPendingIntent(1, PendingIntent.FLAG_CANCEL_CURRENT);
    }
}
