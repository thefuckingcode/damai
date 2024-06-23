package tb;

import android.view.View;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;

/* compiled from: Taobao */
public final /* synthetic */ class uv0 implements DMUpMarqueeView.OnItemClickListener {
    public final /* synthetic */ HomeGrabHotRecommendContainerView a;

    public /* synthetic */ uv0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView) {
        this.a = homeGrabHotRecommendContainerView;
    }

    @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
    public final void onItemClick(int i, View view) {
        HomeGrabHotRecommendContainerView.m130initFlipper$lambda11(this.a, i, view);
    }
}
