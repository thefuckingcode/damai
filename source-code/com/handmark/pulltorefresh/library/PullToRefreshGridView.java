package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.GridView;
import com.baseproject.ui.R$id;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

/* compiled from: Taobao */
public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshGridView.this.setEmptyView(view);
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
            a.d(PullToRefreshGridView.this, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshGridView(Context context) {
        super(context);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalGridView) getRefreshableView()).getContextMenuInfo();
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        GridView gridView;
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
}
