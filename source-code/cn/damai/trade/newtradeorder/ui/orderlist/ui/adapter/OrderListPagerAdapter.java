package cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderListPagerAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String[] a;
    private final Fragment[] b;

    public OrderListPagerAdapter(FragmentActivity fragmentActivity, String[] strArr, Fragment[] fragmentArr) {
        super(fragmentActivity.getSupportFragmentManager());
        this.a = strArr;
        this.b = fragmentArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1146930847")) {
            return this.a.length;
        }
        return ((Integer) ipChange.ipc$dispatch("1146930847", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "800213703")) {
            return this.b[i];
        }
        return (Fragment) ipChange.ipc$dispatch("800213703", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-110373687")) {
            return this.a[i];
        }
        return (CharSequence) ipChange.ipc$dispatch("-110373687", new Object[]{this, Integer.valueOf(i)});
    }
}
