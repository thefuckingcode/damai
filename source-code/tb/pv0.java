package tb;

import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class pv0 implements IImageFailListener {
    public final /* synthetic */ HomeCardGrabView a;

    public /* synthetic */ pv0(HomeCardGrabView homeCardGrabView) {
        this.a = homeCardGrabView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeCardGrabView.m123bindView$lambda1(this.a, failEvent);
    }
}
