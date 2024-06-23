package com.youku.gaiax.provider.module.js;

import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.b;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.uplayer.FileUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JP\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"com/youku/gaiax/provider/module/js/JSDelegate$startEngine$1", "Lcom/youku/gaiax/js/GaiaXJS$Listener;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/ur2;", "errorLog", "", "scene", b.l, "id", "type", "state", "", "value", "jsModuleName", "jsApiName", "jsApiType", "monitor", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class JSDelegate$startEngine$1 implements GaiaXJS.Listener {
    JSDelegate$startEngine$1() {
    }

    @Override // com.youku.gaiax.js.GaiaXJS.Listener
    public void errorLog(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
    }

    @Override // com.youku.gaiax.js.GaiaXJS.Listener
    public void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        k21.i(str, "scene");
        k21.i(str2, b.l);
        k21.i(str3, "id");
        k21.i(str4, "type");
        k21.i(str5, "state");
        k21.i(str6, "jsModuleName");
        k21.i(str7, "jsApiName");
        k21.i(str8, "jsApiType");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.monitor$default(monitor, str, str2, str3, str4, str5, j, null, null, null, FileUtils.S_IRWXU, null);
        }
    }
}
