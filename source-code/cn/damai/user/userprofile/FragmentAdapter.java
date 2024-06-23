package cn.damai.user.userprofile;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FragmentAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a = new ArrayList();

    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326890673")) {
            ipChange.ipc$dispatch("-326890673", new Object[]{this, fragment});
            return;
        }
        this.a.add(fragment);
        notifyDataSetChanged();
    }

    public List<Fragment> b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1885478158")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("-1885478158", new Object[]{this});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1333921724")) {
            return ((Integer) ipChange.ipc$dispatch("1333921724", new Object[]{this})).intValue();
        }
        List<Fragment> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1382275574")) {
            return this.a.get(i);
        }
        return (Fragment) ipChange.ipc$dispatch("-1382275574", new Object[]{this, Integer.valueOf(i)});
    }
}
