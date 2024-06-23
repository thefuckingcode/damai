package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ForegroundToBackgroundTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295981102")) {
            ipChange.ipc$dispatch("-295981102", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float height = (float) view.getHeight();
        float width = (float) view.getWidth();
        float f2 = 1.0f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i <= 0) {
            f2 = Math.abs(1.0f + f);
        }
        float c = ABaseTransformer.c(f2, 0.5f);
        view.setScaleX(c);
        view.setScaleY(c);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(i > 0 ? width * f : (-width) * f * 0.25f);
    }
}
