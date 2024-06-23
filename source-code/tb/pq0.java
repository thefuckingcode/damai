package tb;

import android.view.MotionEvent;
import android.view.View;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;

/* compiled from: Taobao */
public final /* synthetic */ class pq0 implements View.OnTouchListener {
    public final /* synthetic */ GXSliderView a;

    public /* synthetic */ pq0(GXSliderView gXSliderView) {
        this.a = gXSliderView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return GXSliderView.m96initViewPager$lambda0(this.a, view, motionEvent);
    }
}
