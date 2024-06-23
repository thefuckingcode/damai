package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.member.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public class ScrollLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float DRAG_SPEED_MULTIPLIER = 1.2f;
    private static final int DRAG_SPEED_SLOP = 30;
    private static final int FLING_VELOCITY_SLOP = 80;
    private static final int MAX_SCROLL_DURATION = 400;
    private static final int MIN_SCROLL_DURATION = 100;
    private static final int MOTION_DISTANCE_SLOP = 10;
    private static final float SCROLL_TO_CLOSE_OFFSET_FACTOR = 0.5f;
    private static final float SCROLL_TO_EXIT_OFFSET_FACTOR = 0.8f;
    private final AbsListView.OnScrollListener associatedListViewListener = new AbsListView.OnScrollListener() {
        /* class cn.damai.ticklet.view.ScrollLayout.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1789060302")) {
                ipChange.ipc$dispatch("-1789060302", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            ScrollLayout.this.updateListViewScrollState(absListView);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "192383701")) {
                ipChange.ipc$dispatch("192383701", new Object[]{this, absListView, Integer.valueOf(i)});
                return;
            }
            ScrollLayout.this.updateListViewScrollState(absListView);
        }
    };
    private final RecyclerView.OnScrollListener associatedRecyclerViewListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.ticklet.view.ScrollLayout.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1149007402")) {
                ipChange.ipc$dispatch("-1149007402", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-878123639")) {
                ipChange.ipc$dispatch("-878123639", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
        }
    };
    private InnerStatus currentInnerStatus = InnerStatus.OPENED;
    private int exitOffset = 0;
    private GestureDetector gestureDetector;
    private final GestureDetector.OnGestureListener gestureListener;
    private boolean isAllowHorizontalScroll = true;
    private boolean isAllowPointerIntercepted = true;
    private boolean isCurrentPointerIntercepted = false;
    private boolean isDraggable = true;
    private boolean isEnable = true;
    private boolean isSupportExit = false;
    private float lastDownX;
    private float lastDownY;
    private Status lastFlingStatus = Status.CLOSED;
    private float lastX;
    private float lastY;
    private int maxOffset = 0;
    public int minOffset = 0;
    private OnScrollChangedListener onScrollChangedListener;
    private Scroller scroller;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum InnerStatus {
        EXIT,
        OPENED,
        CLOSED,
        MOVING,
        SCROLLING
    }

    /* compiled from: Taobao */
    public interface OnScrollChangedListener {
        void onChildScroll(int i);

        void onScrollFinished(Status status);

        void onScrollProgressChanged(float f);
    }

    /* compiled from: Taobao */
    public enum Status {
        EXIT,
        OPENED,
        CLOSED
    }

    /* compiled from: Taobao */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736021020")) {
                return ((Boolean) ipChange.ipc$dispatch("-1736021020", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (f2 > 80.0f) {
                Status status = ScrollLayout.this.lastFlingStatus;
                Status status2 = Status.OPENED;
                if (!status.equals(status2) || (-ScrollLayout.this.getScrollY()) <= ScrollLayout.this.maxOffset) {
                    ScrollLayout.this.scrollToOpen();
                    ScrollLayout.this.lastFlingStatus = status2;
                } else {
                    ScrollLayout.this.lastFlingStatus = Status.EXIT;
                    ScrollLayout.this.scrollToExit();
                }
                return true;
            } else {
                int i = (f2 > 80.0f ? 1 : (f2 == 80.0f ? 0 : -1));
                if (i < 0 && ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.maxOffset)) {
                    ScrollLayout.this.scrollToOpen();
                    ScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                } else if (i >= 0 || ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.maxOffset)) {
                    return false;
                } else {
                    ScrollLayout.this.scrollToClose();
                    ScrollLayout.this.lastFlingStatus = Status.CLOSED;
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[InnerStatus.values().length];
            a = iArr;
            iArr[InnerStatus.CLOSED.ordinal()] = 1;
            a[InnerStatus.OPENED.ordinal()] = 2;
            try {
                a[InnerStatus.EXIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ScrollLayout(Context context) {
        super(context);
        a aVar = new a();
        this.gestureListener = aVar;
        if (Build.VERSION.SDK_INT >= 11) {
            this.scroller = new Scroller(getContext(), null, true);
        } else {
            this.scroller = new Scroller(getContext());
        }
        this.gestureDetector = new GestureDetector(getContext(), aVar);
    }

    private void completeMove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306619616")) {
            ipChange.ipc$dispatch("1306619616", new Object[]{this});
            return;
        }
        float f = -(((float) (this.maxOffset - this.minOffset)) * 0.5f);
        if (((float) getScrollY()) > f) {
            scrollToClose();
        } else if (this.isSupportExit) {
            int i = this.exitOffset;
            int i2 = this.maxOffset;
            float f2 = -((((float) (i - i2)) * 0.8f) + ((float) i2));
            if (((float) getScrollY()) > f || ((float) getScrollY()) <= f2) {
                scrollToExit();
            } else {
                scrollToOpen();
            }
        } else {
            scrollToOpen();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[RETURN] */
    private boolean disposeEdgeValue(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229636398")) {
            return ((Boolean) ipChange.ipc$dispatch("-229636398", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (this.isSupportExit) {
            if (i > 0 || getScrollY() < (-this.minOffset)) {
                return i >= 0 && getScrollY() <= (-this.exitOffset);
            }
            return true;
        } else if (i <= 0 && getScrollY() >= (-this.minOffset)) {
            return true;
        } else {
            if (i >= 0 && getScrollY() <= (-this.maxOffset)) {
                return true;
            }
        }
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719087967")) {
            ipChange.ipc$dispatch("719087967", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollLayout);
        int i = R$styleable.ScrollLayout_maxOffset;
        if (obtainStyledAttributes.hasValue(i) && (dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(i, this.maxOffset)) != getScreenHeight()) {
            this.maxOffset = getScreenHeight() - dimensionPixelOffset2;
        }
        int i2 = R$styleable.ScrollLayout_minOffset;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.minOffset = obtainStyledAttributes.getDimensionPixelOffset(i2, this.minOffset);
        }
        int i3 = R$styleable.ScrollLayout_exitOffset;
        if (obtainStyledAttributes.hasValue(i3) && (dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i3, getScreenHeight())) != getScreenHeight()) {
            this.exitOffset = getScreenHeight() - dimensionPixelOffset;
        }
        int i4 = R$styleable.ScrollLayout_allowHorizontalScroll;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.isAllowHorizontalScroll = obtainStyledAttributes.getBoolean(i4, true);
        }
        int i5 = R$styleable.ScrollLayout_isSupportExit;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.isSupportExit = obtainStyledAttributes.getBoolean(i5, true);
        }
        int i6 = R$styleable.ScrollLayout_scrollMode;
        if (obtainStyledAttributes.hasValue(i6)) {
            int integer = obtainStyledAttributes.getInteger(i6, 0);
            if (integer == 0) {
                setToOpen();
            } else if (integer == 1) {
                setToClosed();
            } else if (integer != 2) {
                setToClosed();
            } else {
                setToExit();
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void onScrollFinished(Status status) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061166764")) {
            ipChange.ipc$dispatch("-1061166764", new Object[]{this, status});
            return;
        }
        OnScrollChangedListener onScrollChangedListener2 = this.onScrollChangedListener;
        if (onScrollChangedListener2 != null) {
            onScrollChangedListener2.onScrollFinished(status);
        }
    }

    private void onScrollProgressChanged(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862151461")) {
            ipChange.ipc$dispatch("-1862151461", new Object[]{this, Float.valueOf(f)});
            return;
        }
        OnScrollChangedListener onScrollChangedListener2 = this.onScrollChangedListener;
        if (onScrollChangedListener2 != null) {
            onScrollChangedListener2.onScrollProgressChanged(f);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateListViewScrollState(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896799443")) {
            ipChange.ipc$dispatch("-1896799443", new Object[]{this, absListView});
        } else if (absListView.getChildCount() == 0) {
            setDraggable(true);
        } else if (absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() == absListView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateRecyclerViewScrollState(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96068338")) {
            ipChange.ipc$dispatch("-96068338", new Object[]{this, recyclerView});
        } else if (recyclerView.getChildCount() == 0) {
            setDraggable(true);
        } else {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int[] iArr = new int[1];
            if ((layoutManager instanceof LinearLayoutManager) || (layoutManager instanceof GridLayoutManager)) {
                iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                iArr = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
            }
            if (iArr[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
                setDraggable(true);
            } else {
                setDraggable(false);
            }
        }
    }

    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "812674396")) {
            ipChange.ipc$dispatch("812674396", new Object[]{this});
        } else if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
            int currY = this.scroller.getCurrY();
            scrollTo(0, currY);
            if (currY == (-this.minOffset) || currY == (-this.maxOffset) || (this.isSupportExit && currY == (-this.exitOffset))) {
                this.scroller.abortAnimation();
            } else {
                invalidate();
            }
        }
    }

    public Status getCurrentStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721739003")) {
            return (Status) ipChange.ipc$dispatch("-721739003", new Object[]{this});
        }
        int i = b.a[this.currentInnerStatus.ordinal()];
        if (i == 1) {
            return Status.CLOSED;
        }
        if (i == 2) {
            return Status.OPENED;
        }
        if (i != 3) {
            return Status.OPENED;
        }
        return Status.EXIT;
    }

    public int getScreenHeight() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-237630678")) {
            return ((Integer) ipChange.ipc$dispatch("-237630678", new Object[]{this})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((Activity) getContext()).getWindowManager().getDefaultDisplay(), displayMetrics);
        int identifier = getContext().getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            i = getContext().getResources().getDimensionPixelSize(identifier);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) - i;
    }

    public boolean isAllowHorizontalScroll() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1576311700")) {
            return this.isAllowHorizontalScroll;
        }
        return ((Boolean) ipChange.ipc$dispatch("1576311700", new Object[]{this})).booleanValue();
    }

    public boolean isDraggable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-488504799")) {
            return this.isDraggable;
        }
        return ((Boolean) ipChange.ipc$dispatch("-488504799", new Object[]{this})).booleanValue();
    }

    public boolean isSupportExit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1193234657")) {
            return this.isSupportExit;
        }
        return ((Boolean) ipChange.ipc$dispatch("1193234657", new Object[]{this})).booleanValue();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1383881979")) {
            return ((Boolean) ipChange.ipc$dispatch("1383881979", new Object[]{this, motionEvent})).booleanValue();
        } else if (!this.isEnable) {
            return false;
        } else {
            if (!this.isDraggable && this.currentInnerStatus == InnerStatus.CLOSED) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (!this.isAllowPointerIntercepted) {
                        return false;
                    } else {
                        if (this.isCurrentPointerIntercepted) {
                            return true;
                        }
                        int y = (int) (motionEvent.getY() - this.lastDownY);
                        int x = (int) (motionEvent.getX() - this.lastDownX);
                        if (Math.abs(y) < 10) {
                            return false;
                        }
                        if (Math.abs(y) >= Math.abs(x) || !this.isAllowHorizontalScroll) {
                            InnerStatus innerStatus = this.currentInnerStatus;
                            if (innerStatus == InnerStatus.CLOSED) {
                                if (y < 0) {
                                    return false;
                                }
                            } else if (innerStatus == InnerStatus.OPENED && !this.isSupportExit && y > 0) {
                                return false;
                            }
                            this.isCurrentPointerIntercepted = true;
                            return true;
                        }
                        this.isAllowPointerIntercepted = false;
                        this.isCurrentPointerIntercepted = false;
                        return false;
                    }
                }
                this.isAllowPointerIntercepted = true;
                this.isCurrentPointerIntercepted = false;
                if (this.currentInnerStatus == InnerStatus.MOVING) {
                    return true;
                }
            } else {
                this.lastX = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.lastY = y2;
                this.lastDownX = this.lastX;
                this.lastDownY = y2;
                this.isAllowPointerIntercepted = true;
                this.isCurrentPointerIntercepted = false;
                if (!this.scroller.isFinished()) {
                    this.scroller.forceFinished(true);
                    this.currentInnerStatus = InnerStatus.MOVING;
                    this.isCurrentPointerIntercepted = true;
                    return true;
                }
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1739568695")) {
            return ((Boolean) ipChange.ipc$dispatch("-1739568695", new Object[]{this, motionEvent})).booleanValue();
        } else if (!this.isCurrentPointerIntercepted) {
            return false;
        } else {
            this.gestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) ((motionEvent.getY() - this.lastY) * DRAG_SPEED_MULTIPLIER);
                        int signum = ((int) Math.signum((float) y)) * Math.min(Math.abs(y), 30);
                        if (disposeEdgeValue(signum)) {
                            return true;
                        }
                        this.currentInnerStatus = InnerStatus.MOVING;
                        int scrollY = getScrollY() - signum;
                        int i = this.minOffset;
                        if (scrollY >= (-i)) {
                            scrollTo(0, -i);
                        } else {
                            int i2 = this.maxOffset;
                            if (scrollY > (-i2) || this.isSupportExit) {
                                scrollTo(0, scrollY);
                            } else {
                                scrollTo(0, -i2);
                            }
                        }
                        this.lastY = motionEvent.getY();
                        return true;
                    } else if (action != 3) {
                        return false;
                    }
                }
                if (this.currentInnerStatus != InnerStatus.MOVING) {
                    return false;
                }
                completeMove();
                return true;
            }
            this.lastY = motionEvent.getY();
            return true;
        }
    }

    public void scrollTo(int i, int i2) {
        InnerStatus innerStatus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363156226")) {
            ipChange.ipc$dispatch("363156226", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.scrollTo(i, i2);
        int i3 = this.maxOffset;
        int i4 = this.minOffset;
        if (i3 != i4) {
            int i5 = -i2;
            if (i5 <= i3) {
                onScrollProgressChanged(((float) (i5 - i4)) / ((float) (i3 - i4)));
            } else {
                onScrollProgressChanged(((float) (i5 - i3)) / ((float) (i3 - this.exitOffset)));
            }
            if (i2 == (-this.minOffset)) {
                InnerStatus innerStatus2 = this.currentInnerStatus;
                InnerStatus innerStatus3 = InnerStatus.CLOSED;
                if (innerStatus2 != innerStatus3) {
                    this.currentInnerStatus = innerStatus3;
                    onScrollFinished(Status.CLOSED);
                }
            } else if (i2 == (-this.maxOffset)) {
                InnerStatus innerStatus4 = this.currentInnerStatus;
                InnerStatus innerStatus5 = InnerStatus.OPENED;
                if (innerStatus4 != innerStatus5) {
                    this.currentInnerStatus = innerStatus5;
                    onScrollFinished(Status.OPENED);
                }
            } else if (this.isSupportExit && i2 == (-this.exitOffset) && this.currentInnerStatus != (innerStatus = InnerStatus.EXIT)) {
                this.currentInnerStatus = innerStatus;
                onScrollFinished(Status.EXIT);
            }
        }
    }

    public void scrollToClose() {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1730341648")) {
            ipChange.ipc$dispatch("1730341648", new Object[]{this});
        } else if (this.currentInnerStatus != InnerStatus.CLOSED && this.maxOffset != this.minOffset && (i2 = (-getScrollY()) - (i = this.minOffset)) != 0) {
            this.currentInnerStatus = InnerStatus.SCROLLING;
            this.scroller.startScroll(0, getScrollY(), 0, i2, Math.abs((i2 * 300) / (this.maxOffset - i)) + 100);
            invalidate();
        }
    }

    public void scrollToExit() {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849067868")) {
            ipChange.ipc$dispatch("-1849067868", new Object[]{this});
        } else if (this.isSupportExit && this.currentInnerStatus != InnerStatus.EXIT && this.exitOffset != this.maxOffset && (i2 = (-getScrollY()) - (i = this.exitOffset)) != 0) {
            this.currentInnerStatus = InnerStatus.SCROLLING;
            this.scroller.startScroll(0, getScrollY(), 0, i2, Math.abs((i2 * 300) / (i - this.maxOffset)) + 100);
            invalidate();
        }
    }

    public void scrollToOpen() {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796871688")) {
            ipChange.ipc$dispatch("-1796871688", new Object[]{this});
        } else if (this.currentInnerStatus != InnerStatus.OPENED && this.maxOffset != this.minOffset && (i2 = (-getScrollY()) - (i = this.maxOffset)) != 0) {
            this.currentInnerStatus = InnerStatus.SCROLLING;
            this.scroller.startScroll(0, getScrollY(), 0, i2, Math.abs((i2 * 300) / (i - this.minOffset)) + 100);
            invalidate();
        }
    }

    public void setAllowHorizontalScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897621502")) {
            ipChange.ipc$dispatch("-897621502", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isAllowHorizontalScroll = z;
    }

    public void setAssociatedListView(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775244646")) {
            ipChange.ipc$dispatch("-775244646", new Object[]{this, absListView});
            return;
        }
        absListView.setOnScrollListener(this.associatedListViewListener);
        updateListViewScrollState(absListView);
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089321699")) {
            ipChange.ipc$dispatch("2089321699", new Object[]{this, recyclerView});
            return;
        }
        recyclerView.addOnScrollListener(this.associatedRecyclerViewListener);
        updateRecyclerViewScrollState(recyclerView);
    }

    public void setDraggable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731871765")) {
            ipChange.ipc$dispatch("731871765", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isDraggable = z;
    }

    public void setEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815337063")) {
            ipChange.ipc$dispatch("-815337063", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isEnable = z;
    }

    public void setExitOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564046058")) {
            ipChange.ipc$dispatch("-1564046058", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.exitOffset = getScreenHeight() - i;
    }

    public void setIsSupportExit(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390622987")) {
            ipChange.ipc$dispatch("390622987", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSupportExit = z;
    }

    public void setMaxOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885651662")) {
            ipChange.ipc$dispatch("1885651662", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.maxOffset = getScreenHeight() - i;
    }

    public void setMinOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587009476")) {
            ipChange.ipc$dispatch("-587009476", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.minOffset = i;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2110533710")) {
            ipChange.ipc$dispatch("-2110533710", new Object[]{this, onScrollChangedListener2});
            return;
        }
        this.onScrollChangedListener = onScrollChangedListener2;
    }

    public void setToClosed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870617495")) {
            ipChange.ipc$dispatch("870617495", new Object[]{this});
            return;
        }
        scrollTo(0, -this.minOffset);
        this.currentInnerStatus = InnerStatus.CLOSED;
        this.lastFlingStatus = Status.CLOSED;
    }

    public void setToExit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228976165")) {
            ipChange.ipc$dispatch("1228976165", new Object[]{this});
        } else if (this.isSupportExit) {
            scrollTo(0, -this.exitOffset);
            this.currentInnerStatus = InnerStatus.EXIT;
        }
    }

    public void setToOpen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281172345")) {
            ipChange.ipc$dispatch("1281172345", new Object[]{this});
            return;
        }
        scrollTo(0, -this.maxOffset);
        this.currentInnerStatus = InnerStatus.OPENED;
        this.lastFlingStatus = Status.OPENED;
    }

    public void showOrHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100177064")) {
            ipChange.ipc$dispatch("1100177064", new Object[]{this});
            return;
        }
        InnerStatus innerStatus = this.currentInnerStatus;
        if (innerStatus == InnerStatus.OPENED) {
            scrollToClose();
        } else if (innerStatus == InnerStatus.CLOSED) {
            scrollToOpen();
        }
    }

    public ScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a();
        this.gestureListener = aVar;
        if (Build.VERSION.SDK_INT >= 11) {
            this.scroller = new Scroller(getContext(), null, true);
        } else {
            this.scroller = new Scroller(getContext());
        }
        this.gestureDetector = new GestureDetector(getContext(), aVar);
        initFromAttributes(context, attributeSet);
    }

    public ScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a();
        this.gestureListener = aVar;
        if (Build.VERSION.SDK_INT >= 11) {
            this.scroller = new Scroller(getContext(), null, true);
        } else {
            this.scroller = new Scroller(getContext());
        }
        this.gestureDetector = new GestureDetector(getContext(), aVar);
        initFromAttributes(context, attributeSet);
    }
}
