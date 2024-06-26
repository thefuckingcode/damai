package cn.damai.uikit.calendar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BetterViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;

    public BetterViewPager(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void setChildrenDrawingOrderEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046454658")) {
            ipChange.ipc$dispatch("2046454658", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setChildrenDrawingOrderEnabled(z);
    }

    public BetterViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
