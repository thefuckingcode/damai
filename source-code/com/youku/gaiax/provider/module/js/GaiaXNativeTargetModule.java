package com.youku.gaiax.provider.module.js;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import com.youku.gaiax.js.utils.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\b\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXNativeTargetModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/alibaba/fastjson/JSONObject;", "data", "getElementByData", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXNativeTargetModule extends GaiaXBaseModule {
    @GaiaXSyncMethod
    @NotNull
    public final JSONObject getElementByData(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("getElementByData() called with: data = ", jSONObject));
        }
        String string = jSONObject.getString("targetId");
        jSONObject.getString("templateId");
        long longValue = jSONObject.getLongValue("instanceId");
        JSDelegate instance = JSDelegate.Companion.getInstance();
        k21.h(string, "targetId");
        JSONObject nodeInfo = instance.getNodeInfo(string, longValue);
        nodeInfo.put((Object) "targetId", (Object) string);
        if (log.isLog()) {
            log.d(k21.r("getElementByData() called with: result = ", nodeInfo));
        }
        return nodeInfo;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "NativeTarget";
    }
}
