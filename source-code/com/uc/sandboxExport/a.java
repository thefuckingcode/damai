package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
final class a implements Executor {
    final /* synthetic */ PreStartup.a a;

    a(PreStartup.a aVar) {
        this.a = aVar;
    }

    public final void execute(Runnable runnable) {
        this.a.c.post(runnable);
    }
}
