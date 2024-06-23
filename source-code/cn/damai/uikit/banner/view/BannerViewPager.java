package cn.damai.uikit.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BannerViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean scrollable = true;

    public BannerViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1938498323")) {
            return this.scrollable && super.onInterceptTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1938498323", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645181847")) {
            return this.scrollable && super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("645181847", new Object[]{this, motionEvent})).booleanValue();
    }

    public void setScrollable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469330955")) {
            ipChange.ipc$dispatch("1469330955", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.scrollable = z;
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
