package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
public final class dz extends ea {
    protected int a;
    protected long b;
    private String d;
    private Context e;

    public dz(Context context, int i, String str, ea eaVar) {
        super(eaVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ea
    public final boolean a() {
        long j = 0;
        if (this.b == 0) {
            String a2 = cj.a(this.e, this.d);
            if (!TextUtils.isEmpty(a2)) {
                j = Long.parseLong(a2);
            }
            this.b = j;
        }
        return System.currentTimeMillis() - this.b >= ((long) this.a);
    }

    @Override // com.amap.api.col.s.ea
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.b = currentTimeMillis;
            cj.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }
}
