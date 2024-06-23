package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import com.alibaba.security.biometrics.sensor.api.RpSecException;

/* compiled from: Taobao */
public abstract class a<T> {
    protected Activity a;
    protected com.alibaba.security.biometrics.sensor.b.a b;

    public a(Activity activity) {
        this.a = activity;
    }

    private static long e() {
        return System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public abstract void a() throws RpSecException;

    /* access modifiers changed from: package-private */
    public void a(com.alibaba.security.biometrics.sensor.b.a aVar) throws RpSecException {
        this.b = aVar;
    }

    /* access modifiers changed from: package-private */
    public abstract T b();

    /* access modifiers changed from: package-private */
    public abstract boolean c() throws RpSecException;

    /* access modifiers changed from: package-private */
    public abstract void d() throws RpSecException;
}
