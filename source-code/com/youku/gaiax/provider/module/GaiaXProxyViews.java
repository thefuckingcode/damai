package com.youku.gaiax.provider.module;

import androidx.annotation.Keep;
import com.youku.gaiax.api.proxy.IProxyViews;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.gaiax.provider.module.views.GaiaXImageView;
import com.youku.gaiax.provider.module.views.GaiaXYKLottieAnimationView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyViews;", "Lcom/youku/gaiax/api/proxy/IProxyViews;", "Ljava/lang/Class;", "getLottieViewClass", "getImageViewClass", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXProxyViews implements IProxyViews {
    @Override // com.youku.gaiax.api.proxy.IProxyViews
    @NotNull
    public Class<?> getImageViewClass() {
        PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
        Class<?> className = companion.getClassName(companion.getGAIAX_IMAGE_TYPE());
        return className == null ? GaiaXImageView.class : className;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyViews
    @NotNull
    public Class<?> getLottieViewClass() {
        return GaiaXYKLottieAnimationView.class;
    }
}
