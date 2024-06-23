package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.timestamp.ConfigTimeStampMgr;
import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;
import tb.nq2;
import tb.qq2;
import tb.vq2;
import tb.zf2;

/* compiled from: Taobao */
public abstract class d {
    public static String f = "timestamp";
    private Vector<vq2> a = new Vector<>();
    private Map<String, vq2> b = new HashMap();
    private List<qq2> c = new LinkedList();
    private String d = null;
    private String e = "{\"B02N_utap_system\":{\"content\":{\"fu\":30,\"sw_plugin\":0,\"bu\":300}},\"B02N_ut_sample\":{\"content\":{\"1\":{\"cp\":10000},\"1000\":{\"cp\":10000},\"2000\":{\"cp\":10000},\"2100\":{\"cp\":10000},\"3002\":{\"cp\":10000},\"3003\":{\"cp\":10000},\"3004\":{\"cp\":10000},\"4007\":{\"cp\":10000},\"5002\":{\"cp\":10000},\"5004\":{\"cp\":10000},\"5005\":{\"cp\":10000},\"6004\":{\"cp\":10000},\"9001\":{\"cp\":10000},\"9002\":{\"cp\":10000},\"9003\":{\"cp\":10000},\"9101\":{\"cp\":10000},\"9199\":{\"cp\":10000},\"12000\":{\"cp\":10000},\"15301\":{\"cp\":10000},\"15302\":{\"cp\":1},\"15303\":{\"cp\":10000},\"15304\":{\"cp\":10000},\"15305\":{\"cp\":10000},\"15306\":{\"cp\":100},\"15307\":{\"cp\":10000},\"15391\":{\"cp\":100},\"15392\":{\"cp\":10000},\"15393\":{\"cp\":1200},\"15394\":{\"cp\":10000},\"19997\":{\"cp\":10000},\"19998\":{\"cp\":10000},\"19999\":{\"cp\":10000},\"21032\":{\"cp\":10000},\"21034\":{\"cp\":1},\"21064\":{\"cp\":10000},\"22064\":{\"cp\":1},\"61001\":{\"cp\":10000},\"61006\":{\"cp\":10000},\"61007\":{\"cp\":10000},\"65001\":{\"cp\":1},\"65100\":{\"cp\":1},\"65101\":{\"cp\":4},\"65104\":{\"cp\":10000},\"65105\":{\"cp\":10000},\"65111\":{\"cp\":100},\"65113\":{\"cp\":10000},\"65114\":{\"cp\":10000},\"65125\":{\"cp\":10000},\"65132\":{\"cp\":10000},\"65171\":{\"cp\":100},\"65172\":{\"cp\":100},\"65173\":{\"cp\":100},\"65174\":{\"cp\":100},\"65175\":{\"cp\":100},\"65176\":{\"cp\":100},\"65177\":{\"cp\":100},\"65178\":{\"cp\":100},\"65180\":{\"cp\":900},\"65183\":{\"cp\":10000},\"65200\":{\"cp\":10000},\"65501\":{\"cp\":10000},\"65502\":{\"cp\":10000},\"65503\":{\"cp\":10000},\"66001\":{\"cp\":100},\"66003\":{\"cp\":10000},\"66101\":{\"cp\":10000},\"66404\":{\"cp\":10000},\"66602\":{\"cp\":10000}}},\"B02N_ut_stream\":{\"content\":{\"1\":{\"stm\":\"stm_x\"},\"1000\":{\"stm\":\"stm_p\"},\"2000\":{\"stm\":\"stm_p\"},\"2100\":{\"stm\":\"stm_c\"},\"4007\":{\"stm\":\"stm_d\"},\"5002\":{\"stm\":\"stm_d\"},\"5004\":{\"stm\":\"stm_d\"},\"5005\":{\"stm\":\"stm_d\"},\"6004\":{\"stm\":\"stm_d\"},\"9001\":{\"stm\":\"stm_d\"},\"9002\":{\"stm\":\"stm_d\"},\"9003\":{\"stm\":\"stm_d\"},\"9101\":{\"stm\":\"stm_d\"},\"9199\":{\"stm\":\"stm_d\"},\"15301\":{\"stm\":\"stm_x\"},\"15302\":{\"stm\":\"stm_x\"},\"15303\":{\"stm\":\"stm_x\"},\"15304\":{\"stm\":\"stm_x\"},\"15305\":{\"stm\":\"stm_x\"},\"15306\":{\"stm\":\"stm_x\"},\"15307\":{\"stm\":\"stm_x\"},\"15391\":{\"stm\":\"stm_x\"},\"15392\":{\"stm\":\"stm_x\"},\"15393\":{\"stm\":\"stm_x\"},\"15394\":{\"stm\":\"stm_x\"},\"19999\":{\"stm\":\"stm_d\"},\"21032\":{\"stm\":\"stm_x\"},\"21034\":{\"stm\":\"stm_x\"},\"21064\":{\"stm\":\"stm_x\"},\"22064\":{\"stm\":\"stm_x\"},\"61001\":{\"stm\":\"stm_x\"},\"61006\":{\"stm\":\"stm_x\"},\"61007\":{\"stm\":\"stm_x\"},\"65001\":{\"stm\":\"stm_x\"},\"65100\":{\"stm\":\"stm_x\"},\"65101\":{\"stm\":\"stm_x\"},\"65104\":{\"stm\":\"stm_x\"},\"65105\":{\"stm\":\"stm_x\"},\"65111\":{\"stm\":\"stm_x\"},\"65113\":{\"stm\":\"stm_x\"},\"65114\":{\"stm\":\"stm_x\"},\"65125\":{\"stm\":\"stm_x\"},\"65132\":{\"stm\":\"stm_x\"},\"65171\":{\"stm\":\"stm_x\"},\"65172\":{\"stm\":\"stm_x\"},\"65173\":{\"stm\":\"stm_x\"},\"65174\":{\"stm\":\"stm_x\"},\"65175\":{\"stm\":\"stm_x\"},\"65176\":{\"stm\":\"stm_x\"},\"65177\":{\"stm\":\"stm_x\"},\"65178\":{\"stm\":\"stm_x\"},\"65180\":{\"stm\":\"stm_x\"},\"65183\":{\"stm\":\"stm_x\"},\"65200\":{\"stm\":\"stm_d\"},\"65501\":{\"stm\":\"stm_d\"},\"65502\":{\"stm\":\"stm_d\"},\"65503\":{\"stm\":\"stm_d\"},\"66001\":{\"stm\":\"stm_d\"},\"66003\":{\"stm\":\"stm_d\"},\"66101\":{\"stm\":\"stm_d\"},\"66404\":{\"stm\":\"stm_d\"}}},\"B02N_ut_bussiness\":{\"content\":{\"tpk\":[{\"kn\":\"adid\",\"ty\":\"nearby\"},{\"kn\":\"ucm\",\"ty\":\"nearby\"},{\"kn\":\"bdid\",\"ty\":\"far\"},{\"kn\":\"ref_pid\",\"ty\":\"far\"},{\"kn\":\"pid\",\"ty\":\"far\"},{\"kn\":\"tpa\",\"ty\":\"far\"},{\"kn\":\"point\",\"ty\":\"far\"},{\"kn\":\"ali_trackid\",\"ty\":\"far\"},{\"kn\":\"xncode\",\"ty\":\"nearby\"}]}}}";

    public d() {
        n("{\"B02N_utap_system\":{\"content\":{\"fu\":30,\"sw_plugin\":0,\"bu\":300}},\"B02N_ut_sample\":{\"content\":{\"1\":{\"cp\":10000},\"1000\":{\"cp\":10000},\"2000\":{\"cp\":10000},\"2100\":{\"cp\":10000},\"3002\":{\"cp\":10000},\"3003\":{\"cp\":10000},\"3004\":{\"cp\":10000},\"4007\":{\"cp\":10000},\"5002\":{\"cp\":10000},\"5004\":{\"cp\":10000},\"5005\":{\"cp\":10000},\"6004\":{\"cp\":10000},\"9001\":{\"cp\":10000},\"9002\":{\"cp\":10000},\"9003\":{\"cp\":10000},\"9101\":{\"cp\":10000},\"9199\":{\"cp\":10000},\"12000\":{\"cp\":10000},\"15301\":{\"cp\":10000},\"15302\":{\"cp\":1},\"15303\":{\"cp\":10000},\"15304\":{\"cp\":10000},\"15305\":{\"cp\":10000},\"15306\":{\"cp\":100},\"15307\":{\"cp\":10000},\"15391\":{\"cp\":100},\"15392\":{\"cp\":10000},\"15393\":{\"cp\":1200},\"15394\":{\"cp\":10000},\"19997\":{\"cp\":10000},\"19998\":{\"cp\":10000},\"19999\":{\"cp\":10000},\"21032\":{\"cp\":10000},\"21034\":{\"cp\":1},\"21064\":{\"cp\":10000},\"22064\":{\"cp\":1},\"61001\":{\"cp\":10000},\"61006\":{\"cp\":10000},\"61007\":{\"cp\":10000},\"65001\":{\"cp\":1},\"65100\":{\"cp\":1},\"65101\":{\"cp\":4},\"65104\":{\"cp\":10000},\"65105\":{\"cp\":10000},\"65111\":{\"cp\":100},\"65113\":{\"cp\":10000},\"65114\":{\"cp\":10000},\"65125\":{\"cp\":10000},\"65132\":{\"cp\":10000},\"65171\":{\"cp\":100},\"65172\":{\"cp\":100},\"65173\":{\"cp\":100},\"65174\":{\"cp\":100},\"65175\":{\"cp\":100},\"65176\":{\"cp\":100},\"65177\":{\"cp\":100},\"65178\":{\"cp\":100},\"65180\":{\"cp\":900},\"65183\":{\"cp\":10000},\"65200\":{\"cp\":10000},\"65501\":{\"cp\":10000},\"65502\":{\"cp\":10000},\"65503\":{\"cp\":10000},\"66001\":{\"cp\":100},\"66003\":{\"cp\":10000},\"66101\":{\"cp\":10000},\"66404\":{\"cp\":10000},\"66602\":{\"cp\":10000}}},\"B02N_ut_stream\":{\"content\":{\"1\":{\"stm\":\"stm_x\"},\"1000\":{\"stm\":\"stm_p\"},\"2000\":{\"stm\":\"stm_p\"},\"2100\":{\"stm\":\"stm_c\"},\"4007\":{\"stm\":\"stm_d\"},\"5002\":{\"stm\":\"stm_d\"},\"5004\":{\"stm\":\"stm_d\"},\"5005\":{\"stm\":\"stm_d\"},\"6004\":{\"stm\":\"stm_d\"},\"9001\":{\"stm\":\"stm_d\"},\"9002\":{\"stm\":\"stm_d\"},\"9003\":{\"stm\":\"stm_d\"},\"9101\":{\"stm\":\"stm_d\"},\"9199\":{\"stm\":\"stm_d\"},\"15301\":{\"stm\":\"stm_x\"},\"15302\":{\"stm\":\"stm_x\"},\"15303\":{\"stm\":\"stm_x\"},\"15304\":{\"stm\":\"stm_x\"},\"15305\":{\"stm\":\"stm_x\"},\"15306\":{\"stm\":\"stm_x\"},\"15307\":{\"stm\":\"stm_x\"},\"15391\":{\"stm\":\"stm_x\"},\"15392\":{\"stm\":\"stm_x\"},\"15393\":{\"stm\":\"stm_x\"},\"15394\":{\"stm\":\"stm_x\"},\"19999\":{\"stm\":\"stm_d\"},\"21032\":{\"stm\":\"stm_x\"},\"21034\":{\"stm\":\"stm_x\"},\"21064\":{\"stm\":\"stm_x\"},\"22064\":{\"stm\":\"stm_x\"},\"61001\":{\"stm\":\"stm_x\"},\"61006\":{\"stm\":\"stm_x\"},\"61007\":{\"stm\":\"stm_x\"},\"65001\":{\"stm\":\"stm_x\"},\"65100\":{\"stm\":\"stm_x\"},\"65101\":{\"stm\":\"stm_x\"},\"65104\":{\"stm\":\"stm_x\"},\"65105\":{\"stm\":\"stm_x\"},\"65111\":{\"stm\":\"stm_x\"},\"65113\":{\"stm\":\"stm_x\"},\"65114\":{\"stm\":\"stm_x\"},\"65125\":{\"stm\":\"stm_x\"},\"65132\":{\"stm\":\"stm_x\"},\"65171\":{\"stm\":\"stm_x\"},\"65172\":{\"stm\":\"stm_x\"},\"65173\":{\"stm\":\"stm_x\"},\"65174\":{\"stm\":\"stm_x\"},\"65175\":{\"stm\":\"stm_x\"},\"65176\":{\"stm\":\"stm_x\"},\"65177\":{\"stm\":\"stm_x\"},\"65178\":{\"stm\":\"stm_x\"},\"65180\":{\"stm\":\"stm_x\"},\"65183\":{\"stm\":\"stm_x\"},\"65200\":{\"stm\":\"stm_d\"},\"65501\":{\"stm\":\"stm_d\"},\"65502\":{\"stm\":\"stm_d\"},\"65503\":{\"stm\":\"stm_d\"},\"66001\":{\"stm\":\"stm_d\"},\"66003\":{\"stm\":\"stm_d\"},\"66101\":{\"stm\":\"stm_d\"},\"66404\":{\"stm\":\"stm_d\"}}},\"B02N_ut_bussiness\":{\"content\":{\"tpk\":[{\"kn\":\"adid\",\"ty\":\"nearby\"},{\"kn\":\"ucm\",\"ty\":\"nearby\"},{\"kn\":\"bdid\",\"ty\":\"far\"},{\"kn\":\"ref_pid\",\"ty\":\"far\"},{\"kn\":\"pid\",\"ty\":\"far\"},{\"kn\":\"tpa\",\"ty\":\"far\"},{\"kn\":\"point\",\"ty\":\"far\"},{\"kn\":\"ali_trackid\",\"ty\":\"far\"},{\"kn\":\"xncode\",\"ty\":\"nearby\"}]}}}");
    }

    private final synchronized void a() {
        Variables.n().k().b(qq2.class);
        f(new LinkedList());
    }

    private final synchronized void b(List<qq2> list) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (qq2 qq2 : list) {
                if (qq2.c() != null) {
                    hashMap.put(qq2.c(), qq2);
                }
            }
            Iterator<vq2> it = this.a.iterator();
            while (it.hasNext()) {
                vq2 next = it.next();
                String[] a2 = next.a();
                for (String str : a2) {
                    if (hashMap.containsKey(str)) {
                        qq2 qq22 = (qq2) hashMap.get(str);
                        if (Logger.n()) {
                            Logger.f("", "Groupname", str, "DBConfEntity", zf2.i(qq22.a()));
                        }
                        next.c(str, zf2.i(qq22.a()));
                    } else {
                        next.b(str);
                    }
                }
            }
        }
    }

    private final synchronized void c() {
        Iterator<vq2> it = this.a.iterator();
        while (it.hasNext()) {
            vq2 next = it.next();
            for (String str : next.a()) {
                next.b(str);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.List<? extends tb.xd0>, java.util.List<tb.qq2> */
    private final synchronized List<qq2> d() {
        return Variables.n().k().i(qq2.class, null, null, -1);
    }

    private final synchronized List<qq2> e(List<qq2> list) {
        LinkedList linkedList;
        HashMap hashMap = new HashMap();
        for (qq2 qq2 : this.c) {
            if (qq2.c() != null) {
                hashMap.put(qq2.c(), qq2);
            }
        }
        linkedList = new LinkedList();
        for (qq2 qq22 : list) {
            String c2 = qq22.c();
            if (c2 != null) {
                qq2 qq23 = (qq2) hashMap.get(c2);
                if (qq23 != null) {
                    if (!qq22.d()) {
                        qq23.f(qq22.a());
                        qq23.g(qq22.b());
                    }
                    qq23.store();
                    linkedList.add(qq23);
                } else {
                    h(c2);
                    qq22.store();
                    linkedList.add(qq22);
                    this.c.add(qq22);
                }
            }
        }
        return linkedList;
    }

    private final synchronized void f(List<qq2> list) {
        this.c = list;
    }

    public static void m(String str) {
    }

    public synchronized void g(vq2 vq2) {
        if (vq2 != null) {
            this.a.add(vq2);
            for (String str : vq2.a()) {
                this.b.put(str, vq2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void h(String str) {
        if (str != null) {
            if (this.c != null) {
                LinkedList<qq2> linkedList = new LinkedList();
                for (qq2 qq2 : this.c) {
                    if (str.equals(qq2.c())) {
                        qq2.delete();
                        linkedList.add(qq2);
                    }
                }
                for (qq2 qq22 : linkedList) {
                    this.c.remove(qq22);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        b(j());
    }

    /* access modifiers changed from: protected */
    public final synchronized List<qq2> j() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final synchronized void k() {
        List<qq2> d2 = d();
        this.c = d2;
        if ((d2 == null || d2.size() == 0) && this.d != null) {
            try {
                this.c = nq2.c(new JSONObject(this.d));
            } catch (JSONException e2) {
                Logger.h(null, e2, new Object[0]);
            }
        }
    }

    public abstract void l();

    public void n(String str) {
        this.d = str;
    }

    public final synchronized void o(String str, Map<String, String> map) {
        if (map != null) {
            String remove = map.remove(f);
            if (!TextUtils.isEmpty(remove)) {
                ConfigTimeStampMgr.c().d(str, remove);
            }
            long j = 0;
            if (remove != null) {
                try {
                    j = Long.valueOf(remove).longValue();
                } catch (Throwable unused) {
                    Logger.i("parse Timestamp error", "timestamp", remove);
                }
            }
            q(nq2.b(str, map, j), false);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void p(List<qq2> list, boolean z) {
        if (list == null) {
            try {
                c();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            if (z) {
                a();
            }
            List<qq2> e2 = e(list);
            if (e2 != null && e2.size() > 0) {
                b(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void q(qq2 qq2, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(qq2);
        p(linkedList, z);
    }
}
