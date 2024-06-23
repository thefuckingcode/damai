package tb;

import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class mx0 implements IImageFailListener {
    public final /* synthetic */ HomeWelfareContainerView a;

    public /* synthetic */ mx0(HomeWelfareContainerView homeWelfareContainerView) {
        this.a = homeWelfareContainerView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeWelfareContainerView.m136bindView$lambda10$lambda9(this.a, failEvent);
    }
}
