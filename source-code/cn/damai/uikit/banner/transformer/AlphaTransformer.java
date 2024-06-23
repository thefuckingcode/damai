package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AlphaTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766733546")) {
            ipChange.ipc$dispatch("1766733546", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setAlpha((f < -1.0f || f > 1.0f) ? 0.0f : 1.0f - ((Math.abs(f) + 1.0f) - 1.0f));
        if (f == -1.0f) {
            view.setTranslationX((float) (view.getWidth() * -1));
        }
    }
}
