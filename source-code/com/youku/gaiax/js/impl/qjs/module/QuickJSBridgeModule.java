package com.youku.gaiax.js.impl.qjs.module;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.api.ICallBridgeListener;
import com.youku.gaiax.js.support.JSDataConvert;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.BridgeModuleListener;
import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSObject;
import com.youku.gaiax.quickjs.JSValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.jw1;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSBridgeModule;", "Lcom/youku/gaiax/quickjs/BridgeModuleListener;", "", "result", "", "Lcom/youku/gaiax/quickjs/JSValue;", "arrayOfJSValues", "(Ljava/lang/Object;)[Lcom/youku/gaiax/quickjs/JSValue;", "", "contextPointer", "", "argsMap", "callSync", "funPointer", "callAsync", "callPromise", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Ltb/ur2;", "wrapAsJSValueException", "Lcom/youku/gaiax/js/core/GaiaXContext;", "hostContext", "Lcom/youku/gaiax/js/core/GaiaXContext;", "Lcom/youku/gaiax/quickjs/JSContext;", "jsContext", "Lcom/youku/gaiax/quickjs/JSContext;", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXContext;Lcom/youku/gaiax/quickjs/JSContext;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class QuickJSBridgeModule implements BridgeModuleListener {
    @NotNull
    private final GaiaXContext hostContext;
    @NotNull
    private final JSContext jsContext;

    public QuickJSBridgeModule(@NotNull GaiaXContext gaiaXContext, @NotNull JSContext jSContext) {
        k21.i(gaiaXContext, "hostContext");
        k21.i(jSContext, "jsContext");
        this.hostContext = gaiaXContext;
        this.jsContext = jSContext;
    }

    /* access modifiers changed from: private */
    public final JSValue[] arrayOfJSValues(Object obj) {
        if (obj == null) {
            return new JSValue[0];
        }
        return new JSValue[]{JSDataConvert.INSTANCE.convertToJSValue(this.jsContext, obj)};
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.youku.gaiax.quickjs.JSFunction */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.youku.gaiax.quickjs.JSFunction */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* renamed from: callPromise$lambda-0  reason: not valid java name */
    public static final void m903callPromise$lambda0(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, JSFunction jSFunction, JSFunction jSFunction2) {
        k21.i(ref$ObjectRef, "$jsResolve");
        k21.i(ref$ObjectRef2, "$jsReject");
        ref$ObjectRef.element = jSFunction;
        ref$ObjectRef2.element = jSFunction2;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callAsync(long j, long j2, @NotNull String str) {
        k21.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callAsync() called with: jsContext = " + j + ", argsMap = " + str);
        }
        if (this.jsContext.pointer == j) {
            JSONObject parseObject = JSON.parseObject(str);
            long longValue = parseObject.getLongValue("contextId");
            long longValue2 = parseObject.getLongValue("moduleId");
            long longValue3 = parseObject.getLongValue("methodId");
            JSONArray jSONArray = parseObject.getJSONArray("args");
            jSONArray.add(new QuickJSBridgeModule$callAsync$1(j2, this));
            ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
            k21.h(jSONArray, "args");
            bridge$GaiaX_Android_JS.callAsync(longValue, longValue2, longValue3, jSONArray);
        }
        return this.jsContext.createJSUndefined().pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callPromise(long j, @NotNull String str) {
        k21.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callPromise() called with: jsContext = " + j + ", argsMap = " + str);
        }
        JSContext jSContext = this.jsContext;
        if (jSContext.pointer != j) {
            return jSContext.createJSUndefined().pointer;
        }
        JSONObject parseObject = JSON.parseObject(str);
        long longValue = parseObject.getLongValue("contextId");
        long longValue2 = parseObject.getLongValue("moduleId");
        long longValue3 = parseObject.getLongValue("methodId");
        JSONArray jSONArray = parseObject.getJSONArray("args");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        JSObject createJSPromise = this.jsContext.createJSPromise(new jw1(ref$ObjectRef, ref$ObjectRef2));
        jSONArray.add(new QuickJSBridgeModule$callPromise$1(ref$ObjectRef, this, ref$ObjectRef2));
        ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
        k21.h(jSONArray, "args");
        bridge$GaiaX_Android_JS.callPromise(longValue, longValue2, longValue3, jSONArray);
        return createJSPromise.pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callSync(long j, @NotNull String str) {
        k21.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callSync() called with: jsContext = " + j + ", argsMap = " + str);
        }
        JSContext jSContext = this.jsContext;
        if (jSContext.pointer != j) {
            return jSContext.createJSUndefined().pointer;
        }
        JSONObject parseObject = JSON.parseObject(str);
        long longValue = parseObject.getLongValue("contextId");
        long longValue2 = parseObject.getLongValue("moduleId");
        long longValue3 = parseObject.getLongValue("methodId");
        JSONArray jSONArray = parseObject.getJSONArray("args");
        ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
        k21.h(jSONArray, "args");
        Object callSync = bridge$GaiaX_Android_JS.callSync(longValue, longValue2, longValue3, jSONArray);
        if (callSync == null) {
            callSync = Long.valueOf(this.jsContext.createJSNull().pointer);
        }
        return JSDataConvert.INSTANCE.convertToJSValue(this.jsContext, callSync).pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public void wrapAsJSValueException(@Nullable Exception exc) {
        GaiaXJS.Listener listener$GaiaX_Android_JS;
        if (exc != null && (listener$GaiaX_Android_JS = GaiaXJS.Companion.getInstance().getListener$GaiaX_Android_JS()) != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put((Object) "message", (Object) exc.getStackTrace().toString());
            jSONObject2.put((Object) "templateId", (Object) "");
            jSONObject2.put((Object) "templateVersion", (Object) "");
            jSONObject2.put((Object) if1.DIMEN_BIZ, (Object) "");
            jSONObject.put((Object) "data", (Object) jSONObject2);
            ur2 ur2 = ur2.INSTANCE;
            listener$GaiaX_Android_JS.errorLog(jSONObject);
        }
    }
}
