package tb;

import com.alibaba.pictures.bricks.bean.HomeGrabHotBean;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class qv0 implements IImageSuccListener {
    public final /* synthetic */ HomeGrabHotBean a;
    public final /* synthetic */ HomeCardGrabView b;

    public /* synthetic */ qv0(HomeGrabHotBean homeGrabHotBean, HomeCardGrabView homeCardGrabView) {
        this.a = homeGrabHotBean;
        this.b = homeCardGrabView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeCardGrabView.m122bindView$lambda0(this.a, this.b, successEvent);
    }
}
