package com.uc.webview.export.internal.setup;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.uc.startup.b;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class az implements Callable<Object> {
    final /* synthetic */ ax a;

    az(ax axVar) {
        this.a = axVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        b.a(TypedValues.Attributes.TYPE_PIVOT_TARGET);
        if (af.b) {
            CoreFactory.a(af.a);
        }
        j.c();
        j.d();
        b.a(319);
        return null;
    }
}
