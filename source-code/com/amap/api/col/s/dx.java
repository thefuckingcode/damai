package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public final class dx extends ea {
    private String a = "iKey";
    private Context b;
    private boolean d;
    private int e;
    private int f;
    private int g = 0;

    public dx(Context context, boolean z, int i, int i2, String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    private void a(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    @Override // com.amap.api.col.s.ea
    public final int b() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((bo.n(this.b) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        ea eaVar = this.c;
        return eaVar != null ? Math.max(i2, eaVar.b()) : i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ea
    public final boolean a() {
        if (bo.n(this.b) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String a2 = cj.a(this.b, this.a);
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        String[] split = a2.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        if (split == null || split.length < 2) {
            cj.b(this.b, this.a);
            return true;
        }
        if (!bw.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.s.ea
    public final void a(int i) {
        if (bo.n(this.b) != 1) {
            String a2 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
            String a3 = cj.a(this.b, this.a);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                if (split == null || split.length < 2) {
                    cj.b(this.b, this.a);
                } else if (a2.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.b;
            String str = this.a;
            cj.a(context, str, a2 + "|" + i);
        }
    }
}
