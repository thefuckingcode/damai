package cn.damai.videobrowse.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.commonbusiness.view.DmViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ControlScrollViewPager extends DmViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean canScroll;

    public ControlScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-871967662")) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-871967662", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager, cn.damai.commonbusiness.view.DmViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75847991")) {
            return ((Boolean) ipChange.ipc$dispatch("75847991", new Object[]{this, motionEvent})).booleanValue();
        } else if (this.canScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, cn.damai.commonbusiness.view.DmViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960190989")) {
            return ((Boolean) ipChange.ipc$dispatch("960190989", new Object[]{this, motionEvent})).booleanValue();
        } else if (this.canScroll) {
            return super.onTouchEvent(motionEvent);
        } else {
            return true;
        }
    }

    public void setScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026728921")) {
            ipChange.ipc$dispatch("-1026728921", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.canScroll = z;
    }

    public ControlScrollViewPager(Context context) {
        super(context);
    }
}
