package cn.damai.baseview.pull.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    public static final int MODE_BOTH = 3;
    public static final int MODE_PULL_DOWN_TO_REFRESH = 1;
    public static final int MODE_PULL_UP_TO_REFRESH = 2;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private int currentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing = true;
    private LoadingLayout footerLayout;
    private final Handler handler = new Handler();
    private int headerHeight;
    private LoadingLayout headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged = false;
    private boolean isPullToRefreshEnabled = true;
    private float lastAddMontionY;
    private float lastMotionX;
    private float lastMotionY;
    private int mode = 1;
    private OnRefreshListener onRefreshListener;
    private OnUpOrDownListener onUpOrDownListener;
    T refreshableView;
    private int state = 0;
    private int touchSlop;

    /* compiled from: Taobao */
    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    /* compiled from: Taobao */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* compiled from: Taobao */
    public interface OnUpOrDownListener {
        void ondown();

        void onup();
    }

    /* compiled from: Taobao */
    public final class SmoothScrollRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int ANIMATION_DURATION_MS = 190;
        static final int ANIMATION_FPS = 16;
        private boolean continueRunning = true;
        private int currentY = -1;
        private final Handler handler;
        private final Interpolator interpolator;
        private final int scrollFromY;
        private final int scrollToY;
        private long startTime = -1;

        public SmoothScrollRunnable(Handler handler2, int i, int i2) {
            this.handler = handler2;
            this.scrollFromY = i;
            this.scrollToY = i2;
            this.interpolator = new AccelerateDecelerateInterpolator();
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "590523708")) {
                ipChange.ipc$dispatch("590523708", new Object[]{this});
                return;
            }
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int round = this.scrollFromY - Math.round(((float) (this.scrollFromY - this.scrollToY)) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f));
                this.currentY = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (this.continueRunning && this.scrollToY != this.currentY) {
                this.handler.postDelayed(this, 16);
            }
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1988306497")) {
                ipChange.ipc$dispatch("1988306497", new Object[]{this});
                return;
            }
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002716255")) {
            ipChange.ipc$dispatch("-1002716255", new Object[]{this, context, attributeSet});
            return;
        }
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        int i2 = R$styleable.PullToRefresh_mode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mode = obtainStyledAttributes.getInteger(i2, 1);
        }
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.refreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        String string = context.getString(R$string.pull_to_refresh_pull_label);
        String string2 = context.getString(R$string.pull_to_refresh_refreshing_label);
        String string3 = context.getString(R$string.pull_to_refresh_release_label);
        int i3 = this.mode;
        if (i3 == 1 || i3 == 3) {
            i = -1;
            LoadingLayout loadingLayout = new LoadingLayout(context, 1, string3, string, string2);
            this.headerLayout = loadingLayout;
            addView(loadingLayout, 0, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.headerLayout);
            this.headerHeight = this.headerLayout.getMeasuredHeight();
        } else {
            i = -1;
        }
        int i4 = this.mode;
        if (i4 == 2 || i4 == 3) {
            LoadingLayout loadingLayout2 = new LoadingLayout(context, 2, string3, string, string2);
            this.footerLayout = loadingLayout2;
            addView(loadingLayout2, new LinearLayout.LayoutParams(i, -2));
            measureView(this.footerLayout);
            this.headerHeight = this.footerLayout.getMeasuredHeight();
        }
        int i5 = R$styleable.PullToRefresh_headerTextColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            int color = obtainStyledAttributes.getColor(i5, -16777216);
            LoadingLayout loadingLayout3 = this.headerLayout;
            if (loadingLayout3 != null) {
                loadingLayout3.setTextColor(color);
            }
            LoadingLayout loadingLayout4 = this.footerLayout;
            if (loadingLayout4 != null) {
                loadingLayout4.setTextColor(color);
            }
        }
        int i6 = R$styleable.PullToRefresh_headerBackground;
        if (obtainStyledAttributes.hasValue(i6)) {
            setBackgroundResource(obtainStyledAttributes.getResourceId(i6, i));
        }
        int i7 = R$styleable.PullToRefresh_adapterViewBackground;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.refreshableView.setBackgroundResource(obtainStyledAttributes.getResourceId(i7, i));
        }
        obtainStyledAttributes.recycle();
        int i8 = this.mode;
        if (i8 == 2) {
            setPadding(0, 0, 0, -this.headerHeight);
        } else if (i8 != 3) {
            setPadding(0, -this.headerHeight, 0, 0);
        } else {
            int i9 = this.headerHeight;
            setPadding(0, -i9, 0, -i9);
        }
        int i10 = this.mode;
        if (i10 != 3) {
            this.currentMode = i10;
        }
    }

    private boolean isReadyForPull() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891972230")) {
            return ((Boolean) ipChange.ipc$dispatch("-891972230", new Object[]{this})).booleanValue();
        }
        int i = this.mode;
        if (i == 1) {
            return isReadyForPullDown();
        }
        if (i == 2) {
            return isReadyForPullUp();
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1324662806")) {
            ipChange.ipc$dispatch("1324662806", new Object[]{this, view});
            return;
        }
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

    private boolean pullEvent() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392261710")) {
            return ((Boolean) ipChange.ipc$dispatch("1392261710", new Object[]{this})).booleanValue();
        }
        int scrollY = getScrollY();
        if (this.currentMode != 2) {
            i = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        } else {
            i = Math.round(Math.max(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        }
        setHeaderScroll(i);
        if (i != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(i)) {
                this.state = 1;
                int i2 = this.currentMode;
                if (i2 == 1) {
                    this.headerLayout.releaseToRefresh();
                } else if (i2 == 2) {
                    this.footerLayout.releaseToRefresh();
                }
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(i)) {
                this.state = 0;
                int i3 = this.currentMode;
                if (i3 == 1) {
                    this.headerLayout.pullToRefresh();
                } else if (i3 == 2) {
                    this.footerLayout.pullToRefresh();
                }
                return true;
            }
        }
        if (scrollY != i) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void addRefreshableView(Context context, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685062468")) {
            ipChange.ipc$dispatch("-685062468", new Object[]{this, context, t});
            return;
        }
        addView(t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* access modifiers changed from: protected */
    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public final T getAdapterView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2068928433")) {
            return this.refreshableView;
        }
        return (T) ((View) ipChange.ipc$dispatch("-2068928433", new Object[]{this}));
    }

    /* access modifiers changed from: protected */
    public final int getCurrentMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-437738472")) {
            return this.currentMode;
        }
        return ((Integer) ipChange.ipc$dispatch("-437738472", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1018681871")) {
            return this.footerLayout;
        }
        return (LoadingLayout) ipChange.ipc$dispatch("-1018681871", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public final int getHeaderHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "313701736")) {
            return this.headerHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("313701736", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-415403421")) {
            return this.headerLayout;
        }
        return (LoadingLayout) ipChange.ipc$dispatch("-415403421", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public final int getMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1131908231")) {
            return this.mode;
        }
        return ((Integer) ipChange.ipc$dispatch("-1131908231", new Object[]{this})).intValue();
    }

    public final T getRefreshableView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1455869527")) {
            return this.refreshableView;
        }
        return (T) ((View) ipChange.ipc$dispatch("-1455869527", new Object[]{this}));
    }

    public final boolean hasPullFromTop() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1195935651")) {
            return this.currentMode != 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("1195935651", new Object[]{this})).booleanValue();
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-509955806")) {
            return this.disableScrollingWhileRefreshing;
        }
        return ((Boolean) ipChange.ipc$dispatch("-509955806", new Object[]{this})).booleanValue();
    }

    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "223420287")) {
            return this.isPullToRefreshEnabled;
        }
        return ((Boolean) ipChange.ipc$dispatch("223420287", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullDown();

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullUp();

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842167458")) {
            return ((Boolean) ipChange.ipc$dispatch("-842167458", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 2 || i == 3;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnUpOrDownListener onUpOrDownListener2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137023034")) {
            return ((Boolean) ipChange.ipc$dispatch("1137023034", new Object[]{this, motionEvent})).booleanValue();
        }
        if (!this.isPullToRefreshEnabled) {
            return false;
        }
        if (isRefreshing() && this.disableScrollingWhileRefreshing) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.isBeingDragged = false;
            return false;
        } else if (action != 0 && this.isBeingDragged) {
            return true;
        } else {
            if (action == 0) {
                this.lastAddMontionY = motionEvent.getY();
                if (isReadyForPull()) {
                    float y = motionEvent.getY();
                    this.initialMotionY = y;
                    this.lastMotionY = y;
                    this.lastMotionX = motionEvent.getX();
                    this.isBeingDragged = false;
                }
            } else if (action == 2) {
                if (motionEvent.getY() - this.lastAddMontionY > 20.0f) {
                    OnUpOrDownListener onUpOrDownListener3 = this.onUpOrDownListener;
                    if (onUpOrDownListener3 != null) {
                        onUpOrDownListener3.ondown();
                    }
                } else if (motionEvent.getY() - this.lastAddMontionY < -20.0f && (onUpOrDownListener2 = this.onUpOrDownListener) != null) {
                    onUpOrDownListener2.onup();
                }
                if (isReadyForPull()) {
                    float y2 = motionEvent.getY();
                    float f = y2 - this.lastMotionY;
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                    if (abs > ((float) this.touchSlop) && abs > abs2) {
                        int i = this.mode;
                        if ((i == 1 || i == 3) && f >= 1.0E-4f && isReadyForPullDown()) {
                            this.lastMotionY = y2;
                            this.isBeingDragged = true;
                            if (this.mode == 3) {
                                this.currentMode = 1;
                            }
                        } else {
                            int i2 = this.mode;
                            if ((i2 == 2 || i2 == 3) && f <= 1.0E-4f && isReadyForPullUp()) {
                                this.lastMotionY = y2;
                                this.isBeingDragged = true;
                                if (this.mode == 3) {
                                    this.currentMode = 2;
                                }
                            }
                        }
                    }
                }
            }
            return this.isBeingDragged;
        }
    }

    public final void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2102519222")) {
            ipChange.ipc$dispatch("-2102519222", new Object[]{this});
        } else if (this.state != 0) {
            resetHeader();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        if (r0 != 3) goto L_0x0081;
     */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145477718")) {
            return ((Boolean) ipChange.ipc$dispatch("-2145477718", new Object[]{this, motionEvent})).booleanValue();
        } else if (!this.isPullToRefreshEnabled) {
            return false;
        } else {
            if (isRefreshing() && this.disableScrollingWhileRefreshing) {
                return true;
            }
            if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.isBeingDragged) {
                            this.lastMotionY = motionEvent.getY();
                            pullEvent();
                            return true;
                        }
                    }
                }
                if (this.isBeingDragged) {
                    this.isBeingDragged = false;
                    if (this.state != 1 || this.onRefreshListener == null) {
                        smoothScrollTo(0);
                    } else {
                        setRefreshingInternal(true);
                        this.onRefreshListener.onRefresh();
                    }
                    return true;
                }
            } else if (isReadyForPull()) {
                float y = motionEvent.getY();
                this.initialMotionY = y;
                this.lastMotionY = y;
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240515837")) {
            ipChange.ipc$dispatch("-240515837", new Object[]{this});
            return;
        }
        this.state = 0;
        this.isBeingDragged = false;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.reset();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.reset();
        }
        smoothScrollTo(0);
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803493394")) {
            ipChange.ipc$dispatch("1803493394", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.disableScrollingWhileRefreshing = z;
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1832971296")) {
            ipChange.ipc$dispatch("-1832971296", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        scrollTo(0, i);
    }

    public void setLongClickable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863070925")) {
            ipChange.ipc$dispatch("863070925", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        getRefreshableView().setLongClickable(z);
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068187350")) {
            ipChange.ipc$dispatch("-2068187350", new Object[]{this, onRefreshListener2});
            return;
        }
        this.onRefreshListener = onRefreshListener2;
    }

    public final void setOnUpOrDownListener(OnUpOrDownListener onUpOrDownListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378013802")) {
            ipChange.ipc$dispatch("-378013802", new Object[]{this, onUpOrDownListener2});
            return;
        }
        this.onUpOrDownListener = onUpOrDownListener2;
    }

    public void setPullLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331615576")) {
            ipChange.ipc$dispatch("-331615576", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setPullLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setPullLabel(str);
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1604522397")) {
            ipChange.ipc$dispatch("1604522397", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isPullToRefreshEnabled = z;
    }

    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599970570")) {
            ipChange.ipc$dispatch("-1599970570", new Object[]{this});
            return;
        }
        setRefreshing(true);
    }

    /* access modifiers changed from: protected */
    public void setRefreshingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184689157")) {
            ipChange.ipc$dispatch("-1184689157", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.state = 2;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.refreshing();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.refreshing();
        }
        if (z) {
            smoothScrollTo(this.currentMode == 1 ? -this.headerHeight : this.headerHeight);
        }
    }

    public void setRefreshingLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961660682")) {
            ipChange.ipc$dispatch("961660682", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setRefreshingLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setRefreshingLabel(str);
        }
    }

    public void setReleaseLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111423226")) {
            ipChange.ipc$dispatch("1111423226", new Object[]{this, str});
            return;
        }
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setReleaseLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setReleaseLabel(str);
        }
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411503598")) {
            ipChange.ipc$dispatch("411503598", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940565662")) {
            ipChange.ipc$dispatch("1940565662", new Object[]{this, Boolean.valueOf(z)});
        } else if (!isRefreshing()) {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public PullToRefreshBase(Context context, int i) {
        super(context);
        this.mode = i;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
