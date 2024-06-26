package com.taobao.android.speed;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.tencent.open.SocialConstants;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
public class TBSpeed {
    public static final String TAO_SUB_EDITION_DEFAULT = "";
    public static final String TAO_SUB_EDITION_SPEED_DEFAULT = "speed_-1";
    public static final String TAO_SUB_EDITION_SPEED_GRAY = "speed_-2";
    public static final String TAO_SUB_EDITION_STANDARD_GRAY = "standard_-2";
    private static OConfigListener a = null;
    private static boolean b = true;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static Map<String, Boolean> h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String[] n;
    private static Context o;
    private static String p;
    private static Object q = new Object();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends TypeReference<Map<String, Boolean>> {
        a() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements OConfigListener {
        b() {
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            String str2;
            String str3;
            String str4;
            Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
            String str5 = "";
            if (configs == null) {
                str2 = str5;
            } else {
                str2 = configs.get("isSpeedEnable");
            }
            boolean booleanValue = TextUtils.isEmpty(str2) ? true : Boolean.valueOf(str2).booleanValue();
            if (TBSpeed.b != booleanValue) {
                TBSpeed.g("taobao_speed_switch_enable", booleanValue);
                boolean unused = TBSpeed.b = booleanValue;
                Log.e("TBSpeed", "orange update, set speedSwithEnable=" + booleanValue);
                TBSpeed.i(TBSpeed.l, TBSpeed.h, true);
            }
            if (configs == null) {
                str3 = str5;
            } else {
                str3 = configs.get("speedOpen");
            }
            boolean z = false;
            boolean booleanValue2 = TextUtils.isEmpty(str3) ? false : Boolean.valueOf(str3).booleanValue();
            if (TBSpeed.c != booleanValue2) {
                TBSpeed.g("taobao_speed_open", booleanValue2);
                Log.e("TBSpeed", "orange update, set speedOpen=" + booleanValue2);
            }
            if (configs == null) {
                str4 = str5;
            } else {
                str4 = configs.get("speedGray");
            }
            if (!TextUtils.isEmpty(str4)) {
                z = Boolean.valueOf(str4).booleanValue();
            }
            if (TBSpeed.d != z) {
                TBSpeed.g("taobao_speed_gray", z);
                Log.e("TBSpeed", "orange update, set speedGray=" + z);
            }
            if (configs != null) {
                str5 = configs.get("speedBlackList");
            }
            if (!TextUtils.equals(str5, TBSpeed.m)) {
                TBSpeed.h("taobao_speed_open_blacklist", str5);
                Log.e("TBSpeed", "orange update, set blackListSP=" + str5);
            }
        }
    }

    static {
        new LinkedList();
    }

    private static boolean a(String str, boolean z) {
        Context context = o;
        if (context == null) {
            return z;
        }
        try {
            return b(context).getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    private static SharedPreferences b(Context context) {
        return context.getSharedPreferences("taobao_speed", 0);
    }

    private static String c(String str, String str2) {
        Context context = o;
        if (context == null) {
            return str2;
        }
        try {
            return b(context).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void d() {
        if (!f) {
            synchronized (q) {
                if (!f) {
                    k = c("taobao_speed_desc", "");
                    boolean a2 = a("taobao_speed_switch_enable", true);
                    b = a2;
                    if (!a2) {
                        j = "";
                        f = true;
                        Log.e("TBSpeed", "init speedSwithEnable=false");
                        return;
                    }
                    boolean a3 = a("taobao_speed_proxy_enable", false);
                    e = a3;
                    if (a3) {
                        g = true;
                        j = TAO_SUB_EDITION_SPEED_DEFAULT;
                        f = true;
                        Log.e("TBSpeed", "init speedProxyEnable=true, set isClientSpeed=true");
                        return;
                    }
                    String c2 = c("taobao_speed_open_blacklist", "");
                    m = c2;
                    if (!TextUtils.isEmpty(c2)) {
                        n = m.split(",");
                    }
                    Log.e("TBSpeed", "init openBlackLlist, set openBlackLlist=" + m);
                    boolean a4 = a("taobao_speed_open", false);
                    c = a4;
                    if (a4) {
                        g = true;
                        f = true;
                        Log.e("TBSpeed", "init speedOpen=true, set isClientSpeed=true");
                        return;
                    }
                    boolean a5 = a("taobao_speed_gray", false);
                    d = a5;
                    if (a5) {
                        e();
                        f = true;
                        Log.e("TBSpeed", "init speedGray=true, set isClientSpeed=" + g);
                        return;
                    }
                    i = c("taobao_sub_edition_pass_params", "");
                    String c3 = c("taobao_sub_edition", "");
                    j = c3;
                    l = c3;
                    try {
                        String c4 = c("taobao_speed_biz_map", "");
                        Log.w("TBSpeed", "read bizMapJson=" + c4);
                        if (TextUtils.isEmpty(c4)) {
                            f = true;
                            return;
                        }
                        h = (Map) JSON.parseObject(c4, new a(), new Feature[0]);
                        f = true;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private static void e() {
        String c2 = c("taobao_speed_utdid", "");
        if (!TextUtils.isEmpty(c2)) {
            try {
                if (Math.abs(((long) c2.hashCode()) % 100) < 50) {
                    g = true;
                } else {
                    g = false;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void f() {
        String str;
        try {
            if (a == null) {
                a = new b();
                boolean z = true;
                OrangeConfig.getInstance().registerListener(new String[]{"taobao_speed"}, a, true);
                try {
                    Map<String, String> configs = OrangeConfig.getInstance().getConfigs("taobao_speed");
                    if (configs == null) {
                        str = "";
                    } else {
                        str = configs.get("isSpeedEnable");
                    }
                    if (!TextUtils.isEmpty(str)) {
                        z = Boolean.valueOf(str).booleanValue();
                    }
                    b = z;
                } catch (Throwable th) {
                    Log.e("TBSpeed", "get orange config failed", th);
                }
            }
        } catch (Throwable th2) {
            Log.e("TBSpeed", "register orange listener failed", th2);
        }
    }

    /* access modifiers changed from: private */
    public static void g(String str, boolean z) {
        Context context = o;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = b(context).edit();
                edit.putBoolean(str, z);
                edit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    public static String getCurrentSpeedStatus() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("speedOpen=");
        stringBuffer.append(c);
        stringBuffer.append(", speedGray=");
        stringBuffer.append(d);
        stringBuffer.append(", speedSwitch=");
        stringBuffer.append(b);
        stringBuffer.append(", speedProxy=");
        stringBuffer.append(e);
        stringBuffer.append(", blackList=");
        stringBuffer.append(m);
        stringBuffer.append(", bizIds=");
        Map<String, Boolean> map = h;
        if (map != null && !map.isEmpty()) {
            for (String str : h.keySet()) {
                Boolean bool = h.get(str);
                if (bool != null && bool.booleanValue()) {
                    stringBuffer.append(str);
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String getHomeBuckets() {
        return p;
    }

    public static String getSpeedDesc(Context context) {
        try {
            if (o == null && context != null) {
                o = context.getApplicationContext();
            }
            d();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(k)) {
            return null;
        }
        return k;
    }

    public static String getSpeedPassParams() {
        return i;
    }

    public static String getSubEdition() {
        return j;
    }

    /* access modifiers changed from: private */
    public static void h(String str, String str2) {
        Context context = o;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = b(context).edit();
                edit.putString(str, str2);
                edit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void i(String str, Map<String, Boolean> map, boolean z) {
        synchronized (TBSpeed.class) {
            if (!c) {
                if (!d) {
                    if (e) {
                        str = TAO_SUB_EDITION_SPEED_DEFAULT;
                    } else if (!b) {
                        str = "";
                        map.clear();
                    }
                    if (map == null) {
                        h("taobao_speed_biz_map", "");
                    } else if (!map.equals(h)) {
                        h("taobao_speed_biz_map", JSON.toJSONString(map));
                    }
                    if (!TextUtils.equals(str, l)) {
                        l = str;
                        Log.e("TBSpeed", "save subEdition " + str);
                        h("taobao_sub_edition", str);
                        if (z) {
                            j = str;
                            h = map;
                            if (TextUtils.equals(str, TAO_SUB_EDITION_SPEED_DEFAULT)) {
                                g = true;
                            } else {
                                g = false;
                            }
                            Log.e("TBSpeed", "updateSpeedStatus, set isClientSpeed " + g);
                            updateUTParams();
                        }
                    }
                }
            }
        }
    }

    @Deprecated
    public static boolean isSpeedEdition(Context context) {
        return false;
    }

    public static boolean isSpeedEdition(Context context, String str) {
        try {
            if (o == null && context != null) {
                o = context.getApplicationContext();
            }
            d();
        } catch (Throwable unused) {
        }
        if (g) {
            String[] strArr = n;
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return false;
                }
            }
            return true;
        }
        Map<String, Boolean> map = h;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        return h.get(str).booleanValue();
    }

    @Deprecated
    public static void registerSpeedSwitchListener(ISpeedSwitchListener iSpeedSwitchListener) {
    }

    public static void setSpeedEdition(Context context, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            h("taobao_speed_desc", map.get(SocialConstants.PARAM_APP_DESC));
            for (String str2 : map.keySet()) {
                if (Boolean.valueOf(map.get(str2)).booleanValue()) {
                    hashMap.put(str2, Boolean.TRUE);
                }
            }
        }
        try {
            if (o == null) {
                o = context.getApplicationContext();
            }
            d();
            f();
            i(str, hashMap, false);
        } catch (Throwable unused) {
        }
    }

    public static void setSpeedPassParams(String str) {
        if (!c && !d && !TextUtils.equals(i, str)) {
            i = str;
            h("taobao_sub_edition_pass_params", str);
        }
    }

    @Deprecated
    public static void unregisterSpeedSwitchListener(ISpeedSwitchListener iSpeedSwitchListener) {
    }

    public static void updateHomeBuckets(String str) {
        p = str;
    }

    public static void updateSpeedProxy(Context context, boolean z) {
        if (!c && !d) {
            try {
                if (e != z) {
                    e = z;
                    g("taobao_speed_proxy_enable", z);
                    Log.d("TBSpeed", "update proxy, set speedProxyEnable=" + e);
                    i(z ? TAO_SUB_EDITION_SPEED_DEFAULT : "", h, true);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateSpeedUtdid(String str) {
        if (o != null && TextUtils.isEmpty(c("taobao_speed_utdid", ""))) {
            h("taobao_speed_utdid", str);
        }
    }

    public static void updateUTParams() {
        String str;
        if (!c) {
            if (d) {
                str = g ? TAO_SUB_EDITION_SPEED_GRAY : TAO_SUB_EDITION_STANDARD_GRAY;
            } else {
                str = j;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    UTAnalytics.getInstance().getDefaultTracker().setGlobalProperty("x-v-s", str);
                } else {
                    UTAnalytics.getInstance().getDefaultTracker().removeGlobalProperty("x-v-s");
                }
            } catch (Throwable unused) {
            }
        }
    }
}
