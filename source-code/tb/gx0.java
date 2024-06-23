package tb;

import com.alibaba.pictures.bricks.component.home.HomeProjectItemView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class gx0 implements IImageSuccListener {
    public final /* synthetic */ HomeProjectItemView a;

    public /* synthetic */ gx0(HomeProjectItemView homeProjectItemView) {
        this.a = homeProjectItemView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeProjectItemView.m103bindView$lambda0(this.a, successEvent);
    }
}
