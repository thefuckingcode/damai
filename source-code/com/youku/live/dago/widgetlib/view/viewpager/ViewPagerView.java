package com.youku.live.dago.widgetlib.view.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ViewPagerView extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_PROGRESS = 1000;
    private boolean mScrollEnabled = true;

    public ViewPagerView(Context context) {
        super(context);
        setAdapter(new Adapter());
    }

    /* access modifiers changed from: package-private */
    public void addViewToAdapter(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922694697")) {
            ipChange.ipc$dispatch("1922694697", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        getAdapter().addView(view, i);
    }

    /* access modifiers changed from: package-private */
    public int getIndexFromAdapter(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "294900810")) {
            return getAdapter().mViews.indexOf(view);
        }
        return ((Integer) ipChange.ipc$dispatch("294900810", new Object[]{this, view})).intValue();
    }

    /* access modifiers changed from: package-private */
    public int getViewCountInAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-915434719")) {
            return getAdapter().getCount();
        }
        return ((Integer) ipChange.ipc$dispatch("-915434719", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: package-private */
    public View getViewFromAdapter(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1277693655")) {
            return getAdapter().getViewAt(i);
        }
        return (View) ipChange.ipc$dispatch("-1277693655", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1264000575")) {
            return this.mScrollEnabled && super.onInterceptTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("1264000575", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320268795")) {
            return ((Boolean) ipChange.ipc$dispatch("-1320268795", new Object[]{this, motionEvent})).booleanValue();
        } else if (!this.mScrollEnabled) {
            return false;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeViewFromAdapter(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205323658")) {
            ipChange.ipc$dispatch("1205323658", new Object[]{this, view});
            return;
        }
        getAdapter().removeView(view);
    }

    public void setScrollEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247357568")) {
            ipChange.ipc$dispatch("247357568", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mScrollEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void addViewToAdapter(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877641190")) {
            ipChange.ipc$dispatch("-1877641190", new Object[]{this, view});
            return;
        }
        getAdapter().addView(view);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public Adapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1189006948")) {
            return (Adapter) super.getAdapter();
        }
        return (Adapter) ipChange.ipc$dispatch("-1189006948", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class Adapter extends PagerAdapter {
        private List<View> mViews = new ArrayList();

        Adapter() {
        }

        /* access modifiers changed from: package-private */
        public void addView(View view) {
            this.mViews.add(view);
            notifyDataSetChanged();
            ViewPagerView.this.setOffscreenPageLimit(this.mViews.size());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return this.mViews.indexOf(obj) >= 0 ? -1 : -2;
        }

        /* access modifiers changed from: package-private */
        public View getViewAt(int i) {
            return this.mViews.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.mViews.get(i);
            if (viewGroup.indexOfChild(view) < 0) {
                viewGroup.addView(view, 0, ViewPagerView.this.generateDefaultLayoutParams());
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* access modifiers changed from: package-private */
        public void removeView(View view) {
            this.mViews.remove(view);
            notifyDataSetChanged();
            ViewPagerView.this.setOffscreenPageLimit(this.mViews.size());
        }

        /* access modifiers changed from: package-private */
        public void removeViewAt(int i) {
            this.mViews.remove(i);
            notifyDataSetChanged();
            ViewPagerView.this.setOffscreenPageLimit(this.mViews.size());
        }

        /* access modifiers changed from: package-private */
        public void addView(View view, int i) {
            this.mViews.add(i, view);
            notifyDataSetChanged();
            ViewPagerView.this.setOffscreenPageLimit(this.mViews.size());
        }
    }
}
