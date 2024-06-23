package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import cn.damai.uikit.banner.transformer.ABaseTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CubeInTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2062118496")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2062118496", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813988600")) {
            ipChange.ipc$dispatch("-813988600", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotX(f > 0.0f ? 0.0f : (float) view.getWidth());
        view.setPivotY(0.0f);
        view.setRotationY(f * -90.0f);
    }
}
