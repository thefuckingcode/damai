package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class InternalExpandableListView extends ExpandableListView implements EmptyViewMethodAccessor {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalExpandableListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-156217233")) {
                ipChange.ipc$dispatch("-156217233", new Object[]{this, view});
                return;
            }
            PullToRefreshExpandableListView.this.setEmptyView(view);
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "305460620")) {
                ipChange.ipc$dispatch("305460620", new Object[]{this, view});
                return;
            }
            super.setEmptyView(view);
        }
    }

    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalExpandableListViewSDK9 extends InternalExpandableListView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalExpandableListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-306556642")) {
                return ((Boolean) ipChange.ipc$dispatch("-306556642", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.d(PullToRefreshExpandableListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshExpandableListView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "943125047")) {
            return PullToRefreshBase.Orientation.VERTICAL;
        }
        return (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("943125047", new Object[]{this});
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public ExpandableListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ExpandableListView expandableListView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908035830")) {
            return (ExpandableListView) ipChange.ipc$dispatch("-908035830", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            expandableListView = new InternalExpandableListViewSDK9(context, attributeSet);
        } else {
            expandableListView = new InternalExpandableListView(context, attributeSet);
        }
        expandableListView.setId(16908298);
        return expandableListView;
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
