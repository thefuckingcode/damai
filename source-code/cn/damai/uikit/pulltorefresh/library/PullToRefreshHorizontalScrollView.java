package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView> {
    private static transient /* synthetic */ IpChange $ipChange;

    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalHorizontalScrollViewSDK9 extends HorizontalScrollView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalHorizontalScrollViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1015507957")) {
                return ((Integer) ipChange.ipc$dispatch("-1015507957", new Object[]{this})).intValue();
            } else if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight()));
            } else {
                return 0;
            }
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "696265662")) {
                return ((Boolean) ipChange.ipc$dispatch("696265662", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.c(PullToRefreshHorizontalScrollView.this, i, i3, i2, i4, getScrollRange(), z);
            return overScrollBy;
        }
    }

    public PullToRefreshHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2037616554")) {
            return PullToRefreshBase.Orientation.HORIZONTAL;
        }
        return (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("-2037616554", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219525294")) {
            return ((Boolean) ipChange.ipc$dispatch("-1219525294", new Object[]{this})).booleanValue();
        }
        View childAt = ((HorizontalScrollView) this.mRefreshableView).getChildAt(0);
        if (childAt == null || ((HorizontalScrollView) this.mRefreshableView).getScrollX() < childAt.getWidth() - getWidth()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "206500715")) {
            return ((HorizontalScrollView) this.mRefreshableView).getScrollX() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("206500715", new Object[]{this})).booleanValue();
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public HorizontalScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        HorizontalScrollView horizontalScrollView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80375540")) {
            return (HorizontalScrollView) ipChange.ipc$dispatch("-80375540", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            horizontalScrollView = new InternalHorizontalScrollViewSDK9(context, attributeSet);
        } else {
            horizontalScrollView = new HorizontalScrollView(context, attributeSet);
        }
        horizontalScrollView.setId(R$id.scrollview);
        return horizontalScrollView;
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
