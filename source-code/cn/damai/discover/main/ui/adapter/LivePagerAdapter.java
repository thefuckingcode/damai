package cn.damai.discover.main.ui.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class LivePagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;
    private Fragment b;

    public LivePagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public Fragment a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1412326556")) {
            return this.b;
        }
        return (Fragment) ipChange.ipc$dispatch("-1412326556", new Object[]{this});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83406583")) {
            return ((Integer) ipChange.ipc$dispatch("83406583", new Object[]{this})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1506846865")) {
            return (Fragment) ipChange.ipc$dispatch("-1506846865", new Object[]{this, Integer.valueOf(i)});
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
        if (!AndroidInstantRuntime.support(ipChange, "774077162")) {
            return -2;
        }
        return ((Integer) ipChange.ipc$dispatch("774077162", new Object[]{this, obj})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-119470146")) {
            return (Fragment) super.instantiateItem(viewGroup, i);
        }
        return ipChange.ipc$dispatch("-119470146", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153463402")) {
            ipChange.ipc$dispatch("-1153463402", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        this.b = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
