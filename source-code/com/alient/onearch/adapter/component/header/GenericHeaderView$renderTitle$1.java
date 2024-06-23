package com.alient.onearch.adapter.component.header;

import android.widget.ImageView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/alient/oneservice/image/SuccessEvent;", "kotlin.jvm.PlatformType", "event", "Ltb/ur2;", "onSuccess", "(Lcom/alient/oneservice/image/SuccessEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GenericHeaderView$renderTitle$1 implements IImageSuccListener {
    final /* synthetic */ GenericHeaderView this$0;

    GenericHeaderView$renderTitle$1(GenericHeaderView genericHeaderView) {
        this.this$0 = genericHeaderView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        if ((successEvent != null ? successEvent.bitmap : null) != null) {
            ImageView imageView = this.this$0.titleImage;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.this$0.titleImage;
            if (imageView2 != null) {
                imageView2.setImageBitmap(successEvent.bitmap);
                return;
            }
            return;
        }
        ImageView imageView3 = this.this$0.titleImage;
        if (imageView3 != null) {
            imageView3.setImageBitmap(null);
        }
        ImageView imageView4 = this.this$0.titleImage;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }
}
