package com.loc;

import android.content.Context;
import android.os.Handler;
import tb.f53;

/* compiled from: Taobao */
public final class a1 extends ep<b1> {
    public a1(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String w(b1 b1Var) {
        return b1Var == null ? "" : b1Var.b();
    }

    private static void x(b1 b1Var, long j) {
        if (b1Var != null) {
            b1Var.t = j;
        }
    }

    private static int y(b1 b1Var) {
        if (b1Var == null) {
            return 99;
        }
        return b1Var.s;
    }

    private static long z(b1 b1Var) {
        if (b1Var == null) {
            return 0;
        }
        return b1Var.t;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, long] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* bridge */ /* synthetic */ void e(b1 b1Var, long j) {
        x(b1Var, j);
    }

    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final long h() {
        return (long) f53.c;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.loc.ep
    public final /* synthetic */ String i(b1 b1Var) {
        return w(b1Var);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* synthetic */ int l(b1 b1Var) {
        return y(b1Var);
    }

    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final long m() {
        return (long) f53.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.loc.ep
    public final /* synthetic */ long o(b1 b1Var) {
        return z(b1Var);
    }
}
