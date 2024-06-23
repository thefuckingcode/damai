package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MoImageExtensionsKt$loadFitWidthView$1$onDownloaded$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Bitmap $source;
    final /* synthetic */ MoImageExtensionsKt$loadFitWidthView$1 this$0;

    MoImageExtensionsKt$loadFitWidthView$1$onDownloaded$1(MoImageExtensionsKt$loadFitWidthView$1 moImageExtensionsKt$loadFitWidthView$1, Bitmap bitmap) {
        this.this$0 = moImageExtensionsKt$loadFitWidthView$1;
        this.$source = bitmap;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900567843")) {
            ipChange.ipc$dispatch("-1900567843", new Object[]{this});
        } else if (this.$source.getWidth() > 0 && this.$source.getHeight() > 0) {
            ViewGroup.LayoutParams layoutParams = this.this$0.a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.this$0.b.intValue();
            }
            ViewGroup.LayoutParams layoutParams2 = this.this$0.a.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = (this.this$0.b.intValue() * this.$source.getWidth()) / this.$source.getHeight();
            }
            MoImageView moImageView = this.this$0.a;
            moImageView.setLayoutParams(moImageView.getLayoutParams());
        }
    }
}
