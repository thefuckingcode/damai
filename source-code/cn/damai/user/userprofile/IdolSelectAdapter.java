package cn.damai.user.userprofile;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.damai.user.userprofile.bean.IdolData;
import cn.damai.user.userprofile.bean.IdolSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class IdolSelectAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<IdolSelectFragment> a = new ArrayList();
    private Object[] b = new Object[5];
    Map<Integer, List<IdolData>> c;

    public IdolSelectAdapter(FragmentManager fragmentManager, List<IdolSelectFragment> list, Object[] objArr) {
        super(fragmentManager);
        this.a = list;
        this.b = objArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1087902024")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1087902024", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-231186546")) {
            return this.a.get(i);
        }
        return (Fragment) ipChange.ipc$dispatch("-231186546", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "988387759")) {
            return super.getItemId(i);
        }
        return ((Long) ipChange.ipc$dispatch("988387759", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-685717943")) {
            return -2;
        }
        return ((Integer) ipChange.ipc$dispatch("-685717943", new Object[]{this, obj})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708332898")) {
            return (CharSequence) ipChange.ipc$dispatch("708332898", new Object[]{this, Integer.valueOf(i)});
        }
        return this.b[i] + "";
    }

    @Override // androidx.viewpager.widget.PagerAdapter, androidx.fragment.app.FragmentPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279321059")) {
            return ipChange.ipc$dispatch("-279321059", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        IdolSelectFragment idolSelectFragment = (IdolSelectFragment) super.instantiateItem(viewGroup, i);
        Map<Integer, List<IdolData>> map = this.c;
        if (map == null) {
            return idolSelectFragment;
        }
        List<IdolData> list = map.get(Integer.valueOf(i));
        if (idolSelectFragment.getArguments() != null) {
            idolSelectFragment.getArguments().putSerializable("data", (Serializable) list);
            idolSelectFragment.getArguments().putString("type", IdolSelectRequest.tabIds.get(i));
        }
        return idolSelectFragment;
    }
}
