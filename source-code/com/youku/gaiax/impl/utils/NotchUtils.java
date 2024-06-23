package com.youku.gaiax.impl.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001f\u0010\r\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/youku/gaiax/impl/utils/NotchUtils;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "isNotchDevice", "isOppoNotchDevice", "isVivoNotchDevice", "isXiaomiNotchDevice", "isHuaweiNotchDevice", "isLenovoNotchDevice", "isNotch$delegate", "Lkotlin/Lazy;", "isNotch", "()Ljava/lang/Boolean;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class NotchUtils {
    @NotNull
    public static final NotchUtils INSTANCE = new NotchUtils();
    @NotNull
    private static final Lazy isNotch$delegate = b.b(NotchUtils$isNotch$2.INSTANCE);

    private NotchUtils() {
    }

    public static final /* synthetic */ boolean access$isNotchDevice(NotchUtils notchUtils, Context context) {
        return notchUtils.isNotchDevice(context);
    }

    private final boolean isHuaweiNotchDevice(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Object invoke = loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0]);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean isLenovoNotchDevice(Context context) {
        String brand = Build.getBRAND();
        k21.h(brand, Constants.BRAND);
        String lowerCase = brand.toLowerCase();
        k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (TextUtils.isEmpty(lowerCase) || !(StringsKt__StringsKt.Q(lowerCase, "lenovo", false, 2, null))) {
            return false;
        }
        return k21.d(SystemProp.INSTANCE.get("config_screen_has_notch", "0"), "1");
    }

    private final boolean isNotchDevice(Context context) {
        return isHuaweiNotchDevice(context) || isLenovoNotchDevice(context) || isOppoNotchDevice(context) || isVivoNotchDevice(context) || isXiaomiNotchDevice();
    }

    private final boolean isOppoNotchDevice(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean isVivoNotchDevice(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            Object invoke = loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32);
            if (invoke != null) {
                ((Boolean) invoke).booleanValue();
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Exception unused) {
        }
    }

    private final boolean isXiaomiNotchDevice() {
        String brand = Build.getBRAND();
        k21.h(brand, Constants.BRAND);
        String lowerCase = brand.toLowerCase();
        k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (!k21.d(SystemProp.INSTANCE.get("ro.miui.notch", "0"), "1") || TextUtils.isEmpty(lowerCase) || !(StringsKt__StringsKt.Q(lowerCase, "xiaomi", false, 2, null))) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Boolean isNotch() {
        return (Boolean) isNotch$delegate.getValue();
    }
}
