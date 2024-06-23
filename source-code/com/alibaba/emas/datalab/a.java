package com.alibaba.emas.datalab;

import android.content.Context;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.p20;
import tb.r20;
import tb.s20;
import tb.yc2;

/* compiled from: Taobao */
public class a {
    public Map<DatalabBizType, DatalabListener> a;
    public com.alibaba.emas.datalab.decision.make.a b;
    private com.alibaba.emas.datalab.controller.a c;
    public Boolean d;

    /* renamed from: com.alibaba.emas.datalab.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static class C0081a {
        private static a a = new a(null);
    }

    /* synthetic */ a(DatalabService$1 datalabService$1) {
        this();
    }

    public static a b() {
        return C0081a.a;
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        Log.w("Datalab.DatalabService", str);
        p20.c().b("update", DatalabBizType.update, "200", str);
    }

    public void c(Context context, String str) {
        this.b = new com.alibaba.emas.datalab.decision.make.a();
        yc2.b().d(context, DatalabBizType.zcache);
        try {
            p20.c().d();
            com.alibaba.emas.datalab.controller.a aVar = new com.alibaba.emas.datalab.controller.a();
            this.c = aVar;
            aVar.a(context);
        } catch (Exception e) {
            Log.e("Datalab.DatalabService", "orange controller error", e);
        }
        s20.a().c(new r20());
    }

    private a() {
        this.a = new ConcurrentHashMap();
        this.d = Boolean.FALSE;
    }
}
