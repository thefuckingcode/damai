package com.taobao.monitor.impl.data.visible;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.application.common.IPageListener;
import com.taobao.application.common.impl.a;
import com.taobao.monitor.impl.data.IExecutor;
import com.taobao.monitor.impl.data.PageLoadCalculate;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.youku.arch.v3.event.Subject;
import java.lang.ref.WeakReference;
import tb.b0;
import tb.dm2;
import tb.e90;
import tb.i20;
import tb.on1;
import tb.ow2;
import tb.qs0;
import tb.rn1;
import tb.t91;
import tb.us1;

/* compiled from: Taobao */
public class VisibleCalculator implements PageLoadCalculate.IPageLoadPercent, WindowEventDispatcher.OnEventListener, Runnable {
    private static final String ACTIVITY_FRAGMENT_PAGE_NAME = "page_name";
    private static final String ACTIVITY_FRAGMENT_TYPE = "type";
    private static final String ACTIVITY_FRAGMENT_VISIBLE_ACTION = "ACTIVITY_FRAGMENT_VISIBLE_ACTION";
    private static final String ACTIVITY_FRAGMENT_VISIBLE_STATUS = "status";
    private static final int DRAW_TIME_OUT = 20000;
    public static final float PAGE_LOAD_PERCENT = 0.7f;
    private static final String TAG = "VisibleCollector";
    private float DownX;
    private float DownY;
    private int count;
    private volatile boolean isPageLoadCreated;
    private boolean isStopped = false;
    private int lastPageRenderError = 1;
    private float moveX;
    private float moveY;
    private float oldDrawPercent;
    private final on1 page;
    private final IPageListener pageListener;
    private IExecutor pageLoadCalculate;
    private final String pageName;
    private final Runnable timeoutRunnable;
    private boolean usableDispatched;
    private RenderDispatcher usableVisibleDispatcher = null;
    private boolean visibleDispatched;
    private WindowEventDispatcher windowEventDispatcher = null;

    public VisibleCalculator(on1 on1) {
        IPageListener e = a.g().e();
        this.pageListener = e;
        this.timeoutRunnable = new Runnable() {
            /* class com.taobao.monitor.impl.data.visible.VisibleCalculator.AnonymousClass1 */

            public void run() {
                if (!e90.c(VisibleCalculator.this.usableVisibleDispatcher) && VisibleCalculator.this.lastPageRenderError == 1) {
                    VisibleCalculator.this.usableVisibleDispatcher.g(VisibleCalculator.this.page, -1);
                    VisibleCalculator.this.lastPageRenderError = -1;
                }
                VisibleCalculator.this.releasePageLoadCalculate();
            }
        };
        this.isPageLoadCreated = false;
        this.oldDrawPercent = 0.0f;
        this.visibleDispatched = false;
        this.count = 0;
        this.usableDispatched = false;
        this.DownX = 0.0f;
        this.DownY = 0.0f;
        this.moveX = 0.0f;
        this.moveY = 0.0f;
        if (on1 != null) {
            this.page = on1;
            String m = on1.m();
            this.pageName = m;
            e.onPageChanged(m, 0, dm2.a());
            t91.d(TAG, "visibleStart", m);
            initDispatcher();
            return;
        }
        throw new IllegalArgumentException("Visible calculate must page not null");
    }

    private void dispatchVisibleChanged(long j) {
        if (!this.visibleDispatched && !this.isStopped) {
            if (!e90.c(this.usableVisibleDispatcher)) {
                i20.a(TAG, this.pageName, "visible", Long.valueOf(j));
                this.usableVisibleDispatcher.j(this.page, j);
                this.usableVisibleDispatcher.g(this.page, 0);
                this.lastPageRenderError = 0;
            }
            this.pageListener.onPageChanged(this.pageName, 2, j);
            releasePageLoadCalculate();
            this.visibleDispatched = true;
        }
    }

    private void doSendPageFinishedEvent() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(qs0.e().a());
        Intent intent = new Intent(ACTIVITY_FRAGMENT_VISIBLE_ACTION);
        intent.putExtra(ACTIVITY_FRAGMENT_PAGE_NAME, this.pageName);
        if (this.page.a() != null) {
            intent.putExtra("type", "activity");
        } else if (this.page.e() != null) {
            intent.putExtra("type", Subject.FRAGMENT);
        } else {
            intent.putExtra("type", "unknown");
        }
        intent.putExtra("status", 1);
        instance.sendBroadcastSync(intent);
        t91.d(TAG, "doSendPageFinishedEvent:" + this.pageName);
    }

    private int getScaledTouchSlop() {
        Context c = this.page.c();
        if (c != null) {
            return ViewConfiguration.get(c).getScaledTouchSlop();
        }
        return Integer.MAX_VALUE;
    }

    private boolean isMainPage(on1 on1) {
        if (on1.t()) {
            return "com.taobao.tao.TBMainActivity".equals(on1.h());
        }
        if (on1.v()) {
            return "com.taobao.tao.homepage.HomepageFragment".equals(on1.h());
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void releasePageLoadCalculate() {
        this.isStopped = true;
        if (this.pageLoadCalculate != null) {
            synchronized (this) {
                if (this.pageLoadCalculate != null) {
                    qs0.e().d().removeCallbacks(this.timeoutRunnable);
                    IExecutor iExecutor = this.pageLoadCalculate;
                    if (iExecutor != null) {
                        iExecutor.stop();
                    }
                    doSendPageFinishedEvent();
                    this.pageLoadCalculate = null;
                }
            }
        }
        if (!e90.c(this.windowEventDispatcher)) {
            this.windowEventDispatcher.removeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchUsableChanged(long j) {
        if (!this.usableDispatched) {
            i20.a(TAG, "usable", this.pageName);
            t91.d(TAG, this.pageName, " usable", Long.valueOf(j));
            if (!e90.c(this.usableVisibleDispatcher)) {
                this.usableVisibleDispatcher.f(this.page, j);
            }
            releasePageLoadCalculate();
            this.pageListener.onPageChanged(this.pageName, 3, j);
            this.usableDispatched = true;
        }
    }

    public void errorNotify(int i) {
        if (this.lastPageRenderError == 1 && !e90.c(this.usableVisibleDispatcher)) {
            this.usableVisibleDispatcher.g(this.page, i);
            this.lastPageRenderError = i;
        }
        this.isStopped = true;
    }

    /* access modifiers changed from: protected */
    public void initDispatcher() {
        IDispatcher a = b0.a(b0.PAGE_RENDER_DISPATCHER);
        if (a instanceof RenderDispatcher) {
            this.usableVisibleDispatcher = (RenderDispatcher) a;
        }
        IDispatcher b = e90.b(b0.WINDOW_EVENT_DISPATCHER);
        if (b instanceof WindowEventDispatcher) {
            WindowEventDispatcher windowEventDispatcher2 = (WindowEventDispatcher) b;
            this.windowEventDispatcher = windowEventDispatcher2;
            windowEventDispatcher2.addListener(this);
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        if (!this.isStopped && !this.visibleDispatched && this.lastPageRenderError == 1 && ow2.a(activity, this.page.o())) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.DownX = motionEvent.getX();
                this.DownY = motionEvent.getY();
                this.moveX = 0.0f;
                this.moveY = 0.0f;
            } else if (action == 1) {
                float scaledTouchSlop = (float) getScaledTouchSlop();
                if (this.moveX > scaledTouchSlop || this.moveY > scaledTouchSlop) {
                    releasePageLoadCalculate();
                    if (this.lastPageRenderError == 1 && !e90.c(this.usableVisibleDispatcher)) {
                        this.usableVisibleDispatcher.g(this.page, -2);
                        this.lastPageRenderError = -2;
                    }
                }
            } else if (action == 2) {
                this.moveX += Math.abs(motionEvent.getX() - this.DownX);
                this.moveY += Math.abs(motionEvent.getY() - this.DownY);
                this.DownX = motionEvent.getX();
                this.DownY = motionEvent.getY();
            }
        }
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageLoadEndByTag(WeakReference<View> weakReference) {
        this.page.F(weakReference);
        us1.PROCEDURE_MANAGER.t(this.page, weakReference);
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageLoadPercent(float f, long j) {
        String str;
        t91.d(TAG, "visiblePercent", Float.valueOf(f), this.pageName);
        if (this.page.t() || this.page.v()) {
            str = this.page.h();
        } else {
            str = this.page.m();
        }
        float b = rn1.b(str);
        float f2 = 0.7f;
        if (isMainPage(this.page)) {
            f2 = 0.8f;
        }
        if (Math.abs(f - this.oldDrawPercent) > 0.05f || f >= f2 || f >= b) {
            if (!e90.c(this.usableVisibleDispatcher)) {
                this.usableVisibleDispatcher.h(this.page, f, dm2.a());
            }
            i20.a(TAG, "visiblePercent", Float.valueOf(f), this.pageName);
            if ((f >= f2 || f >= b) && !this.visibleDispatched && !this.isStopped) {
                dispatchVisibleChanged(j);
                run();
            }
            this.oldDrawPercent = f;
        }
    }

    @Override // com.taobao.monitor.impl.data.PageLoadCalculate.IPageLoadPercent
    public void pageRootViewChanged(View view) {
        this.page.L(view);
    }

    public void run() {
        int i = this.count + 1;
        this.count = i;
        if (i > 2) {
            dispatchUsableChanged(dm2.a());
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this);
        handler.postDelayed(this, 16);
    }

    public void startPageCalculateExecutor(View view) {
        String str;
        if (!this.isPageLoadCreated && this.page.w()) {
            if (!this.isStopped) {
                if (!e90.c(this.usableVisibleDispatcher)) {
                    this.usableVisibleDispatcher.i(this.page, dm2.a());
                }
                if (this.page.t() || this.page.v()) {
                    str = this.page.h();
                } else {
                    str = this.page.m();
                }
                PageLoadCalculate pageLoadCalculate2 = new PageLoadCalculate(view, str);
                this.pageLoadCalculate = pageLoadCalculate2;
                pageLoadCalculate2.setLifecycle(this);
                this.pageLoadCalculate.execute();
                qs0.e().d().postDelayed(this.timeoutRunnable, 20000);
                this.pageListener.onPageChanged(this.pageName, 1, dm2.a());
                this.isPageLoadCreated = true;
            } else if (!e90.c(this.usableVisibleDispatcher) && this.lastPageRenderError == 1) {
                this.usableVisibleDispatcher.g(this.page, -6);
                this.lastPageRenderError = -6;
            }
        }
    }

    public void stopPageCalculateExecutor() {
        releasePageLoadCalculate();
    }
}
