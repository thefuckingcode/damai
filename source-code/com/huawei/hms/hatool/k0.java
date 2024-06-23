package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class k0 implements n0 {
    public Context a = b.i();
    public String b;
    public String c;
    public String d;

    public k0(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void a(String str, List<q> list) {
        Pair<String, String> a2 = u0.a(str);
        new t(list, (String) a2.first, (String) a2.second, this.d).a();
    }

    public void run() {
        y.c("hmsSdk", "eventReportTask is running");
        boolean a2 = q0.a(this.a);
        if (a2) {
            y.c("hmsSdk", "workKey is refresh,begin report all data");
            this.c = "alltype";
        }
        try {
            Map<String, List<q>> a3 = w.a(this.a, this.b, this.c);
            if (a3.size() == 0) {
                y.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.b, this.c);
                if ("alltype".equals(this.c)) {
                    g0.a(this.a, "stat_v2_1", new String[0]);
                    g0.a(this.a, "cached_v2_1", new String[0]);
                    return;
                }
                String a4 = u0.a(this.b, this.c);
                g0.a(this.a, "stat_v2_1", a4);
                g0.a(this.a, "cached_v2_1", a4);
                return;
            }
            for (Map.Entry<String, List<q>> entry : a3.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.c)) {
                g0.a(this.a, "stat_v2_1", new String[0]);
                g0.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a5 = u0.a(this.b, this.c);
                g0.a(this.a, "stat_v2_1", a5);
                g0.a(this.a, "cached_v2_1", a5);
            }
            if (a2) {
                y.c("hmsSdk", "refresh local key");
                d0.f().b();
            }
        } catch (IllegalArgumentException e) {
            y.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
            if ("alltype".equals(this.c)) {
                g0.a(this.a, "stat_v2_1", new String[0]);
                g0.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a6 = u0.a(this.b, this.c);
                g0.a(this.a, "stat_v2_1", a6);
                g0.a(this.a, "cached_v2_1", a6);
            }
        } catch (Exception e2) {
            y.e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
            if ("alltype".equals(this.c)) {
                g0.a(this.a, "stat_v2_1", new String[0]);
                g0.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a7 = u0.a(this.b, this.c);
                g0.a(this.a, "stat_v2_1", a7);
                g0.a(this.a, "cached_v2_1", a7);
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.c)) {
                g0.a(this.a, "stat_v2_1", new String[0]);
                g0.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a8 = u0.a(this.b, this.c);
                g0.a(this.a, "stat_v2_1", a8);
                g0.a(this.a, "cached_v2_1", a8);
            }
            throw th;
        }
    }
}
