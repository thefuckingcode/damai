package com.scwang.smartrefresh.header.fungame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import tb.gd2;

@SuppressLint({"RestrictedApi"})
/* compiled from: Taobao */
public abstract class FunGameBase extends InternalAbstract implements RefreshHeader {
    boolean enableLoadMore;
    protected int mHeaderHeight;
    protected boolean mIsFinish;
    protected boolean mLastFinish;
    protected boolean mManualOperation;
    protected int mOffset;
    protected RefreshContent mRefreshContent;
    protected RefreshKernel mRefreshKernel;
    protected int mScreenHeightPixels = DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
    protected RefreshState mState;
    protected float mTouchY;

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMinimumHeight(DensityUtil.dp2px(100.0f));
        this.mSpinnerStyle = gd2.MatchLayout;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mLastFinish = z;
        if (!this.mIsFinish) {
            this.mIsFinish = true;
            if (this.mManualOperation) {
                if (this.mTouchY != -1.0f) {
                    return Integer.MAX_VALUE;
                }
                onManualOperationRelease();
                onFinish(refreshLayout, z);
                return 0;
            }
        }
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        this.mHeaderHeight = i;
        if (!isInEditMode()) {
            setTranslationY((float) (this.mOffset - this.mHeaderHeight));
            refreshKernel.requestNeedTouchEventFor(this, true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mState == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public abstract void onManualOperationMove(float f, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public void onManualOperationRelease() {
        if (this.mIsFinish) {
            this.mManualOperation = false;
            this.mRefreshKernel.getRefreshLayout().setEnableLoadMore(this.enableLoadMore);
            if (this.mTouchY != -1.0f) {
                onFinish(this.mRefreshKernel.getRefreshLayout(), this.mLastFinish);
                this.mRefreshKernel.setState(RefreshState.RefreshFinish);
                this.mRefreshKernel.animSpinner(0);
            } else {
                this.mRefreshKernel.moveSpinner(this.mHeaderHeight, true);
            }
            View view = this.mRefreshContent.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin -= this.mHeaderHeight;
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        this.mRefreshKernel.moveSpinner(0, true);
    }

    /* access modifiers changed from: protected */
    public void onManualOperationStart() {
        if (!this.mManualOperation) {
            this.mManualOperation = true;
            this.mRefreshContent = this.mRefreshKernel.getRefreshContent();
            this.enableLoadMore = this.mRefreshKernel.getRefreshLayout().isEnableLoadMore();
            this.mRefreshKernel.getRefreshLayout().setEnableLoadMore(false);
            View view = this.mRefreshContent.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin += this.mHeaderHeight;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (this.mManualOperation) {
            onManualOperationMove(f, i, i2, i3);
            return;
        }
        this.mOffset = i;
        setTranslationY((float) (i - this.mHeaderHeight));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mIsFinish = false;
        setTranslationY(0.0f);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        this.mState = refreshState2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState = this.mState;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mManualOperation) {
            onManualOperationStart();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.mTouchY;
                    if (rawY >= 0.0f) {
                        double max = Math.max(0.0d, ((double) rawY) * 0.5d);
                        this.mRefreshKernel.moveSpinner((int) Math.min(((double) (this.mHeaderHeight * 2)) * (1.0d - Math.pow(100.0d, (-max) / ((double) ((this.mScreenHeightPixels * 2) / 3)))), max), false);
                    } else {
                        double d = -Math.min(0.0d, ((double) rawY) * 0.5d);
                        this.mRefreshKernel.moveSpinner((int) (-Math.min(((double) (this.mHeaderHeight * 2)) * (1.0d - Math.pow(100.0d, (-d) / ((double) ((this.mScreenHeightPixels * 2) / 3)))), d)), false);
                    }
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            onManualOperationRelease();
            this.mTouchY = -1.0f;
            if (this.mIsFinish) {
                this.mRefreshKernel.moveSpinner(this.mHeaderHeight, true);
                return true;
            }
            return true;
        }
        this.mTouchY = motionEvent.getRawY();
        this.mRefreshKernel.moveSpinner(0, true);
        return true;
    }
}
