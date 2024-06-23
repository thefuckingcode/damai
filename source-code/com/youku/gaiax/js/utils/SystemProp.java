package com.youku.gaiax.js.utils;

import com.uc.webview.export.extension.UCCore;
import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u001c\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/js/utils/SystemProp;", "", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "", "key", "value", "set", gl1.TYPE_OPEN_URL_METHOD_GET, "Ljava/lang/Class;", "mClassType", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "mSetMethod", "Ljava/lang/reflect/Method;", "mGetMethod", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class SystemProp {
    @NotNull
    public static final SystemProp INSTANCE = new SystemProp();
    @Nullable
    private static Class<?> mClassType;
    @Nullable
    private static Method mGetMethod;
    @Nullable
    private static Method mSetMethod;

    private SystemProp() {
    }

    private final void init() {
        Method method;
        try {
            if (mClassType == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mClassType = cls;
                mSetMethod = cls.getDeclaredMethod("set", String.class, String.class);
                Class<?> cls2 = mClassType;
                if (cls2 == null) {
                    method = null;
                } else {
                    method = cls2.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
                }
                mGetMethod = method;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final String get(@NotNull String str, @NotNull String str2) {
        Object obj;
        k21.i(str, "key");
        k21.i(str2, "value");
        init();
        try {
            Method method = mGetMethod;
            if (method == null) {
                obj = null;
            } else {
                obj = method.invoke(mClassType, str, str2);
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public final void set(@NotNull String str, @NotNull String str2) {
        k21.i(str, "key");
        k21.i(str2, "value");
        init();
        try {
            Method method = mSetMethod;
            if (method != null) {
                method.invoke(mClassType, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
