package cn.damai.rank.view;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public final class WantSeeIconUpdate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isFollow;
    @Nullable
    private View.OnClickListener listener;
    private boolean playAnimate;
    private boolean showWantSeeIcon;

    public WantSeeIconUpdate(boolean z, boolean z2, boolean z3, @Nullable View.OnClickListener onClickListener) {
        this.showWantSeeIcon = z;
        this.isFollow = z2;
        this.playAnimate = z3;
        this.listener = onClickListener;
    }

    @Nullable
    public final View.OnClickListener getListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2060134737")) {
            return this.listener;
        }
        return (View.OnClickListener) ipChange.ipc$dispatch("2060134737", new Object[]{this});
    }

    public final boolean getPlayAnimate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1329533883")) {
            return this.playAnimate;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1329533883", new Object[]{this})).booleanValue();
    }

    public final boolean getShowWantSeeIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1364956269")) {
            return this.showWantSeeIcon;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1364956269", new Object[]{this})).booleanValue();
    }

    public final boolean isFollow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "103607905")) {
            return this.isFollow;
        }
        return ((Boolean) ipChange.ipc$dispatch("103607905", new Object[]{this})).booleanValue();
    }

    public final void setFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902580043")) {
            ipChange.ipc$dispatch("-902580043", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFollow = z;
    }

    public final void setListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815808349")) {
            ipChange.ipc$dispatch("815808349", new Object[]{this, onClickListener});
            return;
        }
        this.listener = onClickListener;
    }

    public final void setPlayAnimate(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640765401")) {
            ipChange.ipc$dispatch("-1640765401", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.playAnimate = z;
    }

    public final void setShowWantSeeIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949202585")) {
            ipChange.ipc$dispatch("1949202585", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showWantSeeIcon = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeeIconUpdate(boolean z, boolean z2, boolean z3, View.OnClickListener onClickListener, int i, m40 m40) {
        this(z, z2, z3, (i & 8) != 0 ? null : onClickListener);
    }
}
