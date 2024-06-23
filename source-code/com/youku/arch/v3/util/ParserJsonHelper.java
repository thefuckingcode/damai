package com.youku.arch.v3.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ParserJsonHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean getSafeBooleanValue(JSONObject jSONObject, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971267242")) {
            return ((Boolean) ipChange.ipc$dispatch("971267242", new Object[]{jSONObject, str, Boolean.valueOf(z)})).booleanValue();
        }
        try {
            Object obj = jSONObject.get(str);
            if (obj == null) {
                return z;
            }
            return TypeUtils.castToBoolean(obj).booleanValue();
        } catch (Exception unused) {
            return z;
        }
    }

    public static float getSafeFloatValue(JSONObject jSONObject, String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616171958")) {
            return ((Float) ipChange.ipc$dispatch("616171958", new Object[]{jSONObject, str, Float.valueOf(f)})).floatValue();
        }
        try {
            Object obj = jSONObject.get(str);
            if (obj == null) {
                return f;
            }
            return TypeUtils.castToFloat(obj).floatValue();
        } catch (Exception unused) {
            return f;
        }
    }

    public static int getSafeIntValue(JSONObject jSONObject, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233331185")) {
            return ((Integer) ipChange.ipc$dispatch("-1233331185", new Object[]{jSONObject, str, Integer.valueOf(i)})).intValue();
        }
        try {
            Object obj = jSONObject.get(str);
            if (obj == null) {
                return i;
            }
            return TypeUtils.castToInt(obj).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public static JSONArray getSafeJSONArray(JSONObject jSONObject, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092544520")) {
            return (JSONArray) ipChange.ipc$dispatch("1092544520", new Object[]{jSONObject, str});
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject getSafeJSONObject(JSONObject jSONObject, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452161164")) {
            return (JSONObject) ipChange.ipc$dispatch("1452161164", new Object[]{jSONObject, str});
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static long getSafeLongValue(JSONObject jSONObject, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551177630")) {
            return ((Long) ipChange.ipc$dispatch("1551177630", new Object[]{jSONObject, str, Long.valueOf(j)})).longValue();
        }
        try {
            Object obj = jSONObject.get(str);
            if (obj == null) {
                return j;
            }
            return TypeUtils.castToLong(obj).longValue();
        } catch (Exception unused) {
            return j;
        }
    }

    public static String getSafeString(JSONObject jSONObject, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725477504")) {
            return (String) ipChange.ipc$dispatch("725477504", new Object[]{jSONObject, str, str2});
        }
        try {
            Object obj = jSONObject.get(str);
            if (obj == null) {
                return str2;
            }
            return obj.toString();
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String[] jsonArray2StringArray(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009713960")) {
            return (String[]) ipChange.ipc$dispatch("1009713960", new Object[]{jSONArray});
        } else if (jSONArray == null || jSONArray.size() <= 0) {
            return null;
        } else {
            int size = jSONArray.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            return strArr;
        }
    }

    public static List<String> jsonArray2StringList(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466535331")) {
            return (List) ipChange.ipc$dispatch("-466535331", new Object[]{jSONArray});
        } else if (jSONArray == null || jSONArray.size() <= 0) {
            return null;
        } else {
            int size = jSONArray.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        }
    }
}
