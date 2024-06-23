package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import tb.lf2;
import tb.xc2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class TMStoragePlugin$setSharedData$1 implements Runnable {
    final /* synthetic */ WVCallBackContext $callback;
    final /* synthetic */ String $params;

    TMStoragePlugin$setSharedData$1(String str, WVCallBackContext wVCallBackContext) {
        this.$params = str;
        this.$callback = wVCallBackContext;
    }

    public final void run() {
        JSONObject a;
        String str = this.$params;
        JSONObject jSONObject = (str == null || (a = lf2.a(str)) == null) ? null : a.getJSONObject("data");
        if (jSONObject != null) {
            for (Map.Entry entry : jSONObject.entrySet()) {
                if (entry.getKey() != null && (entry.getValue() instanceof String)) {
                    Object value = entry.getValue();
                    Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.String");
                    xc2.a().e((String) entry.getKey(), (String) value);
                }
            }
        }
        WVCallBackContext wVCallBackContext = this.$callback;
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
    }
}
