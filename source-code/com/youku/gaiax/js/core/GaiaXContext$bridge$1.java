package com.youku.gaiax.js.core;

import com.alibaba.fastjson.JSONArray;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.api.ICallBridgeListener;
import com.youku.gaiax.js.utils.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"com/youku/gaiax/js/core/GaiaXContext$bridge$1", "Lcom/youku/gaiax/js/core/api/ICallBridgeListener;", "", "contextId", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "", "callSync", "Ltb/ur2;", "callAsync", "callPromise", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContext$bridge$1 implements ICallBridgeListener {
    GaiaXContext$bridge$1() {
    }

    @Override // com.youku.gaiax.js.core.api.ICallBridgeListener
    public void callAsync(long j, long j2, long j3, @NotNull JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("callAsync() called with: contextId = " + j + ", moduleId = " + j2 + ", methodId = " + j3 + ", args = " + jSONArray);
        }
        GaiaXJS.Companion.getInstance().invokeAsyncMethod$GaiaX_Android_JS(j2, j3, jSONArray);
    }

    @Override // com.youku.gaiax.js.core.api.ICallBridgeListener
    public void callPromise(long j, long j2, long j3, @NotNull JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("callPromise() called with: contextId = " + j + ", moduleId = " + j2 + ", methodId = " + j3 + ", args = " + jSONArray);
        }
        GaiaXJS.Companion.getInstance().invokePromiseMethod$GaiaX_Android_JS(j2, j3, jSONArray);
    }

    @Override // com.youku.gaiax.js.core.api.ICallBridgeListener
    @Nullable
    public Object callSync(long j, long j2, long j3, @NotNull JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("callSync() called with: contextId = " + j + ", moduleId = " + j2 + ", methodId = " + j3 + ", args = " + jSONArray);
        }
        return GaiaXJS.Companion.getInstance().invokeSyncMethod$GaiaX_Android_JS(j2, j3, jSONArray);
    }
}
