package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class je extends jh {
    private String b = "iKey";
    private Context c;
    private boolean d;
    private int e;
    private int f;

    public je(Context context, boolean z, int i, int i2, String str) {
        this.c = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.jh
    public boolean a() {
        if (gg.r(this.c) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String a = hb.a(this.c, this.b);
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        if (split == null || split.length < 2) {
            hb.b(this.c, this.b);
            return true;
        }
        if (!gn.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.jh
    public int b() {
        int i;
        if (gg.r(this.c) == 1 || (i = this.e) <= 0) {
            i = Integer.MAX_VALUE;
        }
        jh jhVar = this.a;
        return jhVar != null ? Math.max(i, jhVar.b()) : i;
    }

    @Override // com.amap.api.mapcore.util.jh
    public void a(int i) {
        if (gg.r(this.c) != 1) {
            String a = gn.a(System.currentTimeMillis(), "yyyyMMdd");
            String a2 = hb.a(this.c, this.b);
            if (!TextUtils.isEmpty(a2)) {
                String[] split = a2.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                if (split == null || split.length < 2) {
                    hb.b(this.c, this.b);
                } else if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.c;
            String str = this.b;
            hb.a(context, str, a + "|" + i);
        }
    }
}
