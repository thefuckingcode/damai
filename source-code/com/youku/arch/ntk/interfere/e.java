package com.youku.arch.ntk.interfere;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.a;
import com.baseproject.utils.speedtest.b;
import com.baseproject.utils.speedtest.j;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.ntk.a.d;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.k;
import com.youku.arch.ntk.b.c;
import com.youku.arch.ntk.b.d;
import com.youku.arch.ntk.interfere.NtkNetworkScheduler;
import com.youku.player.networkscheduler.NetworkSchedulerWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.n23;

/* compiled from: Taobao */
public class e {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "e";
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private volatile boolean c;
    private a d;
    private String[] e = new String[3];

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        int a;
        int b;
        String c;
        String d;
        int e;

        a() {
        }
    }

    private e() {
    }

    private int a(c cVar) {
        a.C0148a[] aVarArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045103054")) {
            return ((Integer) ipChange.ipc$dispatch("1045103054", new Object[]{this, cVar})).intValue();
        }
        j.a aVar = new j.a();
        n23 n23 = new n23();
        aVar.a = n23;
        h hVar = cVar.f;
        n23.a = hVar.a;
        n23.j = hVar.j;
        n23.q = hVar.q;
        n23.b = hVar.b;
        n23.t = hVar.t;
        n23.s = hVar.s;
        n23.o = hVar.o;
        n23.f = hVar.f;
        n23.c = hVar.c;
        n23.d = hVar.d;
        n23.l = hVar.l;
        n23.m = hVar.m;
        n23.r = hVar.r;
        n23.i = hVar.i;
        n23.n = hVar.n;
        n23.h = hVar.h;
        n23.p = hVar.p;
        n23.g = hVar.g;
        n23.e = hVar.e;
        n23.k = hVar.k;
        int a2 = new b().a(null, aVar);
        if (a2 < 0) {
            return a2;
        }
        com.baseproject.utils.speedtest.a aVar2 = aVar.b;
        if (aVar2 == null || (aVarArr = aVar2.d) == null) {
            a2 = -99;
        } else {
            for (a.C0148a aVar3 : aVarArr) {
                if (aVar3.a.contains("myqcloud.com")) {
                    this.e[2] = aVar3.a;
                } else if (aVar3.a.contains("bcebos.com")) {
                    this.e[1] = aVar3.a;
                } else {
                    this.e[0] = aVar3.a;
                }
            }
        }
        if (this.e[0] == null) {
            return -98;
        }
        return a2;
    }

    private a a(com.youku.arch.ntk.a.j jVar) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "226118610")) {
            return (a) ipChange.ipc$dispatch("226118610", new Object[]{this, jVar});
        }
        a aVar = null;
        if (jVar != null && jVar.a != null) {
            aVar = new a();
            aVar.e = 0;
            aVar.a = 0;
            aVar.b = 99999;
            while (true) {
                d[] dVarArr = jVar.a;
                if (i >= dVarArr.length) {
                    break;
                }
                int parseInt = Integer.parseInt(dVarArr[i].b);
                if (parseInt > 0) {
                    aVar.e++;
                    if (parseInt > aVar.a) {
                        aVar.a = parseInt;
                        aVar.d = jVar.a[i].a;
                    }
                    if (parseInt < aVar.b) {
                        aVar.b = parseInt;
                        aVar.c = jVar.a[i].a;
                    }
                }
                i++;
            }
        }
        return aVar;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454749983")) {
            ipChange.ipc$dispatch("454749983", new Object[]{this});
            return;
        }
        a aVar = this.d;
        if (!(aVar == null || aVar.a == null)) {
            d dVar = new d();
            a aVar2 = this.d;
            dVar.a = aVar2.b;
            c cVar = aVar2.a;
            dVar.e = cVar.a;
            dVar.k = aVar2.h;
            dVar.j = aVar2.g;
            String[] strArr = cVar.d;
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.d.a.d) {
                    sb.append(str);
                    sb.append(",");
                }
                dVar.h = sb.toString();
            }
            a aVar3 = this.d;
            dVar.c = aVar3.f;
            dVar.b = aVar3.e;
            c cVar2 = aVar3.a;
            dVar.f = cVar2.b;
            String[] strArr2 = cVar2.c;
            if (strArr2 != null && strArr2.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (String str2 : this.d.a.c) {
                    sb2.append(str2);
                    sb2.append(",");
                }
                dVar.g = sb2.toString();
            }
            dVar.i = this.d.a.e ? "1" : "0";
            f.a(dVar);
        }
    }

    private void a(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045073276")) {
            ipChange.ipc$dispatch("1045073276", new Object[]{this, bVar});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze finish");
        if (bVar != null) {
            bVar.a(this.d);
        }
        if (!this.d.d.isEmpty()) {
            g gVar = this.d.d.get(0);
            for (int i = 1; i < this.d.d.size(); i++) {
                g gVar2 = this.d.d.get(i);
                com.youku.arch.ntk.a.j[] jVarArr = gVar2.b;
                if (jVarArr != null) {
                    if (gVar.b != null) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(gVar.b));
                        arrayList.addAll(Arrays.asList(gVar2.b));
                        gVar.b = (com.youku.arch.ntk.a.j[]) arrayList.toArray(new com.youku.arch.ntk.a.j[0]);
                    } else {
                        gVar.b = jVarArr;
                    }
                }
                List<k> list = gVar2.d;
                if (list != null) {
                    List<k> list2 = gVar.d;
                    if (list2 != null) {
                        list2.addAll(list);
                    } else {
                        gVar.b = gVar2.b;
                    }
                }
            }
            h hVar = this.d.a.f;
            if (hVar != null) {
                gVar.h = hVar.u;
                gVar.e = hVar.e;
                gVar.g = hVar.v;
                gVar.f = hVar.w;
                gVar.s = "impairmentAnalyze";
                gVar.j = hVar.t;
                gVar.n = hVar.j;
                gVar.p = hVar.o;
                gVar.k = hVar.c;
                gVar.l = hVar.d;
                gVar.r = hVar.l;
                gVar.m = hVar.i;
                gVar.o = hVar.n;
                gVar.q = hVar.h;
            }
            com.youku.arch.ntk.b.b().a(this.d.a.f, gVar);
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar, b bVar) {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924889144")) {
            ipChange.ipc$dispatch("924889144", new Object[]{this, cVar, bVar});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze start");
        a aVar = new a();
        this.d = aVar;
        if (cVar == null) {
            aVar.b = -1;
            aVar.c = "ntk analyze inputParam is null";
            a(bVar);
            return;
        }
        aVar.a = cVar;
        h hVar = cVar.f;
        if (!(hVar == null || (context = hVar.a) == null)) {
            com.youku.b.a.a.a(context);
        }
        int a2 = a(cVar);
        if (a2 < 0) {
            a aVar2 = this.d;
            aVar2.b = -2;
            aVar2.c = "" + a2;
            a(bVar);
            return;
        }
        if (cVar.e) {
            c(cVar, bVar);
        } else {
            b(cVar, bVar);
        }
        a(bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d6  */
    private void b(c cVar, b bVar) {
        a aVar;
        boolean z;
        g a2;
        int parseInt;
        NtkNetworkScheduler.Mode mode;
        NtkNetworkScheduler ntkNetworkScheduler;
        String str;
        a.C0148a aVar2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745624425")) {
            ipChange.ipc$dispatch("-745624425", new Object[]{this, cVar, bVar});
            return;
        }
        String str2 = a;
        com.youku.b.a.a.a(str2, "goIpAnalyze");
        LinkedList linkedList = new LinkedList();
        String[] strArr = cVar.c;
        if (strArr == null || strArr.length <= 0) {
            z = false;
            aVar = null;
        } else {
            d.c cVar2 = new d.c();
            cVar2.a = cVar.a;
            cVar2.b = 0;
            d.a[] aVarArr = new d.a[1];
            cVar2.d = aVarArr;
            aVarArr[0] = new d.a();
            d.a[] aVarArr2 = cVar2.d;
            aVarArr2[0].b = "114.114.114.114";
            aVarArr2[0].a = 4;
            cVar2.c = 5000;
            JSONObject parseObject = JSON.parseObject(JSON.toJSONString(cVar2));
            parseObject.put("type", (Object) 1);
            linkedList.add(parseObject);
            c.b bVar2 = new c.b();
            bVar2.a = cVar.a;
            bVar2.b = 0;
            bVar2.c = 5000;
            bVar2.d = cVar.c;
            JSONObject parseObject2 = JSON.parseObject(JSON.toJSONString(bVar2));
            parseObject2.put("type", (Object) 4);
            linkedList.add(parseObject2);
            i iVar = new i();
            iVar.f = (JSONObject[]) linkedList.toArray(new JSONObject[0]);
            iVar.b = 0;
            g a3 = com.youku.arch.ntk.b.b().a(cVar.f, iVar);
            if (a3 == null) {
                com.youku.b.a.a.b(str2, "ntkresult err");
                this.d.b = -1;
                return;
            }
            this.d.d.add(a3);
            aVar = a(a3.b[0]);
            a(a3.b[1]);
            a a4 = a(a3.b[2]);
            int i = aVar.b;
            z = i < 100 && i < a4.b / 3;
        }
        linkedList.clear();
        a.C0148a aVar3 = new a.C0148a();
        aVar3.c = cVar.a;
        aVar3.a = this.e[0];
        if (TextUtils.isEmpty(cVar.b)) {
            aVar3.b = cVar.b;
        } else {
            String[] strArr2 = cVar.c;
            if (strArr2 != null && strArr2.length > 0) {
                aVar3.b = strArr2[0];
            }
        }
        aVar3.g = 1;
        aVar3.e = 1;
        aVar3.f = 0;
        aVar3.d = 5;
        JSONObject parseObject3 = JSON.parseObject(JSON.toJSONString(aVar3));
        parseObject3.put("type", (Object) 3);
        linkedList.add(parseObject3);
        com.youku.b.a.a.a(str2, "goIpAnalyze try local dns? " + z);
        if (z) {
            this.d.g = aVar.c;
            aVar2 = new a.C0148a();
            aVar2.c = cVar.a;
            aVar2.a = this.e[0];
            aVar2.b = aVar.c;
        } else {
            String[] strArr3 = cVar.d;
            if (strArr3 != null && strArr3.length > 0) {
                int length = strArr3.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str = null;
                        break;
                    }
                    String str3 = strArr3[i2];
                    if (!cVar.a.equals(str3)) {
                        str = str3;
                        break;
                    }
                    i2++;
                }
                if (!TextUtils.isEmpty(str)) {
                    com.youku.b.a.a.a(a, "find backupdomain");
                    this.d.h = str;
                    aVar2 = new a.C0148a();
                    aVar2.a = this.e[0];
                    aVar2.c = str;
                }
            }
            JSONObject[] jSONObjectArr = (JSONObject[]) linkedList.toArray(new JSONObject[0]);
            i iVar2 = new i();
            iVar2.f = jSONObjectArr;
            iVar2.b = 0;
            a2 = com.youku.arch.ntk.b.b().a(cVar.f, iVar2);
            if (a2 != null) {
                com.youku.b.a.a.b(a, "ntkresult err.");
                this.d.b = -1;
                return;
            }
            this.d.d.add(a2);
            int parseInt2 = Integer.parseInt(a2.d.get(0).a);
            this.d.e = parseInt2;
            if (jSONObjectArr.length > 1 && ((parseInt = Integer.parseInt(a2.d.get(1).a)) > 8000 || (parseInt > 5000 && parseInt > parseInt2 * 2))) {
                a aVar4 = this.d;
                aVar4.f = parseInt;
                if (z) {
                    aVar4.b = 3;
                    NetworkSchedulerWrapper.getInstance().registerScheduler(1, NtkNetworkScheduler.a());
                    ntkNetworkScheduler = NtkNetworkScheduler.a();
                    mode = NtkNetworkScheduler.Mode.LOCAL_DNS_FIRST;
                } else {
                    aVar4.b = 4;
                    NetworkSchedulerWrapper.getInstance().registerScheduler(1, NtkNetworkScheduler.a());
                    NtkNetworkScheduler a5 = NtkNetworkScheduler.a();
                    a aVar5 = this.d;
                    a5.a(aVar5.a.a, aVar5.h);
                    ntkNetworkScheduler = NtkNetworkScheduler.a();
                    mode = NtkNetworkScheduler.Mode.DOMAIN_MAPPING;
                }
                ntkNetworkScheduler.a(mode);
            }
            a aVar6 = this.d;
            if (aVar6.b == 0) {
                if (parseInt2 > 8000) {
                    aVar6.b = 1;
                } else {
                    aVar6.b = 2;
                }
                aVar6.f = parseInt2;
                return;
            }
            return;
        }
        aVar2.g = 1;
        aVar2.e = 1;
        aVar2.f = 0;
        aVar2.d = 5;
        JSONObject parseObject4 = JSON.parseObject(JSON.toJSONString(aVar2));
        parseObject4.put("type", (Object) 3);
        linkedList.add(parseObject4);
        JSONObject[] jSONObjectArr2 = (JSONObject[]) linkedList.toArray(new JSONObject[0]);
        i iVar22 = new i();
        iVar22.f = jSONObjectArr2;
        iVar22.b = 0;
        a2 = com.youku.arch.ntk.b.b().a(cVar.f, iVar22);
        if (a2 != null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008a A[SYNTHETIC] */
    private void c(c cVar, b bVar) {
        g a2;
        int length;
        int i;
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1878829302")) {
            ipChange.ipc$dispatch("1878829302", new Object[]{this, cVar, bVar});
            return;
        }
        String str3 = a;
        com.youku.b.a.a.a(str3, "goDispatcherDomainAnalyze");
        LinkedList linkedList = new LinkedList();
        a.C0148a aVar = new a.C0148a();
        aVar.c = cVar.a;
        aVar.a = this.e[0];
        if (TextUtils.isEmpty(cVar.b)) {
            str2 = cVar.b;
        } else {
            String[] strArr = cVar.c;
            if (strArr != null && strArr.length > 0) {
                str2 = strArr[0];
            }
            aVar.g = 1;
            aVar.e = 1;
            aVar.f = 0;
            aVar.d = 5;
            JSONObject parseObject = JSON.parseObject(JSON.toJSONString(aVar));
            parseObject.put("type", (Object) 3);
            linkedList.add(parseObject);
            String[] strArr2 = cVar.d;
            String str4 = null;
            if (strArr2 != null && strArr2.length > 0) {
                com.youku.b.a.a.a(str3, "find backup domain");
                String[] strArr3 = cVar.d;
                length = strArr3.length;
                i = 0;
                while (true) {
                    if (i < length) {
                        str = null;
                        break;
                    }
                    str = strArr3[i];
                    if (!cVar.a.equals(str)) {
                        break;
                    }
                    i++;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.C0148a aVar2 = new a.C0148a();
                    aVar2.a = this.e[0];
                    aVar2.c = cVar.a;
                    aVar2.g = 1;
                    aVar2.e = 1;
                    aVar2.f = 0;
                    aVar2.d = 5;
                    JSONObject parseObject2 = JSON.parseObject(JSON.toJSONString(aVar2));
                    parseObject2.put("type", (Object) 3);
                    linkedList.add(parseObject2);
                }
            }
            JSONObject[] jSONObjectArr = (JSONObject[]) linkedList.toArray(new JSONObject[0]);
            i iVar = new i();
            iVar.f = jSONObjectArr;
            iVar.b = 0;
            a2 = com.youku.arch.ntk.b.b().a(cVar.f, iVar);
            if (a2 != null) {
                com.youku.b.a.a.b(a, "ntkresult err");
                this.d.b = -1;
                return;
            }
            this.d.d.add(a2);
            int parseInt = Integer.parseInt(a2.d.get(0).a);
            this.d.e = parseInt;
            for (int i3 = 1; i3 < a2.d.size(); i3++) {
                int parseInt2 = Integer.parseInt(a2.d.get(i3).a);
                if ((parseInt2 > i2 && parseInt2 > 8000) || (parseInt2 > 5000 && parseInt2 > parseInt * 2)) {
                    i2 = parseInt2;
                    str4 = jSONObjectArr[i3].getString("host");
                }
            }
            a aVar3 = this.d;
            if (str4 != null) {
                aVar3.b = 4;
                aVar3.f = i2;
                return;
            }
            if (parseInt > 8000) {
                aVar3.b = 1;
            } else {
                aVar3.b = 2;
            }
            this.d.f = parseInt;
            return;
        }
        aVar.b = str2;
        aVar.g = 1;
        aVar.e = 1;
        aVar.f = 0;
        aVar.d = 5;
        JSONObject parseObject3 = JSON.parseObject(JSON.toJSONString(aVar));
        parseObject3.put("type", (Object) 3);
        linkedList.add(parseObject3);
        String[] strArr22 = cVar.d;
        String str42 = null;
        com.youku.b.a.a.a(str3, "find backup domain");
        String[] strArr32 = cVar.d;
        length = strArr32.length;
        i = 0;
        while (true) {
            if (i < length) {
            }
            i++;
        }
        if (!TextUtils.isEmpty(str)) {
        }
        JSONObject[] jSONObjectArr2 = (JSONObject[]) linkedList.toArray(new JSONObject[0]);
        i iVar2 = new i();
        iVar2.f = jSONObjectArr2;
        iVar2.b = 0;
        a2 = com.youku.arch.ntk.b.b().a(cVar.f, iVar2);
        if (a2 != null) {
        }
    }
}
