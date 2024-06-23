package cn.damai.uikit.calendar;

import android.content.Context;
import android.view.MotionEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CalendarPager extends BetterViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean pagingEnabled = true;

    public CalendarPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScrollHorizontally(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1562470716")) {
            return this.pagingEnabled && super.canScrollHorizontally(i);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1562470716", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    public boolean canScrollVertically(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1822871766")) {
            return this.pagingEnabled && super.canScrollVertically(i);
        }
        return ((Boolean) ipChange.ipc$dispatch("1822871766", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    public boolean isPagingEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "255429514")) {
            return this.pagingEnabled;
        }
        return ((Boolean) ipChange.ipc$dispatch("255429514", new Object[]{this})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1453029996")) {
            return this.pagingEnabled && super.onInterceptTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("1453029996", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1302468920")) {
            return this.pagingEnabled && super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("1302468920", new Object[]{this, motionEvent})).booleanValue();
    }

    public void setPagingEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984642738")) {
            ipChange.ipc$dispatch("-984642738", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.pagingEnabled = z;
    }
}
