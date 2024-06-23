package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: Taobao */
public final class h implements BaseNotifyDataAdapter {
    private static int e;
    private static int f;
    private Resources a;
    private String b;
    private String c;
    private String d;

    private static boolean a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int i;
        if (a(e)) {
            return e;
        }
        String str = this.d;
        if (!a(str)) {
            i = -1;
        } else {
            i = a(str, "_notifyicon");
        }
        e = i;
        if (a(i)) {
            return e;
        }
        for (String str2 = this.c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            Resources resources = this.a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_notifyicon", "drawable", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int i;
        if (a(f)) {
            return f;
        }
        String str = this.d;
        if (!a(str)) {
            i = -1;
        } else {
            i = a(str, "_icon");
        }
        f = i;
        if (a(i)) {
            return f;
        }
        for (String str2 = this.c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            Resources resources = this.a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_icon", "drawable", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
        this.c = j.a();
        this.d = Build.VERSION.getRELEASE();
    }

    private int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    p.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.a.getIdentifier(str3, "drawable", this.b);
                    if (identifier > 0) {
                        p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                p.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
