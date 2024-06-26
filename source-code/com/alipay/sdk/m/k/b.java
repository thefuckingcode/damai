package com.alipay.sdk.m.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";
    public static final String J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";
    public static final String a0 = "ErrActNull";
    public static final String b0 = "ErrActEx";
    public static final String c0 = "ErrActNull2";
    public static final String d0 = "ErrActEx2";
    public static final String e0 = "ErrActNotCreated";
    public static final String f0 = "GetInstalledAppEx";
    public static final String g0 = "StartLaunchAppTransEx";
    public static final String h0 = "CheckLaunchAppExistEx";
    public static final String i0 = "LogBindCalledH5";
    public static final String j0 = "LogCalledH5";
    public static final String k = "net";
    public static final String k0 = "LogHkLoginByIntent";
    public static final String l = "biz";
    public static final String l0 = "SchemePayWrongHashEx";
    public static final String m = "cp";
    public static final String m0 = "LogAppFetchConfigTimeout";
    public static final String n = "auth";
    public static final String n0 = "H5CbUrlEmpty";
    public static final String o = "third";
    public static final String o0 = "H5CbEx";
    public static final String p = "wlt";
    public static final String p0 = "StartActivityEx";
    public static final String q = "FormatResultEx";
    public static final String q0 = "JSONEx";
    public static final String r = "GetApdidEx";
    public static final String r0 = "ParseBundleSerializableError";
    public static final String s = "GetApdidNull";
    public static final String s0 = "ParseSchemeQueryError";
    public static final String t = "GetApdidTimeout";
    public static final String t0 = "TbChk";
    public static final String u = "GetUtdidEx";
    public static final String u0 = "TbStart";
    public static final String v = "GetPackageInfoEx";
    public static final String v0 = "TbCancel";
    public static final String w = "NotIncludeSignatures";
    public static final String w0 = "TbUnknown";
    public static final String x = "GetPublicKeyFromSignEx";
    public static final String x0 = "TbOk";
    public static final String y = "webError";
    public static final String y0 = "TbActFail";
    public static final String z = "SSLError";
    public static final String z0 = "partner";
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h = "";
    public String i = "";
    public String j;

    public b(Context context, boolean z2) {
        long j2;
        context = context != null ? context.getApplicationContext() : context;
        this.a = b();
        this.c = a(context);
        if (z2) {
            j2 = 0;
        } else {
            j2 = a.e.a(context);
        }
        this.d = a(j2);
        this.e = a();
        this.f = b(context);
        this.g = "-";
        this.j = "-";
    }

    public static String c() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    private synchronized void d(String str, String str2, String str3) {
        e.d(com.alipay.sdk.m.l.a.z, String.format("event %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.h)) {
            str4 = str4 + "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? "-" : c(str);
        objArr[1] = c(str2);
        objArr[2] = c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.h += sb.toString();
    }

    public static String e() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public void a(String str, String str2, Throwable th) {
        e(str, str2, a(th));
    }

    public void b(String str, String str2, String str3) {
        e(str, str2, str3);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return String.format("%s,%s", e(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(jl1.ARRAY_START_STR, "【").replace(jl1.ARRAY_END_STR, "】").replace(jl1.BRACKET_START_STR, "（").replace(jl1.BRACKET_END_STR, "）").replace(",", "，").replace("^", Constants.WAVE_SEPARATOR).replace(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "＃");
    }

    private synchronized void e(String str, String str2, String str3) {
        e.c(com.alipay.sdk.m.l.a.z, String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.i)) {
            str4 = str4 + "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? "-" : c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.i += sb.toString();
    }

    public void a(String str, String str2, Throwable th, String str3) {
        String a2 = a(th);
        e(str, str2, str3 + ": " + a2);
    }

    public static String b(String str) {
        String str2;
        String str3;
        if (str == null) {
            str = "";
        }
        String[] split = str.split("&");
        String str4 = null;
        if (split != null) {
            str3 = null;
            str2 = null;
            for (String str5 : split) {
                String[] split2 = str5.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase("partner")) {
                        str4 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(A0)) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(B0)) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(C0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(n.e(com.alipay.sdk.m.s.a.h(), split2[1]));
                            if (TextUtils.isEmpty(str3)) {
                                str3 = jSONObject.getString(A0);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (split2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(str4)) {
                        str4 = split2[1];
                    }
                }
            }
        } else {
            str3 = null;
            str2 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", c(str2), c(str3), c(str4));
    }

    public void a(String str, String str2, String str3) {
        d("", str, str2 + "|" + str3);
    }

    public void a(String str, String str2) {
        d("", str, str2);
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i2 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i2++;
                    if (i2 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public String a(String str) {
        String b2 = b(str);
        this.b = b2;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.a, b2, this.c, this.d, this.e, this.f, this.g, d(this.h), d(this.i), this.j);
    }

    public static String a(Context context) {
        String str;
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 64);
                    str2 = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", c(str), c(str2));
        }
        str = str2;
        return String.format("%s,%s,-,-,-", c(str), c(str2));
    }

    public static String a(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String str;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    String a2 = n.a((com.alipay.sdk.m.s.a) null, signature.toByteArray());
                    if (TextUtils.isEmpty(a2)) {
                        str = "?";
                        sb.append("-");
                        sb.append(str);
                    } else {
                        str = n.g(a2).substring(0, 8);
                        sb.append("-");
                        sb.append(str);
                    }
                } catch (Throwable unused) {
                }
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", c(c.c(context)), "android", c(Build.VERSION.getRELEASE()), c(Build.getMODEL()), "-", "0", c(c.d(context).b()), "gw", c(com.alipay.sdk.m.w.b.b(null, context)));
    }

    public static String a(long j2) {
        String c2 = c("15.8.11");
        String c3 = c("h.a.3.8.11");
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", c2, c3, Constants.WAVE_SEPARATOR + j2);
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", c(com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).d()), c(com.alipay.sdk.m.s.b.d().c()));
    }
}
