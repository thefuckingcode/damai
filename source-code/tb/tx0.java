package tb;

import com.alibaba.pictures.bricks.component.home.HorizontalColorBgView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class tx0 implements IImageFailListener {
    public final /* synthetic */ HorizontalColorBgView a;

    public /* synthetic */ tx0(HorizontalColorBgView horizontalColorBgView) {
        this.a = horizontalColorBgView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        HorizontalColorBgView.m108bindView$lambda7$lambda6(this.a, failEvent);
    }
}
