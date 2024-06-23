package com.youku.gaiax.impl.register;

import android.content.Context;
import android.os.SystemClock;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXMonitor;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;
import tb.vq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00140\u0013J\u0006\u0010\u0016\u001a\u00020\nR\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R1\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00060\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getData", "Ljava/util/concurrent/ConcurrentHashMap;", "", "bizList", "info", "Ltb/ur2;", "collectionNestTemplate", "templateBiz", "templateId", "", "exist", "getTemplateInfo", "Lcom/alibaba/fastjson/JSONObject;", "getTemplate", "", "", "getAllTemplate", Constants.TAG_CLEAR_STRING, "", "dataLock", "Ljava/util/concurrent/ConcurrentHashMap;", "dataCache", "getDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateInfoSource> instance$delegate = b.b(GXExtensionTemplateInfoSource$Companion$instance$2.INSTANCE);
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> dataCache = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, Object> dataLock = new ConcurrentHashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateInfoSource getInstance() {
            return (GXExtensionTemplateInfoSource) GXExtensionTemplateInfoSource.instance$delegate.getValue();
        }
    }

    private final void collectionNestTemplate(ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap, GXTemplateInfo gXTemplateInfo) {
        List<GXTemplateInfo> k = gXTemplateInfo.k();
        if (k != null) {
            for (T t : k) {
                concurrentHashMap.put(t.o().d(), t);
                List<GXTemplateInfo> k2 = t.k();
                boolean z = false;
                if (k2 != null && (!k2.isEmpty())) {
                    z = true;
                }
                if (z) {
                    collectionNestTemplate(concurrentHashMap, t);
                }
            }
        }
    }

    private final GXTemplateInfo getData(GXTemplateEngine.h hVar) {
        GXTemplateInfo g;
        if (exist(hVar.a(), hVar.d())) {
            ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(hVar.a());
            GXTemplateInfo gXTemplateInfo = concurrentHashMap == null ? null : concurrentHashMap.get(hVar.d());
            if (gXTemplateInfo != null) {
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template exist but reference is null");
        }
        String r = k21.r(hVar.a(), hVar.d());
        Object obj = this.dataLock.get(r);
        if (obj == null) {
            obj = new Object();
            this.dataLock.put(r, obj);
        }
        synchronized (obj) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            g = GXTemplateInfo.Companion.g(hVar);
            GaiaXMonitor.INSTANCE.onCreateC(hVar, elapsedRealtime);
            ur2 ur2 = ur2.INSTANCE;
        }
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap2 = getDataCache().get(hVar.a());
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            getDataCache().put(hVar.a(), concurrentHashMap2);
        }
        concurrentHashMap2.put(hVar.d(), g);
        collectionNestTemplate(concurrentHashMap2, g);
        return g;
    }

    public final void clear() {
        this.dataCache.clear();
        this.dataLock.clear();
    }

    public final boolean exist(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(str);
        return (concurrentHashMap == null ? null : concurrentHashMap.get(str2)) != null;
    }

    @NotNull
    public final Map<String, List<JSONObject>> getAllTemplate() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ConcurrentHashMap<String, GXTemplateInfo>> entry : this.dataCache.entrySet()) {
            String key = entry.getKey();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, GXTemplateInfo> entry2 : entry.getValue().entrySet()) {
                vq0 r = entry2.getValue().r();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
                jSONObject2.put((Object) "index.json", (Object) companion.n(r.f()));
                jSONObject2.put((Object) "index.css", (Object) companion.l(r.b()));
                jSONObject2.put((Object) "index.databinding", (Object) companion.m(r.c()));
                jSONObject2.put((Object) "index.js", (Object) r.e());
                jSONObject.put((Object) com.youku.arch.v3.data.Constants.TEMPLATE, (Object) jSONObject2);
                jSONObject.put((Object) "templateId", (Object) r.d());
                jSONObject.put((Object) "templateBiz", (Object) r.a());
                jSONObject.put((Object) "templateVersion", (Object) Integer.valueOf(r.h()));
                jSONObject.put((Object) "templateType", (Object) "memory");
                arrayList.add(jSONObject);
            }
            hashMap.put(key, arrayList);
        }
        return hashMap;
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> getDataCache() {
        return this.dataCache;
    }

    @NotNull
    public final JSONObject getTemplate(@NotNull String str, @NotNull String str2) {
        GXTemplateInfo gXTemplateInfo;
        vq0 r;
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(str);
        if (concurrentHashMap == null || (gXTemplateInfo = concurrentHashMap.get(str2)) == null || (r = gXTemplateInfo.r()) == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
        jSONObject2.put((Object) "index.json", (Object) companion.n(r.f()));
        jSONObject2.put((Object) "index.css", (Object) companion.l(r.b()));
        jSONObject2.put((Object) "index.databinding", (Object) companion.m(r.c()));
        jSONObject2.put((Object) "index.js", (Object) r.e());
        jSONObject.put((Object) com.youku.arch.v3.data.Constants.TEMPLATE, (Object) jSONObject2);
        jSONObject.put((Object) "templateId", (Object) r.d());
        jSONObject.put((Object) "templateBiz", (Object) r.a());
        jSONObject.put((Object) "templateVersion", (Object) Integer.valueOf(r.h()));
        jSONObject.put((Object) "templateType", (Object) "memory");
        return jSONObject;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
    @Nullable
    public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.h hVar) {
        IProxyApp app2;
        Context applicationContext;
        k21.i(hVar, "gxTemplateItem");
        GXTemplateInfo data = getData(hVar);
        boolean z = false;
        if (data != null && data.s()) {
            z = true;
        }
        if (!(!z || (app2 = GaiaXProxy.Companion.getInstance().getApp()) == null || (applicationContext = app2.applicationContext()) == null)) {
            GaiaXJSDelegate.INSTANCE.startEngine(applicationContext, GXExtensionTemplateInfoSource$getTemplateInfo$1$1.INSTANCE);
        }
        return data;
    }
}
