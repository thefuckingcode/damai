package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FlipVerticalTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void d(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834754025")) {
            ipChange.ipc$dispatch("834754025", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        super.d(view, f);
        if (f <= -0.5f || f >= 0.5f) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598999593")) {
            ipChange.ipc$dispatch("598999593", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float f2 = f * -180.0f;
        view.setAlpha((f2 > 90.0f || f2 < -90.0f) ? 0.0f : 1.0f);
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(((float) view.getHeight()) * 0.5f);
        view.setRotationX(f2);
    }
}
