package com.loc;

import android.content.Context;
import android.os.Handler;
import tb.f53;

/* compiled from: Taobao */
public final class d1 extends ep<y0> {
    public d1(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String w(y0 y0Var) {
        return y0Var == null ? "" : y0Var.b();
    }

    private static void x(y0 y0Var, long j) {
        if (y0Var != null) {
            y0Var.f = j;
        }
    }

    private static int y(y0 y0Var) {
        if (y0Var == null) {
            return -113;
        }
        return y0Var.c;
    }

    private static long z(y0 y0Var) {
        if (y0Var == null) {
            return 0;
        }
        return y0Var.f;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, long] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* bridge */ /* synthetic */ void e(y0 y0Var, long j) {
        x(y0Var, j);
    }

    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final long h() {
        return (long) f53.a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.loc.ep
    public final /* synthetic */ String i(y0 y0Var) {
        return w(y0Var);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* synthetic */ int l(y0 y0Var) {
        return y(y0Var);
    }

    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final long m() {
        return (long) f53.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* synthetic */ long o(y0 y0Var) {
        return z(y0Var);
    }
}
