package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DepthPageTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1392168618")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1392168618", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458660354")) {
            ipChange.ipc$dispatch("-1458660354", new Object[]{this, view, Float.valueOf(f)});
        } else if (f <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            float abs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
            view.setAlpha(1.0f - f);
            view.setPivotY(((float) view.getHeight()) * 0.5f);
            view.setTranslationX(((float) view.getWidth()) * (-f));
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
