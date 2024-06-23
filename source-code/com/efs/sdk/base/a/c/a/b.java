package com.efs.sdk.base.a.c.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.d.a;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.c13;
import tb.d63;
import tb.jl1;
import tb.r03;
import tb.t43;

/* compiled from: Taobao */
public final class b {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);

    private static int a(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        if (str2 == null) {
            str2 = "0";
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    private static int b(String str, String str2, String str3) {
        if ("ver".equals(str)) {
            return a(str2, str3);
        }
        if (Constants.Value.DATETIME.equals(str)) {
            return e(str2, str3);
        }
        return -100;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x017a, code lost:
        if (r9.compareTo(r8) != 0) goto L_0x017c;
     */
    private static void c(Map<String, String> map, JSONArray jSONArray, JSONArray jSONArray2) {
        String str;
        int i = 0;
        boolean z = true;
        while (true) {
            try {
                if (i < jSONArray.length()) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject == null || jSONObject.length() >= 2) {
                        String optString = jSONObject.optString("fld");
                        String optString2 = jSONObject.optString("val");
                        String optString3 = jSONObject.optString("opc");
                        if (!(optString == null || optString2 == null)) {
                            if (optString3 != null) {
                                c13 a2 = a.a();
                                Context context = a2.c;
                                Map<String, String> b = a2.b();
                                if ("ver".equals(optString)) {
                                    str = d63.a(context);
                                } else if (Constants.Value.DATETIME.equals(optString)) {
                                    SimpleDateFormat simpleDateFormat = a;
                                    r03.c();
                                    str = simpleDateFormat.format(new Date(r03.e()));
                                } else {
                                    str = "pkg".equals(optString) ? context.getPackageName() : (b.isEmpty() || !b.containsKey(optString)) ? null : b.get(optString);
                                }
                                if (str != null) {
                                    char c = 65535;
                                    switch (optString3.hashCode()) {
                                        case -1555538761:
                                            if (optString3.equals("startsWith")) {
                                                c = '\b';
                                                break;
                                            }
                                            break;
                                        case -1295482945:
                                            if (optString3.equals("equals")) {
                                                c = 11;
                                                break;
                                            }
                                            break;
                                        case -567445985:
                                            if (optString3.equals("contains")) {
                                                c = '\n';
                                                break;
                                            }
                                            break;
                                        case 33:
                                            if (optString3.equals(jl1.AND_NOT)) {
                                                c = 5;
                                                break;
                                            }
                                            break;
                                        case 60:
                                            if (optString3.equals(jl1.L)) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case 62:
                                            if (optString3.equals(jl1.G)) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case 1084:
                                            if (optString3.equals(jl1.NOT_EQUAL2)) {
                                                c = 6;
                                                break;
                                            }
                                            break;
                                        case 1921:
                                            if (optString3.equals(jl1.LE)) {
                                                c = 4;
                                                break;
                                            }
                                            break;
                                        case 1922:
                                            if (optString3.equals("<>")) {
                                                c = 7;
                                                break;
                                            }
                                            break;
                                        case 1952:
                                            if (optString3.equals(jl1.EQUAL2)) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 1983:
                                            if (optString3.equals(jl1.GE)) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        case 257797441:
                                            if (optString3.equals("equalsIgnoreCase")) {
                                                c = '\f';
                                                break;
                                            }
                                            break;
                                        case 840862003:
                                            if (optString3.equals("matches")) {
                                                c = 14;
                                                break;
                                            }
                                            break;
                                        case 1743158238:
                                            if (optString3.equals("endsWith")) {
                                                c = '\t';
                                                break;
                                            }
                                            break;
                                        case 2058039875:
                                            if (optString3.equals("isEmpty")) {
                                                c = CharUtils.CR;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            int b2 = b(optString, str, optString2);
                                            if (b2 == -100) {
                                                if (str.compareTo(optString2) == 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            } else {
                                                if (b2 == 0) {
                                                    z = true;
                                                }
                                                z = false;
                                            }
                                        case 1:
                                            int b3 = b(optString, str, optString2);
                                            if (b3 == -100) {
                                                if (str.compareTo(optString2) > 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            } else {
                                                if (b3 > 0) {
                                                    z = true;
                                                }
                                                z = false;
                                            }
                                        case 2:
                                            int b4 = b(optString, str, optString2);
                                            if (b4 == -100) {
                                                if (str.compareTo(optString2) < 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            } else {
                                                if (b4 < 0) {
                                                    z = true;
                                                }
                                                z = false;
                                            }
                                        case 3:
                                            int b5 = b(optString, str, optString2);
                                            if (b5 == -100) {
                                                if (str.compareTo(optString2) >= 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            } else {
                                                if (b5 >= 0) {
                                                    z = true;
                                                }
                                                z = false;
                                            }
                                        case 4:
                                            int b6 = b(optString, str, optString2);
                                            if (b6 == -100) {
                                                if (str.compareTo(optString2) <= 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            } else {
                                                if (b6 <= 0) {
                                                    z = true;
                                                }
                                                z = false;
                                            }
                                        case 5:
                                        case 6:
                                        case 7:
                                            int b7 = b(optString, str, optString2);
                                            if (b7 == -100) {
                                                break;
                                            } else {
                                                if (b7 != 0) {
                                                    z = true;
                                                    break;
                                                }
                                                z = false;
                                                break;
                                            }
                                        case '\b':
                                            z = str.startsWith(optString2);
                                            break;
                                        case '\t':
                                            z = str.endsWith(optString2);
                                            break;
                                        case '\n':
                                            z = str.contains(optString2);
                                            break;
                                        case 11:
                                            z = str.equals(optString2);
                                            break;
                                        case '\f':
                                            z = str.equalsIgnoreCase(optString2);
                                            break;
                                        case '\r':
                                            z = str.isEmpty();
                                            break;
                                        case 14:
                                            z = str.matches(optString2);
                                            break;
                                    }
                                    if (z) {
                                    }
                                } else if (!"isNull".equals(optString3)) {
                                }
                                i++;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                t43.c("efs.config", "updateConfigCond error", th);
                return;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i2);
                if (jSONObject2 != null && jSONObject2.length() >= 2) {
                    String optString4 = jSONObject2.optString("opt");
                    Object opt = jSONObject2.opt("set");
                    if (!(optString4 == null || opt == null)) {
                        String optString5 = jSONObject2.optString("lt", null);
                        String optString6 = jSONObject2.optString("net", null);
                        if (optString5 != null) {
                            optString4 = optString4 + JSMethod.NOT_SET + optString5;
                        }
                        if (optString6 != null) {
                            optString4 = optString4 + JSMethod.NOT_SET + optString6;
                        }
                        map.put(optString4, String.valueOf(opt));
                    }
                }
            }
        }
    }

    public static boolean d(@NonNull String str, @NonNull a aVar) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.youku.arch.v3.core.Constants.CONFIG);
            int i = jSONObject.getInt("cver");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject2.optString(next, ""));
                    }
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("app_configs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("conditions");
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("actions");
                            if (!(optJSONArray2 == null || optJSONArray3 == null || optJSONArray3.length() <= 0)) {
                                c(hashMap, optJSONArray2, optJSONArray3);
                            }
                        }
                    }
                }
            }
            aVar.b(hashMap);
            aVar.a = i;
            return true;
        } catch (Throwable th) {
            t43.c("efs.config", "parseConfig error, data is ".concat(String.valueOf(str)), th);
            return false;
        }
    }

    private static int e(String str, String str2) {
        if (str == null) {
            str = "1970/01/01 00:00:00";
        }
        if (str2 == null) {
            str2 = "1970/01/01 00:00:00";
        }
        String[] split = str.split("[:/\\s]");
        String[] split2 = str2.split("[:/\\s]");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
