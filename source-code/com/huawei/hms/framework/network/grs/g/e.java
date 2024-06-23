package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class e {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ JSONArray c;

        a(long j, ArrayList arrayList, JSONArray jSONArray) {
            this.a = j;
            this.b = arrayList;
            this.c = jSONArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
        public void run() {
            boolean z;
            d dVar;
            com.huawei.hms.framework.network.grs.g.k.a aVar = new com.huawei.hms.framework.network.grs.g.k.a();
            aVar.put("total_time", this.a);
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar.o() || dVar.m()) {
                        aVar.put(e.b(dVar));
                        it.remove();
                        z = true;
                    }
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                }
            }
            aVar.put(e.b(dVar));
            it.remove();
            z = true;
            if (!z && this.b.size() > 0) {
                ArrayList arrayList = this.b;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.b(dVar2));
                this.b.remove(dVar2);
            }
            if (this.b.size() > 0) {
                Iterator it2 = this.b.iterator();
                while (it2.hasNext()) {
                    this.c.put(new JSONObject(e.b((d) it2.next())));
                }
            }
            if (this.c.length() > 0) {
                aVar.put("failed_info", this.c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void a(ArrayList<d> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d = dVar.d();
        if (d != null) {
            linkedHashMapPack.put("error_code", (long) ExceptionCode.getErrorCodeFromException(d));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", (long) dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, (long) dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
