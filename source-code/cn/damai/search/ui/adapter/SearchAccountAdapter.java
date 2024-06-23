package cn.damai.search.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchAccountAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private String[] a;
    private DamaiBaseMvpFragment[] b;

    public SearchAccountAdapter(FragmentActivity fragmentActivity, String[] strArr, DamaiBaseMvpFragment[] damaiBaseMvpFragmentArr) {
        super(fragmentActivity.getSupportFragmentManager());
        this.a = strArr;
        this.b = damaiBaseMvpFragmentArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1385704496")) {
            return this.a.length;
        }
        return ((Integer) ipChange.ipc$dispatch("-1385704496", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-373172362")) {
            return this.b[i];
        }
        return (Fragment) ipChange.ipc$dispatch("-373172362", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1428414854")) {
            return this.a[i];
        }
        return (CharSequence) ipChange.ipc$dispatch("-1428414854", new Object[]{this, Integer.valueOf(i)});
    }
}
