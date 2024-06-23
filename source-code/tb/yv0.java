package tb;

import com.alibaba.pictures.bricks.bean.HomeGrabHotRecoBean;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class yv0 implements IImageSuccListener {
    public final /* synthetic */ HomeGrabHotRecommendContainerView a;
    public final /* synthetic */ HomeGrabHotRecoBean b;

    public /* synthetic */ yv0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean) {
        this.a = homeGrabHotRecommendContainerView;
        this.b = homeGrabHotRecoBean;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeGrabHotRecommendContainerView.m127bindView$lambda4$lambda2(this.a, this.b, successEvent);
    }
}
