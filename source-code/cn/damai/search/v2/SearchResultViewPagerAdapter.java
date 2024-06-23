package cn.damai.search.v2;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.damai.search.v2.bean.SearchResultTabBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.BaseViewPagerAdapter;

/* compiled from: Taobao */
public final class SearchResultViewPagerAdapter extends BaseViewPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Activity activity;

    public SearchResultViewPagerAdapter(Activity activity2, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.activity = activity2;
    }

    private SearchResultTabBean getTabItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-613190012")) {
            return (SearchResultTabBean) getData(i);
        }
        return (SearchResultTabBean) ipChange.ipc$dispatch("-613190012", new Object[]{this, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.BaseViewPagerAdapter
    public Fragment createFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088733607")) {
            return (Fragment) ipChange.ipc$dispatch("-2088733607", new Object[]{this, Integer.valueOf(i)});
        }
        return Fragment.instantiate(this.activity, getTabItem(i).fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-120075522")) {
            return getTabItem(i).title;
        }
        return (CharSequence) ipChange.ipc$dispatch("-120075522", new Object[]{this, Integer.valueOf(i)});
    }
}
