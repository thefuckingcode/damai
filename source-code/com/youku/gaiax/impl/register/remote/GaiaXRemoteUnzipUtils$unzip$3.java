package com.youku.gaiax.impl.register.remote;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils$ZipIO;", AdvanceSetting.NETWORK_TYPE, "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXRemoteUnzipUtils$unzip$3 extends Lambda implements Function1<GaiaXRemoteUnzipUtils.ZipIO, Boolean> {
    public static final GaiaXRemoteUnzipUtils$unzip$3 INSTANCE = new GaiaXRemoteUnzipUtils$unzip$3();

    GaiaXRemoteUnzipUtils$unzip$3() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull GaiaXRemoteUnzipUtils.ZipIO zipIO) {
        k21.i(zipIO, AdvanceSetting.NETWORK_TYPE);
        return Boolean.valueOf(!zipIO.getEntry().isDirectory());
    }
}
