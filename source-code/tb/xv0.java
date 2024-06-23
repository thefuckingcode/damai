package tb;

import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class xv0 implements IImageSuccListener {
    public final /* synthetic */ HomeGrabHotRecommendContainerView a;

    public /* synthetic */ xv0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView) {
        this.a = homeGrabHotRecommendContainerView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeGrabHotRecommendContainerView.m125bindView$lambda4$lambda0(this.a, successEvent);
    }
}
