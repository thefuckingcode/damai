package com.alibaba.emas.datalab.controller;

import android.content.Context;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.tmall.android.dai.DAI;
import com.tmall.android.dai.DAICallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.p20;

/* compiled from: Taobao */
public class DaiController {
    String a = "zcache_preload_realtime_cold";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements DAICallback {
        a(DaiController daiController, Long l, Context context) {
        }
    }

    /* compiled from: Taobao */
    private static class b {
        private static DaiController a = new DaiController();
    }

    public static DaiController a() {
        return b.a;
    }

    public void b(final Context context, Boolean bool, List<String> list) {
        try {
            final HashMap hashMap = new HashMap();
            if (bool.booleanValue()) {
                hashMap.put(AdUtConstants.XAD_UT_ARG_IS_COLD_START, 1);
            } else {
                hashMap.put(AdUtConstants.XAD_UT_ARG_IS_COLD_START, 0);
            }
            StringBuilder sb = new StringBuilder();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i < list.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            hashMap.put("zcachePack", sb.toString());
            Log.d("Datalab.Dai", "isCold " + bool + " " + sb.toString());
            if (bool.booleanValue()) {
                Log.d("Datalab.Dai", "run realTime cold model");
                new Thread() {
                    /* class com.alibaba.emas.datalab.controller.DaiController.AnonymousClass1 */

                    public void run() {
                        DaiController.this.c(context, hashMap);
                    }
                }.start();
                return;
            }
            Log.d("Datalab.Dai", "run realTime model");
        } catch (Exception e) {
            Log.e("Datalab.Dai", "dai realTime trigger error ", e);
        }
    }

    public void c(Context context, Map<String, Object> map) {
        try {
            DAI.runCompute(this.a, map, new a(this, Long.valueOf(System.currentTimeMillis()), context));
        } catch (Exception e) {
            Log.e("Datalab.Dai", "dai trigger error ", e);
            p20.c().b("dai", DatalabBizType.zcache, "500", e.getMessage());
        }
    }
}
