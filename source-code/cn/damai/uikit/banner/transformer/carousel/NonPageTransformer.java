package cn.damai.uikit.banner.transformer.carousel;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NonPageTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624609051")) {
            ipChange.ipc$dispatch("-1624609051", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setScaleX(0.999f);
    }
}
