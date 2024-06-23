package com.uploader.implement.b.a;

import com.uploader.implement.b.b;
import com.uploader.implement.b.e;
import com.uploader.implement.c;
import java.lang.ref.WeakReference;
import tb.g13;

/* compiled from: Taobao */
public abstract class a implements e {
    final g13 a;
    volatile WeakReference<b> b;
    final int c = hashCode();

    a(c cVar, g13 g13) {
        this.a = g13;
    }

    @Override // com.uploader.implement.b.e
    public g13 a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public b e() {
        WeakReference<b> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.uploader.implement.b.e
    public void a(b bVar) {
        this.b = new WeakReference<>(bVar);
    }
}
