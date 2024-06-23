package com.youku.arch.ntk.b;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.BaseMonitor;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.f;
import com.youku.arch.ntk.a.g;
import java.util.Date;

/* compiled from: Taobao */
public class b extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final b a = new b();
    }

    /* renamed from: com.youku.arch.ntk.b.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0256b {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
    }

    private b() {
    }

    public static b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443823759") ? (b) ipChange.ipc$dispatch("-1443823759", new Object[0]) : a.a;
    }

    public synchronized void a(g gVar, JSONObject jSONObject, f fVar) {
        IpChange ipChange = $ipChange;
        int i = 3;
        if (AndroidInstantRuntime.support(ipChange, "-267580349")) {
            ipChange.ipc$dispatch("-267580349", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do dnsInfer");
        C0256b bVar = (C0256b) JSON.toJavaObject(jSONObject, C0256b.class);
        if (bVar != null) {
            if (bVar.b == 1 || TextUtils.isEmpty(bVar.a)) {
                bVar.a = BaseMonitor.COUNT_POINT_DNS + (new Date().getTime() % 1024) + ".debug.danuoyi.alicdn.com";
            }
            NtkWrapper a2 = NtkWrapper.a();
            String str = bVar.a;
            int i2 = bVar.c;
            if (i2 > 0) {
                i = i2;
            }
            a2.inspect_dns(gVar, str, i);
        }
    }
}
