package tb;

import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class px0 implements IImageSuccListener {
    public final /* synthetic */ HomeWelfareContainerView a;

    public /* synthetic */ px0(HomeWelfareContainerView homeWelfareContainerView) {
        this.a = homeWelfareContainerView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeWelfareContainerView.m135bindView$lambda10$lambda8(this.a, successEvent);
    }
}
