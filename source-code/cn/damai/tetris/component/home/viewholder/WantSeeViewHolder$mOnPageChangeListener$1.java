package cn.damai.tetris.component.home.viewholder;

import androidx.viewpager.widget.ViewPager;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k21;

/* compiled from: Taobao */
public final class WantSeeViewHolder$mOnPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ WantSeeViewHolder a;

    WantSeeViewHolder$mOnPageChangeListener$1(WantSeeViewHolder wantSeeViewHolder) {
        this.a = wantSeeViewHolder;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097176701")) {
            ipChange.ipc$dispatch("-1097176701", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483221282")) {
            ipChange.ipc$dispatch("1483221282", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805617806")) {
            ipChange.ipc$dispatch("805617806", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        HomeTabScrollView access$getMTabLayout$p = WantSeeViewHolder.access$getMTabLayout$p(this.a);
        k21.f(access$getMTabLayout$p);
        access$getMTabLayout$p.selectTitle(i);
    }
}
