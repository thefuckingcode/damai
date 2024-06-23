package tb;

import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class fi1 implements IImageFailListener {
    public final /* synthetic */ NewHeadAtmosphereView a;

    public /* synthetic */ fi1(NewHeadAtmosphereView newHeadAtmosphereView) {
        this.a = newHeadAtmosphereView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        NewHeadAtmosphereView.m114loadStaticPicAtmosphere$lambda8(this.a, failEvent);
    }
}
