package com.alient.onearch.adapter.widget;

import com.airbnb.lottie.LottieAnimationView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/alient/oneservice/image/SuccessEvent;", "kotlin.jvm.PlatformType", "event", "Ltb/ur2;", "onSuccess", "(Lcom/alient/oneservice/image/SuccessEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class OneTabLayout$setTitles$1$1$2 implements IImageSuccListener {
    final /* synthetic */ LottieAnimationView $tabIcon;

    OneTabLayout$setTitles$1$1$2(LottieAnimationView lottieAnimationView) {
        this.$tabIcon = lottieAnimationView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        LottieAnimationView lottieAnimationView;
        if (successEvent != null && (lottieAnimationView = this.$tabIcon) != null) {
            lottieAnimationView.setImageDrawable(successEvent.drawable);
        }
    }
}
