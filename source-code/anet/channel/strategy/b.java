package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.util.ALog;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.BaseMonitor;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.a90;
import tb.h9;
import tb.ju2;

/* compiled from: Taobao */
public class b {

    /* compiled from: Taobao */
    public static class a {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final String h;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.b = jSONObject.optString("protocol");
            this.c = jSONObject.optInt("cto");
            this.d = jSONObject.optInt("rto");
            this.e = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_RETRY);
            this.f = jSONObject.optInt("heartbeat");
            this.g = jSONObject.optString("rtt", "");
            this.h = jSONObject.optString("publickey");
        }
    }

    /* renamed from: anet.channel.strategy.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0004b {
        public String[] a;
        public c[] b;
        public boolean c = false;

        public C0004b(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new String[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = optJSONArray.optString(i);
                    if (ju2.d(this.a[i])) {
                        this.c = true;
                    }
                }
            } else {
                this.a = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("attributes");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.b = new c[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.b[i2] = new c(optJSONArray2.optJSONObject(i2));
                }
                return;
            }
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    public static class c {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final String h;

        public c(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.b = jSONObject.optString("protocol");
            this.c = jSONObject.optInt("cto");
            this.d = jSONObject.optInt("rto");
            this.e = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_RETRY);
            this.f = jSONObject.optInt("heartbeat");
            this.h = jSONObject.optString("publickey");
            this.g = jSONObject.optString("rtt");
        }
    }

    /* compiled from: Taobao */
    public static class d {
        public String a;
        public int b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public boolean g;
        public int h;
        public boolean i;
        public HashMap<String, Boolean> j;
        public i[] k;
        public int l;

        public d(JSONObject jSONObject) {
            this.a = jSONObject.optString("host");
            this.b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.c = jSONObject.optString("safeAisles");
            this.d = jSONObject.optString("cname", null);
            this.e = jSONObject.optString("unit", null);
            this.f = jSONObject.optInt(Constants.TAG_CLEAR_STRING) == 1;
            this.g = jSONObject.optBoolean("effectNow");
            this.h = jSONObject.optInt("version");
            this.l = jSONObject.optInt("um");
            JSONArray optJSONArray = jSONObject.optJSONArray("servers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.k = new i[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.k[i2] = new i(optJSONArray.optJSONObject(i2));
                }
            } else {
                this.k = null;
            }
            if (this.k != null) {
                int i3 = 0;
                while (true) {
                    i[] iVarArr = this.k;
                    if (i3 >= iVarArr.length) {
                        break;
                    }
                    C0004b[] bVarArr = iVarArr[i3].a;
                    if (bVarArr != null && bVarArr.length > 0) {
                        this.i = bVarArr[0] != null ? bVarArr[0].c : false;
                    }
                    i3++;
                }
            }
            String optString = jSONObject.optString(a90.AB_STRATEGY);
            if (!TextUtils.isEmpty(optString)) {
                this.j = new HashMap<>();
                String[] split = optString.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        String[] split2 = str.split("=");
                        if (split2 != null && split2.length == 2) {
                            try {
                                this.j.put(split2[0], Boolean.valueOf(Integer.parseInt(split2[1]) == 1));
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.j = null;
        }
    }

    /* compiled from: Taobao */
    public static class e {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String[] f;
        public final String[] g;
        public final a[] h;
        public final j[] i;
        public final boolean j;
        public final boolean k;
        public final int l;
        public final boolean m;
        public final HashMap<String, Boolean> n;
        public final int o;

        public e(JSONObject jSONObject) {
            boolean z;
            this.a = jSONObject.optString("host");
            this.b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.c = jSONObject.optString("safeAisles");
            this.d = jSONObject.optString("cname", null);
            this.e = jSONObject.optString("unit", null);
            this.j = jSONObject.optInt(Constants.TAG_CLEAR_STRING) == 1;
            this.k = jSONObject.optBoolean("effectNow");
            this.l = jSONObject.optInt("version");
            this.o = jSONObject.optInt("um");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f = new String[length];
                z = false;
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!z) {
                        z = ju2.d(optString);
                    }
                    this.f[i2] = optString;
                }
            } else {
                this.f = null;
                z = false;
            }
            this.m = z;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                this.g = null;
            } else {
                int length2 = optJSONArray2.length();
                this.g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.g[i3] = optJSONArray2.optString(i3);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.h[i4] = new a(optJSONArray3.optJSONObject(i4));
                }
            } else {
                this.h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                this.i = null;
            } else {
                int length4 = optJSONArray4.length();
                this.i = new j[length4];
                for (int i5 = 0; i5 < length4; i5++) {
                    this.i[i5] = new j(optJSONArray4.optJSONObject(i5));
                }
            }
            String optString2 = jSONObject.optString(a90.AB_STRATEGY);
            if (!TextUtils.isEmpty(optString2)) {
                this.n = new HashMap<>();
                String[] split = optString2.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        String[] split2 = str.split("=");
                        if (split2 != null && split2.length == 2) {
                            try {
                                this.n.put(split2[0], Boolean.valueOf(Integer.parseInt(split2[1]) == 1));
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return;
                }
                return;
            }
            this.n = null;
        }
    }

    /* compiled from: Taobao */
    public static class f {
        public final String a;
        public final j[] b;

        public f(JSONObject jSONObject) {
            this.a = jSONObject.optString("host");
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.b = new j[length];
                for (int i = 0; i < length; i++) {
                    this.b[i] = new j(optJSONArray.optJSONObject(i));
                }
                return;
            }
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    public static class g {
        public final String a;
        public e[] b;
        public d[] c;
        public final f[] d;
        public final int e;
        public final int f;
        public final int g;
        public final String h;

        public g(JSONObject jSONObject) {
            this.a = jSONObject.optString(TbAuthConstants.IP);
            jSONObject.optString("uid", null);
            jSONObject.optString("utdid", null);
            this.e = jSONObject.optInt(a90.CONFIG_VERSION);
            this.f = jSONObject.optInt("fcl");
            this.g = jSONObject.optInt("fct");
            this.h = jSONObject.optString("accessPoint");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (h9.N()) {
                    this.c = new d[length];
                    for (int i = 0; i < length; i++) {
                        this.c[i] = new d(optJSONArray.optJSONObject(i));
                    }
                } else {
                    this.b = new e[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        this.b[i2] = new e(optJSONArray.optJSONObject(i2));
                    }
                }
            } else {
                this.b = null;
                this.c = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.d = new f[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.d[i3] = new f(optJSONArray2.optJSONObject(i3));
                }
                return;
            }
            this.d = null;
        }
    }

    /* compiled from: Taobao */
    static class h {
        C0004b[] a;

        public h(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("channels");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new C0004b[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = new C0004b(optJSONArray.optJSONObject(i));
                }
                return;
            }
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    public static class i {
        public C0004b[] a;
        public h[] b;
        public boolean c;

        public i(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("channels");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new C0004b[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = new C0004b(optJSONArray.optJSONObject(i));
                }
            } else {
                this.a = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("proxies");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.b = new h[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.b[i2] = new h(optJSONArray2.optJSONObject(i2));
                }
            } else {
                this.b = null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("labels");
            if (optJSONObject != null) {
                this.c = "bgp-static".equalsIgnoreCase(optJSONObject.optString("networkRouteProtocolType"));
            }
        }
    }

    /* compiled from: Taobao */
    public static class j {
        public final String a;
        public final a b;
        public final String c;

        public j(JSONObject jSONObject) {
            this.a = jSONObject.optString(TbAuthConstants.IP);
            this.c = jSONObject.optString(com.alibaba.security.realidentity.jsbridge.a.V);
            this.b = new a(jSONObject);
        }
    }

    public static g a(JSONObject jSONObject) {
        try {
            return new g(jSONObject);
        } catch (Exception e2) {
            ALog.d("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
