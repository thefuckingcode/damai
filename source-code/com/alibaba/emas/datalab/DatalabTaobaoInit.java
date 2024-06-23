package com.alibaba.emas.datalab;

import android.app.Application;
import android.util.Log;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class DatalabTaobaoInit implements Serializable {
    private static final String tag = "Datalab.init";

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (application == null) {
            Log.e(tag, "init error, application is null");
        } else if (hashMap == null) {
            Log.e(tag, "init error, params is null");
        } else {
            String str = null;
            if (hashMap.get("onlineAppKey") != null) {
                str = String.valueOf(hashMap.get("onlineAppKey"));
            }
            if (str == null) {
                Log.e(tag, "init error, params appkey is null");
                str = "12278902";
            }
            try {
                Log.e(tag, ">>>>>>> init start >>>>>>>>");
                a b = a.b();
                b.c(application, str + "@android");
                Log.e(tag, ">>>>>>> init success >>>>>>>>");
            } catch (Exception e) {
                Log.e(tag, "init error ", e);
            }
        }
    }
}
