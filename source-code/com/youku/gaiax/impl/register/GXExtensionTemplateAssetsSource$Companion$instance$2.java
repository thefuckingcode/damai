package com.youku.gaiax.impl.register;

import android.content.Context;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GXExtensionTemplateAssetsSource$Companion$instance$2 extends Lambda implements Function0<GXExtensionTemplateAssetsSource> {
    public static final GXExtensionTemplateAssetsSource$Companion$instance$2 INSTANCE = new GXExtensionTemplateAssetsSource$Companion$instance$2();

    GXExtensionTemplateAssetsSource$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GXExtensionTemplateAssetsSource invoke() {
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context applicationContext = app2 == null ? null : app2.applicationContext();
        if (applicationContext != null) {
            return new GXExtensionTemplateAssetsSource(applicationContext);
        }
        throw new IllegalArgumentException("GXExtensionTemplateAssetsSource context not exist");
    }
}
