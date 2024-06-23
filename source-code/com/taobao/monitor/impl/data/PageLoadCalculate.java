package com.taobao.monitor.impl.data;

import android.view.View;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import com.taobao.monitor.impl.data.calculator.ICalculatorFactory;
import java.lang.ref.WeakReference;
import tb.dm2;
import tb.ne;
import tb.oe;
import tb.qs0;

/* compiled from: Taobao */
public class PageLoadCalculate implements IExecutor, Runnable {
    private static final long INTERVAL = 75;
    private final ICalculatorFactory calculatorFactory = new oe();
    private WeakReference<View> containRef;
    private final String fullPageName;
    private IPageLoadPercent lifecycle;
    private volatile boolean stopped = false;

    /* compiled from: Taobao */
    public interface IPageLoadPercent {
        void pageLoadEndByTag(WeakReference<View> weakReference);

        void pageLoadPercent(float f, long j);

        void pageRootViewChanged(View view);
    }

    public PageLoadCalculate(View view, String str) {
        this.containRef = new WeakReference<>(view);
        this.fullPageName = str;
    }

    private void calculateDraw(View view, View view2) {
        ne calculate;
        if (this.lifecycle != null) {
            long a = dm2.a();
            ICalculator createCalculator = this.calculatorFactory.createCalculator(this.fullPageName, view, view2);
            if (createCalculator != null && (calculate = createCalculator.calculate()) != null) {
                View a2 = calculate.a();
                if (a2 != null) {
                    this.containRef = new WeakReference<>(a2);
                    this.lifecycle.pageRootViewChanged(a2);
                    run();
                } else if (calculate.b() != null) {
                    this.lifecycle.pageLoadEndByTag(new WeakReference<>(calculate.b()));
                    stop();
                } else {
                    this.lifecycle.pageLoadPercent(calculate.d() ? 1.0f : calculate.c(), a);
                }
            }
        }
    }

    private void check() {
        View view = this.containRef.get();
        if (view == null) {
            stop();
            return;
        }
        try {
            View findViewById = view.findViewById(view.getResources().getIdentifier("content", "id", "android"));
            if (findViewById == null) {
                findViewById = view;
            }
            if (findViewById.getHeight() * findViewById.getWidth() != 0) {
                calculateDraw(findViewById, view);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void execute() {
        qs0.e().b().postDelayed(this, 50);
    }

    public void run() {
        if (!this.stopped) {
            check();
            qs0.e().b().postDelayed(this, 75);
        }
    }

    public PageLoadCalculate setLifecycle(IPageLoadPercent iPageLoadPercent) {
        this.lifecycle = iPageLoadPercent;
        return this;
    }

    @Override // com.taobao.monitor.impl.data.IExecutor
    public void stop() {
        this.stopped = true;
        qs0.e().b().removeCallbacks(this);
        qs0.e().d().post(new Runnable() {
            /* class com.taobao.monitor.impl.data.PageLoadCalculate.AnonymousClass1 */

            public void run() {
                PageLoadCalculate.this.lifecycle = null;
            }
        });
    }
}
