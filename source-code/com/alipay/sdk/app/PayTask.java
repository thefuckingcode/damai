package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.q.f;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.util.H5PayResultModel;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.youku.network.HttpIntent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: Taobao */
public class PayTask {
    public static final Object h = h.class;
    public static long i;
    public Activity a;
    public com.alipay.sdk.m.x.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    /* compiled from: Taobao */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        public void run() {
            H5PayResultModel h5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            e.d(com.alipay.sdk.m.l.a.z, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    /* compiled from: Taobao */
    public class b implements h.g {
        public b() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    /* compiled from: Taobao */
    public class c {
        public String a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    private h.g b() {
        return new b();
    }

    private String c(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString(HttpIntent.COOKIE, c2[1]);
        }
        intent.putExtras(bundle);
        a.C0134a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e2) {
                e.a(e2);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String d2 = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(d2) ? com.alipay.sdk.m.j.b.a() : d2;
    }

    private String d(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar, String str) {
        boolean c2;
        String d2;
        String[] c3 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        try {
            JSONObject h2 = n.h(new String(com.alipay.sdk.m.n.a.a(c3[2])));
            intent.putExtra("url", c3[0]);
            intent.putExtra("title", c3[1]);
            intent.putExtra("version", com.alipay.sdk.m.x.c.d);
            intent.putExtra("method", h2.optString("method", "POST"));
            com.alipay.sdk.m.j.b.a(false);
            com.alipay.sdk.m.j.b.a((String) null);
            a.C0134a.a(aVar, intent);
            this.a.startActivity(intent);
            Object obj = h;
            synchronized (obj) {
                try {
                    obj.wait();
                    c2 = com.alipay.sdk.m.j.b.c();
                    d2 = com.alipay.sdk.m.j.b.d();
                    com.alipay.sdk.m.j.b.a(false);
                    com.alipay.sdk.m.j.b.a((String) null);
                } catch (InterruptedException e2) {
                    e.a(e2);
                    return com.alipay.sdk.m.j.b.a();
                }
            }
            String str2 = "";
            if (c2) {
                try {
                    List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(n.h(new String(com.alipay.sdk.m.n.a.a(d2))));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a2.size()) {
                            break;
                        }
                        com.alipay.sdk.m.r.b bVar2 = a2.get(i2);
                        if (bVar2.a() == com.alipay.sdk.m.r.a.SetResult) {
                            String[] c4 = bVar2.c();
                            str2 = com.alipay.sdk.m.j.b.a(Integer.valueOf(c4[1]).intValue(), c4[0], n.e(aVar, c4[2]));
                            break;
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    e.a(th);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th, d2);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return com.alipay.sdk.m.j.b.a(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th2, "endCode: " + str);
                return com.alipay.sdk.m.j.b.a(JosStatusCodes.RTN_CODE_COMMON_ERROR, "", "");
            }
        } catch (Throwable th3) {
            e.a(th3);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th3, Arrays.toString(c3));
            return com.alipay.sdk.m.j.b.a();
        }
    }

    /* JADX INFO: finally extract failed */
    private String e(com.alipay.sdk.m.s.a aVar, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVar = null;
        try {
            JSONObject c2 = new f().a(aVar, this.a.getApplicationContext(), str).c();
            String optString = c2.optString("end_code", null);
            List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(c2.optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
            for (int i2 = 0; i2 < a2.size(); i2++) {
                if (a2.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                    com.alipay.sdk.m.r.b.a(a2.get(i2));
                }
            }
            j(aVar, c2);
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            for (int i3 = 0; i3 < a2.size(); i3++) {
                com.alipay.sdk.m.r.b bVar = a2.get(i3);
                if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                    String c3 = c(aVar, bVar);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    return c3;
                } else if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                    String d2 = d(aVar, bVar, optString);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    return d2;
                }
            }
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        } catch (IOException e2) {
            com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
            com.alipay.sdk.m.k.a.a(aVar, "net", e2);
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            cVar = b2;
        } catch (Throwable th) {
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            throw th;
        }
        if (cVar == null) {
            cVar = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
        }
        return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0107, code lost:
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x015d, code lost:
        if (com.alipay.sdk.m.m.a.D().s() != false) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x015f, code lost:
        com.alipay.sdk.m.m.a.D().a(r7, r6.a.getApplicationContext(), false, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x016c, code lost:
        dismissLoading();
        com.alipay.sdk.m.k.a.b(r6.a.getApplicationContext(), r7, r8, r7.d);
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay returning: " + r9);
     */
    private synchronized String f(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        String str2;
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            com.alipay.sdk.m.j.a.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            com.alipay.sdk.m.j.a.a("");
        }
        if (str.contains(com.alipay.sdk.m.l.a.v)) {
            com.alipay.sdk.m.l.a.w = true;
        }
        if (com.alipay.sdk.m.l.a.w) {
            if (str.startsWith(com.alipay.sdk.m.l.a.x)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.x) + 53);
            } else if (str.startsWith(com.alipay.sdk.m.l.a.y)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.y) + 52);
            }
        }
        str2 = "";
        try {
            e.d(com.alipay.sdk.m.l.a.z, "pay prepared: " + str);
            str2 = g(str, aVar);
            e.d(com.alipay.sdk.m.l.a.z, "pay raw result: " + str2);
            i.a(aVar, this.a.getApplicationContext(), str2);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(str2, l.a) + "|" + l.a(str2, l.b));
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(str2, l.a) + "|" + l.a(str2, l.b));
            if (!com.alipay.sdk.m.m.a.D().s()) {
                com.alipay.sdk.m.m.a.D().a(aVar, this.a.getApplicationContext(), false, 3);
            }
            dismissLoading();
            com.alipay.sdk.m.k.a.b(this.a.getApplicationContext(), aVar, str, aVar.d);
            throw th;
        }
        return str2;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.m.s.b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < ((long) com.alipay.sdk.m.m.a.D().d())) {
                    return false;
                }
                i = elapsedRealtime;
                com.alipay.sdk.m.m.a.D().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
                return true;
            } catch (Exception e2) {
                e.a(e2);
                return false;
            }
        }
    }

    private String g(String str, com.alipay.sdk.m.s.a aVar) {
        String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return e(aVar, a2);
        }
        List<a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, l, true)) {
            h hVar = new h(this.a, aVar, b());
            e.d(com.alipay.sdk.m.l.a.z, "pay inner started: " + a2);
            String a3 = hVar.a(a2, false);
            if (!TextUtils.isEmpty(a3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("resultStatus={");
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT;
                sb.append(cVar.b());
                sb.append("}");
                if (a3.contains(sb.toString())) {
                    n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, aVar);
                    if (com.alipay.sdk.m.m.a.D().A()) {
                        a3 = hVar.a(a2, true);
                    } else {
                        a3 = a3.replace("resultStatus={" + cVar.b() + "}", "resultStatus={" + com.alipay.sdk.m.j.c.CANCELED.b() + "}");
                    }
                }
            }
            e.d(com.alipay.sdk.m.l.a.z, "pay inner raw result: " + a3);
            hVar.a();
            boolean w = com.alipay.sdk.m.m.a.D().w();
            if (TextUtils.equals(a3, "failed") || TextUtils.equals(a3, h.k) || (w && aVar.e())) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
                return e(aVar, a2);
            } else if (TextUtils.isEmpty(a3)) {
                return com.alipay.sdk.m.j.b.a();
            } else {
                if (!a3.contains(PayResultActivity.b)) {
                    return a3;
                }
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
                return a(aVar, a2, l, a3, this.a);
            }
        } else {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
            return e(aVar, a2);
        }
    }

    private String h(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private String i(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String str2;
        String str3;
        boolean equals = "9000".equals(map.get(l.a));
        String str4 = map.get("result");
        c remove = this.g.remove(str);
        String[] strArr = new String[2];
        if (remove != null) {
            str2 = remove.a();
        } else {
            str2 = "";
        }
        strArr[0] = str2;
        if (remove != null) {
            str3 = remove.d();
        } else {
            str3 = "";
        }
        strArr[1] = str3;
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str4.length() > 15) {
            String a2 = a(n.a("&callBackUrl=\"", "\"", str4), n.a("&call_back_url=\"", "\"", str4), n.a(com.alipay.sdk.m.l.a.t, "\"", str4), URLDecoder.decode(n.a(com.alipay.sdk.m.l.a.u, "&", str4), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str4), "utf-8"), n.a("call_back_url=\"", "\"", str4));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String b2 = equals ? remove.b() : remove.c();
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        if (remove != null) {
            return com.alipay.sdk.m.m.a.D().r();
        }
        return "";
    }

    private void j(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(optString, optString2);
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th);
        }
    }

    private boolean k(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            if (z2) {
                return false;
            }
            return true;
        } else if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        } else {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.a));
                    return com.alipay.sdk.m.s.a.C + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String a2 = n.a("?", "", str);
                    if (!TextUtils.isEmpty(a2)) {
                        Map<String, String> b2 = n.b(a2);
                        StringBuilder sb = new StringBuilder();
                        if (k(false, true, com.alipay.sdk.m.k.b.B0, sb, b2, com.alipay.sdk.m.k.b.B0, "alipay_trade_no")) {
                            k(true, false, "pay_phase_id", sb, b2, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = b2.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(b2.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(b2.get("sid")) || !TextUtils.isEmpty(b2.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!k(true, true, "extern_token", sb, b2, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            k(true, false, "appenv", sb, b2, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            c cVar = new c(this, null);
                            cVar.b(b2.get("return_url"));
                            cVar.c(b2.get("show_url"));
                            cVar.a(b2.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                            this.g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") || trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") || (EnvUtils.isSandBox() && trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    String a3 = a(this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", trim);
                    jSONObject2.put("bizcontext", a3);
                    return String.format("new_external_info==%s", jSONObject2.toString());
                } else if (com.alipay.sdk.m.m.a.D().h() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                    Uri parse = Uri.parse(trim);
                    String queryParameter = parse.getQueryParameter("return_url");
                    String queryParameter2 = parse.getQueryParameter("show_url");
                    String queryParameter3 = parse.getQueryParameter("pay_order_id");
                    String a4 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                    String a5 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                    String[] strArr = new String[4];
                    strArr[0] = parse.getQueryParameter("app_name");
                    strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                    strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                    strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                    String a6 = a(strArr);
                    String a7 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                    String a8 = a(parse.getQueryParameter("appenv"));
                    if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a6) && !TextUtils.isEmpty(a7)) {
                        String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a4, a5, a6, a7, a8, a(this.a));
                        c cVar2 = new c(this, null);
                        cVar2.b(queryParameter);
                        cVar2.c(queryParameter2);
                        cVar2.a(queryParameter3);
                        cVar2.d(a4);
                        this.g.put(format, cVar2);
                        return format;
                    }
                }
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return i.a(new com.alipay.sdk.m.s.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.11";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] split = f(aVar, str, z).split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, h(str2, substring));
                }
            }
            if (hashMap.containsKey(l.a)) {
                h5PayResultModel.setResultCode(hashMap.get(l.a));
            }
            h5PayResultModel.setReturnUrl(i(str, hashMap));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.o0, th);
            e.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return f(new com.alipay.sdk.m.s.a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            e.d(com.alipay.sdk.m.l.a.z, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String str2;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            aVar = null;
            str2 = com.alipay.sdk.m.j.b.b();
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.a, str, "payV2");
            str2 = f(aVar2, str, z);
            aVar = aVar2;
        }
        return l.a(aVar, str2);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    public static String a(Context context) {
        String str;
        String str2;
        Exception e2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str2 = packageInfo.versionName;
            try {
                str = packageInfo.packageName;
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            e.a(e2);
            str = "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", com.alipay.sdk.m.l.a.f);
            jSONObject.put(com.alipay.sdk.m.s.a.s, "and_lite");
            jSONObject.put(com.alipay.sdk.m.s.a.t, "h.a.3.8.11");
            jSONObject.put(com.alipay.sdk.m.s.a.u, str);
            jSONObject.put(com.alipay.sdk.m.s.a.w, str2);
            jSONObject.put(com.alipay.sdk.m.s.a.x, System.currentTimeMillis());
            if (!TextUtils.isEmpty(IRequestConst.SC)) {
            }
            return jSONObject.toString();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", com.alipay.sdk.m.l.a.f);
            jSONObject2.put(com.alipay.sdk.m.s.a.s, "and_lite");
            jSONObject2.put(com.alipay.sdk.m.s.a.t, "h.a.3.8.11");
            jSONObject2.put(com.alipay.sdk.m.s.a.u, str);
            jSONObject2.put(com.alipay.sdk.m.s.a.w, str2);
            jSONObject2.put(com.alipay.sdk.m.s.a.x, System.currentTimeMillis());
            if (!TextUtils.isEmpty(IRequestConst.SC)) {
                jSONObject2.put(IRequestConst.SC, "h5tonative");
            }
            return jSONObject2.toString();
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(com.alipay.sdk.m.s.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        n.c a2 = n.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.a.packageName, PayResultActivity.d)) {
            return str2;
        }
        e.b(com.alipay.sdk.m.l.a.z, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.c;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, valueOf);
        a.C0134a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                e.b(com.alipay.sdk.m.l.a.z, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                e.b(com.alipay.sdk.m.l.a.z, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        e.b(com.alipay.sdk.m.l.a.z, "PayTask ret: " + str3);
        return str3;
    }
}
