package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.aranger.constant.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import tb.lf2;
import tb.ur2;
import tb.xc2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class TMStoragePlugin$getSharedData$1 implements Runnable {
    final /* synthetic */ WVCallBackContext $callback;
    final /* synthetic */ String $params;

    TMStoragePlugin$getSharedData$1(String str, WVCallBackContext wVCallBackContext) {
        this.$params = str;
        this.$callback = wVCallBackContext;
    }

    public final void run() {
        JSONObject a;
        String str = this.$params;
        JSONArray jSONArray = (str == null || (a = lf2.a(str)) == null) ? null : a.getJSONArray(Constants.PARAM_KEYS);
        if (jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                String str2 = (String) (!(next instanceof String) ? null : next);
                if (str2 != null) {
                    jSONObject.put((String) next, (Object) xc2.a().d(str2));
                }
            }
            WVCallBackContext wVCallBackContext = this.$callback;
            if (wVCallBackContext != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                ur2 ur2 = ur2.INSTANCE;
                wVCallBackContext.success(jSONObject2.toJSONString());
            }
        }
    }
}
