package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.uc.CoreFactory;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k implements Callable<Object> {
    k() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        CoreFactory.a();
        return null;
    }
}
