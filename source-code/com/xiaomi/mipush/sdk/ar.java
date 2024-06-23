package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bj;
import com.xiaomi.push.service.bn;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ar extends ContentObserver {
    final /* synthetic */ ao a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ar(ao aoVar, Handler handler) {
        super(handler);
        this.a = aoVar;
    }

    public void onChange(boolean z) {
        ao aoVar = this.a;
        aoVar.f52a = Integer.valueOf(bn.a(ao.a(aoVar)).a());
        if (ao.a(this.a).intValue() != 0) {
            ao.a(this.a).getContentResolver().unregisterContentObserver(this);
            if (bj.b(ao.a(this.a))) {
                this.a.m216c();
            }
        }
    }
}
