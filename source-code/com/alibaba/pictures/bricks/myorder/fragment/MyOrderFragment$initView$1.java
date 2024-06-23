package com.alibaba.pictures.bricks.myorder.fragment;

import androidx.viewpager.widget.ViewPager;
import com.alibaba.pictures.bricks.view.EqualLinearView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k21;
import tb.vm1;

/* compiled from: Taobao */
public final class MyOrderFragment$initView$1 implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MyOrderFragment a;

    MyOrderFragment$initView$1(MyOrderFragment myOrderFragment) {
        this.a = myOrderFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1381289502")) {
            ipChange.ipc$dispatch("-1381289502", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "916111489")) {
            ipChange.ipc$dispatch("916111489", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711173037")) {
            ipChange.ipc$dispatch("711173037", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        EqualLinearView equalLinearView = this.a.tabLayout;
        if (equalLinearView == null) {
            k21.A("tabLayout");
            equalLinearView = null;
        }
        equalLinearView.selectTitle(i);
        vm1.INSTANCE.g(i != 0 ? i != 1 ? i != 2 ? "unkonwn" : "pay" : "usable" : "all", this.a.userCode);
    }
}
