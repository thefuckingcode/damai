package cn.damai.ticklet.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class TickletMyCommentAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;

    public TickletMyCommentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-702464318")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-702464318", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1577611708")) {
            return this.a.get(i);
        }
        return (Fragment) ipChange.ipc$dispatch("-1577611708", new Object[]{this, Integer.valueOf(i)});
    }
}
