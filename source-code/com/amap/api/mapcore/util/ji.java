package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Taobao */
public class ji extends jh {
    private Context b;
    private boolean c = false;

    public ji(Context context, boolean z) {
        this.b = context;
        this.c = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.jh
    public boolean a() {
        return gg.r(this.b) == 1 || this.c;
    }
}
