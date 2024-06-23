package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ae;
import com.xiaomi.push.ba;
import com.xiaomi.push.bh;
import com.xiaomi.push.bj;
import com.xiaomi.push.bp;
import com.xiaomi.push.fx;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.q;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.o70;

/* compiled from: Taobao */
public class u {
    private static t a;

    /* renamed from: a  reason: collision with other field name */
    private static a f997a;

    /* compiled from: Taobao */
    public interface a {
        void a();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized t m870a(Context context) {
        synchronized (u.class) {
            t tVar = a;
            if (tVar != null) {
                return tVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString(PushConstants.DEVICE_ID, null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && j.a(string7)) {
                string7 = j.i(context);
                sharedPreferences.edit().putString(PushConstants.DEVICE_ID, string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String i2 = j.i(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(i2) && !TextUtils.isEmpty(string7) && !string7.equals(i2)) {
                b.m182a("read_phone_state permission changes.");
            }
            t tVar2 = new t(string, string2, string3, string4, string5, string6, i);
            a = tVar2;
            return tVar2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0245 A[SYNTHETIC, Splitter:B:77:0x0245] */
    public static synchronized t a(Context context, String str, String str2, String str3) {
        String str4;
        String a2;
        PackageInfo packageInfo;
        int a3;
        boolean z;
        bh bhVar;
        boolean z2;
        String a4;
        JSONException e;
        String str5;
        Object th;
        synchronized (u.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", j.a(context, false));
            t tVar = a;
            if (tVar != null && !TextUtils.isEmpty(tVar.f996a)) {
                treeMap.put("uuid", a.f996a);
                int lastIndexOf = a.f996a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.f996a.substring(lastIndexOf + 1);
                    ba.a(context).a(treeMap);
                    a2 = j.a(context);
                    if (!TextUtils.isEmpty(a2)) {
                        treeMap.put("gaid", a2);
                    }
                    String str6 = !m873a(context) ? "1000271" : str2;
                    String str7 = !m873a(context) ? "420100086271" : str3;
                    String str8 = !m873a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str6);
                    treeMap.put("apptoken", str7);
                    packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(40091));
                    treeMap.put("packagename", str8);
                    treeMap.put("model", Build.getMODEL());
                    treeMap.put("board", android.os.Build.BOARD);
                    if (!m.m740d()) {
                        String str9 = "";
                        String d = j.d(context);
                        if (!TextUtils.isEmpty(d)) {
                            str9 = str9 + bp.a(d);
                        }
                        String f = j.f(context);
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(f)) {
                            str9 = str9 + "," + f;
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str9);
                        }
                    }
                    treeMap.put("os", Build.VERSION.getRELEASE() + "-" + Build.VERSION.INCREMENTAL);
                    a3 = j.a();
                    if (a3 >= 0) {
                        treeMap.put("space_id", Integer.toString(a3));
                    }
                    treeMap.put("brand", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND() + "");
                    treeMap.put("ram", j.m686a());
                    treeMap.put("rom", j.m689b());
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e2) {
                            b.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e2);
                        }
                    }
                    String a5 = bs.a(jSONObject.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("requestData", a5);
                    treeMap2.put("keyPairVer", "1");
                    if (a(context) < 2 || TextUtils.isEmpty(a5)) {
                        z = false;
                    } else {
                        b.m182a("r.data = " + a5);
                        z = true;
                    }
                    String a6 = a(context, z);
                    if (z) {
                        treeMap = treeMap2;
                    }
                    bhVar = bj.a(context, a6, treeMap);
                    if (bhVar != null && bhVar.a == 200) {
                        a4 = bhVar.a();
                        if (!TextUtils.isEmpty(a4)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(a4);
                                if (jSONObject2.getInt("code") == 0) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                    String string = jSONObject3.getString("ssecurity");
                                    String string2 = jSONObject3.getString("token");
                                    String string3 = jSONObject3.getString("userId");
                                    if (TextUtils.isEmpty(str4)) {
                                        str4 = com.alipay.sdk.m.s.a.u + bp.a(6);
                                    }
                                    z2 = z;
                                    try {
                                        t tVar2 = new t(string3 + "@xiaomi.com/" + str4, string2, string, str6, str7, str8, ae.a());
                                        a(context, tVar2);
                                        a = tVar2;
                                        a(context, 0);
                                        b.m182a("device registration is successful. " + string3);
                                        return tVar2;
                                    } catch (JSONException e3) {
                                        e = e3;
                                        str5 = "failed to parse respone json data. " + e;
                                        b.d(str5);
                                        a(context, a(context) + 1);
                                        b.m182a("fail to register push account. meet error.");
                                        return null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str5 = "unknow throwable. " + th;
                                        b.d(str5);
                                        a(context, a(context) + 1);
                                        b.m182a("fail to register push account. meet error.");
                                        return null;
                                    }
                                } else {
                                    z2 = z;
                                    x.a(context, jSONObject2.getInt("code"), jSONObject2.optString(SocialConstants.PARAM_COMMENT));
                                    b.m182a("device registration resp: " + a4);
                                    if (z2 && bj.c(context)) {
                                        a(context, a(context) + 1);
                                    }
                                    b.m182a("fail to register push account. meet error.");
                                    return null;
                                }
                            } catch (JSONException e4) {
                                e = e4;
                                z2 = z;
                                str5 = "failed to parse respone json data. " + e;
                                b.d(str5);
                                a(context, a(context) + 1);
                                b.m182a("fail to register push account. meet error.");
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z;
                                str5 = "unknow throwable. " + th;
                                b.d(str5);
                                a(context, a(context) + 1);
                                b.m182a("fail to register push account. meet error.");
                                return null;
                            }
                        }
                    }
                    z2 = z;
                    a(context, a(context) + 1);
                    b.m182a("fail to register push account. meet error.");
                    return null;
                }
            }
            str4 = null;
            ba.a(context).a(treeMap);
            a2 = j.a(context);
            if (!TextUtils.isEmpty(a2)) {
            }
            if (!m873a(context)) {
            }
            if (!m873a(context)) {
            }
            if (!m873a(context)) {
            }
            treeMap.put("appid", str6);
            treeMap.put("apptoken", str7);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
            } catch (Exception e5) {
                b.a(e5);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(40091));
            treeMap.put("packagename", str8);
            treeMap.put("model", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
            treeMap.put("board", android.os.Build.BOARD);
            if (!m.m740d()) {
            }
            treeMap.put("os", Build.VERSION.getRELEASE() + "-" + Build.VERSION.INCREMENTAL);
            a3 = j.a();
            if (a3 >= 0) {
            }
            treeMap.put("brand", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND() + "");
            treeMap.put("ram", j.m686a());
            treeMap.put("rom", j.m689b());
            JSONObject jSONObject4 = new JSONObject();
            while (r9.hasNext()) {
            }
            String a52 = bs.a(jSONObject4.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", a52);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2) {
            }
            z = false;
            String a62 = a(context, z);
            if (z) {
            }
            try {
                bhVar = bj.a(context, a62, treeMap);
            } catch (IOException e6) {
                b.d("device registration request failed. " + e6);
                bhVar = null;
            }
            a4 = bhVar.a();
            if (!TextUtils.isEmpty(a4)) {
            }
            z2 = z;
            a(context, a(context) + 1);
            b.m182a("fail to register push account. meet error.");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m871a(Context context) {
        t a2 = m870a(context);
        if (a2 != null && !TextUtils.isEmpty(a2.f996a)) {
            String[] split = a2.f996a.split(o70.DINAMIC_PREFIX_AT);
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    private static String a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        String a2 = a.a(context).a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (ae.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fx.b);
            str = ":9085";
        } else if (q.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (q.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (q.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (q.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (q.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = ae.m250a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void a() {
        a aVar = f997a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m872a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, t tVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", tVar.f996a);
        edit.putString("security", tVar.c);
        edit.putString("token", tVar.b);
        edit.putString("app_id", tVar.d);
        edit.putString("package_name", tVar.f);
        edit.putString("app_token", tVar.e);
        edit.putString(PushConstants.DEVICE_ID, j.i(context));
        edit.putInt("env_type", tVar.a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f997a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m873a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
