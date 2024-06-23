package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.gd2;

/* compiled from: Taobao */
public class TwoLevelHeader extends InternalAbstract implements RefreshHeader {
    protected boolean mEnablePullToCloseTwoLevel;
    protected boolean mEnableTwoLevel;
    protected int mFloorDuration;
    protected float mFloorRage;
    protected int mHeaderHeight;
    protected float mMaxRage;
    protected float mPercent;
    protected RefreshInternal mRefreshHeader;
    protected RefreshKernel mRefreshKernel;
    protected float mRefreshRage;
    protected int mSpinner;
    protected OnTwoLevelListener mTwoLevelListener;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.TwoLevelReleased.ordinal()] = 1;
            a[RefreshState.TwoLevel.ordinal()] = 2;
            a[RefreshState.TwoLevelFinish.ordinal()] = 3;
            try {
                a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        return (refreshInternal != null && refreshInternal.equals(obj)) || super.equals(obj);
    }

    public TwoLevelHeader finishTwoLevel() {
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.finishTwoLevel();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void moveSpinner(int i) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (this.mSpinner != i && refreshInternal != null) {
            this.mSpinner = i;
            gd2 spinnerStyle = refreshInternal.getSpinnerStyle();
            if (spinnerStyle == gd2.Translate) {
                refreshInternal.getView().setTranslationY((float) i);
            } else if (spinnerStyle.c) {
                View view = refreshInternal.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSpinnerStyle = gd2.MatchLayout;
        if (this.mRefreshHeader == null) {
            setRefreshHeader(new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mSpinnerStyle = gd2.FixedBehind;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof RefreshHeader) {
                this.mRefreshHeader = (RefreshHeader) childAt;
                this.mWrappedInternal = (RefreshInternal) childAt;
                bringChildToFront(childAt);
                break;
            }
            i++;
        }
        if (this.mRefreshHeader == null) {
            setRefreshHeader(new ClassicsHeader(getContext()));
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            if ((((float) (i2 + i)) * 1.0f) / ((float) i) != this.mMaxRage && this.mHeaderHeight == 0) {
                this.mHeaderHeight = i;
                this.mRefreshHeader = null;
                refreshKernel.getRefreshLayout().setHeaderMaxDragRate(this.mMaxRage);
                this.mRefreshHeader = refreshInternal;
            }
            if (this.mRefreshKernel == null && refreshInternal.getSpinnerStyle() == gd2.Translate && !isInEditMode()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) refreshInternal.getView().getLayoutParams();
                marginLayoutParams.topMargin -= i;
                refreshInternal.getView().setLayoutParams(marginLayoutParams);
            }
            this.mHeaderHeight = i;
            this.mRefreshKernel = refreshKernel;
            refreshKernel.requestFloorDuration(this.mFloorDuration);
            refreshKernel.requestNeedTouchEventFor(this, !this.mEnablePullToCloseTwoLevel);
            refreshInternal.onInitialized(refreshKernel, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal == null) {
            super.onMeasure(i, i2);
        } else if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            refreshInternal.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), refreshInternal.getView().getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        moveSpinner(i);
        RefreshInternal refreshInternal = this.mRefreshHeader;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshInternal != null) {
            refreshInternal.onMoving(z, f, i, i2, i3);
        }
        if (z) {
            float f2 = this.mPercent;
            float f3 = this.mFloorRage;
            if (f2 < f3 && f >= f3 && this.mEnableTwoLevel) {
                refreshKernel.setState(RefreshState.ReleaseToTwoLevel);
            } else if (f2 >= f3 && f < this.mRefreshRage) {
                refreshKernel.setState(RefreshState.PullDownToRefresh);
            } else if (f2 >= f3 && f < f3) {
                refreshKernel.setState(RefreshState.ReleaseToRefresh);
            }
            this.mPercent = f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            refreshInternal.onStateChanged(refreshLayout, refreshState, refreshState2);
            int i = a.a[refreshState2.ordinal()];
            boolean z = true;
            if (i == 1) {
                if (refreshInternal.getView() != this) {
                    refreshInternal.getView().animate().alpha(0.0f).setDuration((long) (this.mFloorDuration / 2));
                }
                RefreshKernel refreshKernel = this.mRefreshKernel;
                if (refreshKernel != null) {
                    OnTwoLevelListener onTwoLevelListener = this.mTwoLevelListener;
                    if (onTwoLevelListener != null && !onTwoLevelListener.onTwoLevel(refreshLayout)) {
                        z = false;
                    }
                    refreshKernel.startTwoLevel(z);
                }
            } else if (i != 3) {
                if (i == 4 && refreshInternal.getView().getAlpha() == 0.0f && refreshInternal.getView() != this) {
                    refreshInternal.getView().setAlpha(1.0f);
                }
            } else if (refreshInternal.getView() != this) {
                refreshInternal.getView().animate().alpha(1.0f).setDuration((long) (this.mFloorDuration / 2));
            }
        }
    }

    public TwoLevelHeader openTwoLevel(boolean z) {
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            OnTwoLevelListener onTwoLevelListener = this.mTwoLevelListener;
            refreshKernel.startTwoLevel(!z || onTwoLevelListener == null || onTwoLevelListener.onTwoLevel(refreshKernel.getRefreshLayout()));
        }
        return this;
    }

    public TwoLevelHeader setEnablePullToCloseTwoLevel(boolean z) {
        RefreshKernel refreshKernel = this.mRefreshKernel;
        this.mEnablePullToCloseTwoLevel = z;
        if (refreshKernel != null) {
            refreshKernel.requestNeedTouchEventFor(this, !z);
        }
        return this;
    }

    public TwoLevelHeader setEnableTwoLevel(boolean z) {
        this.mEnableTwoLevel = z;
        return this;
    }

    public TwoLevelHeader setFloorDuration(int i) {
        this.mFloorDuration = i;
        return this;
    }

    public TwoLevelHeader setFloorRage(float f) {
        this.mFloorRage = f;
        return this;
    }

    public TwoLevelHeader setMaxRage(float f) {
        if (this.mMaxRage != f) {
            this.mMaxRage = f;
            RefreshKernel refreshKernel = this.mRefreshKernel;
            if (refreshKernel != null) {
                this.mHeaderHeight = 0;
                refreshKernel.getRefreshLayout().setHeaderMaxDragRate(this.mMaxRage);
            }
        }
        return this;
    }

    public TwoLevelHeader setOnTwoLevelListener(OnTwoLevelListener onTwoLevelListener) {
        this.mTwoLevelListener = onTwoLevelListener;
        return this;
    }

    public TwoLevelHeader setRefreshHeader(RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    public TwoLevelHeader setRefreshRage(float f) {
        this.mRefreshRage = f;
        return this;
    }

    public TwoLevelHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mPercent = 0.0f;
        this.mMaxRage = 2.5f;
        this.mFloorRage = 1.9f;
        this.mRefreshRage = 1.0f;
        this.mEnableTwoLevel = true;
        this.mEnablePullToCloseTwoLevel = true;
        this.mFloorDuration = 1000;
        this.mSpinnerStyle = gd2.FixedBehind;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TwoLevelHeader);
        this.mMaxRage = obtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlMaxRage, this.mMaxRage);
        this.mFloorRage = obtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlFloorRage, this.mFloorRage);
        this.mRefreshRage = obtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlRefreshRage, this.mRefreshRage);
        this.mFloorDuration = obtainStyledAttributes.getInt(R$styleable.TwoLevelHeader_srlFloorDuration, this.mFloorDuration);
        this.mEnableTwoLevel = obtainStyledAttributes.getBoolean(R$styleable.TwoLevelHeader_srlEnableTwoLevel, this.mEnableTwoLevel);
        this.mEnablePullToCloseTwoLevel = obtainStyledAttributes.getBoolean(R$styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.mEnablePullToCloseTwoLevel);
        obtainStyledAttributes.recycle();
    }

    public TwoLevelHeader setRefreshHeader(RefreshHeader refreshHeader, int i, int i2) {
        if (refreshHeader != null) {
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null) {
                removeView(refreshInternal.getView());
            }
            if (refreshHeader.getSpinnerStyle() == gd2.FixedBehind) {
                addView(refreshHeader.getView(), 0, new RelativeLayout.LayoutParams(i, i2));
            } else {
                addView(refreshHeader.getView(), getChildCount(), new RelativeLayout.LayoutParams(i, i2));
            }
            this.mRefreshHeader = refreshHeader;
            this.mWrappedInternal = refreshHeader;
        }
        return this;
    }
}
