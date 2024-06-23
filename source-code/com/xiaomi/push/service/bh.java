package com.xiaomi.push.service;

import com.xiaomi.push.service.bg;
import org.apache.commons.lang3.time.DateUtils;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bh implements bg.b.a {
    final /* synthetic */ bg.b a;

    bh(bg.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (cVar2 == bg.c.binding) {
            this.a.f921a.a(bg.b.a(this.a), DateUtils.MILLIS_PER_MINUTE);
        } else {
            this.a.f921a.b(bg.b.a(this.a));
        }
    }
}
