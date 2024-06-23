package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.ut.mini.UTAnalytics;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ht2 extends va {
    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        int i;
        JSONObject fields = e().getFields();
        if (fields != null) {
            try {
                i = fields.getInteger("eventId").intValue();
            } catch (Exception unused) {
                i = -1;
            }
            if (i >= 0) {
                String string = fields.getString("page");
                String string2 = fields.getString("arg1");
                String string3 = fields.getString("arg2");
                String string4 = fields.getString(UTDataCollectorNodeColumn.ARG3);
                String str = "";
                String str2 = TextUtils.isEmpty(string3) ? str : string3;
                if (!TextUtils.isEmpty(string4)) {
                    str = string4;
                }
                JSONObject jSONObject = fields.getJSONObject("args");
                HashMap hashMap = new HashMap();
                if (jSONObject != null) {
                    for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && (value instanceof String)) {
                            hashMap.put(key, String.valueOf(bg0.a(this.e.getData(), value)));
                        }
                    }
                }
                UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(string, i, string2, str2, str, hashMap).build());
            }
        }
    }
}
