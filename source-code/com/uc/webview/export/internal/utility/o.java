package com.uc.webview.export.internal.utility;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.internal.utility.n;
import java.lang.Thread;

/* compiled from: Taobao */
final class o implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ String a;
    final /* synthetic */ n.b b;

    o(n.b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String str = n.a;
        Log.d(str, this.a + " uncaughtException " + thread + AVFSCacheConstants.COMMA_SEP + p.a(th));
    }
}
