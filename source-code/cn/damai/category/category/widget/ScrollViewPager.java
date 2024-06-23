package cn.damai.category.category.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScrollViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;

    public ScrollViewPager(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1387384074")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1387384074", new Object[]{this, view, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "679726055")) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("679726055", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-207609507")) {
            return super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-207609507", new Object[]{this, motionEvent})).booleanValue();
    }

    public ScrollViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
