package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1821695249")) {
                ipChange.ipc$dispatch("-1821695249", new Object[]{this, view});
                return;
            }
            PullToRefreshGridView.this.setEmptyView(view);
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1707784180")) {
                ipChange.ipc$dispatch("-1707784180", new Object[]{this, view});
                return;
            }
            super.setEmptyView(view);
        }
    }

    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalGridViewSDK9 extends InternalGridView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "430244766")) {
                return ((Boolean) ipChange.ipc$dispatch("430244766", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.d(PullToRefreshGridView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshGridView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "444411531")) {
            return PullToRefreshBase.Orientation.VERTICAL;
        }
        return (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("444411531", new Object[]{this});
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        GridView gridView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419677022")) {
            return (GridView) ipChange.ipc$dispatch("-419677022", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            gridView = new InternalGridViewSDK9(context, attributeSet);
        } else {
            gridView = new InternalGridView(context, attributeSet);
        }
        gridView.setId(R$id.gridview);
        return gridView;
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
