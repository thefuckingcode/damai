package cn.damai.uikit.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.internal.FlipLoadingLayout;
import cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout;
import cn.damai.uikit.pulltorefresh.library.internal.PullLoadingLayout;
import cn.damai.uikit.pulltorefresh.library.internal.RotateLoadingLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.du2;
import tb.sv2;

/* compiled from: Taobao */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final boolean DEBUG = true;
    static final int DEMO_SCROLL_INTERVAL = 225;
    static final float FRICTION = 2.0f;
    static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    static final boolean USE_HW_LAYERS = false;
    private Mode mCurrentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable mCurrentSmoothScrollRunnable;
    private boolean mFilterTouchEvents = true;
    private LoadingLayout mFooterLayout;
    private LoadingLayout mHeaderLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged = false;
    private float mLastMotionX;
    private float mLastMotionY;
    private boolean mLayoutVisibilityChangesEnabled = true;
    private AnimationStyle mLoadingAnimationStyle = AnimationStyle.getDefault();
    private Mode mMode = Mode.getDefault();
    private OnPullEventListener<T> mOnPullEventListener;
    private OnRefreshListener<T> mOnRefreshListener;
    private OnRefreshListener2<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled = true;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    private boolean mScrollingWhileRefreshingEnabled = false;
    private boolean mShowViewWhileRefreshing = true;
    private State mState = State.RESET;
    private int mTouchSlop;

    /* compiled from: Taobao */
    public enum AnimationStyle {
        ROTATE,
        FLIP,
        PULL;

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i) {
            if (i == 1) {
                return FLIP;
            }
            if (i != 2) {
                return ROTATE;
            }
            return PULL;
        }

        /* access modifiers changed from: package-private */
        public LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            int i = c.d[ordinal()];
            if (i == 2) {
                return new FlipLoadingLayout(context, mode, orientation, typedArray);
            }
            if (i != 3) {
                return new RotateLoadingLayout(context, mode, orientation, typedArray);
            }
            return new PullLoadingLayout(context, mode, orientation, typedArray);
        }
    }

    /* compiled from: Taobao */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        private int mIntValue;

        static {
            Mode mode;
            Mode mode2;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        private Mode(int i) {
            this.mIntValue = i;
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        static Mode mapIntToValue(int i) {
            Mode[] values = values();
            for (Mode mode : values) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        /* access modifiers changed from: package-private */
        public int getIntValue() {
            return this.mIntValue;
        }

        /* access modifiers changed from: package-private */
        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    /* compiled from: Taobao */
    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    /* compiled from: Taobao */
    public interface OnPullEventListener<V extends View> {
        void onPullEvent(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
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
    public interface OnSmoothScrollFinishedListener {
        void onSmoothScrollFinished();
    }

    /* compiled from: Taobao */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* compiled from: Taobao */
    public final class SmoothScrollRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean mContinueRunning = true;
        private int mCurrentY = -1;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private OnSmoothScrollFinishedListener mListener;
        private final int mScrollFromY;
        private final int mScrollToY;
        private long mStartTime = -1;

        public SmoothScrollRunnable(int i, int i2, long j, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mInterpolator = PullToRefreshBase.this.mScrollAnimationInterpolator;
            this.mDuration = j;
            this.mListener = onSmoothScrollFinishedListener;
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "464729794")) {
                ipChange.ipc$dispatch("464729794", new Object[]{this});
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                int round = this.mScrollFromY - Math.round(((float) (this.mScrollFromY - this.mScrollToY)) * this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f));
                this.mCurrentY = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (!this.mContinueRunning || this.mScrollToY == this.mCurrentY) {
                OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.mListener;
                if (onSmoothScrollFinishedListener != null) {
                    onSmoothScrollFinishedListener.onSmoothScrollFinished();
                    return;
                }
                return;
            }
            sv2.a(PullToRefreshBase.this, this);
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1911304837")) {
                ipChange.ipc$dispatch("-1911304837", new Object[]{this});
                return;
            }
            this.mContinueRunning = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    /* compiled from: Taobao */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        private State(int i) {
            this.mIntValue = i;
        }

        static State mapIntToValue(int i) {
            State[] values = values();
            for (State state : values) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        /* access modifiers changed from: package-private */
        public int getIntValue() {
            return this.mIntValue;
        }
    }

    /* compiled from: Taobao */
    public class a implements OnSmoothScrollFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnSmoothScrollFinishedListener
        public void onSmoothScrollFinished() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "65738194")) {
                ipChange.ipc$dispatch("65738194", new Object[]{this});
                return;
            }
            PullToRefreshBase.this.callRefreshListener();
        }
    }

    /* compiled from: Taobao */
    public class b implements OnSmoothScrollFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnSmoothScrollFinishedListener
        public void onSmoothScrollFinished() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1451941588")) {
                ipChange.ipc$dispatch("1451941588", new Object[]{this});
                return;
            }
            PullToRefreshBase.this.smoothScrollTo(0, 200, 225, null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ae */
        static {
            int[] iArr = new int[AnimationStyle.values().length];
            d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[AnimationStyle.PULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Mode.values().length];
            c = iArr2;
            iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            c[Mode.PULL_FROM_START.ordinal()] = 2;
            c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            try {
                c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[State.values().length];
            b = iArr3;
            iArr3[State.RESET.ordinal()] = 1;
            b[State.PULL_TO_REFRESH.ordinal()] = 2;
            b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            b[State.REFRESHING.ordinal()] = 4;
            b[State.MANUAL_REFRESHING.ordinal()] = 5;
            try {
                b[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            a = iArr4;
            iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            try {
                a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    private void addRefreshableView(Context context, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712899522")) {
            ipChange.ipc$dispatch("712899522", new Object[]{this, context, t});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRefreshableViewWrapper = frameLayout;
        frameLayout.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void callRefreshListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872778264")) {
            ipChange.ipc$dispatch("-1872778264", new Object[]{this});
            return;
        }
        OnRefreshListener<T> onRefreshListener = this.mOnRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh(this);
            return;
        }
        OnRefreshListener2<T> onRefreshListener2 = this.mOnRefreshListener2;
        if (onRefreshListener2 != null) {
            Mode mode = this.mCurrentMode;
            if (mode == Mode.PULL_FROM_START) {
                onRefreshListener2.onPullDownToRefresh(this);
            } else if (mode == Mode.PULL_FROM_END) {
                onRefreshListener2.onPullUpToRefresh(this);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507176326")) {
            return (LinearLayout.LayoutParams) ipChange.ipc$dispatch("-1507176326", new Object[]{this});
        } else if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        } else {
            return new LinearLayout.LayoutParams(-2, -1);
        }
    }

    private int getMaximumPullScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127525608")) {
            return ((Integer) ipChange.ipc$dispatch("2127525608", new Object[]{this})).intValue();
        } else if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return Math.round(((float) getHeight()) / FRICTION);
        } else {
            return Math.round(((float) getWidth()) / FRICTION);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256161063")) {
            ipChange.ipc$dispatch("256161063", new Object[]{this, context, attributeSet});
            return;
        }
        if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        int i = R$styleable.PullToRefresh_ptrMode;
        if (obtainStyledAttributes.hasValue(i)) {
            this.mMode = Mode.mapIntToValue(obtainStyledAttributes.getInteger(i, 0));
        }
        int i2 = R$styleable.PullToRefresh_ptrAnimationStyle;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mLoadingAnimationStyle = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(i2, 0));
        }
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.mRefreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        this.mHeaderLayout = createLoadingLayout(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.mFooterLayout = createLoadingLayout(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        int i3 = R$styleable.PullToRefresh_ptrRefreshableViewBackground;
        if (obtainStyledAttributes.hasValue(i3)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(i3);
            if (drawable != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        } else {
            int i4 = R$styleable.PullToRefresh_ptrAdapterViewBackground;
            if (obtainStyledAttributes.hasValue(i4)) {
                du2.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
                Drawable drawable2 = obtainStyledAttributes.getDrawable(i4);
                if (drawable2 != null) {
                    this.mRefreshableView.setBackgroundDrawable(drawable2);
                }
            }
        }
        int i5 = R$styleable.PullToRefresh_ptrOverScroll;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.mOverScrollEnabled = obtainStyledAttributes.getBoolean(i5, true);
        }
        int i6 = R$styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mScrollingWhileRefreshingEnabled = obtainStyledAttributes.getBoolean(i6, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean isReadyForPull() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572182912")) {
            return ((Boolean) ipChange.ipc$dispatch("-572182912", new Object[]{this})).booleanValue();
        }
        int i = c.c[this.mMode.ordinal()];
        if (i == 1) {
            return isReadyForPullEnd();
        }
        if (i == 2) {
            return isReadyForPullStart();
        }
        if (i != 4) {
            return false;
        }
        if (isReadyForPullEnd() || isReadyForPullStart()) {
            return true;
        }
        return false;
    }

    private void pullEvent() {
        float f;
        float f2;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445369220")) {
            ipChange.ipc$dispatch("1445369220", new Object[]{this});
            return;
        }
        if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f2 = this.mInitialMotionY;
            f = this.mLastMotionY;
        } else {
            f2 = this.mInitialMotionX;
            f = this.mLastMotionX;
        }
        int[] iArr = c.c;
        if (iArr[this.mCurrentMode.ordinal()] != 1) {
            i2 = Math.round(Math.min(f2 - f, 0.0f) / FRICTION);
            i = getHeaderSize();
        } else {
            i2 = Math.round(Math.max(f2 - f, 0.0f) / FRICTION);
            i = getFooterSize();
        }
        setHeaderScroll(i2);
        if (i2 != 0 && !isRefreshing()) {
            float abs = ((float) Math.abs(i2)) / ((float) i);
            if (iArr[this.mCurrentMode.ordinal()] != 1) {
                this.mHeaderLayout.onPull(abs);
            } else {
                this.mFooterLayout.onPull(abs);
            }
            State state = this.mState;
            State state2 = State.PULL_TO_REFRESH;
            if (state != state2 && i >= Math.abs(i2)) {
                setState(state2, new boolean[0]);
            } else if (this.mState == state2 && i < Math.abs(i2)) {
                setState(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private final void smoothScrollToAndBack(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1730393010")) {
            ipChange.ipc$dispatch("1730393010", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        smoothScrollTo(i, 200, 0, new b());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864272167")) {
            ipChange.ipc$dispatch("-1864272167", new Object[]{this, view, Integer.valueOf(i), layoutParams});
            return;
        }
        Log.d(LOG_TAG, "addView: " + view.getClass().getSimpleName());
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1022939594")) {
            ipChange.ipc$dispatch("-1022939594", new Object[]{this, view, Integer.valueOf(i), layoutParams});
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601651813")) {
            return (LoadingLayout) ipChange.ipc$dispatch("1601651813", new Object[]{this, context, mode, typedArray});
        }
        LoadingLayout createLoadingLayout = this.mLoadingAnimationStyle.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    /* access modifiers changed from: protected */
    public a createLoadingLayoutProxy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110430726")) {
            return (a) ipChange.ipc$dispatch("110430726", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        a aVar = new a();
        if (z && this.mMode.showHeaderLoadingLayout()) {
            aVar.a(this.mHeaderLayout);
        }
        if (z2 && this.mMode.showFooterLoadingLayout()) {
            aVar.a(this.mFooterLayout);
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean demo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170054834")) {
            return ((Boolean) ipChange.ipc$dispatch("1170054834", new Object[]{this})).booleanValue();
        } else if (this.mMode.showHeaderLoadingLayout() && isReadyForPullStart()) {
            smoothScrollToAndBack((-getHeaderSize()) * 2);
            return true;
        } else if (!this.mMode.showFooterLoadingLayout() || !isReadyForPullEnd()) {
            return false;
        } else {
            smoothScrollToAndBack(getFooterSize() * 2);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final void disableLoadingLayoutVisibilityChanges() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602300070")) {
            ipChange.ipc$dispatch("1602300070", new Object[]{this});
            return;
        }
        this.mLayoutVisibilityChangesEnabled = false;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final Mode getCurrentMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1944148273")) {
            return this.mCurrentMode;
        }
        return (Mode) ipChange.ipc$dispatch("1944148273", new Object[]{this});
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean getFilterTouchEvents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1813367115")) {
            return this.mFilterTouchEvents;
        }
        return ((Boolean) ipChange.ipc$dispatch("1813367115", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1788075275")) {
            return this.mFooterLayout;
        }
        return (LoadingLayout) ipChange.ipc$dispatch("1788075275", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public final int getFooterSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-154163846")) {
            return this.mFooterLayout.getContentSize();
        }
        return ((Integer) ipChange.ipc$dispatch("-154163846", new Object[]{this})).intValue();
    }

    public final LoadingLayout getHeaderLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1036744871")) {
            return this.mHeaderLayout;
        }
        return (LoadingLayout) ipChange.ipc$dispatch("-1036744871", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public final int getHeaderSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "499934280")) {
            return this.mHeaderLayout.getContentSize();
        }
        return ((Integer) ipChange.ipc$dispatch("499934280", new Object[]{this})).intValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final ILoadingLayout getLoadingLayoutProxy() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-522635201")) {
            return getLoadingLayoutProxy(true, true);
        }
        return (ILoadingLayout) ipChange.ipc$dispatch("-522635201", new Object[]{this});
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final Mode getMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1522506694")) {
            return this.mMode;
        }
        return (Mode) ipChange.ipc$dispatch("1522506694", new Object[]{this});
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-193294242")) {
            return 200;
        }
        return ((Integer) ipChange.ipc$dispatch("-193294242", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public int getPullToRefreshScrollDurationLonger() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1160274187")) {
            return 325;
        }
        return ((Integer) ipChange.ipc$dispatch("-1160274187", new Object[]{this})).intValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final T getRefreshableView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-657874385")) {
            return this.mRefreshableView;
        }
        return (T) ((View) ipChange.ipc$dispatch("-657874385", new Object[]{this}));
    }

    /* access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-822866129")) {
            return this.mRefreshableViewWrapper;
        }
        return (FrameLayout) ipChange.ipc$dispatch("-822866129", new Object[]{this});
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean getShowViewWhileRefreshing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1925024021")) {
            return this.mShowViewWhileRefreshing;
        }
        return ((Boolean) ipChange.ipc$dispatch("1925024021", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final State getState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1563352838")) {
            return this.mState;
        }
        return (State) ipChange.ipc$dispatch("1563352838", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520054682")) {
            ipChange.ipc$dispatch("520054682", new Object[]{this, typedArray});
        }
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1525318052")) {
            return !isScrollingWhileRefreshingEnabled();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1525318052", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "22172293")) {
            return this.mMode.permitsPullToRefresh();
        }
        return ((Boolean) ipChange.ipc$dispatch("22172293", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean isPullToRefreshOverScrollEnabled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580551654")) {
            return ((Boolean) ipChange.ipc$dispatch("1580551654", new Object[]{this})).booleanValue();
        } else if (Build.VERSION.SDK_INT < 9 || !this.mOverScrollEnabled || !b.a(this.mRefreshableView)) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullEnd();

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullStart();

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735817188")) {
            return ((Boolean) ipChange.ipc$dispatch("735817188", new Object[]{this})).booleanValue();
        }
        State state = this.mState;
        return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final boolean isScrollingWhileRefreshingEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "797700041")) {
            return this.mScrollingWhileRefreshingEnabled;
        }
        return ((Boolean) ipChange.ipc$dispatch("797700041", new Object[]{this})).booleanValue();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039199732")) {
            return ((Boolean) ipChange.ipc$dispatch("2039199732", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isPullToRefreshEnabled()) {
            return false;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action != 0 && this.mIsBeingDragged) {
                return true;
            } else {
                if (action != 0) {
                    if (action == 2) {
                        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
                            return true;
                        }
                        if (isReadyForPull()) {
                            float y = motionEvent.getY();
                            float x = motionEvent.getX();
                            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                f2 = y - this.mLastMotionY;
                                f = x - this.mLastMotionX;
                            } else {
                                f2 = x - this.mLastMotionX;
                                f = y - this.mLastMotionY;
                            }
                            float abs = Math.abs(f2);
                            if (abs > ((float) this.mTouchSlop) && (!this.mFilterTouchEvents || abs > Math.abs(f))) {
                                if (this.mMode.showHeaderLoadingLayout() && f2 >= 1.0f && isReadyForPullStart()) {
                                    this.mLastMotionY = y;
                                    this.mLastMotionX = x;
                                    this.mIsBeingDragged = true;
                                    if (this.mMode == Mode.BOTH) {
                                        this.mCurrentMode = Mode.PULL_FROM_START;
                                    }
                                } else if (this.mMode.showFooterLoadingLayout() && f2 <= -1.0f && isReadyForPullEnd()) {
                                    this.mLastMotionY = y;
                                    this.mLastMotionX = x;
                                    this.mIsBeingDragged = true;
                                    if (this.mMode == Mode.BOTH) {
                                        this.mCurrentMode = Mode.PULL_FROM_END;
                                    }
                                }
                            }
                        }
                    }
                } else if (isReadyForPull()) {
                    float y2 = motionEvent.getY();
                    this.mInitialMotionY = y2;
                    this.mLastMotionY = y2;
                    float x2 = motionEvent.getX();
                    this.mInitialMotionX = x2;
                    this.mLastMotionX = x2;
                    this.mIsBeingDragged = false;
                }
                return this.mIsBeingDragged;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPtrRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095138888")) {
            ipChange.ipc$dispatch("-2095138888", new Object[]{this, bundle});
        }
    }

    /* access modifiers changed from: protected */
    public void onPtrSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254746509")) {
            ipChange.ipc$dispatch("-1254746509", new Object[]{this, bundle});
        }
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251306243")) {
            ipChange.ipc$dispatch("-1251306243", new Object[]{this});
            return;
        }
        int i = c.c[this.mCurrentMode.ordinal()];
        if (i == 1) {
            this.mFooterLayout.pullToRefresh();
        } else if (i == 2) {
            this.mHeaderLayout.pullToRefresh();
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496409212")) {
            ipChange.ipc$dispatch("-1496409212", new Object[]{this});
        } else if (isRefreshing()) {
            setState(State.RESET, new boolean[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675487511")) {
            ipChange.ipc$dispatch("-675487511", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.refreshing();
        }
        if (this.mMode.showFooterLoadingLayout()) {
            this.mFooterLayout.refreshing();
        }
        if (!z) {
            callRefreshListener();
        } else if (this.mShowViewWhileRefreshing) {
            a aVar = new a();
            int i = c.c[this.mCurrentMode.ordinal()];
            if (i == 1 || i == 3) {
                smoothScrollTo(getFooterSize(), aVar);
            } else {
                smoothScrollTo(-getHeaderSize(), aVar);
            }
        } else {
            smoothScrollTo(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143594535")) {
            ipChange.ipc$dispatch("-143594535", new Object[]{this});
            return;
        }
        int i = c.c[this.mCurrentMode.ordinal()];
        if (i == 1) {
            this.mFooterLayout.releaseToRefresh();
        } else if (i == 2) {
            this.mHeaderLayout.releaseToRefresh();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7186761")) {
            ipChange.ipc$dispatch("7186761", new Object[]{this});
            return;
        }
        this.mIsBeingDragged = false;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mHeaderLayout.reset();
        this.mFooterLayout.reset();
        smoothScrollTo(0);
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640227727")) {
            ipChange.ipc$dispatch("640227727", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt(STATE_MODE, 0)));
            this.mCurrentMode = Mode.mapIntToValue(bundle.getInt(STATE_CURRENT_MODE, 0));
            this.mScrollingWhileRefreshingEnabled = bundle.getBoolean(STATE_SCROLLING_REFRESHING_ENABLED, false);
            this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, true);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            State mapIntToValue = State.mapIntToValue(bundle.getInt(STATE_STATE, 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                setState(mapIntToValue, true);
            }
            onPtrRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    /* access modifiers changed from: protected */
    public final Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894653916")) {
            return (Parcelable) ipChange.ipc$dispatch("1894653916", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt(STATE_STATE, this.mState.getIntValue());
        bundle.putInt(STATE_MODE, this.mMode.getIntValue());
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.getIntValue());
        bundle.putBoolean(STATE_SCROLLING_REFRESHING_ENABLED, this.mScrollingWhileRefreshingEnabled);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395666267")) {
            ipChange.ipc$dispatch("-395666267", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        Log.d(LOG_TAG, String.format("onSizeChanged. W: %d, H: %d", Integer.valueOf(i), Integer.valueOf(i2)));
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() {
            /* class cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1030424896")) {
                    ipChange.ipc$dispatch("-1030424896", new Object[]{this});
                    return;
                }
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r0 != 3) goto L_0x00a6;
     */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223675056")) {
            return ((Boolean) ipChange.ipc$dispatch("223675056", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isPullToRefreshEnabled()) {
            return false;
        } else {
            if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
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
                            this.mLastMotionX = motionEvent.getX();
                            pullEvent();
                            return true;
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    this.mIsBeingDragged = false;
                    if (this.mState == State.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
                        setState(State.REFRESHING, true);
                        return true;
                    } else if (isRefreshing()) {
                        smoothScrollTo(0);
                        return true;
                    } else {
                        setState(State.RESET, new boolean[0]);
                        return true;
                    }
                }
            } else if (isReadyForPull()) {
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void refreshLoadingViewsSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1767440245")) {
            ipChange.ipc$dispatch("-1767440245", new Object[]{this});
            return;
        }
        int maximumPullScroll = (int) (((float) getMaximumPullScroll()) * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i = c.a[getPullToRefreshScrollDirection().ordinal()];
        if (i == 1) {
            if (this.mMode.showHeaderLoadingLayout()) {
                this.mHeaderLayout.setWidth(maximumPullScroll);
                paddingLeft = -maximumPullScroll;
            } else {
                paddingLeft = 0;
            }
            if (this.mMode.showFooterLoadingLayout()) {
                this.mFooterLayout.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
            } else {
                paddingRight = 0;
            }
        } else if (i == 2) {
            if (this.mMode.showHeaderLoadingLayout()) {
                this.mHeaderLayout.setHeight(maximumPullScroll);
                paddingTop = -maximumPullScroll;
            } else {
                paddingTop = 0;
            }
            if (this.mMode.showFooterLoadingLayout()) {
                this.mFooterLayout.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
            } else {
                paddingBottom = 0;
            }
        }
        Log.d(LOG_TAG, String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(paddingRight), Integer.valueOf(paddingBottom)));
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* access modifiers changed from: protected */
    public final void refreshRefreshableViewSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70584145")) {
            ipChange.ipc$dispatch("70584145", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        int i3 = c.a[getPullToRefreshScrollDirection().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && layoutParams.height != i2) {
                layoutParams.height = i2;
                this.mRefreshableViewWrapper.requestLayout();
            }
        } else if (layoutParams.width != i) {
            layoutParams.width = i;
            this.mRefreshableViewWrapper.requestLayout();
        }
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997951180")) {
            ipChange.ipc$dispatch("997951180", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        setScrollingWhileRefreshingEnabled(!z);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setFilterTouchEvents(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424229663")) {
            ipChange.ipc$dispatch("-424229663", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mFilterTouchEvents = z;
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541885286")) {
            ipChange.ipc$dispatch("541885286", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Log.d(LOG_TAG, "setHeaderScroll: " + i);
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.mLayoutVisibilityChangesEnabled) {
            if (min < 0) {
                this.mHeaderLayout.setVisibility(0);
            } else if (min > 0) {
                this.mFooterLayout.setVisibility(0);
            } else {
                this.mHeaderLayout.setVisibility(4);
                this.mFooterLayout.setVisibility(4);
            }
        }
        int i2 = c.a[getPullToRefreshScrollDirection().ordinal()];
        if (i2 == 1) {
            scrollTo(min, 0);
        } else if (i2 == 2) {
            scrollTo(0, min);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-544101940")) {
            ipChange.ipc$dispatch("-544101940", new Object[]{this, charSequence});
            return;
        }
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444777251")) {
            ipChange.ipc$dispatch("-444777251", new Object[]{this, drawable});
            return;
        }
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLongClickable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469180935")) {
            ipChange.ipc$dispatch("1469180935", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        getRefreshableView().setLongClickable(z);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setMode(Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571683362")) {
            ipChange.ipc$dispatch("1571683362", new Object[]{this, mode});
        } else if (mode != this.mMode) {
            Log.d(LOG_TAG, "Setting mode to: " + mode);
            this.mMode = mode;
            updateUIForMode();
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public void setOnPullEventListener(OnPullEventListener<T> onPullEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537918986")) {
            ipChange.ipc$dispatch("-537918986", new Object[]{this, onPullEventListener});
            return;
        }
        this.mOnPullEventListener = onPullEventListener;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311668202")) {
            ipChange.ipc$dispatch("1311668202", new Object[]{this, onRefreshListener});
            return;
        }
        this.mOnRefreshListener = onRefreshListener;
        this.mOnRefreshListener2 = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266647160")) {
            ipChange.ipc$dispatch("-1266647160", new Object[]{this, charSequence});
            return;
        }
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478728483")) {
            ipChange.ipc$dispatch("1478728483", new Object[]{this, Boolean.valueOf(z)});
        } else {
            setMode(z ? Mode.getDefault() : Mode.DISABLED);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816236062")) {
            ipChange.ipc$dispatch("-1816236062", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mOverScrollEnabled = z;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72913200")) {
            ipChange.ipc$dispatch("72913200", new Object[]{this});
            return;
        }
        setRefreshing(true);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055666198")) {
            ipChange.ipc$dispatch("-2055666198", new Object[]{this, charSequence});
            return;
        }
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104232334")) {
            ipChange.ipc$dispatch("2104232334", new Object[]{this, charSequence});
            return;
        }
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123238192")) {
            ipChange.ipc$dispatch("2123238192", new Object[]{this, interpolator});
            return;
        }
        this.mScrollAnimationInterpolator = interpolator;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2931969")) {
            ipChange.ipc$dispatch("-2931969", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mScrollingWhileRefreshingEnabled = z;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setShowViewWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317958313")) {
            ipChange.ipc$dispatch("-317958313", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowViewWhileRefreshing = z;
    }

    /* access modifiers changed from: package-private */
    public final void setState(State state, boolean... zArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284825145")) {
            ipChange.ipc$dispatch("-284825145", new Object[]{this, state, zArr});
            return;
        }
        this.mState = state;
        Log.d(LOG_TAG, "State: " + this.mState.name());
        int i = c.b[this.mState.ordinal()];
        if (i == 1) {
            onReset();
        } else if (i == 2) {
            onPullToRefresh();
        } else if (i == 3) {
            onReleaseToRefresh();
        } else if (i == 4 || i == 5) {
            onRefreshing(zArr[0]);
        }
        OnPullEventListener<T> onPullEventListener = this.mOnPullEventListener;
        if (onPullEventListener != null) {
            onPullEventListener.onPullEvent(this, this.mState, this.mCurrentMode);
        }
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1735037864")) {
            ipChange.ipc$dispatch("1735037864", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration());
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollToLonger(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758240241")) {
            ipChange.ipc$dispatch("758240241", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        smoothScrollTo(i, (long) getPullToRefreshScrollDurationLonger());
    }

    /* access modifiers changed from: protected */
    public void updateUIForMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539232406")) {
            ipChange.ipc$dispatch("-1539232406", new Object[]{this});
            return;
        }
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.mHeaderLayout.getParent()) {
            removeView(this.mHeaderLayout);
        }
        if (this.mMode.showHeaderLoadingLayout()) {
            addViewInternal(this.mHeaderLayout, 0, loadingLayoutLayoutParams);
        }
        if (this == this.mFooterLayout.getParent()) {
            removeView(this.mFooterLayout);
        }
        if (this.mMode.showFooterLoadingLayout()) {
            addViewInternal(this.mFooterLayout, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        Mode mode = this.mMode;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_FROM_START;
        }
        this.mCurrentMode = mode;
    }

    /* access modifiers changed from: protected */
    public final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "423989857")) {
            ipChange.ipc$dispatch("423989857", new Object[]{this, view, layoutParams});
            return;
        }
        super.addView(view, -1, layoutParams);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "390639615")) {
            return createLoadingLayoutProxy(z, z2);
        }
        return (ILoadingLayout) ipChange.ipc$dispatch("390639615", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692880025")) {
            ipChange.ipc$dispatch("692880025", new Object[]{this, drawable, mode});
            return;
        }
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665128910")) {
            ipChange.ipc$dispatch("665128910", new Object[]{this, charSequence, mode});
            return;
        }
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034612316")) {
            ipChange.ipc$dispatch("-2034612316", new Object[]{this, Boolean.valueOf(z)});
        } else if (!isRefreshing()) {
            setState(State.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402586452")) {
            ipChange.ipc$dispatch("-402586452", new Object[]{this, charSequence, mode});
            return;
        }
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130260088")) {
            ipChange.ipc$dispatch("-130260088", new Object[]{this, charSequence, mode});
            return;
        }
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344674831")) {
            ipChange.ipc$dispatch("-344674831", new Object[]{this, Integer.valueOf(i), onSmoothScrollFinishedListener});
            return;
        }
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration(), 0, onSmoothScrollFinishedListener);
    }

    private final void smoothScrollTo(int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048370660")) {
            ipChange.ipc$dispatch("-2048370660", new Object[]{this, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        smoothScrollTo(i, j, 0, null);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.IPullToRefresh
    public final void setOnRefreshListener(OnRefreshListener2<T> onRefreshListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006756468")) {
            ipChange.ipc$dispatch("2006756468", new Object[]{this, onRefreshListener2});
            return;
        }
        this.mOnRefreshListener2 = onRefreshListener2;
        this.mOnRefreshListener = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void smoothScrollTo(int i, long j, long j2, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626853233")) {
            ipChange.ipc$dispatch("1626853233", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), onSmoothScrollFinishedListener});
            return;
        }
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.mCurrentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            i2 = getScrollY();
        } else {
            i2 = getScrollX();
        }
        if (i2 != i) {
            if (this.mScrollAnimationInterpolator == null) {
                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(i2, i, j, onSmoothScrollFinishedListener);
            this.mCurrentSmoothScrollRunnable = smoothScrollRunnable2;
            if (j2 > 0) {
                postDelayed(smoothScrollRunnable2, j2);
            } else {
                post(smoothScrollRunnable2);
            }
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

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mMode = mode;
        this.mLoadingAnimationStyle = animationStyle;
        init(context, null);
    }
}
