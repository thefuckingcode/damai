package com.xiaomi.push;

import com.xiaomi.push.ao;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ha extends ao.b {
    final /* synthetic */ Runnable a;

    ha(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        this.a.run();
    }
}
