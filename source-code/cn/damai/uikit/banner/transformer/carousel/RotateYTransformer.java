package cn.damai.uikit.banner.transformer.carousel;

import android.annotation.TargetApi;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RotateYTransformer extends BasePageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float b = 35.0f;

    @Override // cn.damai.uikit.banner.transformer.carousel.BasePageTransformer
    @TargetApi(11)
    public void a(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131712005")) {
            ipChange.ipc$dispatch("1131712005", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotY((float) (view.getHeight() / 2));
        if (f < -1.0f) {
            view.setRotationY(this.b * -1.0f);
            view.setPivotX((float) view.getWidth());
        } else if (f <= 1.0f) {
            view.setRotationY(this.b * f);
            if (f < 0.0f) {
                view.setPivotX(((float) view.getWidth()) * (((-f) * 0.5f) + 0.5f));
                view.setPivotX((float) view.getWidth());
                return;
            }
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f));
            view.setPivotX(0.0f);
        } else {
            view.setRotationY(this.b * 1.0f);
            view.setPivotX(0.0f);
        }
    }
}
