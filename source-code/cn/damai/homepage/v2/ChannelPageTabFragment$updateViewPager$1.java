package cn.damai.homepage.v2;

import android.annotation.SuppressLint;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class ChannelPageTabFragment$updateViewPager$1 implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ChannelPageTabFragment a;

    ChannelPageTabFragment$updateViewPager$1(ChannelPageTabFragment channelPageTabFragment) {
        this.a = channelPageTabFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977562470")) {
            ipChange.ipc$dispatch("977562470", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    @SuppressLint({"NewApi"})
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171425285")) {
            ipChange.ipc$dispatch("171425285", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1519766991")) {
            ipChange.ipc$dispatch("-1519766991", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a.changePage(i);
    }
}
