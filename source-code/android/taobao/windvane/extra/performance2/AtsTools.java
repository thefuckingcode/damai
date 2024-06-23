package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.config.GlobalConfig;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.aboat.ReceivePerformance;

/* compiled from: Taobao */
class AtsTools {
    private static boolean needSendPerformance = true;

    static {
        try {
            Class.forName("com.taobao.aboat.ReceivePerformance");
        } catch (Throwable unused) {
        }
    }

    AtsTools() {
    }

    static void sendAtsPerformanceLog(String str, Object obj) {
        try {
            if (!needSendPerformance || TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                ReceivePerformance.onReceiveWindmillPerformanceLog(GlobalConfig.context.getApplicationContext(), "windvane_performance_statistics", jSONObject.toJSONString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
