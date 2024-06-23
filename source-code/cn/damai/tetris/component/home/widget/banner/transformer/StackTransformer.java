package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import cn.damai.uikit.banner.transformer.ABaseTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StackTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927506732")) {
            ipChange.ipc$dispatch("927506732", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = ((float) (-view.getWidth())) * f;
        }
        view.setTranslationX(f2);
    }
}
