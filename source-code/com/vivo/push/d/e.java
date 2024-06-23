package com.vivo.push.d;

import android.text.TextUtils;
import com.vivo.push.b.i;

/* compiled from: Taobao */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ d c;

    e(d dVar, String str, i iVar) {
        this.c = dVar;
        this.a = str;
        this.b = iVar;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            d dVar = this.c;
            ((z) dVar).b.onReceiveRegId(d.a(dVar), this.a);
        }
        d dVar2 = this.c;
        ((z) dVar2).b.onBind(d.b(dVar2), this.b.h(), this.b.d());
    }
}
