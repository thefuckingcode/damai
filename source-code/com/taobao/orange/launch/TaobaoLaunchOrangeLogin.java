package com.taobao.orange.launch;

import android.app.Application;
import com.taobao.orange.OrangeConfig;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class TaobaoLaunchOrangeLogin implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        String str;
        try {
            str = (String) hashMap.get("userId");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        OrangeConfig.getInstance().setUserId(str);
    }
}
