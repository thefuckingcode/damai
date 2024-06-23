package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.commonbusiness.view.DmViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bw2;

/* compiled from: Taobao */
public class CustomViewPager extends DmViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    PointF curP = new PointF();
    PointF downP = new PointF();
    private bw2 helper = new bw2(this);

    public CustomViewPager(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870524287")) {
            ipChange.ipc$dispatch("1870524287", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, cn.damai.commonbusiness.view.DmViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1019516917")) {
            return super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1019516917", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934953761")) {
            ipChange.ipc$dispatch("934953761", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setCurrentItem(i, true);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081158701")) {
            ipChange.ipc$dispatch("-1081158701", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        bw2 bw2 = this.helper;
        if (bw2 == null || bw2.a() == null) {
            super.setCurrentItem(i, z);
            return;
        }
        ViewPagerScroller a = this.helper.a();
        if (Math.abs(getCurrentItem() - i) > 1) {
            a.setNoDuration(true);
            super.setCurrentItem(i, z);
            a.setNoDuration(false);
            return;
        }
        a.setNoDuration(false);
        super.setCurrentItem(i, z);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
