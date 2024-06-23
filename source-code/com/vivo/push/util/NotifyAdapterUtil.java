package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.vivo.push.b.p;
import com.vivo.push.c.d;
import com.vivo.push.d.r;
import com.vivo.push.e;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
public class NotifyAdapterUtil {
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i);
        return true;
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        synchronized (NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                        sNotificationManager.deleteNotificationChannel("default");
                    }
                }
                NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLockscreenVisibility(1);
                sNotificationManager.createNotificationChannel(notificationChannel2);
            }
        }
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        p.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, aVar);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, r.a aVar) {
        Notification notification;
        int i;
        int i2;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i3 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong("pushId", j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            notification = builder.build();
        } else if (i4 >= 19) {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            notification = builder2.build();
        } else {
            notification = new Notification();
        }
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i3;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            i = i3;
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            i = i3;
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, i2);
        if (list == null || list.isEmpty() || (bitmap = list.get(i2)) == null) {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        } else {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        }
        Bitmap bitmap2 = null;
        if (list != null && list.size() > 1) {
            bitmap2 = list.get(1);
        }
        if (bitmap2 == null) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        } else if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
        }
        notification.contentView = remoteViews;
        if (i4 >= 16 && TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        p.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            if (i4 >= 18) {
                intent.putExtra("security_avoid_pull_rsa", d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", u.a(d.a(context).a().a()));
            }
        } catch (Exception e) {
            p.a(TAG, "pushNotificationByCustom encrypt ：" + e.getMessage());
        }
        new p(packageName, j, insideNotificationItem).b(intent);
        notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456);
        if (sNotificationManager != null) {
            int k = e.a().k();
            if (k == 0) {
                try {
                    sNotificationManager.notify(sNotifyId, notification);
                    if (aVar != null) {
                        aVar.a();
                    }
                } catch (Exception e2) {
                    p.a(TAG, e2);
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            } else if (k == 1) {
                sNotificationManager.notify((int) j, notification);
                if (aVar != null) {
                    aVar.a();
                }
            } else {
                p.a(TAG, "unknow notify style ".concat(String.valueOf(k)));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0192 A[Catch:{ Exception -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        String str;
        Bitmap bitmap;
        String str2;
        Notification.Builder builder;
        int i2;
        int i3;
        Bitmap bitmap2;
        String str3;
        NotificationManager notificationManager;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i4 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list == null || list.isEmpty()) {
            str = packageName;
            bitmap = null;
        } else {
            bitmap = list.get(0);
            if (bitmap == null || defaultNotifyIcon <= 0 || (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) == null) {
                str = packageName;
            } else {
                int width = decodeResource.getWidth();
                str = packageName;
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = c.a(bitmap, width, height);
            }
        }
        Bundle bundle = new Bundle();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            str2 = TAG;
            builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        } else {
            str2 = TAG;
            builder = new Notification.Builder(context);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            } else if (i5 <= 22) {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i4));
            }
        }
        if (i5 >= 19) {
            bundle.putLong("pushId", j);
            builder.setExtras(bundle);
        }
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i4 = defaultSmallIconId;
        }
        builder.setSmallIcon(i4);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        builder.setWhen(isShowTime ? System.currentTimeMillis() : 0);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
        } else if (ringerMode == 2) {
            i2 = 1;
            builder.setDefaults(1);
            if (list != null || list.size() <= i2) {
                i3 = i;
                bitmap2 = null;
            } else {
                bitmap2 = list.get(i2);
                i3 = i;
            }
            if (i3 != i2) {
                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.setBigContentTitle(title);
                bigTextStyle.bigText(content);
                builder.setStyle(bigTextStyle);
            }
            if (bitmap2 != null) {
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                bigPictureStyle.setBigContentTitle(title);
                bigPictureStyle.setSummaryText(content);
                bigPictureStyle.bigPicture(bitmap2);
                builder.setStyle(bigPictureStyle);
            }
            builder.setAutoCancel(true);
            Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
            intent.putExtra("command_type", "reflect_receiver");
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            if (i5 >= 18) {
                intent.putExtra("security_avoid_pull_rsa", d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", u.a(d.a(context).a().a()));
            }
            str3 = str2;
            new p(str, j, insideNotificationItem).b(intent);
            builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456));
            Notification build = builder.build();
            int k = e.a().k();
            notificationManager = sNotificationManager;
            if (notificationManager != null) {
                return;
            }
            if (k == 0) {
                try {
                    notificationManager.notify(sNotifyId, build);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    p.a(str3, e);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            } else if (k == 1) {
                notificationManager.notify((int) j, build);
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            } else {
                p.a(str3, "unknow notify style ".concat(String.valueOf(k)));
                return;
            }
        }
        i2 = 1;
        if (list != null) {
        }
        i3 = i;
        bitmap2 = null;
        if (i3 != i2) {
        }
        if (bitmap2 != null) {
        }
        builder.setAutoCancel(true);
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        try {
            intent2.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            if (i5 >= 18) {
            }
            str3 = str2;
        } catch (Exception e2) {
            str3 = str2;
            p.a(str3, "pushNotificationBySystem encrypt ：" + e2.getMessage());
        }
        new p(str, j, insideNotificationItem).b(intent2);
        builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent2, 268435456));
        Notification build2 = builder.build();
        int k2 = e.a().k();
        notificationManager = sNotificationManager;
        if (notificationManager != null) {
        }
    }

    public static boolean repealNotifyById(Context context, long j) {
        int k = e.a().k();
        if (k == 0) {
            long b = w.b().b("com.vivo.push.notify_key", -1);
            if (b == j) {
                p.d(TAG, "undo showed message ".concat(String.valueOf(j)));
                p.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
                return cancelNotify(context, sNotifyId);
            }
            p.d(TAG, "current showing message id " + b + " not match " + j);
            p.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
            return false;
        } else if (k == 1) {
            return cancelNotify(context, (int) j);
        } else {
            p.a(TAG, "unknow cancle notify style ".concat(String.valueOf(k)));
            return false;
        }
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
