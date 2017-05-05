package com.phoebus_ravi.www.chiku;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by gravi on 5/5/2017.
 */

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
                .setAutoCancel(true);

        notificationManager.notify(100,builder.build());


    }
}
