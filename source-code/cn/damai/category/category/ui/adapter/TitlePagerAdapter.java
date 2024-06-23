package cn.damai.category.category.ui.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class TitlePagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846463067")) {
            return ((Integer) ipChange.ipc$dispatch("1846463067", new Object[]{this})).intValue();
        }
        List<Fragment> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470888565")) {
            return (Fragment) ipChange.ipc$dispatch("-470888565", new Object[]{this, Integer.valueOf(i)});
        }
        List<Fragment> list = this.a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1367984122")) {
            return -2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1367984122", new Object[]{this, obj})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1096102106")) {
            return (Fragment) super.instantiateItem(viewGroup, i);
        }
        return ipChange.ipc$dispatch("1096102106", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
