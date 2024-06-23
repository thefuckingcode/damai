package tb;

import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class as0 implements IImageFailListener {
    public static final /* synthetic */ as0 a = new as0();

    private /* synthetic */ as0() {
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        GenericBannerPresenterExt.m145init$lambda10$lambda9$lambda8$lambda7$lambda6(failEvent);
    }
}
