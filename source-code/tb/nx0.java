package tb;

import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class nx0 implements IImageFailListener {
    public final /* synthetic */ HomeWelfareContainerView a;

    public /* synthetic */ nx0(HomeWelfareContainerView homeWelfareContainerView) {
        this.a = homeWelfareContainerView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeWelfareContainerView.m134bindView$lambda10$lambda7(this.a, failEvent);
    }
}
