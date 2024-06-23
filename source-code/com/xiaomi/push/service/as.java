package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eq;
import java.util.Map;

/* compiled from: Taobao */
public abstract class as {
    /* access modifiers changed from: package-private */
    public abstract eq a(Context context, int i, String str, Map<String, String> map);

    /* access modifiers changed from: package-private */
    public abstract void a(Cif ifVar, Map<String, String> map, int i, Notification notification);

    /* access modifiers changed from: package-private */
    public abstract void a(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m802a(Context context, int i, String str, Map<String, String> map);

    /* access modifiers changed from: package-private */
    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
