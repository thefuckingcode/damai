package tb;

import com.alibaba.pictures.bricks.component.home.HorizontalColorBgView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class sx0 implements IImageFailListener {
    public final /* synthetic */ HorizontalColorBgView a;

    public /* synthetic */ sx0(HorizontalColorBgView horizontalColorBgView) {
        this.a = horizontalColorBgView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HorizontalColorBgView.m106bindView$lambda3$lambda2(this.a, failEvent);
    }
}
