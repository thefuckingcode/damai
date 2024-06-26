package com.youku.gaiax.impl.register;

import android.app.Activity;
import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXKey;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fp0;
import tb.k21;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionGrid;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "", "propertyName", "Ltb/wq0;", "gxTemplateContext", "Ltb/fp0;", "gridConfig", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionGrid implements GXRegisterCenter.GXIExtensionGrid {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionGrid
    @Nullable
    public Object convert(@NotNull String str, @NotNull wq0 wq0, @NotNull fp0 fp0) {
        IProxyFeatures features;
        k21.i(str, "propertyName");
        k21.i(wq0, "gxTemplateContext");
        k21.i(fp0, "gridConfig");
        if (!k21.d(str, "column") || !fp0.c().getBooleanValue(GaiaXKey.GAIAX_GRID_RESPONSIVE_ENABLE)) {
            return null;
        }
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app2 = companion.getInstance().getApp();
        Context context = app2 == null ? null : app2.topActivity();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        IProxyFeatures features2 = companion.getInstance().getFeatures();
        boolean z = false;
        if (features2 != null && features2.isSupportResponsiveLayout(activity)) {
            z = true;
        }
        if (!z || (features = companion.getInstance().getFeatures()) == null) {
            return null;
        }
        return Integer.valueOf(features.getResponsiveSpan(wq0.i().b(), fp0.b()));
    }
}
