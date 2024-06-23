package cn.damai.message.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MessageListMainAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a = new ArrayList();
    private List<String> b = new ArrayList();

    public MessageListMainAdapter(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        super(fragmentManager);
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "901419672")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("901419672", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "206127022")) {
            return this.a.get(i);
        }
        return (Fragment) ipChange.ipc$dispatch("206127022", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1466090895")) {
            return super.getItemId(i);
        }
        return ((Long) ipChange.ipc$dispatch("1466090895", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-164601534")) {
            return this.b.get(i);
        }
        return (CharSequence) ipChange.ipc$dispatch("-164601534", new Object[]{this, Integer.valueOf(i)});
    }
}
