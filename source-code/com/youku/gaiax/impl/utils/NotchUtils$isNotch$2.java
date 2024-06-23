package com.youku.gaiax.impl.utils;

import android.app.Activity;
import android.content.Context;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class NotchUtils$isNotch$2 extends Lambda implements Function0<Boolean> {
    public static final NotchUtils$isNotch$2 INSTANCE = new NotchUtils$isNotch$2();

    NotchUtils$isNotch$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        try {
            IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
            if (app2 != null) {
                Context context = app2.topActivity();
                if (context != null) {
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (activity != null) {
                        return Boolean.valueOf(NotchUtils.access$isNotchDevice(NotchUtils.INSTANCE, activity));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }
}
