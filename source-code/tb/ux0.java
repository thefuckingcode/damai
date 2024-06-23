package tb;

import com.alibaba.pictures.bricks.component.home.HorizontalColorBgView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class ux0 implements IImageSuccListener {
    public final /* synthetic */ Object a;
    public final /* synthetic */ HorizontalColorBgView b;

    public /* synthetic */ ux0(Object obj, HorizontalColorBgView horizontalColorBgView) {
        this.a = obj;
        this.b = horizontalColorBgView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        HorizontalColorBgView.m107bindView$lambda7$lambda5(this.a, this.b, successEvent);
    }
}
