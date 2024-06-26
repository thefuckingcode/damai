package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CubeInTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1440083848")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1440083848", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926957280")) {
            ipChange.ipc$dispatch("-1926957280", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotX(f > 0.0f ? 0.0f : (float) view.getWidth());
        view.setPivotY(0.0f);
        view.setRotationY(f * -90.0f);
    }
}
