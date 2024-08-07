package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.js2;

/* compiled from: Taobao */
public final class hp {

    /* compiled from: Taobao */
    static class a {
        public static hp a = new hp();
    }

    private static gm a(String str, List<gm> list) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (list != null && i < list.size()) {
            gm gmVar = list.get(i);
            if (gmVar != null) {
                String[] g = gmVar.g();
                for (int i2 = 0; i2 < g.length; i2++) {
                    if (!TextUtils.isEmpty(g[i]) && str.contains(g[i2])) {
                        return gmVar;
                    }
                }
                continue;
            }
            i++;
        }
        return null;
    }

    private JSONArray a(String str) {
        if (str == null) {
            str = "";
        }
        String[] strArr = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", js2.MAIN};
        JSONArray jSONArray = new JSONArray();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && !str.equals(thread.getName())) {
                for (int i = 0; i < 6; i++) {
                    String str2 = strArr[i];
                    String name = thread.getName();
                    if ((!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(name) && (str2.contains(name) || name.contains(str2))) && a(thread) != null) {
                        jSONArray.put(a(thread));
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final boolean a(Context context, String str, String str2, List<gm> list, boolean z, gm gmVar) {
        Thread next;
        String str3 = "";
        if (str2 != null) {
            Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str3 = null;
                    break;
                }
                next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getName())) {
                    if (str2.contains(next.getName()) || next.getName().contains(str2)) {
                        StackTraceElement[] stackTrace = next.getStackTrace();
                    }
                }
            }
            StackTraceElement[] stackTrace2 = next.getStackTrace();
            if (stackTrace2 != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (StackTraceElement stackTraceElement : stackTrace2) {
                    stringBuffer.append("at ");
                    stringBuffer.append(stackTraceElement);
                    stringBuffer.append("<br />");
                }
                str3 = stringBuffer.toString();
            }
        }
        gm a2 = a(str3, list);
        if (z && a2 == null) {
            return false;
        }
        String str4 = str + "<br />" + str3;
        JSONArray a3 = a(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", a3);
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        if (z || a2 != null) {
            hd.a(context, a2, jSONObject2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
            return true;
        }
        hd.b(context, gmVar, jSONObject2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
        return true;
    }
}
