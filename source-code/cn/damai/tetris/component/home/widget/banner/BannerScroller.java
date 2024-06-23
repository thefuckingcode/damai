package cn.damai.tetris.component.home.widget.banner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BannerScroller extends Scroller {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mDuration = 800;

    public BannerScroller(Context context) {
        super(context);
    }

    public void setDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091958931")) {
            ipChange.ipc$dispatch("-1091958931", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDuration = i;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057192038")) {
            ipChange.ipc$dispatch("2057192038", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451833405")) {
            ipChange.ipc$dispatch("1451833405", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public BannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public BannerScroller(Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
    }
}
