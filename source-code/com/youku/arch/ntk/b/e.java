package com.youku.arch.ntk.b;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.baseproject.utils.speedtest.a;
import com.youku.arch.ntk.a.f;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.k;

/* compiled from: Taobao */
public class e extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final e a = new e();
    }

    private e() {
    }

    public static e a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-391423855") ? (e) ipChange.ipc$dispatch("-391423855", new Object[0]) : a.a;
    }

    public void a(g gVar, JSONObject jSONObject, f fVar) {
        i iVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423680698")) {
            ipChange.ipc$dispatch("-1423680698", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do speed test");
        a.C0148a aVar = (a.C0148a) JSON.toJavaObject(jSONObject, a.C0148a.class);
        com.baseproject.utils.speedtest.a aVar2 = new com.baseproject.utils.speedtest.a();
        aVar2.d = new a.C0148a[]{aVar};
        if (!(fVar == null || (iVar = fVar.a) == null)) {
            aVar2.f = iVar.b;
            aVar2.b = iVar.d;
            aVar2.e = iVar.c;
            aVar2.c = (long) iVar.e;
            aVar2.a = iVar.a;
        }
        SpeedTestRequest speedTestRequest = new SpeedTestRequest(fVar.b.a, aVar2, aVar, 0, 1);
        k kVar = new k();
        kVar.a(speedTestRequest.h());
        gVar.d.add(kVar);
    }
}
