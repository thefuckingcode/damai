package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class TitleViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<View> list;
    private List<String> titles;

    public TitleViewPagerAdapter(List<View> list2) {
        this.list = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694328632")) {
            ipChange.ipc$dispatch("1694328632", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        List<View> list2 = this.list;
        if (list2 != null && list2.size() > i) {
            viewGroup.removeView(this.list.get(i));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-721001905")) {
            return this.list.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-721001905", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685508729")) {
            return (CharSequence) ipChange.ipc$dispatch("685508729", new Object[]{this, Integer.valueOf(i)});
        }
        List<String> list2 = this.titles;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        return this.titles.get(i);
    }

    public View getView(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1079291051")) {
            return this.list.get(i);
        }
        return (View) ipChange.ipc$dispatch("1079291051", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240256358")) {
            return ipChange.ipc$dispatch("1240256358", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        List<View> list2 = this.list;
        if (list2 == null || list2.size() <= i) {
            return null;
        }
        viewGroup.addView(this.list.get(i));
        return this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1592676565")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("1592676565", new Object[]{this, view, obj})).booleanValue();
    }

    public TitleViewPagerAdapter(List<View> list2, List<String> list3) {
        this.list = list2;
        this.titles = list3;
    }
}
