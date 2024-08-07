package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class BasePageTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract void a(View view, float f);

    public abstract void b(View view, float f);

    public abstract void c(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556407552")) {
            ipChange.ipc$dispatch("-1556407552", new Object[]{this, view, Float.valueOf(f)});
        } else if (f < -1.0f || f >= 1.0f) {
            a(view, f);
        } else {
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i >= 0) {
                return;
            }
            if (f > -1.0f && f < 0.0f) {
                b(view, f);
            } else if (f >= 0.0f && i < 0) {
                c(view, f);
            }
        }
    }
}
