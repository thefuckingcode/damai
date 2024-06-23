package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class z extends y {
    final /* synthetic */ Runnable a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.a = runnable;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.y
    public void a(Context context) {
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
