package com.youku.gaiax.provider.module;

import android.content.Context;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.provider.module.GaiaXProxySource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKAssetsTemplateSource;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion$instance$2 extends Lambda implements Function0<GaiaXProxySource.GaiaXYKAssetsTemplateSource> {
    public static final GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion$instance$2 INSTANCE = new GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion$instance$2();

    GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GaiaXProxySource.GaiaXYKAssetsTemplateSource invoke() {
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context applicationContext = app2 == null ? null : app2.applicationContext();
        k21.f(applicationContext);
        return new GaiaXProxySource.GaiaXYKAssetsTemplateSource(applicationContext);
    }
}
