package com.vivo.push;

import android.text.TextUtils;
import com.vivo.push.util.z;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    f(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.h != null && !TextUtils.isEmpty(this.a) && z.b(this.b.h, this.b.h.getPackageName(), this.a)) {
            this.b.i();
        }
    }
}
