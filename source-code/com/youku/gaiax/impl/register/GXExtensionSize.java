package com.youku.gaiax.impl.register;

import android.app.Activity;
import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyDesignToken;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.nq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionSize;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionSize;", "", "value", "", "create", "(Ljava/lang/String;)Ljava/lang/Float;", "convert", "(F)Ljava/lang/Float;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionSize implements GXRegisterCenter.GXIExtensionSize {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Set<String> processSizes = new LinkedHashSet();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionSize$Companion;", "", "", "", "processSizes", "Ljava/util/Set;", "getProcessSizes", "()Ljava/util/Set;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final Set<String> getProcessSizes() {
            return GXExtensionSize.processSizes;
        }
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionSize
    @Nullable
    public Float convert(float f) {
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app2 = companion.getInstance().getApp();
        Activity activity = null;
        Context context = app2 == null ? null : app2.topActivity();
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        IProxyFeatures features = companion.getInstance().getFeatures();
        boolean z = false;
        if (features != null && features.isSupportResponsiveLayout(activity)) {
            z = true;
        }
        if (!z) {
            return Float.valueOf(f);
        }
        IProxyFeatures features2 = companion.getInstance().getFeatures();
        if (features2 != null) {
            f = features2.getResponsiveLayoutScale();
        }
        return Float.valueOf(f);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionSize
    @Nullable
    public Float create(@NotNull String str) {
        k21.i(str, "value");
        IProxyDesignToken designToken = GaiaXProxy.Companion.getInstance().getDesignToken();
        Float designTokenDimen = designToken == null ? null : designToken.designTokenDimen(str);
        if (designTokenDimen != null) {
            Set<String> set = processSizes;
            if (!set.contains(str)) {
                set.add(str);
            }
        }
        if (designTokenDimen != null) {
            return designTokenDimen;
        }
        try {
            return Float.valueOf(nq0.Companion.e(Float.parseFloat(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
