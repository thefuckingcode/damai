package tb;

import com.alibaba.pictures.bricks.bean.HomeGrabHotRecoBean;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class wv0 implements IImageFailListener {
    public final /* synthetic */ HomeGrabHotRecommendContainerView a;
    public final /* synthetic */ HomeGrabHotRecoBean b;

    public /* synthetic */ wv0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean) {
        this.a = homeGrabHotRecommendContainerView;
        this.b = homeGrabHotRecoBean;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeGrabHotRecommendContainerView.m128bindView$lambda4$lambda3(this.a, this.b, failEvent);
    }
}
