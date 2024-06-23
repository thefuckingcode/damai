package com.youku.gaiax.js.impl.qjs;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXRuntime;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.js.core.api.IRuntime;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.JSRuntime;
import com.youku.gaiax.quickjs.QuickJS;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;
import tb.kw1;
import tb.lw1;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "Lcom/youku/gaiax/js/core/api/IRuntime;", "Ltb/ur2;", "checkRuntime", "initRuntime", "destroyRuntime", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "getRuntime", "()Lcom/youku/gaiax/js/core/GaiaXRuntime;", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "getEngine", "()Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "Lcom/youku/gaiax/quickjs/JSRuntime;", "jsRuntime", "Lcom/youku/gaiax/quickjs/JSRuntime;", "getJsRuntime", "()Lcom/youku/gaiax/quickjs/JSRuntime;", "setJsRuntime", "(Lcom/youku/gaiax/quickjs/JSRuntime;)V", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXRuntime;Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class QuickJSRuntime implements IRuntime {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final QuickJSEngine engine;
    @Nullable
    private JSRuntime jsRuntime;
    @NotNull
    private final GaiaXRuntime runtime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime", "Lcom/youku/gaiax/js/core/api/IEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final QuickJSRuntime create(@NotNull GaiaXRuntime gaiaXRuntime, @NotNull IEngine iEngine) {
            k21.i(gaiaXRuntime, "runtime");
            k21.i(iEngine, "engine");
            return new QuickJSRuntime(gaiaXRuntime, (QuickJSEngine) iEngine, null);
        }
    }

    private QuickJSRuntime(GaiaXRuntime gaiaXRuntime, QuickJSEngine quickJSEngine) {
        this.runtime = gaiaXRuntime;
        this.engine = quickJSEngine;
    }

    public /* synthetic */ QuickJSRuntime(GaiaXRuntime gaiaXRuntime, QuickJSEngine quickJSEngine, m40 m40) {
        this(gaiaXRuntime, quickJSEngine);
    }

    /* access modifiers changed from: private */
    /* renamed from: initRuntime$lambda-2  reason: not valid java name */
    public static final void m901initRuntime$lambda2(String str) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e(k21.r("setPromiseRejectionHandler() called with: message = ", str));
        }
        GaiaXJS.Listener listener$GaiaX_Android_JS = GaiaXJS.Companion.getInstance().getListener$GaiaX_Android_JS();
        if (listener$GaiaX_Android_JS != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put((Object) "message", (Object) str);
            jSONObject2.put((Object) "templateId", (Object) "");
            jSONObject2.put((Object) "templateVersion", (Object) "");
            jSONObject2.put((Object) if1.DIMEN_BIZ, (Object) "");
            jSONObject.put((Object) "data", (Object) jSONObject2);
            ur2 ur2 = ur2.INSTANCE;
            listener$GaiaX_Android_JS.errorLog(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initRuntime$lambda-3  reason: not valid java name */
    public static final boolean m902initRuntime$lambda3() {
        Log log = Log.INSTANCE;
        if (!log.isLog()) {
            return false;
        }
        log.e("setInterruptHandler() called with:");
        return false;
    }

    public final void checkRuntime() {
        if (this.jsRuntime == null) {
            throw new IllegalArgumentException("JSRuntime Instance Null");
        }
    }

    @Override // com.youku.gaiax.js.core.api.IRuntime
    public void destroyRuntime() {
        JSRuntime jSRuntime = this.jsRuntime;
        if (jSRuntime != null) {
            jSRuntime.close();
        }
        this.jsRuntime = null;
    }

    @NotNull
    public final QuickJSEngine getEngine() {
        return this.engine;
    }

    @Nullable
    public final JSRuntime getJsRuntime() {
        return this.jsRuntime;
    }

    @NotNull
    public final GaiaXRuntime getRuntime() {
        return this.runtime;
    }

    @Override // com.youku.gaiax.js.core.api.IRuntime
    public void initRuntime() {
        this.engine.checkQuickJS();
        QuickJS quickJS = this.engine.getQuickJS();
        JSRuntime createJSRuntime = quickJS == null ? null : quickJS.createJSRuntime();
        this.jsRuntime = createJSRuntime;
        if (createJSRuntime != null) {
            createJSRuntime.setRuntimeMaxStackSize(0);
        }
        JSRuntime jSRuntime = this.jsRuntime;
        if (jSRuntime != null) {
            jSRuntime.setPromiseRejectionHandler(lw1.a);
        }
        JSRuntime jSRuntime2 = this.jsRuntime;
        if (jSRuntime2 != null) {
            jSRuntime2.setInterruptHandler(kw1.a);
        }
    }

    public final void setJsRuntime(@Nullable JSRuntime jSRuntime) {
        this.jsRuntime = jSRuntime;
    }
}
