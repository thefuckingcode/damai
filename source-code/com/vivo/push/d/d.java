package com.vivo.push.d;

import android.text.TextUtils;
import com.vivo.push.b.i;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.o;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d extends z {
    d(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        i iVar = (i) oVar;
        String e = iVar.e();
        e.a().a(iVar.g(), iVar.h(), e);
        if (TextUtils.isEmpty(iVar.g()) && !TextUtils.isEmpty(e)) {
            e.a().a(e);
        }
        m.b(new e(this, e, iVar));
    }
}
