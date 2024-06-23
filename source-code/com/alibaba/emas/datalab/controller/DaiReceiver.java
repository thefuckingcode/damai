package com.alibaba.emas.datalab.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.a;
import com.alibaba.fastjson.JSON;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.ArrayList;
import tb.p20;
import tb.t20;
import tb.yc2;

/* compiled from: Taobao */
public class DaiReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        a b = a.b();
        Boolean bool = Boolean.TRUE;
        b.d = bool;
        p20.c().d();
        try {
            String diskValue = DAIKVStoreage.getDiskValue("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update");
            if (diskValue != null && diskValue.equals("show")) {
                Log.d("Datalab.DaiReceiver", "put to dai mem " + diskValue);
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", diskValue);
            }
            yc2 b2 = yc2.b();
            DatalabBizType datalabBizType = DatalabBizType.zcache;
            t20 a = b2.a(context, datalabBizType, "algo.open");
            Log.d("Datalab.DaiReceiver", "algoNotify result is " + JSON.toJSONString(a));
            if (a == null || (str = a.d) == null) {
                Log.d("Datalab.DaiReceiver", "run first: dai trigger start ");
                DaiController.a().b(context, bool, new ArrayList());
                Log.d("Datalab.DaiReceiver", "run first: dai trigger end ");
                p20.c().b("dai", datalabBizType, "201", "true");
            } else if (str.equals("true")) {
                Log.d("Datalab.DaiReceiver", "run: dai trigger start ");
                DaiController.a().b(context, bool, new ArrayList());
                Log.d("Datalab.DaiReceiver", "run: dai trigger end ");
                p20.c().b("dai", datalabBizType, "200", "true");
            } else {
                p20.c().b("dai", datalabBizType, "200", "false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
