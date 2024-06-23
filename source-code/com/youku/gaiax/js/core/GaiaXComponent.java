package com.youku.gaiax.js.core;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.core.api.IComponent;
import com.youku.gaiax.js.support.GaiaXScriptBuilder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.if1;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B1\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0019\u0010\u001e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001d\u0010%\u001a\u00020 8B@\u0002X\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0013\u0010'\u001a\u00020 8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006+"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXComponent;", "Lcom/youku/gaiax/js/core/api/IComponent;", "Ltb/ur2;", "initComponent", "onReady", "onReuse", "onShow", "onHide", "onDestroy", "destroyComponent", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "onEvent", "onNativeEvent", "onLoadMore", "Lcom/youku/gaiax/js/core/GaiaXContext;", "jsContext", "Lcom/youku/gaiax/js/core/GaiaXContext;", "getJsContext", "()Lcom/youku/gaiax/js/core/GaiaXContext;", if1.DIMEN_BIZ, "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "templateId", "getTemplateId", "templateVersion", "getTemplateVersion", "script", "getScript", "", "_id$delegate", "Lkotlin/Lazy;", "get_id", "()J", "_id", "getId", "id", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXComponent implements IComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Lazy _id$delegate;
    @NotNull
    private final String bizId;
    @NotNull
    private final GaiaXContext jsContext;
    @NotNull
    private final String script;
    @NotNull
    private final String templateId;
    @NotNull
    private final String templateVersion;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXComponent$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXContext;", "jsContext", "", if1.DIMEN_BIZ, "templateId", "templateVersion", "script", "Lcom/youku/gaiax/js/core/GaiaXComponent;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GaiaXComponent create(@NotNull GaiaXContext gaiaXContext, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            k21.i(gaiaXContext, "jsContext");
            k21.i(str, if1.DIMEN_BIZ);
            k21.i(str2, "templateId");
            k21.i(str3, "templateVersion");
            k21.i(str4, "script");
            return new GaiaXComponent(gaiaXContext, str, str2, str3, str4, null);
        }
    }

    private GaiaXComponent(GaiaXContext gaiaXContext, String str, String str2, String str3, String str4) {
        this.jsContext = gaiaXContext;
        this.bizId = str;
        this.templateId = str2;
        this.templateVersion = str3;
        this.script = str4;
        this._id$delegate = b.b(GaiaXComponent$_id$2.INSTANCE);
    }

    public /* synthetic */ GaiaXComponent(GaiaXContext gaiaXContext, String str, String str2, String str3, String str4, m40 m40) {
        this(gaiaXContext, str, str2, str3, str4);
    }

    private final long get_id() {
        return ((Number) this._id$delegate.getValue()).longValue();
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void destroyComponent() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildDestroyComponentScript(getId()));
    }

    @NotNull
    public final String getBizId() {
        return this.bizId;
    }

    public final long getId() {
        return get_id();
    }

    @NotNull
    public final GaiaXContext getJsContext() {
        return this.jsContext;
    }

    @NotNull
    public final String getScript() {
        return this.script;
    }

    @NotNull
    public final String getTemplateId() {
        return this.templateId;
    }

    @NotNull
    public final String getTemplateVersion() {
        return this.templateVersion;
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void initComponent() {
        getJsContext().executeTask(new GaiaXComponent$initComponent$1$1(this, GaiaXScriptBuilder.INSTANCE.buildInitComponentScript(getId(), this.bizId, this.templateId, this.templateVersion, this.script)));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onDestroy() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentDestroyScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onEvent(@NotNull String str, @NotNull JSONObject jSONObject) {
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll(jSONObject);
        jSONObject2.put((Object) if1.DIMEN_BIZ, (Object) getBizId());
        jSONObject2.put((Object) "templateId", (Object) getTemplateId());
        jSONObject2.put((Object) "templateVersion", (Object) getTemplateVersion());
        jSONObject2.put((Object) "instanceId", (Object) Long.valueOf(getId()));
        jSONObject2.put((Object) "type", (Object) str);
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        String jSONString = jSONObject2.toJSONString();
        k21.h(jSONString, "targetData.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildPostMessage(jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onHide() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentHideScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onLoadMore(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        long id = getId();
        String jSONString = jSONObject.toJSONString();
        k21.h(jSONString, "data.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildComponentLoadMoreScript(id, jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onNativeEvent(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        String jSONString = jSONObject.toJSONString();
        k21.h(jSONString, "data.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildPostNativeMessage(jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onReady() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentReadyScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onReuse() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentReuseScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onShow() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentShowScript(getId()));
    }
}
