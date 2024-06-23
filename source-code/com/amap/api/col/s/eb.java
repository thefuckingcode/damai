package com.amap.api.col.s;

import android.content.Context;

/* compiled from: Taobao */
public final class eb extends ea {
    private Context a;
    private boolean b = false;

    public eb(Context context) {
        this.a = context;
        this.b = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ea
    public final boolean a() {
        return bo.n(this.a) == 1 || this.b;
    }
}
