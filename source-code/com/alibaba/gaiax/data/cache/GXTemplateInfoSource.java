package com.alibaba.gaiax.data.cache;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

/* compiled from: Taobao */
public final class GXTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXTemplateInfoSource> c = b.b(GXTemplateInfoSource$Companion$instance$2.INSTANCE);
    @NotNull
    private final ConcurrentHashMap<String, Object> a = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> b = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final GXTemplateInfoSource a() {
            return (GXTemplateInfoSource) GXTemplateInfoSource.c.getValue();
        }
    }

    private final void b(ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap, GXTemplateInfo gXTemplateInfo) {
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
                    b(concurrentHashMap, t);
                }
            }
        }
    }

    private final boolean c(String str, String str2) {
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.b.get(str);
        return (concurrentHashMap == null ? null : concurrentHashMap.get(str2)) != null;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
    @Nullable
    public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.h hVar) {
        GXTemplateInfo g;
        k21.i(hVar, "gxTemplateItem");
        if (c(hVar.a(), hVar.d())) {
            ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.b.get(hVar.a());
            GXTemplateInfo gXTemplateInfo = concurrentHashMap == null ? null : concurrentHashMap.get(hVar.d());
            if (gXTemplateInfo != null) {
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template exist but reference is null");
        }
        String r = k21.r(hVar.a(), hVar.d());
        Object obj = this.a.get(r);
        if (obj == null) {
            obj = new Object();
            this.a.put(r, obj);
        }
        synchronized (obj) {
            g = GXTemplateInfo.Companion.g(hVar);
            ur2 ur2 = ur2.INSTANCE;
        }
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap2 = this.b.get(hVar.a());
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            this.b.put(hVar.a(), concurrentHashMap2);
        }
        concurrentHashMap2.put(hVar.d(), g);
        b(concurrentHashMap2, g);
        return g;
    }
}
