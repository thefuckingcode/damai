package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ao;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class hc extends ao.b {
    final /* synthetic */ Context a;

    hc(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        ArrayList arrayList;
        synchronized (hb.a()) {
            arrayList = new ArrayList(hb.a());
            hb.a().clear();
        }
        hb.b(this.a, arrayList);
    }
}
