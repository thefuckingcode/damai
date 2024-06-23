package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.orange.OConstant;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public class b {
    private static b a;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private List<Serializable> i = Collections.synchronizedList(new ArrayList());
    private List<Serializable> j = Collections.synchronizedList(new ArrayList());
    private Executor k = l.b();
    private boolean l;

    private b() {
    }

    private void c() {
        while (!this.j.isEmpty()) {
            c cVar = (c) this.j.remove(0);
            cVar.a.put("appid", this.b);
            cVar.a.put("app_name", this.c);
            cVar.a.put("app_ver", this.e);
            cVar.a.put(Constants.PARAM_PKG_NAME, this.f);
            cVar.a.put("qq_install", this.g);
            cVar.a.put(Constants.PARAM_QQ_VER, this.h);
            cVar.a.put("openid", this.d);
            HashMap<String, String> hashMap = cVar.a;
            hashMap.put("time_appid_openid", cVar.a.get("time") + JSMethod.NOT_SET + this.b + JSMethod.NOT_SET + this.d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.i.add(cVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.l) {
            List<Serializable> b2 = g.b("report_atta");
            this.l = b2.isEmpty();
            this.i.addAll(b2);
            Iterator<Serializable> it = b2.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.i.isEmpty()) {
            c cVar = (c) this.i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) it2.next())));
            }
            g.a("report_atta", arrayList);
            this.l = false;
        } else if (!this.l) {
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.l = true;
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        String str3;
        String str4;
        String str5;
        String str6;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + JSMethod.NOT_SET + this.b + JSMethod.NOT_SET + this.d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.d);
        hashMap.put("appid", this.b);
        hashMap.put("app_name", this.c);
        hashMap.put("app_ver", this.e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f);
        hashMap.put("os", "AND");
        hashMap.put(OConstant.CANDIDATE_OSVER, Build.VERSION.getRELEASE());
        hashMap.put("sdk_ver", Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, f.a().c(g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        String str7 = "";
        if (obj == null) {
            str3 = str7;
        } else {
            str3 = obj.toString();
        }
        hashMap.put("interface_result", str3);
        hashMap.put("qq_install", this.g);
        hashMap.put(Constants.PARAM_QQ_VER, this.h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            if (obj2 == null) {
                str4 = str7;
            } else {
                str4 = obj2.toString();
            }
            hashMap.put("reserve1", str4);
            Object obj3 = map.get("reserve2");
            if (obj3 == null) {
                str5 = str7;
            } else {
                str5 = obj3.toString();
            }
            hashMap.put("reserve2", str5);
            Object obj4 = map.get("reserve3");
            if (obj4 == null) {
                str6 = str7;
            } else {
                str6 = obj4.toString();
            }
            hashMap.put("reserve3", str6);
            Object obj5 = map.get("reserve4");
            if (obj5 != null) {
                str7 = obj5.toString();
            }
            hashMap.put("reserve4", str7);
        }
        return new c(hashMap);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", UCCore.LEGACY_EVENT_INIT);
        this.b = str;
        this.c = k.a(context);
        this.e = m.d(context, g.b());
        this.f = g.b();
        this.g = k.b(context) ? "1" : "0";
        this.h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c b2 = b(str, str2, obj, map);
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || g.a() == null) {
            SLog.i("AttaReporter", "attaReport cancel appid=" + this.b + ", mAppName=" + this.c + ", context=" + g.a() + AVFSCacheConstants.COMMA_SEP + b2);
            this.j.add(b2);
            return;
        }
        a(b2);
    }

    private void a(final c cVar) {
        this.k.execute(new Runnable() {
            /* class com.tencent.open.b.b.AnonymousClass1 */

            public void run() {
                b.this.i.add(cVar);
                if (!m.b(g.a())) {
                    SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
                    return;
                }
                try {
                    b.this.d();
                } catch (Exception e) {
                    SLog.e("AttaReporter", "Exception", e);
                }
            }
        });
    }

    private boolean b(c cVar) {
        int i2 = 0;
        do {
            i2++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                if (com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.a).d() == 200) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                SLog.i("AttaReporter", "Exception", e2);
                if (i2 >= 2) {
                    return false;
                }
            }
        } while (i2 >= 2);
        return false;
    }

    public static String b() {
        return a().b;
    }
}
