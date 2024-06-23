package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

/* compiled from: Taobao */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    static final boolean DEBUG = false;
    static final Mode DEFAULT_MODE = Mode.PULL_DOWN_TO_REFRESH;
    static final float FRICTION = 2.0f;
    static final int INITIAL_STATE = 0;
    static final String LOG_TAG = "PullToRefresh";
    static final int MANUAL_REFRESHING = 9;
    static final int PULL_TO_REFRESH = 1;
    static final int REFRESHING = 8;
    static final int RELEASE_TO_REFRESH = 2;
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_DISABLE_SCROLLING_REFRESHING = "ptr_disable_scrolling";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    static final int WAITING = 0;
    private Mode mCurrentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable mCurrentSmoothScrollRunnable;
    private boolean mDisableScrollingWhileRefreshing = true;
    private boolean mFilterTouchEvents = true;
    private int mFooterHeight;
    private LoadingLayout mFooterLayout;
    private int mHeaderHeight;
    private LoadingLayout mHeaderLayout;
    private float mInitialMotionY;
    private boolean mIsBeingDragged = false;
    private float mLastMotionX;
    private float mLastMotionY;
    private Mode mMode = DEFAULT_MODE;
    private OnPullEventListener<T> mOnPullEventListener;
    private OnRefreshListener<T> mOnRefreshListener;
    private OnRefreshListener2<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled = true;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    private boolean mShowViewWhileRefreshing = true;
    private int mState = 0;
    private int mTouchSlop;

    /* compiled from: Taobao */
    public enum Mode {
        DISABLED(0),
        PULL_DOWN_TO_REFRESH(1),
        PULL_UP_TO_REFRESH(2),
        BOTH(3);
        
        private int mIntValue;

        private Mode(int i) {
            this.mIntValue = i;
        }

        public static Mode mapIntToMode(int i) {
            if (i == 0) {
                return DISABLED;
            }
            if (i == 2) {
                return PULL_UP_TO_REFRESH;
            }
            if (i != 3) {
                return PULL_DOWN_TO_REFRESH;
            }
            return BOTH;
        }

        /* access modifiers changed from: package-private */
        public boolean canPullDown() {
            return this == PULL_DOWN_TO_REFRESH || this == BOTH;
        }

        /* access modifiers changed from: package-private */
        public boolean canPullUp() {
            return this == PULL_UP_TO_REFRESH || this == BOTH;
        }

        /* access modifiers changed from: package-private */
        public int getIntValue() {
            return this.mIntValue;
        }
    }

    /* compiled from: Taobao */
    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    /* compiled from: Taobao */
    public interface OnPullEventListener<V extends View> {
        void onPull(PullToRefreshBase<V> pullToRefreshBase, Mode mode);

        void onRelease(PullToRefreshBase<V> pullToRefreshBase, Mode mode);
    }

    /* compiled from: Taobao */
    public interface OnRefreshListener<V extends View> {
        void onRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* compiled from: Taobao */
    public interface OnRefreshListener2<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class SmoothScrollRunnable implements Runnable {
        static final int ANIMATION_DELAY = 10;
        private boolean mContinueRunning = true;
        private int mCurrentY = -1;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private final int mScrollFromY;
        private final int mScrollToY;
        private long mStartTime = -1;

        public SmoothScrollRunnable(int i, int i2, long j) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mInterpolator = PullToRefreshBase.this.mScrollAnimationInterpolator;
            this.mDuration = j;
        }

        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                int round = this.mScrollFromY - Math.round(((float) (this.mScrollFromY - this.mScrollToY)) * this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f));
                this.mCurrentY = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                PullToRefreshBase.this.postDelayed(this, 10);
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            iArr[Mode.PULL_UP_TO_REFRESH.ordinal()] = 1;
            a[Mode.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            a[Mode.BOTH.ordinal()] = 3;
            try {
                a[Mode.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    private void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRefreshableViewWrapper = frameLayout;
        frameLayout.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    private void init(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        Drawable drawable2;
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        int i = R$styleable.PullToRefresh_ptrMode;
        if (obtainStyledAttributes.hasValue(i)) {
            this.mMode = Mode.mapIntToMode(obtainStyledAttributes.getInteger(i, 0));
        }
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.mRefreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        this.mHeaderLayout = createLoadingLayout(context, Mode.PULL_DOWN_TO_REFRESH, obtainStyledAttributes);
        this.mFooterLayout = createLoadingLayout(context, Mode.PULL_UP_TO_REFRESH, obtainStyledAttributes);
        int i2 = R$styleable.PullToRefresh_ptrHeaderBackground;
        if (obtainStyledAttributes.hasValue(i2) && (drawable2 = obtainStyledAttributes.getDrawable(i2)) != null) {
            setBackgroundDrawable(drawable2);
        }
        int i3 = R$styleable.PullToRefresh_ptrAdapterViewBackground;
        if (obtainStyledAttributes.hasValue(i3) && (drawable = obtainStyledAttributes.getDrawable(i3)) != null) {
            this.mRefreshableView.setBackgroundDrawable(drawable);
        }
        int i4 = R$styleable.PullToRefresh_ptrOverScroll;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.mOverScrollEnabled = obtainStyledAttributes.getBoolean(i4, true);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean isReadyForPull() {
        int i = a.a[this.mMode.ordinal()];
        if (i == 1) {
            return isReadyForPullUp();
        }
        if (i == 2) {
            return isReadyForPullDown();
        }
        if (i != 3) {
            return false;
        }
        if (isReadyForPullUp() || isReadyForPullDown()) {
            return true;
        }
        return false;
    }

    private void measureView(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
    }

    private void pullEvent() {
        int i;
        int i2;
        int[] iArr = a.a;
        if (iArr[this.mCurrentMode.ordinal()] != 1) {
            i2 = Math.round(Math.min(this.mInitialMotionY - this.mLastMotionY, 0.0f) / FRICTION);
            i = this.mHeaderHeight;
        } else {
            i2 = Math.round(Math.max(this.mInitialMotionY - this.mLastMotionY, 0.0f) / FRICTION);
            i = this.mFooterHeight;
        }
        setHeaderScroll(i2);
        if (i2 != 0) {
            float abs = ((float) Math.abs(i2)) / ((float) i);
            int i3 = iArr[this.mCurrentMode.ordinal()];
            if (i3 == 1) {
                this.mFooterLayout.onPullY(abs);
            } else if (i3 == 2) {
                this.mHeaderLayout.onPullY(abs);
            }
            if (this.mState != 1 && i >= Math.abs(i2)) {
                if (this.mState == 0) {
                    onPullEventStarted();
                }
                this.mState = 1;
                onPullToRefresh();
            } else if (this.mState == 1 && i < Math.abs(i2)) {
                this.mState = 2;
                onReleaseToRefresh();
            }
        }
    }

    private void refreshLoadingViewsHeight() {
        this.mFooterHeight = 0;
        this.mHeaderHeight = 0;
        if (this.mMode.canPullDown()) {
            measureView(this.mHeaderLayout);
            this.mHeaderHeight = this.mHeaderLayout.getMeasuredHeight();
        }
        if (this.mMode.canPullUp()) {
            measureView(this.mFooterLayout);
            this.mFooterHeight = this.mFooterLayout.getMeasuredHeight();
        }
        int i = a.a[this.mMode.ordinal()];
        if (i != 1) {
            if (i != 3) {
                if (i != 4) {
                    setPadding(0, -this.mHeaderHeight, 0, 0);
                    return;
                }
                setPadding(0, 0, 0, 0);
            }
            setPadding(0, -this.mHeaderHeight, 0, -this.mFooterHeight);
            return;
        }
        setPadding(0, 0, 0, -this.mFooterHeight);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedArray) {
        return new LoadingLayout(context, mode, typedArray);
    }

    /* access modifiers changed from: protected */
    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final Mode getCurrentMode() {
        return this.mCurrentMode;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean getFilterTouchEvents() {
        return this.mFilterTouchEvents;
    }

    /* access modifiers changed from: protected */
    public final int getFooterHeight() {
        return this.mFooterHeight;
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    /* access modifiers changed from: protected */
    public final int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final Mode getMode() {
        return this.mMode;
    }

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDuration() {
        return 200;
    }

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    /* access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean getShowViewWhileRefreshing() {
        return this.mShowViewWhileRefreshing;
    }

    /* access modifiers changed from: protected */
    public final int getState() {
        return this.mState;
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray typedArray) {
    }

    public final boolean hasPullFromTop() {
        return this.mCurrentMode == Mode.PULL_DOWN_TO_REFRESH;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean isDisableScrollingWhileRefreshing() {
        return this.mDisableScrollingWhileRefreshing;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean isPullToRefreshEnabled() {
        return this.mMode != Mode.DISABLED;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean isPullToRefreshOverScrollEnabled() {
        return Build.VERSION.SDK_INT >= 9 && this.mOverScrollEnabled && a.a(this.mRefreshableView);
    }

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullDown();

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullUp();

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final boolean isRefreshing() {
        int i = this.mState;
        return i == 8 || i == 9;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            return false;
        } else if (action != 0 && this.mIsBeingDragged) {
            return true;
        } else {
            if (action != 0) {
                if (action == 2) {
                    if (this.mDisableScrollingWhileRefreshing && isRefreshing()) {
                        return true;
                    }
                    if (isReadyForPull()) {
                        float y = motionEvent.getY();
                        float f = y - this.mLastMotionY;
                        float abs = Math.abs(f);
                        float abs2 = Math.abs(motionEvent.getX() - this.mLastMotionX);
                        if (abs > ((float) this.mTouchSlop) && (!this.mFilterTouchEvents || abs > abs2)) {
                            if (this.mMode.canPullDown() && f >= 1.0f && isReadyForPullDown()) {
                                this.mLastMotionY = y;
                                this.mIsBeingDragged = true;
                                if (this.mMode == Mode.BOTH) {
                                    this.mCurrentMode = Mode.PULL_DOWN_TO_REFRESH;
                                }
                            } else if (this.mMode.canPullUp() && f <= -1.0f && isReadyForPullUp()) {
                                this.mLastMotionY = y;
                                this.mIsBeingDragged = true;
                                if (this.mMode == Mode.BOTH) {
                                    this.mCurrentMode = Mode.PULL_UP_TO_REFRESH;
                                }
                            }
                        }
                    }
                }
            } else if (isReadyForPull()) {
                float y2 = motionEvent.getY();
                this.mInitialMotionY = y2;
                this.mLastMotionY = y2;
                this.mLastMotionX = motionEvent.getX();
                this.mIsBeingDragged = false;
            }
            return this.mIsBeingDragged;
        }
    }

    /* access modifiers changed from: protected */
    public void onPullEventFinished() {
        OnPullEventListener<T> onPullEventListener = this.mOnPullEventListener;
        if (onPullEventListener != null) {
            onPullEventListener.onRelease(this, this.mCurrentMode);
        }
    }

    /* access modifiers changed from: protected */
    public void onPullEventStarted() {
        OnPullEventListener<T> onPullEventListener = this.mOnPullEventListener;
        if (onPullEventListener != null) {
            onPullEventListener.onPull(this, this.mCurrentMode);
        }
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
        int i = a.a[this.mCurrentMode.ordinal()];
        if (i == 1) {
            this.mFooterLayout.pullToRefresh();
        } else if (i == 2) {
            this.mHeaderLayout.pullToRefresh();
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void onRefreshComplete() {
        if (isRefreshing()) {
            resetHeader();
        }
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
        int i = a.a[this.mCurrentMode.ordinal()];
        if (i == 1) {
            this.mFooterLayout.releaseToRefresh();
        } else if (i == 2) {
            this.mHeaderLayout.releaseToRefresh();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mMode = Mode.mapIntToMode(bundle.getInt(STATE_MODE, 0));
            this.mCurrentMode = Mode.mapIntToMode(bundle.getInt(STATE_CURRENT_MODE, 0));
            this.mDisableScrollingWhileRefreshing = bundle.getBoolean(STATE_DISABLE_SCROLLING_REFRESHING, true);
            this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, true);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            int i = bundle.getInt(STATE_STATE, 0);
            if (i == 8 || i == 9) {
                setRefreshingInternal(true);
                this.mState = i;
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt(STATE_STATE, this.mState);
        bundle.putInt(STATE_MODE, this.mMode.getIntValue());
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.getIntValue());
        bundle.putBoolean(STATE_DISABLE_SCROLLING_REFRESHING, this.mDisableScrollingWhileRefreshing);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (r0 != 3) goto L_0x008f;
     */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        if (this.mDisableScrollingWhileRefreshing && isRefreshing()) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.mIsBeingDragged) {
                        this.mLastMotionY = motionEvent.getY();
                        pullEvent();
                        return true;
                    }
                }
            }
            if (this.mIsBeingDragged) {
                this.mIsBeingDragged = false;
                if (this.mState == 2) {
                    onPullEventFinished();
                    if (this.mOnRefreshListener != null) {
                        setRefreshingInternal(true);
                        this.mOnRefreshListener.onRefresh(this);
                        return true;
                    } else if (this.mOnRefreshListener2 != null) {
                        setRefreshingInternal(true);
                        Mode mode = this.mCurrentMode;
                        if (mode == Mode.PULL_DOWN_TO_REFRESH) {
                            this.mOnRefreshListener2.onPullDownToRefresh(this);
                        } else if (mode == Mode.PULL_UP_TO_REFRESH) {
                            this.mOnRefreshListener2.onPullUpToRefresh(this);
                        }
                        return true;
                    } else {
                        resetHeader();
                        return true;
                    }
                } else {
                    onPullEventFinished();
                    resetHeader();
                    return true;
                }
            }
        } else if (isReadyForPull()) {
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void resetHeader() {
        this.mState = 0;
        this.mIsBeingDragged = false;
        if (this.mMode.canPullDown()) {
            this.mHeaderLayout.reset();
        }
        if (this.mMode.canPullUp()) {
            this.mFooterLayout.reset();
        }
        smoothScrollTo(0);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setDisableScrollingWhileRefreshing(boolean z) {
        this.mDisableScrollingWhileRefreshing = z;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setFilterTouchEvents(boolean z) {
        this.mFilterTouchEvents = z;
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        scrollTo(0, i);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setSubHeaderText(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setSubHeaderText(charSequence);
        }
        refreshLoadingViewsHeight();
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setLoadingDrawable(Drawable drawable) {
        setLoadingDrawable(drawable, Mode.BOTH);
    }

    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setMode(Mode mode) {
        if (mode != this.mMode) {
            this.mMode = mode;
            updateUIForMode();
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setOnPullEventListener(OnPullEventListener<T> onPullEventListener) {
        this.mOnPullEventListener = onPullEventListener;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setPullLabel(CharSequence charSequence) {
        setPullLabel(charSequence, Mode.BOTH);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? DEFAULT_MODE : Mode.DISABLED);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.mOverScrollEnabled = z;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setRefreshing() {
        setRefreshing(true);
    }

    /* access modifiers changed from: protected */
    public void setRefreshingInternal(boolean z) {
        this.mState = 8;
        if (this.mMode.canPullDown()) {
            this.mHeaderLayout.refreshing();
        }
        if (this.mMode.canPullUp()) {
            this.mFooterLayout.refreshing();
        }
        if (!z) {
            return;
        }
        if (this.mShowViewWhileRefreshing) {
            smoothScrollTo(this.mCurrentMode == Mode.PULL_DOWN_TO_REFRESH ? -this.mHeaderHeight : this.mFooterHeight);
        } else {
            smoothScrollTo(0);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setRefreshingLabel(CharSequence charSequence) {
        setRefreshingLabel(charSequence, Mode.BOTH);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.mScrollAnimationInterpolator = interpolator;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setShowViewWhileRefreshing(boolean z) {
        this.mShowViewWhileRefreshing = z;
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration());
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollToLonger(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDurationLonger());
    }

    /* access modifiers changed from: protected */
    public void updateUIForMode() {
        if (this == this.mHeaderLayout.getParent()) {
            removeView(this.mHeaderLayout);
        }
        if (this.mMode.canPullDown()) {
            addViewInternal(this.mHeaderLayout, 0, new LinearLayout.LayoutParams(-1, -2));
        }
        if (this == this.mFooterLayout.getParent()) {
            removeView(this.mFooterLayout);
        }
        if (this.mMode.canPullUp()) {
            addViewInternal(this.mFooterLayout, new LinearLayout.LayoutParams(-1, -2));
        }
        refreshLoadingViewsHeight();
        Mode mode = this.mMode;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_DOWN_TO_REFRESH;
        }
        this.mCurrentMode = mode;
    }

    private final void smoothScrollTo(int i, long j) {
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.mCurrentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            if (this.mScrollAnimationInterpolator == null) {
                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(getScrollY(), i, j);
            this.mCurrentSmoothScrollRunnable = smoothScrollRunnable2;
            post(smoothScrollRunnable2);
        }
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        if (this.mHeaderLayout != null && mode.canPullDown()) {
            this.mHeaderLayout.setLoadingDrawable(drawable);
        }
        if (this.mFooterLayout != null && mode.canPullUp()) {
            this.mFooterLayout.setLoadingDrawable(drawable);
        }
        refreshLoadingViewsHeight();
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener2<T> onRefreshListener2) {
        this.mOnRefreshListener2 = onRefreshListener2;
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setPullLabel(CharSequence charSequence, Mode mode) {
        if (this.mHeaderLayout != null && mode.canPullDown()) {
            this.mHeaderLayout.setPullLabel(charSequence);
        }
        if (this.mFooterLayout != null && mode.canPullUp()) {
            this.mFooterLayout.setPullLabel(charSequence);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            setRefreshingInternal(z);
            this.mState = 9;
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        if (this.mHeaderLayout != null && mode.canPullDown()) {
            this.mHeaderLayout.setRefreshingLabel(charSequence);
        }
        if (this.mFooterLayout != null && mode.canPullUp()) {
            this.mFooterLayout.setRefreshingLabel(charSequence);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh
    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        if (this.mHeaderLayout != null && mode.canPullDown()) {
            this.mHeaderLayout.setReleaseLabel(charSequence);
        }
        if (this.mFooterLayout != null && mode.canPullUp()) {
            this.mFooterLayout.setReleaseLabel(charSequence);
        }
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mMode = mode;
        init(context, null);
    }
}
