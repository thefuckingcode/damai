package com.alibaba.ability.utils;

import com.taobao.orange.OrangeConfig;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class OrangeUtils {
    @NotNull
    public static final OrangeUtils INSTANCE = new OrangeUtils();
    private static final Lazy a = b.b(OrangeUtils$sHasOrange$2.INSTANCE);

    private OrangeUtils() {
    }

    private static final boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        if (!a()) {
            return false;
        }
        return k21.d("true", OrangeConfig.getInstance().getConfig("megability", "userMegaScheduler", "true"));
    }
}
