package com.youku.gaiax.impl.register.remote;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils;
import java.io.File;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Ljava/util/zip/ZipEntry;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils$ZipIO;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXRemoteUnzipUtils$unzip$1 extends Lambda implements Function1<ZipEntry, GaiaXRemoteUnzipUtils.ZipIO> {
    final /* synthetic */ String $target;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXRemoteUnzipUtils$unzip$1(String str) {
        super(1);
        this.$target = str;
    }

    @NotNull
    public final GaiaXRemoteUnzipUtils.ZipIO invoke(ZipEntry zipEntry) {
        k21.h(zipEntry, AdvanceSetting.NETWORK_TYPE);
        return new GaiaXRemoteUnzipUtils.ZipIO(zipEntry, new File(this.$target + ((Object) File.separator) + ((Object) zipEntry.getName())));
    }
}
