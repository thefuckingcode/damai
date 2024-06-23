package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import com.baseproject.ui.R$id;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.youku.widget.HeaderGridView;

/* compiled from: Taobao */
public class PullToRefreshHeaderGridView extends PullToRefreshAdapterViewBase<HeaderGridView> {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class InternalGridView extends HeaderGridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshHeaderGridView.this.setEmptyView(view);
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalGridViewSDK9 extends InternalGridView {
        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            a.d(PullToRefreshHeaderGridView.this, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshHeaderGridView(Context context) {
        super(context);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalGridView) getRefreshableView()).getContextMenuInfo();
    }

    public PullToRefreshHeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final HeaderGridView createRefreshableView(Context context, AttributeSet attributeSet) {
        HeaderGridView headerGridView;
        if (Build.VERSION.SDK_INT >= 9) {
            headerGridView = new InternalGridViewSDK9(context, attributeSet);
        } else {
            headerGridView = new InternalGridView(context, attributeSet);
        }
        headerGridView.setId(R$id.gridview);
        return headerGridView;
    }

    public PullToRefreshHeaderGridView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }
}
