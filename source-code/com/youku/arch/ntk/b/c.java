package com.youku.arch.ntk.b;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.f;
import com.youku.arch.ntk.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import tb.ny0;

/* compiled from: Taobao */
public class c extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final c a = new c();
    }

    /* compiled from: Taobao */
    public static class b {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
        @JSONField(name = "ips")
        public String[] d;
    }

    private c() {
    }

    public static c a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1093023791") ? (c) ipChange.ipc$dispatch("-1093023791", new Object[0]) : a.a;
    }

    public void a(g gVar, JSONObject jSONObject, f fVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652947132")) {
            ipChange.ipc$dispatch("-652947132", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do DnsResolve");
        b bVar = (b) JSON.toJavaObject(jSONObject, b.class);
        if (bVar != null) {
            if (bVar.b == 1 || TextUtils.isEmpty(bVar.a)) {
                if (TextUtils.isEmpty(fVar.b.x)) {
                    com.youku.b.a.a.b("ntk_implementer", "empty resolve domain, stop.");
                    return;
                }
                bVar.a = fVar.b.x;
            }
            try {
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (bVar.b == 1 || bVar.d == null) {
                    ArrayList<ny0.a> a2 = ny0.a(bVar.a);
                    if (a2 == null || a2.size() <= 0) {
                        com.youku.b.a.a.a("ntk_implementer", "getIpArrayByHost -----> list is null");
                        return;
                    }
                    Iterator<ny0.a> it = a2.iterator();
                    while (it.hasNext()) {
                        ny0.a next = it.next();
                        if (!next.a() && next.c() == 80) {
                            String b2 = next.b();
                            if (!TextUtils.isEmpty(b2)) {
                                linkedList.add(next.b());
                                if (b2.contains(".")) {
                                    linkedList2.add(0);
                                } else {
                                    linkedList2.add(1);
                                }
                            }
                        }
                    }
                } else {
                    int i = 0;
                    while (true) {
                        String[] strArr = bVar.d;
                        if (i >= strArr.length) {
                            break;
                        }
                        linkedList.add(strArr[i]);
                        if (bVar.d[i].contains(".")) {
                            linkedList2.add(0);
                        } else {
                            linkedList2.add(1);
                        }
                        i++;
                    }
                }
                int[] iArr = new int[linkedList2.size()];
                for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                    iArr[i2] = ((Integer) linkedList2.get(i2)).intValue();
                }
                NtkWrapper.a().inspect_ext_resolve(gVar, bVar.a, (String[]) linkedList.toArray(new String[0]), iArr, bVar.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
