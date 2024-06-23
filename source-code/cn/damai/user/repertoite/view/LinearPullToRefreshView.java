package cn.damai.user.repertoite.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LinearPullToRefreshView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing = true;
    private final Handler handler = new Handler();
    private int headerHeight;
    private PullToRefreshHeaderView headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged = false;
    private boolean isPullToRefreshEnabled = true;
    private float lastAddMontionY;
    private float lastMotionX;
    private float lastMotionY;
    private OnRefreshListener onRefreshListener;
    private OnUpOrDownListener onUpOrDownListener;
    private int state = 0;
    private int touchSlop;

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
            if (AndroidInstantRuntime.support(ipChange, "1346759472")) {
                ipChange.ipc$dispatch("1346759472", new Object[]{this});
                return;
            }
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int round = this.scrollFromY - Math.round(((float) (this.scrollFromY - this.scrollToY)) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f));
                this.currentY = round;
                LinearPullToRefreshView.this.setHeaderScroll(round);
            }
            if (this.continueRunning && this.scrollToY != this.currentY) {
                this.handler.postDelayed(this, 16);
            }
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-338188595")) {
                ipChange.ipc$dispatch("-338188595", new Object[]{this});
                return;
            }
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public LinearPullToRefreshView(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118319153")) {
            ipChange.ipc$dispatch("-2118319153", new Object[]{this});
            return;
        }
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        this.headerLayout = PullToRefreshHeaderView.getInstance(getContext(), true);
        addView(this.headerLayout, 0, new LinearLayout.LayoutParams(-1, -2));
        measureView(this.headerLayout);
        int measuredHeight = this.headerLayout.getMeasuredHeight();
        this.headerHeight = measuredHeight;
        setPadding(0, -measuredHeight, 0, 0);
    }

    private void measureView(View view) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767290634")) {
            ipChange.ipc$dispatch("1767290634", new Object[]{this, view});
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593800486")) {
            return ((Boolean) ipChange.ipc$dispatch("-593800486", new Object[]{this})).booleanValue();
        }
        int scrollY = getScrollY();
        int round = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        setHeaderScroll(round);
        if (round != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(round)) {
                this.state = 1;
                this.headerLayout.onRelease();
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(round)) {
                this.state = 0;
                this.headerLayout.onRelease();
                return true;
            }
        }
        if (Math.abs(round) >= this.headerHeight) {
            this.headerLayout.onMove(false, false, Math.abs(round));
        } else {
            this.headerLayout.onReset();
        }
        if (scrollY != round) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int getHeaderHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "747123956")) {
            return this.headerHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("747123956", new Object[]{this})).intValue();
    }

    public final PullToRefreshHeaderView getHeaderLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1318919102")) {
            return this.headerLayout;
        }
        return (PullToRefreshHeaderView) ipChange.ipc$dispatch("1318919102", new Object[]{this});
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "266069422")) {
            return this.disableScrollingWhileRefreshing;
        }
        return ((Boolean) ipChange.ipc$dispatch("266069422", new Object[]{this})).booleanValue();
    }

    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1371321741")) {
            return this.isPullToRefreshEnabled;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1371321741", new Object[]{this})).booleanValue();
    }

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151578798")) {
            return ((Boolean) ipChange.ipc$dispatch("-151578798", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 2 || i == 3;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnUpOrDownListener onUpOrDownListener2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579554874")) {
            return ((Boolean) ipChange.ipc$dispatch("-1579554874", new Object[]{this, motionEvent})).booleanValue();
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
                float y = motionEvent.getY();
                this.initialMotionY = y;
                this.lastMotionY = y;
                this.lastMotionX = motionEvent.getX();
                this.isBeingDragged = false;
            } else if (action == 2) {
                if (motionEvent.getY() - this.lastAddMontionY > 20.0f) {
                    OnUpOrDownListener onUpOrDownListener3 = this.onUpOrDownListener;
                    if (onUpOrDownListener3 != null) {
                        onUpOrDownListener3.ondown();
                    }
                } else if (motionEvent.getY() - this.lastAddMontionY < -20.0f && (onUpOrDownListener2 = this.onUpOrDownListener) != null) {
                    onUpOrDownListener2.onup();
                }
                float y2 = motionEvent.getY();
                float f = y2 - this.lastMotionY;
                float abs = Math.abs(f);
                float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                if (abs > ((float) this.touchSlop) && abs > abs2) {
                    if (f >= 1.0E-4f) {
                        this.lastMotionY = y2;
                        this.isBeingDragged = true;
                    } else if (f <= 1.0E-4f) {
                        this.lastMotionY = y2;
                        this.isBeingDragged = false;
                    }
                }
            }
            return this.isBeingDragged;
        }
    }

    public final void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099373782")) {
            ipChange.ipc$dispatch("2099373782", new Object[]{this});
        } else if (this.state != 0) {
            resetHeader();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        if (r0 != 3) goto L_0x007e;
     */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117495650")) {
            return ((Boolean) ipChange.ipc$dispatch("-1117495650", new Object[]{this, motionEvent})).booleanValue();
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
                    return false;
                }
                if (this.isBeingDragged) {
                    this.isBeingDragged = false;
                    if (this.state != 1 || this.onRefreshListener == null) {
                        smoothScrollTo(0);
                    } else {
                        setRefreshingInternal(true);
                        this.headerLayout.onMove(false, false, 10000);
                        this.headerLayout.onRefresh();
                        this.onRefreshListener.onRefresh();
                    }
                    return true;
                }
                return false;
            }
            float y = motionEvent.getY();
            this.initialMotionY = y;
            this.lastMotionY = y;
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880806769")) {
            ipChange.ipc$dispatch("-1880806769", new Object[]{this});
            return;
        }
        this.state = 0;
        this.isBeingDragged = false;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onReset();
        }
        smoothScrollTo(0);
        this.headerLayout.onComplete();
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239427998")) {
            ipChange.ipc$dispatch("239427998", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.disableScrollingWhileRefreshing = z;
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281784364")) {
            ipChange.ipc$dispatch("-1281784364", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        scrollTo(0, i);
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627668642")) {
            ipChange.ipc$dispatch("627668642", new Object[]{this, onRefreshListener2});
            return;
        }
        this.onRefreshListener = onRefreshListener2;
    }

    public final void setOnUpOrDownListener(OnUpOrDownListener onUpOrDownListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561534704")) {
            ipChange.ipc$dispatch("561534704", new Object[]{this, onUpOrDownListener2});
            return;
        }
        this.onUpOrDownListener = onUpOrDownListener2;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934209135")) {
            ipChange.ipc$dispatch("-1934209135", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isPullToRefreshEnabled = z;
    }

    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666558590")) {
            ipChange.ipc$dispatch("-1666558590", new Object[]{this});
            return;
        }
        setRefreshing(true);
        this.headerLayout.onRefresh();
    }

    /* access modifiers changed from: protected */
    public void setRefreshingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515536111")) {
            ipChange.ipc$dispatch("1515536111", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.state = 2;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onRefresh();
        }
        if (z) {
            smoothScrollTo(-this.headerHeight);
        }
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844925818")) {
            ipChange.ipc$dispatch("844925818", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123662958")) {
            ipChange.ipc$dispatch("-123662958", new Object[]{this, Boolean.valueOf(z)});
        } else if (!isRefreshing()) {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public LinearPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
