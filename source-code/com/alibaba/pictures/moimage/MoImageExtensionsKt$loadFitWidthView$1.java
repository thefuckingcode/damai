package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class MoImageExtensionsKt$loadFitWidthView$1 implements DownloadImgListener<Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MoImageView a;
    final /* synthetic */ Integer b;

    MoImageExtensionsKt$loadFitWidthView$1(MoImageView moImageView, Integer num) {
        this.a = moImageView;
        this.b = num;
    }

    /* renamed from: a */
    public void onDownloaded(@Nullable String str, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240521341")) {
            ipChange.ipc$dispatch("-240521341", new Object[]{this, str, bitmap});
            return;
        }
        k21.i(bitmap, "source");
        this.a.post(new MoImageExtensionsKt$loadFitWidthView$1$onDownloaded$1(this, bitmap));
        this.a.setLocalImageBitmap(bitmap);
    }

    @Override // com.alibaba.pictures.moimage.DownloadImgListener
    public void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025010942")) {
            ipChange.ipc$dispatch("-2025010942", new Object[]{this, moImageLoadException, str});
            return;
        }
        k21.i(moImageLoadException, "exception");
    }
}
