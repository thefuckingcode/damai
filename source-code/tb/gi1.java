package tb;

import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class gi1 implements IImageSuccListener {
    public final /* synthetic */ NewHeadAtmosphereView a;

    public /* synthetic */ gi1(NewHeadAtmosphereView newHeadAtmosphereView) {
        this.a = newHeadAtmosphereView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        NewHeadAtmosphereView.m113loadStaticPicAtmosphere$lambda7(this.a, successEvent);
    }
}
