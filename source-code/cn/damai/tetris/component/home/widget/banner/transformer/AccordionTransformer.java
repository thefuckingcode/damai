package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import cn.damai.uikit.banner.transformer.ABaseTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AccordionTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791895660")) {
            ipChange.ipc$dispatch("791895660", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float f2 = 0.0f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i >= 0) {
            f2 = (float) view.getWidth();
        }
        view.setPivotX(f2);
        view.setScaleX(i < 0 ? f + 1.0f : 1.0f - f);
    }
}
