package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget.PagerExpression;
import java.util.List;

/* compiled from: Taobao */
public class ExpressionPageAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<PagerExpression> mListViews = null;

    public ExpressionPageAdapter(List<PagerExpression> list) {
        this.mListViews = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395596320")) {
            ipChange.ipc$dispatch("1395596320", new Object[]{this, view, Integer.valueOf(i), obj});
            return;
        }
        ((ViewPager) view).removeView(this.mListViews.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1741137700")) {
            return this.mListViews.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1741137700", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444541662")) {
            return ipChange.ipc$dispatch("444541662", new Object[]{this, view, Integer.valueOf(i)});
        }
        ((ViewPager) view).addView(this.mListViews.get(i), 0);
        return this.mListViews.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-471571936")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("-471571936", new Object[]{this, view, obj})).booleanValue();
    }
}
