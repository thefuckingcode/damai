package com.youku.gaiax.api.proxy;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyViews;", "", "Ljava/lang/Class;", "getImageViewClass", "getLottieViewClass", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface IProxyViews {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Nullable
        public static Class<?> getImageViewClass(@NotNull IProxyViews iProxyViews) {
            k21.i(iProxyViews, "this");
            return null;
        }

        @Nullable
        public static Class<?> getLottieViewClass(@NotNull IProxyViews iProxyViews) {
            k21.i(iProxyViews, "this");
            return null;
        }
    }

    @Nullable
    Class<?> getImageViewClass();

    @Nullable
    Class<?> getLottieViewClass();
}
