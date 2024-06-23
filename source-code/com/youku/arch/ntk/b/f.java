package com.youku.arch.ntk.b;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.tao.log.TLogConstant;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.d;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.j;

/* compiled from: Taobao */
public class f extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class a {
        @JSONField(name = "type")
        public int a;
        @JSONField(name = "domain")
        public String b;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int c;
        @JSONField(name = TLogConstant.PERSIST_TASK_ID)
        public String d;
        @JSONField(name = "maxHopNum")
        public int e;
        @JSONField(name = "time")
        public int f;
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final f a = new f();
    }

    private f() {
    }

    public static f a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-40623887") ? (f) ipChange.ipc$dispatch("-40623887", new Object[0]) : b.a;
    }

    private String a(g gVar) {
        j[] jVarArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832145809")) {
            return (String) ipChange.ipc$dispatch("1832145809", new Object[]{this, gVar});
        }
        String str = null;
        int i = 65535;
        if (!(gVar == null || (jVarArr = gVar.b) == null)) {
            for (j jVar : jVarArr) {
                d[] dVarArr = jVar.a;
                if (dVarArr != null) {
                    for (d dVar : dVarArr) {
                        try {
                            if (Integer.parseInt(dVar.b) > 0 && Integer.parseInt(dVar.b) < i) {
                                i = Integer.parseInt(dVar.b);
                                str = dVar.a;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return str;
    }

    private String b(g gVar) {
        j[] jVarArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131405330")) {
            return (String) ipChange.ipc$dispatch("131405330", new Object[]{this, gVar});
        }
        String str = null;
        if (!(gVar == null || (jVarArr = gVar.b) == null)) {
            int i = 0;
            for (j jVar : jVarArr) {
                d[] dVarArr = jVar.a;
                if (dVarArr != null) {
                    for (d dVar : dVarArr) {
                        try {
                            if (Integer.parseInt(dVar.b) > 0 && Integer.parseInt(dVar.b) > i) {
                                i = Integer.parseInt(dVar.b);
                                str = dVar.a;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    public synchronized void a(g gVar, JSONObject jSONObject, com.youku.arch.ntk.a.f fVar) {
        String b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809047481")) {
            ipChange.ipc$dispatch("-1809047481", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do trace");
        a aVar = (a) JSON.toJavaObject(jSONObject, a.class);
        int i = aVar.c;
        if (i == 1) {
            b2 = a(gVar);
        } else {
            if (i == 2) {
                b2 = b(gVar);
            }
            if (!TextUtils.isEmpty(aVar.b)) {
                NtkWrapper.a().inspect_trace(gVar, aVar.b, aVar.e, aVar.f);
            }
        }
        aVar.b = b2;
        if (!TextUtils.isEmpty(aVar.b)) {
        }
    }
}
