package com.alibaba.pictures.moimage;

import com.alibaba.pictures.moimage.MoImageDownloader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class MoImageExtensionsKt {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull MoImageView moImageView, @Nullable Integer num, @Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-93189851")) {
            ipChange.ipc$dispatch("-93189851", new Object[]{moImageView, num, str});
            return;
        }
        k21.i(moImageView, "$this$loadFitWidthView");
        if (num != null && num.intValue() > 0) {
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z) {
                MoImageDownloader.g(MoImageDownloader.a.b(MoImageDownloader.Companion, null, 1, null), str, null, null, 6, null).c(new MoImageExtensionsKt$loadFitWidthView$1(moImageView, num));
            }
        }
    }
}
