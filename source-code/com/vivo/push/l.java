package com.vivo.push;

import android.content.Context;
import com.vivo.push.b.n;
import com.vivo.push.util.p;
import tb.jl1;

/* compiled from: Taobao */
public abstract class l implements Runnable {
    protected Context a;
    private int b = -1;
    private o c;

    public l(o oVar) {
        this.c = oVar;
        int b2 = oVar.b();
        this.b = b2;
        if (b2 >= 0) {
            this.a = e.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public abstract void a(o oVar);

    public final void run() {
        Context context = this.a;
        if (context != null && !(this.c instanceof n)) {
            p.a(context, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(jl1.BLOCK_START_STR);
        o oVar = this.c;
        sb.append(oVar == null ? "[null]" : oVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
