package com.alient.onearch.adapter.widget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;
import kotlin.Metadata;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alient/oneservice/image/SuccessEvent;", "kotlin.jvm.PlatformType", "event", "Ltb/ur2;", "onSuccess", "(Lcom/alient/oneservice/image/SuccessEvent;)V", "com/alient/onearch/adapter/widget/OneTabLayout$$special$$inlined$apply$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class OneTabLayout$setSelectedTab$$inlined$apply$lambda$1 implements IImageSuccListener {
    final /* synthetic */ ImageView $this_apply;
    final /* synthetic */ OneTabLayout this$0;

    OneTabLayout$setSelectedTab$$inlined$apply$lambda$1(ImageView imageView, OneTabLayout oneTabLayout) {
        this.$this_apply = imageView;
        this.this$0 = oneTabLayout;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        if (successEvent != null) {
            OneTabLayout oneTabLayout = this.this$0;
            ImageView imageView = this.$this_apply;
            Drawable drawable = successEvent.drawable;
            k21.h(drawable, "it.drawable");
            oneTabLayout.onLoadIndicatorBackgroundSuccess(imageView, drawable);
        }
    }
}
