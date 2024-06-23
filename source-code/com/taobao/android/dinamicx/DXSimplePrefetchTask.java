package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.a;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.c00;
import tb.vx;

/* compiled from: Taobao */
public class DXSimplePrefetchTask extends DXSimpleBaseRenderWorkTask {
    protected DXAsyncRenderCallback<DXRuntimeContext> callback;
    protected Runnable callbackRunnable;

    public DXSimplePrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, d dVar, h hVar, View view, DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, dVar, hVar, view);
        this.callback = dXAsyncRenderCallback;
    }

    private void notifyPrefetchSuccess(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            try {
                if (dXWidgetNode instanceof PrefetchListener) {
                    ((PrefetchListener) dXWidgetNode).onPrefetchSuccess();
                }
                if (!(dXWidgetNode.getChildren() == null || dXWidgetNode.getChildren().isEmpty())) {
                    for (DXWidgetNode dXWidgetNode2 : dXWidgetNode.getChildren()) {
                        notifyPrefetchSuccess(dXWidgetNode2);
                    }
                }
            } catch (Throwable th) {
                e eVar = new e(this.runtimeContext.getBizType());
                e.a aVar = new e.a("Engine", "Engine_Render", e.DX_SIMPLE_PREFETCH_LISTENER_CRASH);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
            }
        }
    }

    public void cancel() {
        Runnable runnable = this.callbackRunnable;
        if (runnable != null) {
            c00.a(runnable);
        }
        this.options.k(true);
        this.isDone = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXSimpleBaseRenderWorkTask
    public void onRunTask() {
        a k;
        try {
            getPipeline().h(this.runtimeContext.getWidgetNode(), null, this.viewWeakReference.get(), this.runtimeContext, this.options);
            this.isDone = true;
            if (this.callback != null && !this.options.i()) {
                if (!this.runtimeContext.hasError()) {
                    notifyPrefetchSuccess(this.runtimeContext.getWidgetNode());
                    this.callbackRunnable = new Runnable() {
                        /* class com.taobao.android.dinamicx.DXSimplePrefetchTask.AnonymousClass1 */

                        public void run() {
                            DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                            dXSimplePrefetchTask.callback.onRenderSuccess(dXSimplePrefetchTask.runtimeContext);
                        }
                    };
                } else {
                    this.callbackRunnable = new Runnable() {
                        /* class com.taobao.android.dinamicx.DXSimplePrefetchTask.AnonymousClass2 */

                        public void run() {
                            DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                            dXSimplePrefetchTask.callback.onRenderFailed(dXSimplePrefetchTask.runtimeContext, null);
                        }
                    };
                }
                c00.o(this.callbackRunnable);
            }
            if (this.runtimeContext.getEngineContext().j() && (k = this.runtimeContext.getEngineContext().e().k()) != null) {
                k.A();
            }
        } catch (Throwable th) {
            vx.b(th);
            this.isDone = true;
            if (this.callback != null && !this.options.i()) {
                AnonymousClass3 r0 = new Runnable() {
                    /* class com.taobao.android.dinamicx.DXSimplePrefetchTask.AnonymousClass3 */

                    public void run() {
                        DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                        dXSimplePrefetchTask.callback.onRenderFailed(dXSimplePrefetchTask.runtimeContext, th);
                    }
                };
                this.callbackRunnable = r0;
                c00.o(r0);
            }
        }
    }
}
