package com.scwang.smartrefresh.layout.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import tb.gd2;

/* compiled from: Taobao */
public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
    protected gd2 mSpinnerStyle;
    protected RefreshInternal mWrappedInternal;
    protected View mWrappedView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected InternalAbstract(@NonNull View view) {
        this(view, view instanceof RefreshInternal ? (RefreshInternal) view : null);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof RefreshInternal) || getView() != ((RefreshInternal) obj).getView()) {
            return false;
        }
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public gd2 getSpinnerStyle() {
        int i;
        gd2 gd2 = this.mSpinnerStyle;
        if (gd2 != null) {
            return gd2;
        }
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (!(refreshInternal == null || refreshInternal == this)) {
            return refreshInternal.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                gd2 gd22 = ((SmartRefreshLayout.LayoutParams) layoutParams).spinnerStyle;
                this.mSpinnerStyle = gd22;
                if (gd22 != null) {
                    return gd22;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                gd2[] gd2Arr = gd2.values;
                for (gd2 gd23 : gd2Arr) {
                    if (gd23.c) {
                        this.mSpinnerStyle = gd23;
                        return gd23;
                    }
                }
            }
        }
        gd2 gd24 = gd2.Translate;
        this.mSpinnerStyle = gd24;
        return gd24;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        return (refreshInternal == null || refreshInternal == this || !refreshInternal.isSupportHorizontalDrag()) ? false : true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return 0;
        }
        return refreshInternal.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float f, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onHorizontalDrag(f, i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            View view = this.mWrappedView;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    refreshKernel.requestDrawBackgroundFor(this, ((SmartRefreshLayout.LayoutParams) layoutParams).backgroundColor);
                    return;
                }
                return;
            }
            return;
        }
        refreshInternal.onInitialized(refreshKernel, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onMoving(z, f, i, i2, i3);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onReleased(refreshLayout, i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onStartAnimator(refreshLayout, i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof RefreshHeaderWrapper) && (refreshInternal instanceof RefreshFooter)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            RefreshInternal refreshInternal2 = this.mWrappedInternal;
            if (refreshInternal2 != null) {
                refreshInternal2.onStateChanged(refreshLayout, refreshState, refreshState2);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        return (refreshInternal instanceof RefreshFooter) && ((RefreshFooter) refreshInternal).setNoMoreData(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void setPrimaryColors(@ColorInt int... iArr) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.setPrimaryColors(iArr);
        }
    }

    protected InternalAbstract(@NonNull View view, @Nullable RefreshInternal refreshInternal) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = refreshInternal;
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader) && refreshInternal.getSpinnerStyle() == gd2.MatchLayout) {
            refreshInternal.getView().setScaleY(-1.0f);
        } else if (this instanceof RefreshHeaderWrapper) {
            RefreshInternal refreshInternal2 = this.mWrappedInternal;
            if ((refreshInternal2 instanceof RefreshFooter) && refreshInternal2.getSpinnerStyle() == gd2.MatchLayout) {
                refreshInternal.getView().setScaleY(-1.0f);
            }
        }
    }

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
