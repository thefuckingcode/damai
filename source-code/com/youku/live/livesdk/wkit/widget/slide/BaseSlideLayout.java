package com.youku.live.livesdk.wkit.widget.slide;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.ViewConfigurationCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ContextUtils;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.dom.CSSLayout;
import java.util.List;

/* compiled from: Taobao */
public class BaseSlideLayout extends CSSLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_LR_SHOW_DURATION = 200;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "LiveHouseSlidingDrawer";
    private Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1523406299")) {
                ipChange.ipc$dispatch("1523406299", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            BaseSlideLayout.this.onTouchClick(message.arg1, message.arg2, message.what);
        }
    };
    private boolean isClearScreen = false;
    private boolean isFullScreen;
    private boolean isLrEnabled = true;
    long mCurTime = 0;
    private int mEndX = 0;
    private int mEndY = 0;
    private View mFirstSliderContainer;
    private int mHorizontalRange;
    private boolean mIntercept = false;
    private boolean mIsClearScreen = false;
    private boolean mIsContentViewShow = false;
    private boolean mIsLeftSlide = true;
    private boolean mIsShow = true;
    long mLastTime = 0;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int mScrollX = 0;
    private int mScrollY = 0;
    private OverScroller mScroller;
    private int mSlideDistance = 0;
    private List<View> mSliderContainers;
    private int mStartX = 0;
    private int mStartY = 0;
    private StatusListener mStatusListener;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* compiled from: Taobao */
    public interface StatusListener {
        void onHideContent();

        void onShowContent();

        void onTouchClick(int i, int i2, int i3);
    }

    public BaseSlideLayout(Context context) {
        super(context);
        init(context);
    }

    private int containerGetScrollX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040958641")) {
            return ((Integer) ipChange.ipc$dispatch("2040958641", new Object[]{this})).intValue();
        }
        View view = this.mFirstSliderContainer;
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    private void containerScrollTo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524177867")) {
            ipChange.ipc$dispatch("1524177867", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        List<View> list = this.mSliderContainers;
        if (list != null && list.size() > 0) {
            for (View view : this.mSliderContainers) {
                if (view != null) {
                    view.scrollTo(i, i2);
                }
            }
        }
    }

    private void handleLrActionEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117597341")) {
            ipChange.ipc$dispatch("2117597341", new Object[]{this});
        } else if (this.mFirstSliderContainer != null && this.isLrEnabled) {
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            this.mSlideDistance = this.isFullScreen ? this.mScreenHeight : this.mScreenWidth;
            float xVelocity = this.mVelocityTracker.getXVelocity();
            int scrollX = this.mFirstSliderContainer.getScrollX();
            if (Math.abs(xVelocity) >= ((float) this.mMinimumVelocity)) {
                if (this.mIsLeftSlide) {
                    if (xVelocity > 0.0f) {
                        showContentView();
                    } else {
                        hideContentView();
                    }
                } else if (xVelocity > 0.0f) {
                    hideContentView();
                } else {
                    showContentView();
                }
            } else if (this.mIsLeftSlide) {
                int i = this.mHorizontalRange;
                if (scrollX < i) {
                    showContentView();
                } else if (scrollX > this.mScreenWidth - i) {
                    hideContentView();
                } else if (this.mScrollX > 0) {
                    showContentView();
                } else {
                    hideContentView();
                }
            } else {
                int i2 = this.mHorizontalRange;
                if (scrollX > (-i2)) {
                    showContentView();
                } else if (scrollX < (-this.mScreenWidth) + i2) {
                    hideContentView();
                } else if (this.mScrollX > 0) {
                    hideContentView();
                } else {
                    showContentView();
                }
            }
        }
    }

    private void handleLrActionMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713249442")) {
            ipChange.ipc$dispatch("1713249442", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<View> list = this.mSliderContainers;
        if (list != null && list.size() > 0 && this.isLrEnabled) {
            if (this.isFullScreen) {
                this.mSlideDistance = this.mScreenHeight;
            } else {
                this.mSlideDistance = this.mScreenWidth;
            }
            int i2 = this.mIsLeftSlide ? -(i - this.mEndX) : i - this.mEndX;
            for (View view : this.mSliderContainers) {
                if (view != null) {
                    view.scrollBy(i2, 0);
                }
            }
        }
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541256286")) {
            ipChange.ipc$dispatch("-541256286", new Object[]{this, context});
            return;
        }
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        setSoundEffectsEnabled(false);
        this.mScroller = new OverScroller(context);
        this.mScreenWidth = ContextUtils.getScreenWidth(context);
        this.mScreenHeight = ContextUtils.getFullActivityHeight(context);
        float f = context.getResources().getDisplayMetrics().density;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (f * 400.0f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mHorizontalRange = this.mScreenWidth / 3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onTouchClick(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414765387")) {
            ipChange.ipc$dispatch("-414765387", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        StatusListener statusListener = this.mStatusListener;
        if (statusListener != null) {
            statusListener.onTouchClick(i, i2, i3);
        }
    }

    private void startLrScroller(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93875438")) {
            ipChange.ipc$dispatch("-93875438", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mScroller.startScroll(i, 0, i2, 0, 200);
        invalidate();
    }

    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963867216")) {
            ipChange.ipc$dispatch("-1963867216", new Object[]{this});
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            if (this.mIsContentViewShow) {
                containerScrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            }
            postInvalidate();
        }
        super.computeScroll();
    }

    public void handleFullScreenPraise(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503774420")) {
            ipChange.ipc$dispatch("-1503774420", new Object[]{this, motionEvent});
            return;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            this.mLastTime = this.mCurTime;
            this.mCurTime = System.currentTimeMillis();
            MyLog.v(TAG, "diff= " + (this.mCurTime - this.mLastTime));
            if (this.mCurTime - this.mLastTime < 600) {
                this.mCurTime = 0;
                this.mLastTime = 0;
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.removeMessages(1);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = this.mEndX;
                    obtain.arg2 = this.mEndY;
                    this.handler.sendMessage(obtain);
                }
            } else if (this.handler != null) {
                Message obtain2 = Message.obtain();
                obtain2.what = 1;
                obtain2.arg1 = this.mEndX;
                obtain2.arg2 = this.mEndY;
                this.handler.sendMessage(obtain2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0088, code lost:
        if (r0 != 4) goto L_0x01b1;
     */
    public boolean handleSlideEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367047426")) {
            return ((Boolean) ipChange.ipc$dispatch("-1367047426", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        this.mScrollX = this.mEndX - this.mStartX;
        this.mScrollY = this.mEndY - this.mStartY;
        MyLog.v(TAG, "onTouchEvent mScrollX " + this.mScrollX);
        MyLog.v(TAG, "onTouchEvent mScrollY " + this.mScrollY);
        if (containerGetScrollX() == 0 || containerGetScrollX() == (-this.mScreenWidth)) {
            this.mIsContentViewShow = false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    MyLog.v(TAG, "onTouchEvent ACTION_MOVE");
                    if (!this.mIsContentViewShow) {
                        this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                        float xVelocity = this.mVelocityTracker.getXVelocity();
                        float yVelocity = this.mVelocityTracker.getYVelocity();
                        boolean z = containerGetScrollX() != 0 || (!this.mIsLeftSlide ? this.mScrollX >= 0 : this.mScrollX <= 0);
                        if (!z) {
                            return false;
                        }
                        if (Math.abs(this.mScrollX) > Math.abs(this.mScrollY)) {
                            MyLog.v(TAG, "onTouchEvent ACTION_MOVE X方向滑动");
                            if (!z) {
                                MyLog.w(TAG, "onTouchEvent ACTION_MOVE X方向滑动 超出边界");
                            } else if (Math.abs(this.mScrollX) <= this.mTouchSlop || ((double) Math.abs(yVelocity / xVelocity)) > Math.sqrt(3.0d) / 3.0d) {
                                MyLog.w(TAG, "onTouchEvent ACTION_MOVE X方向滑动 事件抛弃");
                            } else {
                                this.mIsContentViewShow = true;
                                MyLog.i(TAG, "onTouchEvent ACTION_MOVE X方向滑动 mIsContentViewShow = true");
                            }
                        } else if (Math.abs(this.mScrollY) > this.mTouchSlop) {
                            MyLog.v(TAG, "onTouchEvent ACTION_MOVE Y方向滑动");
                            if ((yVelocity <= 0.0f || ((double) Math.abs(xVelocity / yVelocity)) > Math.sqrt(3.0d) / 3.0d) && yVelocity < 0.0f && ((double) Math.abs(xVelocity / yVelocity)) <= Math.sqrt(3.0d) / 3.0d) {
                                MyLog.i(TAG, "onTouchEvent ACTION_MOVE Y方向滑动 isNextImageShow = true");
                            }
                        } else {
                            MyLog.w(TAG, "onTouchEvent ACTION_MOVE Y方向滑动 事件抛弃");
                        }
                    } else {
                        MyLog.v(TAG, "onTouchEvent ACTION_MOVE 视图显示中 事件抛弃");
                    }
                    if (this.mIsContentViewShow) {
                        MyLog.d(TAG, "onTouchEvent 左右移动View开始");
                        handleLrActionMove((int) motionEvent.getX());
                    }
                } else if (action != 3) {
                }
            }
            if (this.mIsContentViewShow) {
                MyLog.v(TAG, "onTouchEvent 左右移动View结束");
                handleLrActionEnd();
            } else {
                MyLog.w(TAG, "onTouchEvent 未知方向滑动结束 " + this.mIsContentViewShow);
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else {
            int x = (int) motionEvent.getX();
            this.mEndX = x;
            this.mStartX = x;
            int y = (int) motionEvent.getY();
            this.mEndY = y;
            this.mStartY = y;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
        }
        this.mEndX = (int) motionEvent.getX();
        this.mEndY = (int) motionEvent.getY();
        MyLog.v(TAG, "onTouchEvent mStartX " + this.mStartX);
        MyLog.v(TAG, "onTouchEvent mStartY " + this.mStartY);
        MyLog.v(TAG, "onTouchEvent mEndX " + this.mEndX);
        MyLog.v(TAG, "onTouchEvent mEndY " + this.mEndY);
        MyLog.v(TAG, "onTouchEvent mIsContentViewShow " + this.mIsContentViewShow);
        return this.mIsContentViewShow;
    }

    public void hideContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143906120")) {
            ipChange.ipc$dispatch("-2143906120", new Object[]{this});
            return;
        }
        View view = this.mFirstSliderContainer;
        if (view != null) {
            if (this.mIsLeftSlide) {
                startLrScroller(view.getScrollX(), this.mSlideDistance - this.mFirstSliderContainer.getScrollX());
            } else {
                startLrScroller(view.getScrollX(), -(this.mSlideDistance + this.mFirstSliderContainer.getScrollX()));
            }
            if (!this.isClearScreen) {
                this.isClearScreen = true;
            }
            StatusListener statusListener = this.mStatusListener;
            if (statusListener != null) {
                statusListener.onHideContent();
            }
            this.mIsShow = false;
        }
    }

    public void initContainers(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574262053")) {
            ipChange.ipc$dispatch("574262053", new Object[]{this, list});
            return;
        }
        this.mSliderContainers = list;
    }

    public void initFirst(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365505474")) {
            ipChange.ipc$dispatch("-365505474", new Object[]{this, view});
            return;
        }
        this.mFirstSliderContainer = view;
    }

    public boolean isShow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "986380051")) {
            return this.mIsShow;
        }
        return ((Boolean) ipChange.ipc$dispatch("986380051", new Object[]{this})).booleanValue();
    }

    public void onClearScreenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508922424")) {
            ipChange.ipc$dispatch("508922424", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mIsClearScreen != z) {
            this.mIsClearScreen = z;
        }
    }

    @Override // com.youku.live.widgets.dom.CSSLayout
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845972457")) {
            ipChange.ipc$dispatch("-845972457", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953535861")) {
            ipChange.ipc$dispatch("-1953535861", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-30737931")) {
            return super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-30737931", new Object[]{this, motionEvent})).booleanValue();
    }

    public void setIntercept(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157045022")) {
            ipChange.ipc$dispatch("157045022", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIntercept = z;
    }

    public void setLrEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1383886519")) {
            ipChange.ipc$dispatch("1383886519", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isLrEnabled = z;
    }

    public void setScreenMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828798735")) {
            ipChange.ipc$dispatch("-1828798735", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFullScreen = z;
    }

    public void setStatusListener(StatusListener statusListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824775412")) {
            ipChange.ipc$dispatch("-1824775412", new Object[]{this, statusListener});
            return;
        }
        this.mStatusListener = statusListener;
    }

    public void showContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534889677")) {
            ipChange.ipc$dispatch("-1534889677", new Object[]{this});
            return;
        }
        View view = this.mFirstSliderContainer;
        if (view != null) {
            startLrScroller(view.getScrollX(), -this.mFirstSliderContainer.getScrollX());
            if (this.isClearScreen) {
                this.isClearScreen = false;
            }
            StatusListener statusListener = this.mStatusListener;
            if (statusListener != null) {
                statusListener.onShowContent();
            }
            this.mIsShow = true;
        }
    }

    public BaseSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BaseSlideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
