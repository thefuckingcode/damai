package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* compiled from: Taobao */
public class a {

    /* renamed from: com.alipay.sdk.m.k.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0123a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            synchronized (C0123a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat append " + str2 + " , " + str);
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C0124a a2 = a(context);
                        if (a2.a.size() > 20) {
                            a2.a.clear();
                        }
                        a2.a.put(str2, str);
                        a(context, a2);
                        return str2;
                    }
                }
                return null;
            }
        }

        public static synchronized String b(Context context) {
            synchronized (C0123a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                C0124a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                try {
                    return a2.a.entrySet().iterator().next().getValue();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return null;
                }
            }
        }

        /* renamed from: com.alipay.sdk.m.k.a$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0124a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C0124a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0124a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            synchronized (C0123a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat remove " + str);
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0124a a2 = a(context);
                        if (a2.a.isEmpty()) {
                            return 0;
                        }
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (Map.Entry<String, String> entry : a2.a.entrySet()) {
                                if (str.equals(entry.getValue())) {
                                    arrayList.add(entry.getKey());
                                }
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                a2.a.remove((String) it.next());
                            }
                            a(context, a2);
                            return arrayList.size();
                        } catch (Throwable th) {
                            com.alipay.sdk.m.u.e.a(th);
                            int size = a2.a.size();
                            a(context, new C0124a());
                            return size;
                        }
                    }
                }
                return 0;
            }
        }

        public static synchronized C0124a a(Context context) {
            synchronized (C0123a.class) {
                try {
                    String a2 = j.a(null, context, b, null);
                    if (TextUtils.isEmpty(a2)) {
                        return new C0124a();
                    }
                    return new C0124a(a2);
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new C0124a();
                }
            }
        }

        public static synchronized void a(Context context, C0124a aVar) {
            synchronized (C0123a.class) {
                if (aVar == null) {
                    try {
                        aVar = new C0124a();
                    } catch (Throwable th) {
                        com.alipay.sdk.m.u.e.a(th);
                    }
                }
                j.b(null, context, b, aVar.a());
            }
            return;
        }
    }

    /* compiled from: Taobao */
    public static final class b {

        /* renamed from: com.alipay.sdk.m.k.a$b$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class RunnableC0125a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC0125a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            public void run() {
                if (TextUtils.isEmpty(this.a) || b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        String b2 = C0123a.b(this.b);
                        if (TextUtils.isEmpty(b2) || !b.b(this.b, b2)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            synchronized (b.class) {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "stat sub " + str);
                try {
                    if ((com.alipay.sdk.m.m.a.D().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) == null) {
                        return false;
                    }
                    C0123a.a(context, str);
                    return true;
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return false;
                }
            }
        }

        public static synchronized void a(Context context, b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context != null && bVar != null && str != null) {
                    a(context, bVar.a(str), str2);
                }
            }
        }

        public static synchronized void a(Context context) {
            synchronized (b.class) {
                a(context, null, null);
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0123a.a(context, str, str2);
                    }
                    new Thread(new RunnableC0125a(str, context)).start();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c {
        public static final String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (c.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    /* compiled from: Taobao */
    public static final class d {
        public static synchronized long a(Context context, String str) {
            long j;
            long j2;
            synchronized (d.class) {
                try {
                    String a = j.a(null, context, str, null);
                    if (!TextUtils.isEmpty(a)) {
                        j = Long.parseLong(a);
                        j2 = j + 1;
                        j.b(null, context, str, Long.toString(j2));
                    }
                } catch (Throwable unused) {
                }
                j = 0;
                j2 = j + 1;
                try {
                    j.b(null, context, str, Long.toString(j2));
                } catch (Throwable unused2) {
                }
            }
            return j2;
        }
    }

    /* compiled from: Taobao */
    public static final class e {
        public static final String a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (e.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                try {
                    C0123a.a(context, aVar.l.a(str), str2);
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
                return;
            }
            return;
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                b.a(context, aVar.l, str, str2);
            }
        }
    }

    public static void b(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.l.b(str, str2, str3);
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, Throwable th) {
        if (aVar != null && th != null) {
            aVar.l.a(str, th.getClass().getSimpleName(), th);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar != null) {
            aVar.l.a(str, str2, th, str3);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th) {
        if (aVar != null) {
            aVar.l.a(str, str2, th);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.l.a(str, str2, str3);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (aVar != null) {
            aVar.l.a(str, str2);
        }
    }
}
