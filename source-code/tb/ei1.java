package tb;

import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView;
import com.alibaba.pictures.bricks.view.SafeLottieAnimationView;

/* compiled from: Taobao */
public final /* synthetic */ class ei1 implements SafeLottieAnimationView.OnLottieDrawFailListener {
    public final /* synthetic */ NewHeadAtmosphereView a;

    public /* synthetic */ ei1(NewHeadAtmosphereView newHeadAtmosphereView) {
        this.a = newHeadAtmosphereView;
    }

    @Override // com.alibaba.pictures.bricks.view.SafeLottieAnimationView.OnLottieDrawFailListener
    public final void onDrawLottieFail(Throwable th, int i) {
        NewHeadAtmosphereView.m112lambda4$lambda3(this.a, th, i);
    }
}
