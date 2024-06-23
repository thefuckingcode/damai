package com.youku.gaiax.impl;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IRemoteTemplateStateListener;
import com.youku.gaiax.IStable;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\"\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010)\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160302H\u0016J\u0018\u00105\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\bH\u0016J\u0006\u00109\u001a\u00020\bR\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020+0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXStableApiImpl;", "Lcom/youku/gaiax/IStable;", "Landroid/content/Context;", "getContext", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getTemplateInfo", "Ltb/ur2;", "launchDB", "launchRemote", "Landroid/view/View;", "container", "Lcom/youku/gaiax/GaiaX$Params;", "findParamsByContainer", "params", "", "viewId", "findViewById", "templateBiz", "templateId", "key", "Lcom/alibaba/fastjson/JSONObject;", "getDataBindingRawContentByKey", "rawJson", "getConfigs", "getRawConfigs", "getContainerItemTemplateRawConfigs", "getConfigsWithAssets", "getRawConfigsWithAssets", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "getValueWithExpression", "parentParams", "containerId", "", "targetPosition", "getItemParamsByPosition", "", "templateExistWithMemory", "templateExistWithAssets", "templateExistWithRemote", "getRemoteTemplateVersion", "Lcom/youku/gaiax/IRemoteTemplateStateListener;", "listener", "addRemoteTemplateStateListener", "removeRemoteTemplateStateListener", "templatesId", "requestRemoteTemplatesWithAsync", "requestRemoteTemplatesWithSync", "", "", "getAllRemoteTemplates", "getRemoteTemplate", "data", "dispatcherNativeMessageEventToJs", "cleanRemoteTemplates", "notifyRemoteTemplateStateSuccess", "", "listeners", "Ljava/util/List;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXStableApiImpl implements IStable {
    @NotNull
    private final List<IRemoteTemplateStateListener> listeners = new ArrayList();

    private final Context getContext() {
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context applicationContext = app2 == null ? null : app2.applicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        throw new IllegalArgumentException("GaiaXProxy.instance.app?.applicationContext() not exist");
    }

    private final GXTemplateInfo getTemplateInfo(GXTemplateEngine.h hVar) {
        try {
            return GXExtensionTemplateInfoSource.Companion.getInstance().getTemplateInfo(hVar);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            return null;
        }
    }

    @Override // com.youku.gaiax.IStable
    public void addRemoteTemplateStateListener(@NotNull IRemoteTemplateStateListener iRemoteTemplateStateListener) {
        k21.i(iRemoteTemplateStateListener, "listener");
        this.listeners.add(iRemoteTemplateStateListener);
    }

    @Override // com.youku.gaiax.IStable
    public void cleanRemoteTemplates() {
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().cleanRemoteTemplates();
    }

    @Override // com.youku.gaiax.IStable
    public void dispatcherNativeMessageEventToJs(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        GaiaXJSDelegate.INSTANCE.dispatcherNativeMessageEvent(jSONObject);
    }

    @Override // com.youku.gaiax.IStable
    @Nullable
    public GaiaX.Params findParamsByContainer(@NotNull View view) {
        k21.i(view, "container");
        Object tag = view.getTag();
        GaiaXContext gaiaXContext = tag instanceof GaiaXContext ? (GaiaXContext) tag : null;
        GaiaX.Params params = gaiaXContext == null ? null : gaiaXContext.getParams();
        if (params instanceof GaiaX.Params) {
            return params;
        }
        return null;
    }

    @Override // com.youku.gaiax.IStable
    @Nullable
    public View findViewById(@NotNull GaiaX.Params params, @NotNull String str) {
        View rootView;
        k21.i(params, "params");
        k21.i(str, "viewId");
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext == null || (rootView = containerContext.getRootView()) == null) {
            return null;
        }
        return GXTemplateEngine.Companion.a().o(rootView, str);
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public Map<String, List<JSONObject>> getAllRemoteTemplates() {
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().getAllRemoteTemplatesInMemory();
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getConfigs(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        k21.i(jSONObject, "rawJson");
        GXTemplateInfo templateInfo = getTemplateInfo(new GXTemplateEngine.h(getContext(), str, str2));
        JSONObject l = templateInfo == null ? null : templateInfo.l(jSONObject);
        return l == null ? new JSONObject() : l;
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getConfigsWithAssets(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        k21.i(jSONObject, "rawJson");
        GXTemplateEngine.h hVar = new GXTemplateEngine.h(getContext(), str, str2);
        hVar.g(true);
        GXTemplateInfo templateInfo = getTemplateInfo(hVar);
        JSONObject l = templateInfo == null ? null : templateInfo.l(jSONObject);
        return l == null ? new JSONObject() : l;
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getContainerItemTemplateRawConfigs(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return new JSONObject();
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getDataBindingRawContentByKey(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        JSONObject q;
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        k21.i(str3, "key");
        GXTemplateInfo templateInfo = getTemplateInfo(new GXTemplateEngine.h(getContext(), str, str2));
        JSONObject jSONObject = null;
        if (!(templateInfo == null || (q = templateInfo.q()) == null)) {
            jSONObject = q.getJSONObject(str3);
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.youku.gaiax.IStable
    @Nullable
    public GaiaX.Params getItemParamsByPosition(@NotNull GaiaX.Params params, @NotNull String str, int i) {
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        k21.i(params, "parentParams");
        k21.i(str, "containerId");
        View findViewById = findViewById(params, str);
        GXContainer gXContainer = findViewById instanceof GXContainer ? (GXContainer) findViewById : null;
        if (gXContainer == null || (layoutManager = gXContainer.getLayoutManager()) == null || (findViewByPosition = layoutManager.findViewByPosition(i)) == null) {
            return null;
        }
        return findParamsByContainer(findViewByPosition);
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getRawConfigs(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        GXTemplateInfo templateInfo = getTemplateInfo(new GXTemplateEngine.h(getContext(), str, str2));
        JSONObject p = templateInfo == null ? null : templateInfo.p();
        return p == null ? new JSONObject() : p;
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getRawConfigsWithAssets(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        GXTemplateEngine.h hVar = new GXTemplateEngine.h(getContext(), str, str2);
        hVar.g(true);
        GXTemplateInfo templateInfo = getTemplateInfo(hVar);
        JSONObject p = templateInfo == null ? null : templateInfo.p();
        return p == null ? new JSONObject() : p;
    }

    @Override // com.youku.gaiax.IStable
    @NotNull
    public JSONObject getRemoteTemplate(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().getRemoteTemplateFromDB(str, str2);
    }

    @Override // com.youku.gaiax.IStable
    public int getRemoteTemplateVersion(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().getRemoteTemplateVersion(str, str2);
    }

    @Override // com.youku.gaiax.IStable
    @Nullable
    public Object getValueWithExpression(@NotNull String str, @NotNull JSONObject jSONObject) {
        k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
        k21.i(jSONObject, "rawJson");
        return GaiaXExpression.Companion.create(str).desireData(jSONObject);
    }

    @Override // com.youku.gaiax.IStable
    public void launchDB() {
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX初始化逻辑 - launchDB - start");
        }
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().launchDB();
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX初始化逻辑 - launchDB - end");
        }
    }

    @Override // com.youku.gaiax.IStable
    public void launchRemote() {
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().launchRemote();
    }

    public final void notifyRemoteTemplateStateSuccess() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDownloadSuccess();
        }
    }

    @Override // com.youku.gaiax.IStable
    public void removeRemoteTemplateStateListener(@NotNull IRemoteTemplateStateListener iRemoteTemplateStateListener) {
        k21.i(iRemoteTemplateStateListener, "listener");
        this.listeners.remove(iRemoteTemplateStateListener);
    }

    @Override // com.youku.gaiax.IStable
    public void requestRemoteTemplatesWithAsync(@NotNull String str) {
        k21.i(str, "templatesId");
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().requestRemoteTemplatesWithAsync(str);
    }

    @Override // com.youku.gaiax.IStable
    public void requestRemoteTemplatesWithSync(@NotNull String str) {
        k21.i(str, "templatesId");
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().requestRemoteTemplatesWithSync(str);
    }

    @Override // com.youku.gaiax.IStable
    public boolean templateExistWithAssets(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return GXExtensionTemplateAssetsSource.Companion.assetsInstance().exist(str, str2);
    }

    @Override // com.youku.gaiax.IStable
    public boolean templateExistWithMemory(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return GXExtensionTemplateInfoSource.Companion.getInstance().exist(str, str2);
    }

    @Override // com.youku.gaiax.IStable
    public boolean templateExistWithRemote(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().templateExistWithRemote(str, str2);
    }

    @Override // com.youku.gaiax.IStable
    public void requestRemoteTemplatesWithSync(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        GXExtensionTemplateRemoteSource.Companion.remoteInstance().requestRemoteTemplatesWithSync(str, str2);
    }
}
