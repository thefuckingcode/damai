package com.youku.gaiax.provider.module.js;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXOneArchModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/alibaba/fastjson/JSONObject;", "params", "Ltb/ur2;", "refresh", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXOneArchModule extends GaiaXBaseModule {
    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "OneArch";
    }

    @GaiaXSyncMethod
    public final void refresh(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "params");
        String string = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        String string2 = jSONObject.getString("type");
        Boolean bool = jSONObject.getBoolean("resetOffset");
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = jSONObject.getBoolean("noRequest");
        boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
        if (string2 == null) {
            return;
        }
        if (string2.equals("card")) {
            JSDelegate instance = JSDelegate.Companion.getInstance();
            k21.h(l, "componentId");
            long longValue = l.longValue();
            k21.h(string, "templateId");
            instance.refreshCard(longValue, string, booleanValue2);
        } else if (string2.equals("page")) {
            JSDelegate instance2 = JSDelegate.Companion.getInstance();
            k21.h(l, "componentId");
            long longValue2 = l.longValue();
            k21.h(string, "templateId");
            instance2.refreshPage(longValue2, string, booleanValue, booleanValue2);
        } else if (string2.equals("component")) {
            JSDelegate instance3 = JSDelegate.Companion.getInstance();
            k21.h(l, "componentId");
            long longValue3 = l.longValue();
            k21.h(string, "templateId");
            instance3.refreshComponent(longValue3, string);
        }
    }
}
