package com.alient.onearch.adapter.component.header;

import android.widget.ImageView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/alient/oneservice/image/FailEvent;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "onFail", "(Lcom/alient/oneservice/image/FailEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GenericHeaderView$renderTitle$2 implements IImageFailListener {
    final /* synthetic */ GenericHeaderView this$0;

    GenericHeaderView$renderTitle$2(GenericHeaderView genericHeaderView) {
        this.this$0 = genericHeaderView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        ImageView imageView = this.this$0.titleImage;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        ImageView imageView2 = this.this$0.titleImage;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }
}
