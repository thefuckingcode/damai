package tb;

import com.alibaba.pictures.bricks.component.home.ball.HomeBallView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class lv0 implements IImageSuccListener {
    public final /* synthetic */ HomeBallView a;

    public /* synthetic */ lv0(HomeBallView homeBallView) {
        this.a = homeBallView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HomeBallView.m115bindView$lambda0(this.a, successEvent);
    }
}
