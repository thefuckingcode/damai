package tb;

import com.alibaba.pictures.bricks.component.home.ball.HomeBallView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class kv0 implements IImageFailListener {
    public final /* synthetic */ HomeBallView a;

    public /* synthetic */ kv0(HomeBallView homeBallView) {
        this.a = homeBallView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HomeBallView.m116bindView$lambda1(this.a, failEvent);
    }
}
