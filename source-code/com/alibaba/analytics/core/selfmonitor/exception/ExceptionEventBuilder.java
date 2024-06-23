package com.alibaba.analytics.core.selfmonitor.exception;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import tb.cr2;
import tb.e03;
import tb.q52;
import tb.rq2;
import tb.t6;
import tb.zf2;

/* compiled from: Taobao */
public class ExceptionEventBuilder {

    /* compiled from: Taobao */
    public enum ExceptionType {
        UT,
        AP,
        COMMON
    }

    private static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String sb2 = sb.toString();
        return zf2.e(sb2) ? th.toString() : sb2;
    }

    private static String b(ExceptionType exceptionType) {
        if (ExceptionType.UT == exceptionType) {
            return "ut-exception";
        }
        return ExceptionType.COMMON == exceptionType ? "ut-common-exception" : "sdk-exception";
    }

    public static void c(ExceptionType exceptionType, Throwable th) {
        if (th != null) {
            try {
                rq2 rq2 = (rq2) a.a().poll(rq2.class, new Object[0]);
                EventType eventType = EventType.ALARM;
                rq2.b = eventType.getEventId();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", q52.b());
                ReuseJSONArray reuseJSONArray = (ReuseJSONArray) a.a().poll(ReuseJSONArray.class, new Object[0]);
                reuseJSONArray.add(d(exceptionType, th));
                hashMap.put("data", reuseJSONArray);
                rq2.f.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(hashMap));
                rq2.c = "APPMONITOR";
                rq2.d = b(exceptionType);
                cr2.a(rq2);
                a.a().offer(reuseJSONArray);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private static JSONObject d(ExceptionType exceptionType, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) a.a().poll(ReuseJSONObject.class, new Object[0]);
        Context j = Variables.n().j();
        if (j != null) {
            jSONObject.put("pname", (Object) t6.d(j));
        }
        jSONObject.put("page", (Object) "APPMONITOR");
        jSONObject.put("monitorPoint", (Object) b(exceptionType));
        jSONObject.put("arg", (Object) th.getClass().getSimpleName());
        jSONObject.put(e03.POINT_SUCCESS_COUNT_MEASURE, (Object) 0);
        jSONObject.put(e03.POINT_FAIL_COUNT_MEASURE, (Object) 1);
        ArrayList arrayList = new ArrayList();
        String a = a(th);
        if (a != null) {
            JSONObject jSONObject2 = (JSONObject) a.a().poll(ReuseJSONObject.class, new Object[0]);
            jSONObject2.put("errorCode", (Object) a);
            jSONObject2.put("errorCount", (Object) 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", (Object) arrayList);
        return jSONObject;
    }
}
