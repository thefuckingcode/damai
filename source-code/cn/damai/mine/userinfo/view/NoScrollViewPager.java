package cn.damai.mine.userinfo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NoScrollViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1463069491")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1463069491", new Object[]{this, motionEvent})).booleanValue();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-656548425")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-656548425", new Object[]{this, motionEvent})).booleanValue();
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
