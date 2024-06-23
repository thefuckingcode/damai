package cn.damai.category.category.ui.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;
    private Fragment b;

    public CategoryPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546788510")) {
            ipChange.ipc$dispatch("-1546788510", new Object[]{this});
            return;
        }
        List<Fragment> list = this.a;
        if (list != null) {
            list.clear();
            this.a = null;
        }
    }

    public Fragment b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "924310466")) {
            return this.b;
        }
        return (Fragment) ipChange.ipc$dispatch("924310466", new Object[]{this});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119737127")) {
            return ((Integer) ipChange.ipc$dispatch("-119737127", new Object[]{this})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1905972557")) {
            return (Fragment) ipChange.ipc$dispatch("1905972557", new Object[]{this, Integer.valueOf(i)});
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
        if (!AndroidInstantRuntime.support(ipChange, "-670943416")) {
            return -2;
        }
        return ((Integer) ipChange.ipc$dispatch("-670943416", new Object[]{this, obj})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1795688988")) {
            return (Fragment) super.instantiateItem(viewGroup, i);
        }
        return ipChange.ipc$dispatch("1795688988", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentStatePagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761695732")) {
            ipChange.ipc$dispatch("761695732", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        this.b = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
