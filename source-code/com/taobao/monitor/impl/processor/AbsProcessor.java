package com.taobao.monitor.impl.processor;

import com.taobao.monitor.impl.processor.IProcessor;
import com.taobao.monitor.impl.trace.IDispatcher;
import tb.b0;
import tb.qs0;

/* compiled from: Taobao */
public abstract class AbsProcessor implements IProcessor {
    private b0 a;
    private IProcessor.IProcessorLifeCycle b;
    private volatile boolean c;

    protected AbsProcessor() {
        this(true);
    }

    /* access modifiers changed from: protected */
    public IDispatcher a(String str) {
        return b0.a(str);
    }

    /* access modifiers changed from: protected */
    public void b() {
        qs0.e().d().post(new Runnable() {
            /* class com.taobao.monitor.impl.processor.AbsProcessor.AnonymousClass1 */

            public void run() {
                AbsProcessor.this.e();
            }
        });
    }

    public void c(IProcessor.IProcessorLifeCycle iProcessorLifeCycle) {
        this.b = iProcessorLifeCycle;
    }

    /* access modifiers changed from: protected */
    public void d() {
        IProcessor.IProcessorLifeCycle iProcessorLifeCycle = this.b;
        if (iProcessorLifeCycle != null) {
            iProcessorLifeCycle.processorOnStart(this);
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (!this.c) {
            this.c = true;
            IProcessor.IProcessorLifeCycle iProcessorLifeCycle = this.b;
            if (iProcessorLifeCycle != null) {
                iProcessorLifeCycle.processorOnEnd(this);
            }
        }
    }

    protected AbsProcessor(boolean z) {
        this.a = b0.b();
        this.c = false;
    }
}
