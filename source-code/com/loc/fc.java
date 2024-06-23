package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.loc.bl;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.e53;
import tb.jl1;
import tb.q53;
import tb.r53;
import tb.x53;

/* compiled from: Taobao */
public final class fc {
    private static fc i = null;
    public static int j = 1;
    public static int k = 2;
    private long a = 0;
    private ArrayList<String> b = new ArrayList<>();
    private e53 c = new e53();
    private e53 d = new e53();
    private long e = 120000;
    private Context f;
    private String g;
    private boolean h = false;

    private fc(Context context) {
        this.f = context;
    }

    public static synchronized fc c(Context context) {
        fc fcVar;
        synchronized (fc.class) {
            if (i == null) {
                i = new fc(context);
            }
            fcVar = i;
        }
        return fcVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private e53 j(int i2) {
        return i2 == k ? this.d : this.c;
    }

    private synchronized void l(boolean z, final int i2) {
        if (!z) {
            if (!i1.E() && this.h) {
                return;
            }
        }
        if (this.a != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.a;
            if (currentTimeMillis - j2 < this.e) {
                return;
            }
            if (currentTimeMillis - j2 < DateUtils.MILLIS_PER_MINUTE) {
                return;
            }
        }
        this.a = System.currentTimeMillis();
        this.h = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + jl1.BRACKET_START_STR + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        o0.f().d(new ck() {
            /* class com.loc.fc.AnonymousClass1 */

            @Override // com.loc.ck
            public final void a() {
                JSONObject jSONObject;
                int i;
                StringBuilder sb = new StringBuilder("http://");
                sb.append(i1.G());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i2 == fc.k ? 6 : 4);
                String sb2 = sb.toString();
                q53 q53 = new q53();
                q53.L(sb2);
                q53.N(sb2);
                q53.d(bl.a.SINGLE);
                q53.f(bl.c.HTTP);
                try {
                    bg.b();
                    JSONObject jSONObject2 = new JSONObject(new String(bg.c(q53).a));
                    String[] n = fc.n(jSONObject2.optJSONArray("ips"), fc.j);
                    if (n != null && n.length > 0 && !fc.m(n, fc.this.j(fc.j).d())) {
                        fc.this.j(fc.j).c(n);
                        fc.this.r(fc.j);
                    }
                    String[] n2 = fc.n(jSONObject2.optJSONArray("ipsv6"), fc.k);
                    if (n2 != null && n2.length > 0 && !fc.m(n2, fc.this.j(fc.k).d())) {
                        fc.this.j(fc.k).c(n2);
                        fc.this.r(fc.k);
                    }
                    if ((jSONObject2.has("ips") || jSONObject2.has("ipsv6")) && jSONObject2.has(RemoteMessageConst.TTL) && (i = jSONObject2.getInt(RemoteMessageConst.TTL)) > 30) {
                        fc.this.e = (long) (i * 1000);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                }
                l1.n(fc.this.f, "O018", jSONObject);
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean m(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!strArr[i2].equals(strArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static String[] n(JSONArray jSONArray, int i2) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String string = jSONArray.getString(i3);
            if (!TextUtils.isEmpty(string)) {
                if (i2 == k) {
                    string = jl1.ARRAY_START_STR + string + jl1.ARRAY_END_STR;
                }
                strArr[i3] = string;
            }
        }
        return strArr;
    }

    private static String o(int i2) {
        return i2 == k ? "last_ip_6" : "last_ip_4";
    }

    private void p(int i2) {
        if (j(i2).i()) {
            SharedPreferences.Editor c2 = x53.c(this.f, "cbG9jaXA");
            x53.g(c2, o(i2));
            x53.f(c2);
            j(i2).b(false);
        }
    }

    private String q(int i2) {
        String str;
        int i3 = 0;
        l(false, i2);
        String[] d2 = j(i2).d();
        if (d2 == null || d2.length <= 0) {
            s(i2);
            return j(i2).e();
        }
        int length = d2.length;
        while (true) {
            if (i3 >= length) {
                str = null;
                break;
            }
            str = d2[i3];
            if (!this.b.contains(str)) {
                break;
            }
            i3++;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        j(i2).a(str);
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(int i2) {
        if (j(i2).d() != null && j(i2).d().length > 0) {
            String str = j(i2).d()[0];
            if (!str.equals(this.g) && !this.b.contains(str)) {
                this.g = str;
                SharedPreferences.Editor c2 = x53.c(this.f, "cbG9jaXA");
                x53.j(c2, o(i2), str);
                x53.f(c2);
            }
        }
    }

    private void s(int i2) {
        String e2 = x53.e(this.f, "cbG9jaXA", o(i2), null);
        if (!TextUtils.isEmpty(e2) && !this.b.contains(e2)) {
            j(i2).a(e2);
            j(i2).f(e2);
            j(i2).b(true);
        }
    }

    public final String d(r53 r53, int i2) {
        try {
            if (i1.F() && r53 != null) {
                String j2 = r53.j();
                String host = new URL(j2).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(j2)) {
                    if (!"abroad.apilocate.amap.com".equals(host)) {
                        String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                        if (!m.J(str)) {
                            return null;
                        }
                        String q = q(i2);
                        if (!TextUtils.isEmpty(q)) {
                            r53.c0(j2.replace(host, q));
                            r53.b().put("host", str);
                            r53.d0(str);
                            r53.i(i2 == k);
                            return q;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void f(int i2) {
        if (!j(i2).j()) {
            this.b.add(j(i2).e());
            p(i2);
            l(true, i2);
            return;
        }
        p(i2);
    }

    public final void g(boolean z, int i2) {
        j(i2).g(z);
        if (z) {
            String h2 = j(i2).h();
            String e2 = j(i2).e();
            if (!TextUtils.isEmpty(e2) && !e2.equals(h2)) {
                SharedPreferences.Editor c2 = x53.c(this.f, "cbG9jaXA");
                x53.j(c2, o(i2), e2);
                x53.f(c2);
            }
        }
    }
}
