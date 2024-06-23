package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class g extends ba.a {
    final /* synthetic */ f a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(f fVar, int i, String str) {
        super(i, str);
        this.a = fVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.service.ba.a
    public void onCallback() {
        boolean a2 = ba.a(f.a(this.a)).a(ho.AggregatePushSwitch.a(), true);
        if (f.a(this.a) != a2) {
            this.a.f73a = a2;
            i.b(f.a(this.a));
        }
    }
}
