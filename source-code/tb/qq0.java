package tb;

import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView$startTimer$1$1;

/* compiled from: Taobao */
public final /* synthetic */ class qq0 implements Runnable {
    public final /* synthetic */ GXSliderView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ qq0(GXSliderView gXSliderView, int i, int i2) {
        this.a = gXSliderView;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        GXSliderView$startTimer$1$1.m97run$lambda2$lambda1$lambda0(this.a, this.b, this.c);
    }
}
