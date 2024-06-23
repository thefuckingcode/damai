package com.youku.gaiax.impl.utils;

import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXUtils$isAppPublishVersion$2 extends Lambda implements Function0<Boolean> {
    public static final GaiaXUtils$isAppPublishVersion$2 INSTANCE = new GaiaXUtils$isAppPublishVersion$2();

    GaiaXUtils$isAppPublishVersion$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        String appVersionName;
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        return Boolean.valueOf(StringsKt__StringsKt.z0((app2 != null && (appVersionName = app2.getAppVersionName()) != null) ? appVersionName : "", new String[]{"."}, false, 0, 6, null).size() == 3);
    }
}
