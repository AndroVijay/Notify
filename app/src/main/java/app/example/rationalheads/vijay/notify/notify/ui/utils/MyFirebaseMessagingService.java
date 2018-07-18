package app.example.rationalheads.vijay.notify.notify.ui.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import app.example.rationalheads.vijay.notify.R;
import app.example.rationalheads.vijay.notify.notify.ui.activity.ActivityA;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private int messageCount=0;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        if (remoteMessage.getData().size()>=0) {


            messageCount=messageCount+1;
            //NotifyPreference.getInstance(getApplicationContext()).getInteger(AppConstants.BADGE_COUNT,messageCount);
            BadgeUtils.setBadge(this, messageCount);
            sendNotification(remoteMessage.getData());
        }

    }

    private void sendNotification(Map<String, String> data) {


        try {

            Intent notificationIntent = null;

            if (!TextUtils.isEmpty("URL")) {
                notificationIntent = new Intent(Intent.ACTION_VIEW);
                notificationIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                notificationIntent.setData(Uri.parse("URL"));
            } else {
                notificationIntent = new Intent(this, ActivityA.class);
                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }

            PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.iqmojo_logo)
                    .setColor(ContextCompat.getColor(this, R.color.notify_icon))
                    .setContentTitle("Notify")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(intent);

            NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            int rand = (int) (Math.random() * 50 + 1);
            if (notificationManager != null) {
                notificationManager.notify(rand, notificationBuilder.build());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    private String getValueFromKey(Map<String, String> mapData, String key) {
//        String value = "";
//        if (mapData.containsKey(key) && mapData.get(key) != null)
//            value = mapData.get(key).toString();
//        return value;
//    }
}
