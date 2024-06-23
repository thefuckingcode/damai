package com.alibaba.emas.datalab.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.DatalabListener;
import com.alibaba.emas.datalab.a;
import com.alibaba.emas.datalab.stage.Stage;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.HashMap;
import tb.p20;
import tb.u20;

/* compiled from: Taobao */
public class DaiUpdateReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(String str) {
        Log.w("Datalab.Update", str);
        p20.c().b("update", DatalabBizType.update, "200", str);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            Log.w("Datalab.Update", "onReceive, action=" + intent.getAction());
            b("dai notify to datalab");
            final DatalabListener datalabListener = a.b().a.get(DatalabBizType.update);
            if (datalabListener == null) {
                b("listener is null");
                return;
            }
            HashMap hashMap = (HashMap) intent.getSerializableExtra("com.tmall.android.dai.intent.extra.OUTPUT_DATA");
            if (hashMap == null) {
                b("alinn ouput data is null");
                return;
            }
            Object obj = hashMap.get("showAndroidUpdateAlert");
            Log.w("Datalab.Update", "ob value is " + obj);
            if (obj == null) {
                b("alinn ouput data is null, not key value");
                return;
            }
            final String valueOf = String.valueOf(obj);
            new Thread() {
                /* class com.alibaba.emas.datalab.controller.DaiUpdateReceiver.AnonymousClass1 */

                public void run() {
                    Boolean bool = Boolean.FALSE;
                    if (valueOf.equals("true")) {
                        bool = Boolean.TRUE;
                        DaiUpdateReceiver.this.b("notify to update, open=true, result=true");
                    } else {
                        DaiUpdateReceiver.this.b("notify to update, result=false");
                    }
                    u20 u20 = new u20();
                    u20.b = DatalabBizType.update;
                    Stage stage = Stage.NOTIFY;
                    u20.a = "datalab";
                    bool.booleanValue();
                    DAIKVStoreage.putToDisk("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "clean");
                    DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "clean");
                    datalabListener.execute(stage, u20);
                }
            }.start();
        } catch (Exception e) {
            b("dai receive error" + e.getMessage());
            Log.e("Datalab.Update", "on receive update model", e);
        }
    }
}
