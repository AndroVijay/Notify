package app.example.rationalheads.vijay.notify.notify.ui.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

import app.example.rationalheads.vijay.notify.notify.ui.base.constance.AppConstants;
import app.example.rationalheads.vijay.notify.notify.ui.persistence.NotifyPreference;


public class BadgeUtils {

    public static int mCount=0;

    public static void setBadge(Context context, int count) {

        // mCount = NotifyPreference.getInstance(context).getInteger(AppConstants.BADGE_COUNT,0);


             setBadgeSamsung(context, count);




        //setBadgeSony(context, count);
    }

    public static void clearBadge(Context context) {
        setBadgeSamsung(context, 0);
        clearBadgeSony(context);
    }

public static int setBadgeCount(){


     int badgeCount=0;
     badgeCount = badgeCount + 1;

    return badgeCount;

}
    private static void setBadgeSamsung(Context context, int count) {
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", launcherClassName);
        context.sendBroadcast(intent);
    }

//    private static void setBadgeSony(Context context, int count) {
//        String launcherClassName = getLauncherClassName(context);
//        if (launcherClassName == null) {
//            return;
//        }
//
//        Intent intent = new Intent();
//        intent.setAction("com.samsung.home.action.UPDATE_BADGE");
//        intent.putExtra("com.samsung.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);
//        intent.putExtra("com.samsung.home.intent.extra.badge.SHOW_MESSAGE", true);
//        intent.putExtra("com.samsung.home.intent.extra.badge.MESSAGE", String.valueOf(count));
//        intent.putExtra("com.samsung.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());
//
//        context.sendBroadcast(intent);
//    }


    private static void clearBadgeSony(Context context) {
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }

        Intent intent = new Intent();
        intent.setAction("com.samsung.home.action.UPDATE_BADGE");
        intent.putExtra("com.samsung.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);
        intent.putExtra("com.samsung.home.intent.extra.badge.SHOW_MESSAGE", false);
        intent.putExtra("com.samsung.home.intent.extra.badge.MESSAGE", String.valueOf(0));
        intent.putExtra("com.samsung.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());

        context.sendBroadcast(intent);
    }

    private static String getLauncherClassName(Context context) {

        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }
}


