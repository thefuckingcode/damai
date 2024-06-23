package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class GiftViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<? extends GiftBaseView> list;
    private List<String> titles;

    public GiftViewPagerAdapter(List<? extends GiftBaseView> list2, List<String> list3) {
        this.list = list2;
        this.titles = list3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104327466")) {
            ipChange.ipc$dispatch("104327466", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        viewGroup.removeView((View) this.list.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763154881")) {
            return this.list.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1763154881", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417432299")) {
            return (CharSequence) ipChange.ipc$dispatch("417432299", new Object[]{this, Integer.valueOf(i)});
        }
        List<String> list2 = this.titles;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        return this.titles.get(i);
    }

    public GiftStarItemView getStarItemView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374979924")) {
            return (GiftStarItemView) ipChange.ipc$dispatch("1374979924", new Object[]{this});
        }
        List<? extends GiftBaseView> list2 = this.list;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        for (int i = 0; i < this.list.size(); i++) {
            GiftBaseView giftBaseView = (GiftBaseView) this.list.get(i);
            if (giftBaseView != null) {
                Iterator<CommonAdapter<T>> it = giftBaseView.mCategoryAllAdapterGV.keySet().iterator();
                while (it.hasNext()) {
                    GiftShowAdapter giftShowAdapter = (GiftShowAdapter) it.next();
                    if (!(giftShowAdapter.getCurrentSelectedView() == null || giftShowAdapter.getCheckedBean() == null || giftShowAdapter.getCheckedBean().girdViewType != 1 || !giftShowAdapter.getCheckedBean().isChecked || giftShowAdapter.getCurrentSelectedView() == null)) {
                        return (GiftStarItemView) giftShowAdapter.getCurrentSelectedView();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public View getView(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-674681443")) {
            return (View) this.list.get(i);
        }
        return (View) ipChange.ipc$dispatch("-674681443", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1585139660")) {
            return ipChange.ipc$dispatch("-1585139660", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        viewGroup.addView((View) this.list.get(i), new ViewGroup.LayoutParams(-1, -1));
        return this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-398276445")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("-398276445", new Object[]{this, view, obj})).booleanValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197415362")) {
            ipChange.ipc$dispatch("197415362", new Object[]{this});
            return;
        }
        super.notifyDataSetChanged();
        ((ILog) Dsl.getService(ILog.class)).i("liulei-datachange", "GiftViewPagerAdapter notifyDataSetChanged");
    }
}
