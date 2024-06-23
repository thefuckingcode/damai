package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bz;
import com.xiaomi.push.service.ca;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class hg {
    private static volatile hg a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f457a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hh> f458a = new HashMap();

    private hg(Context context) {
        this.f457a = context;
    }

    public static hg a(Context context) {
        if (context == null) {
            b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (hg.class) {
                if (a == null) {
                    a = new hg(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hn hnVar = new hn();
        hnVar.d(str3);
        hnVar.c(str4);
        hnVar.a(j);
        hnVar.b(str5);
        hnVar.a(true);
        hnVar.a("push_sdk_channel");
        hnVar.e(str2);
        return a(hnVar, str);
    }

    /* access modifiers changed from: package-private */
    public hh a() {
        hh hhVar = this.f458a.get("UPLOADER_PUSH_CHANNEL");
        if (hhVar != null) {
            return hhVar;
        }
        hh hhVar2 = this.f458a.get("UPLOADER_HTTP");
        if (hhVar2 != null) {
            return hhVar2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public Map<String, hh> m547a() {
        return this.f458a;
    }

    public void a(hh hhVar, String str) {
        if (hhVar == null) {
            b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m547a().put(str, hhVar);
        }
    }

    public boolean a(hn hnVar, String str) {
        if (TextUtils.isEmpty(str)) {
            b.m182a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (bz.a(hnVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hnVar.d())) {
                hnVar.f(bz.a());
            }
            hnVar.g(str);
            ca.a(this.f457a, hnVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f457a.getPackageName(), this.f457a.getPackageName(), str, str2, j, str3);
    }
}
