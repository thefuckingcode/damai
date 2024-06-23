package tb;

import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class vv0 implements IImageFailListener {
    public final /* synthetic */ HomeGrabHotRecommendContainerView a;

    public /* synthetic */ vv0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView) {
        this.a = homeGrabHotRecommendContainerView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeGrabHotRecommendContainerView.m126bindView$lambda4$lambda1(this.a, failEvent);
    }
}
