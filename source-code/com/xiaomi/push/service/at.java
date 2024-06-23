package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.h;
import com.xiaomi.push.hw;
import com.xiaomi.push.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class at {
    private static final boolean a = Log.isLoggable("NCHelper", 3);

    private static int a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) bk.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (Exception e) {
            b.m183a("NCHelper", "is user locked error" + e);
        }
        return i;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(ax axVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String a2 = axVar.m814a(str);
        boolean z = a;
        if (z) {
            a("createChannel: appChannelId:" + a2 + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(a2, charSequence, i2);
        notificationChannel.setDescription(str2);
        boolean z2 = false;
        notificationChannel.enableVibration((i & 2) != 0);
        if ((i & 4) != 0) {
            z2 = true;
        }
        notificationChannel.enableLights(z2);
        if ((i & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + axVar.m813a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z) {
            a("create channel:" + notificationChannel);
        }
        a(axVar, notificationChannel, str4);
        return a2;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    static void a(Context context, ax axVar, NotificationChannel notificationChannel, int i, String str) {
        if (i > 0) {
            int a2 = h.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
            NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    a3.setSound(null, null);
                } else {
                    a3.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    a3.enableVibration(false);
                } else {
                    a3.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    a3.enableLights(false);
                } else {
                    a3.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                a3.setImportance(importance);
            }
            if ((i & 2) != 0) {
                a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            axVar.a(a3);
            axVar.a(notificationChannel, true);
            e.a(axVar.m813a(), notificationChannel.getId(), a2, 0);
            return;
        }
        axVar.a(notificationChannel);
    }

    public static void a(Context context, String str) {
        if (m.m735a(context) && !TextUtils.isEmpty(str)) {
            c(context, str);
            e.a(context, str);
        }
    }

    private static void a(Context context, List<String> list) {
        if (a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = a(context).edit();
            for (String str : list) {
                edit.remove(str);
            }
            edit.apply();
        }
    }

    static void a(hw hwVar) {
        Map<String, String> map;
        if (hwVar != null && (map = hwVar.f532a) != null && map.containsKey("REMOVE_CHANNEL_MARK")) {
            hwVar.f528a = 0;
            hwVar.f532a.remove("channel_id");
            hwVar.f532a.remove("channel_importance");
            hwVar.f532a.remove("channel_name");
            hwVar.f532a.remove("channel_description");
            hwVar.f532a.remove("channel_perm");
            b.m182a("delete channel info by:" + hwVar.f532a.get("REMOVE_CHANNEL_MARK"));
            hwVar.f532a.remove("REMOVE_CHANNEL_MARK");
        }
    }

    @TargetApi(26)
    private static void a(ax axVar, NotificationChannel notificationChannel, String str) {
        char c;
        int i;
        int i2;
        Context a2 = axVar.m812a();
        String id = notificationChannel.getId();
        String a3 = ax.a(id, axVar.m813a());
        boolean z = a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + a3);
        }
        if (!m.m735a(a2) || TextUtils.equals(id, a3)) {
            NotificationChannel a4 = axVar.m811a(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + a4);
            }
            if (a4 == null) {
                axVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) a2.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a3);
            NotificationChannel a5 = axVar.m811a(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + a5);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a6 = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + a6);
                }
                if (a5 != null) {
                    i2 = a(a5);
                    axVar.a(a6, i2 == 0);
                    c = 3;
                } else {
                    i2 = a(notificationChannel2);
                    a(a2, axVar, a6, i2, notificationChannel2.getId());
                    c = 4;
                }
                b(a2, id);
                notificationManager.deleteNotificationChannel(a3);
            } else if (a5 == null) {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                axVar.a(notificationChannel);
                i2 = 0;
                c = 1;
            } else if (m803a(a2, id) || !a(notificationChannel, a5)) {
                i2 = 0;
                c = 0;
            } else {
                if (z) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i2 = a(a5);
                axVar.a(notificationChannel, i2 == 0);
                c = 2;
            }
            i = i2;
        }
        e.a(axVar.m812a(), axVar.m813a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    private static void a(String str) {
        b.m183a("NCHelper", str);
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        boolean z2 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z3 = true;
        if (!TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        boolean z4 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z2 = true;
        }
        if (z4 != z2) {
            notificationChannel.setSound(null, null);
            if (a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z3 = z;
        }
        if (a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z3);
        }
        return z3;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m803a(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + AltriaXLaunchTime.SPACE + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            ax a2 = ax.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m816a(str2)) {
                    arrayList.add(str2);
                    if (a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }
}
