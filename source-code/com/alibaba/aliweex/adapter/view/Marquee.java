package com.alibaba.aliweex.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$layout;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak"})
/* compiled from: Taobao */
public class Marquee extends FrameLayout {
    private static final int sSTOP_MSG = 1;
    private Context context;
    private int currentY;
    private long delayTime;
    private long durationTime;
    private Handler handler;
    private long intervalTime;
    private boolean isFirst;
    private boolean isStop;
    private Runnable mLogic;
    private FrameLayout marqueeRealView;
    private ScrollView scrollView;
    private long time;
    private long times;
    private int viewHeight;
    private List<View> viewList;

    /* compiled from: Taobao */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                Marquee.this.isStop = false;
            }
        }
    }

    public Marquee(Context context2) {
        this(context2, null);
    }

    static /* synthetic */ long access$708(Marquee marquee) {
        long j = marquee.times;
        marquee.times = 1 + j;
        return j;
    }

    static /* synthetic */ long access$908(Marquee marquee) {
        long j = marquee.time;
        marquee.time = 1 + j;
        return j;
    }

    private void init() {
        this.delayTime = 0;
        this.intervalTime = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.durationTime = 500;
        this.time = 1;
        this.times = 0;
        this.isFirst = true;
        this.currentY = 0;
        this.viewList = new ArrayList();
        LayoutInflater.from(this.context).inflate(R$layout.huichang_marquee_layout, (ViewGroup) this, true);
        this.scrollView = (ScrollView) findViewById(R$id.huichang_marquee_scroll_view);
        this.marqueeRealView = (FrameLayout) findViewById(R$id.huichang_marquee_layout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postDelayedInner(Runnable runnable, long j) {
        Handler handler2 = this.handler;
        if (handler2 != null && j >= 0) {
            handler2.postDelayed(runnable, j);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postInner(Runnable runnable) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(runnable);
        }
    }

    public void destroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public View getRealView() {
        return this.marqueeRealView;
    }

    public void setDelayTime(long j) {
        this.delayTime = j;
    }

    public void setDurationTime(long j) {
        this.durationTime = j;
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setViewList(List<View> list, FrameLayout.LayoutParams layoutParams) {
        this.handler.removeCallbacksAndMessages(null);
        this.marqueeRealView.removeAllViews();
        this.viewList.clear();
        this.viewList.addAll(list);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        layoutParams2.setMargins(0, 0, 0, 0);
        this.scrollView.setLayoutParams(layoutParams2);
        this.viewHeight = layoutParams.height;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int size = this.viewList.size();
        for (int i = 0; i < size; i++) {
            View view = this.viewList.get(i);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams3.setMargins(0, this.viewHeight * this.viewList.indexOf(view), 0, 0);
            view.setLayoutParams(layoutParams3);
            view.forceLayout();
            view.requestLayout();
            this.marqueeRealView.addView(view, layoutParams3);
        }
    }

    public void startScroll() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(null);
            this.isStop = false;
            int i = this.viewHeight;
            if (i > 0) {
                postDelayedInner(this.mLogic, this.durationTime / ((long) i));
            }
        }
    }

    public void startScrollA() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.marqueeRealView.scrollTo(0, 0);
            this.currentY = 0;
            postDelayedInner(this.mLogic, 20);
        }
    }

    public void stopScroll() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public Marquee(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.handler = new a(Looper.getMainLooper());
        this.mLogic = new Runnable() {
            /* class com.alibaba.aliweex.adapter.view.Marquee.AnonymousClass1 */

            public void run() {
                if (Marquee.this.marqueeRealView.getChildCount() > 0 && Marquee.this.viewHeight != 0) {
                    if (Marquee.this.isFirst) {
                        Marquee.this.isFirst = false;
                        Marquee marquee = Marquee.this;
                        marquee.postDelayedInner(this, marquee.delayTime);
                    } else if (!Marquee.this.isStop) {
                        Marquee.this.currentY++;
                        Marquee.this.marqueeRealView.scrollTo(0, Marquee.this.currentY);
                        if (Marquee.this.marqueeRealView.getScrollY() % Marquee.this.viewHeight == 0 && Marquee.this.handler != null) {
                            Marquee.this.isStop = true;
                            Marquee.this.handler.sendEmptyMessageDelayed(1, Marquee.this.intervalTime);
                            View childAt = Marquee.this.marqueeRealView.getChildAt(0);
                            Marquee.this.marqueeRealView.removeViewAt(0);
                            Marquee.access$708(Marquee.this);
                            if (Marquee.this.times % ((long) Marquee.this.viewList.size()) == 0) {
                                Marquee.access$908(Marquee.this);
                            }
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                            layoutParams.setMargins(0, (int) (((long) Marquee.this.viewHeight) * (((Marquee.this.times % ((long) Marquee.this.viewList.size())) - 1) + (Marquee.this.time * ((long) Marquee.this.viewList.size())))), 0, 0);
                            childAt.setLayoutParams(layoutParams);
                            Marquee.this.marqueeRealView.addView(childAt);
                        }
                        Marquee marquee2 = Marquee.this;
                        marquee2.postDelayedInner(this, marquee2.durationTime / ((long) Marquee.this.viewHeight));
                    } else {
                        Marquee.this.postInner(this);
                    }
                }
            }
        };
        this.context = context2;
        init();
    }
}
