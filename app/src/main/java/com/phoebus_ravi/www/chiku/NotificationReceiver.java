package com.phoebus_ravi.www.chiku;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intentRepeatingActivity = new Intent(context, RepeatingActivity.class);
        intentRepeatingActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent2 = PendingIntent.getActivity(context,100,intentRepeatingActivity,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent2)
                .setSmallIcon(R.drawable.flower_background)
                .setContentTitle("Good Morning Beta")
                .setContentText("Have a nice day.")
                .setAutoCancel(true)
                .setColor(ContextCompat.getColor(context,R.color.colorBackground))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setLargeIcon(largeIcon(context));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder.setPriority(Notification.PRIORITY_HIGH);
        }

        notificationManager.notify(100,builder.build());
    }

    private Bitmap largeIcon(Context context) {
        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.drawable.parents_img2);
        return largeIcon;
    }
}
