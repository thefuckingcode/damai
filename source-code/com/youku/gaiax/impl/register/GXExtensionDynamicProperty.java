package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fp0;
import tb.k21;
import tb.m70;
import tb.nq0;
import tb.ob2;
import tb.uq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionDynamicProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$a;", "params", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionDynamicProperty implements GXRegisterCenter.GXIExtensionDynamicProperty {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionDynamicProperty
    @Nullable
    public Object convert(@NotNull GXRegisterCenter.GXIExtensionDynamicProperty.a aVar) {
        nq0 n;
        nq0 n2;
        k21.i(aVar, "params");
        if (k21.d(aVar.c(), "scroll-compute-container-height")) {
            if (k21.d(aVar.d(), Boolean.FALSE)) {
                return Boolean.TRUE;
            }
        } else if (k21.d(aVar.c(), "grid-compute-container-height")) {
            fp0 b = aVar.b();
            boolean z = false;
            if (b != null && !b.h()) {
                z = true;
            }
            if (z && k21.d(aVar.d(), Boolean.FALSE)) {
                return Boolean.TRUE;
            }
        } else if (k21.d(aVar.c(), "size") || k21.d(aVar.c(), "min-size") || k21.d(aVar.c(), "max-size")) {
            ob2 ob2 = (ob2) aVar.d();
            uq0 a = aVar.a();
            if (CollectionsKt___CollectionsKt.J(GXExtensionSize.Companion.getProcessSizes(), (a == null || (n = a.n()) == null) ? null : n.a())) {
                IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
                Float valueOf = features == null ? null : Float.valueOf(features.largeFontScale());
                if (valueOf != null) {
                    m70 m70 = (m70) ob2.a();
                    if (m70 instanceof m70.c) {
                        ob2.c(new m70.c(((m70.c) m70).c() * valueOf.floatValue()));
                    }
                    return aVar.d();
                }
            }
        } else if (k21.d(aVar.c(), "line-height")) {
            uq0 a2 = aVar.a();
            if (CollectionsKt___CollectionsKt.J(GXExtensionSize.Companion.getProcessSizes(), (a2 == null || (n2 = a2.n()) == null) ? null : n2.a())) {
                IProxyFeatures features2 = GaiaXProxy.Companion.getInstance().getFeatures();
                Float valueOf2 = features2 == null ? null : Float.valueOf(features2.largeFontScale());
                if (valueOf2 != null) {
                    return Float.valueOf(((Float) aVar.d()).floatValue() * valueOf2.floatValue());
                }
            }
        }
        return null;
    }
}
