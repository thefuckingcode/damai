package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class q extends ba.a {
    final /* synthetic */ Context a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.service.ba.a
    public void onCallback() {
        ed.a(this.a).a(ba.a(this.a).a(ho.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
