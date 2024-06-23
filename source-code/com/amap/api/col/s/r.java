package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.bl;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class r {
    public static bv a;
    private static r b;
    private static Context c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") {
        /* class com.amap.api.col.s.r.AnonymousClass1 */

        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            bv a2 = h.a(false);
            r.c(r.c);
            bl.a(r.c, a2, "11K" + ";" + "001" + ";" + "184" + ";" + "185", new bl.a() {
                /* class com.amap.api.col.s.r.AnonymousClass1.AnonymousClass1 */

                @Override // com.amap.api.col.s.bl.a
                public final void a(bl.b bVar) {
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    JSONObject jSONObject2;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            bl.b.a aVar = bVar.g;
                            if (aVar != null) {
                                message.obj = new s(aVar.b, aVar.a);
                            }
                        } catch (Throwable th) {
                            message.what = 3;
                            if (r.this.d != null) {
                                r.this.d.sendMessage(message);
                            }
                            throw th;
                        }
                    }
                    if (!(bVar == null || (jSONObject2 = bVar.f) == null || (optJSONObject2 = jSONObject2.optJSONObject("184")) == null)) {
                        r.d(optJSONObject2);
                        am.a(r.c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (!(bVar == null || (jSONObject = bVar.f) == null || (optJSONObject = jSONObject.optJSONObject("185")) == null)) {
                        r.c(optJSONObject);
                        am.a(r.c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (r.this.d == null) {
                        return;
                    }
                    r.this.d.sendMessage(message);
                }
            });
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends Handler {
        String a = "handleMessage";

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    s sVar = (s) message.obj;
                    if (sVar == null) {
                        sVar = new s(false, false);
                    }
                    cl.a(r.c, h.a(sVar.a()));
                    r.a = h.a(sVar.a());
                } catch (Throwable th) {
                    i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    private r(Context context) {
        c = context;
        a = h.a(false);
        try {
            b();
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        try {
            String str = (String) am.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) am.b(context, "amap_search", "parm_control", "");
            if (!TextUtils.isEmpty(str2)) {
                c(new JSONObject(str2));
            }
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    ae.a a2 = a(jSONObject, true, (ae.a) null);
                    ae.a().a(a2);
                    if (a2.a()) {
                        a("regeo", jSONObject, a2);
                        a("geo", jSONObject, a2);
                        a("placeText", jSONObject, a2);
                        a("placeAround", jSONObject, a2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void b() {
        ad.a();
    }

    public static r a(Context context) {
        if (b == null) {
            b = new r(context);
        }
        return b;
    }

    private static void a(String str, JSONObject jSONObject, ae.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            ae.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static ae.a a(JSONObject jSONObject, boolean z, ae.a aVar) {
        Throwable th;
        boolean z2;
        ae.a aVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            ae.a aVar3 = new ae.a();
            boolean z3 = false;
            if (z) {
                try {
                    String optString = jSONObject.optString("able");
                    if (aVar == null || aVar.a()) {
                        z3 = true;
                    }
                    z2 = bl.a(optString, z3);
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar3;
                    th.printStackTrace();
                    return aVar2;
                }
            } else {
                if (aVar == null || aVar.a()) {
                    z3 = true;
                }
                z2 = jSONObject.optBoolean("able", z3);
            }
            int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : 86400);
            int optInt2 = jSONObject.optInt(GiftNumBean.KEY_NUM, aVar != null ? aVar.c() : 10);
            double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : 0.0d);
            aVar3.a(z2);
            aVar3.a((long) optInt);
            aVar3.a(optInt2);
            aVar3.a(optDouble);
            return aVar3;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return aVar2;
        }
    }

    /* access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = bl.a(jSONObject.optString("passAreaAble"), true);
                boolean a3 = bl.a(jSONObject.optString("truckAble"), true);
                boolean a4 = bl.a(jSONObject.optString("poiPageAble"), true);
                boolean a5 = bl.a(jSONObject.optString("rideAble"), true);
                boolean a6 = bl.a(jSONObject.optString("walkAble"), true);
                boolean a7 = bl.a(jSONObject.optString("passPointAble"), true);
                boolean a8 = bl.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                ah.a().a(a2);
                ah.a().c(optInt2);
                ah.a().i(optInt8);
                ah.a().j(optInt9);
                ah.a().b(a3);
                ah.a().g(optInt6);
                ah.a().c(a4);
                ah.a().f(optInt5);
                ah.a().a(optInt);
                ah.a().b(optInt10);
                ah.a().g(a8);
                ah.a().d(a5);
                ah.a().h(optInt7);
                ah.a().e(a6);
                ah.a().d(optInt3);
                ah.a().f(a7);
                ah.a().e(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
