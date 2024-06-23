package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import java.lang.ref.WeakReference;
import tb.c00;
import tb.ft;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class DXPrefetchTask extends DXBaseRenderWorkTask {
    private final DXAsyncRenderCallback<Void> callback;

    public DXPrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, ft ftVar) {
        this(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, ftVar, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask
    public void run() {
        DXRenderPipeline dXRenderPipeline;
        super.run();
        try {
            DXRenderPipeline dXRenderPipeline2 = DXBaseRenderWorkTask.pipelineThreadLocal.get();
            if (dXRenderPipeline2 != null) {
                if (this.config.c == dXRenderPipeline2.b().c) {
                    dXRenderPipeline = dXRenderPipeline2;
                    DinamicXEngine.x();
                    this.runtimeContext.setDxRenderPipeline(new WeakReference<>(dXRenderPipeline));
                    dXRenderPipeline.r(null, null, null, this.runtimeContext, this.options);
                    this.isDone = true;
                    if (DinamicXEngine.x()) {
                        ry.q("prefetchTemplate desc : \n", this.runtimeContext.getDxPerformInfo().toString());
                        DXRuntimeContext dXRuntimeContext = this.runtimeContext;
                        if (!(dXRuntimeContext == null || dXRuntimeContext.getDxTemplateItem() == null)) {
                            ry.q("prefetchTemplate end ", this.runtimeContext.getDxTemplateItem().name, this.runtimeContext.getDxTemplateItem().version + "\n ");
                        }
                    }
                    if (this.callback != null) {
                        return;
                    }
                    if (this.runtimeContext.hasError()) {
                        c00.o(new Runnable() {
                            /* class com.taobao.android.dinamicx.DXPrefetchTask.AnonymousClass1 */

                            public void run() {
                                DXPrefetchTask.this.callback.onRenderFailed(DXPrefetchTask.this.runtimeContext, null);
                            }
                        });
                        return;
                    } else {
                        c00.o(new Runnable() {
                            /* class com.taobao.android.dinamicx.DXPrefetchTask.AnonymousClass2 */

                            public void run() {
                                DXPrefetchTask.this.callback.onRenderSuccess(null);
                            }
                        });
                        return;
                    }
                }
            }
            DXRenderPipeline dXRenderPipeline3 = new DXRenderPipeline(this.engineContext, new DXTemplateManager(this.engineContext, DinamicXEngine.i()));
            DXBaseRenderWorkTask.pipelineThreadLocal.set(dXRenderPipeline3);
            dXRenderPipeline = dXRenderPipeline3;
            DinamicXEngine.x();
            this.runtimeContext.setDxRenderPipeline(new WeakReference<>(dXRenderPipeline));
            dXRenderPipeline.r(null, null, null, this.runtimeContext, this.options);
            this.isDone = true;
            if (DinamicXEngine.x()) {
            }
            if (this.callback != null) {
            }
        } catch (Throwable th) {
            vx.b(th);
            this.isFailed = true;
            if (this.callback != null) {
                c00.o(new Runnable() {
                    /* class com.taobao.android.dinamicx.DXPrefetchTask.AnonymousClass3 */

                    public void run() {
                        DXPrefetchTask.this.callback.onRenderFailed(DXPrefetchTask.this.runtimeContext, th);
                    }
                });
            }
        }
    }

    public DXPrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, ft ftVar, DXAsyncRenderCallback<Void> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, ftVar);
        this.callback = dXAsyncRenderCallback;
    }
}
