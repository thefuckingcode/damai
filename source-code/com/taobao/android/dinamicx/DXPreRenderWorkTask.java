package com.taobao.android.dinamicx;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.lang.ref.WeakReference;
import tb.c00;
import tb.ft;
import tb.uv2;
import tb.v10;
import tb.vx;
import tb.xz;

/* compiled from: Taobao */
public class DXPreRenderWorkTask extends DXBaseRenderWorkTask {
    public static final String TAG = "DXPreRenderWorkTask";
    private final DXAsyncRenderCallback<xz<DXRootView>> callback;

    public DXPreRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, ft ftVar) {
        this(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, ftVar, null);
    }

    @Override // com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask
    public void run() {
        try {
            super.run();
            DXRenderPipeline dXRenderPipeline = DXBaseRenderWorkTask.pipelineThreadLocal.get();
            if (dXRenderPipeline == null || this.config.c != dXRenderPipeline.b().c) {
                DXRenderPipeline dXRenderPipeline2 = new DXRenderPipeline(this.engineContext, new DXTemplateManager(this.engineContext, DinamicXEngine.i()));
                DXBaseRenderWorkTask.pipelineThreadLocal.set(dXRenderPipeline2);
                dXRenderPipeline = dXRenderPipeline2;
            }
            this.runtimeContext.setDxRenderPipeline(new WeakReference<>(dXRenderPipeline));
            this.runtimeContext.contextWeakReference = new WeakReference<>(new uv2(this.runtimeContext.getContext().getApplicationContext()));
            DXRootView dXRootView = new DXRootView(this.runtimeContext.getContext());
            dXRootView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            dXRootView.dxTemplateItem = this.runtimeContext.getDxTemplateItem();
            d dVar = this.engineContext;
            if (!(dVar == null || dVar.e() == null)) {
                dXRootView.setBindingXManagerWeakReference(this.engineContext.e().n);
            }
            this.runtimeContext.rootViewWeakReference = new WeakReference<>(dXRootView);
            final xz<DXRootView> q = dXRenderPipeline.q(dXRootView, this.runtimeContext, -1, this.options);
            this.isDone = true;
            if (q != null && q.a != null) {
                v10.c().b(q.a, this.runtimeContext.getDxTemplateItem(), this.config.a);
                if (this.callback == null) {
                    return;
                }
                if (this.runtimeContext.hasError()) {
                    c00.o(new Runnable() {
                        /* class com.taobao.android.dinamicx.DXPreRenderWorkTask.AnonymousClass1 */

                        public void run() {
                            DXPreRenderWorkTask.this.callback.onRenderFailed(DXPreRenderWorkTask.this.runtimeContext, null);
                        }
                    });
                } else {
                    c00.o(new Runnable() {
                        /* class com.taobao.android.dinamicx.DXPreRenderWorkTask.AnonymousClass2 */

                        public void run() {
                            DXPreRenderWorkTask.this.callback.onRenderSuccess(q);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            DXRuntimeContext dXRuntimeContext = this.runtimeContext;
            if (dXRuntimeContext != null && !TextUtils.isEmpty(dXRuntimeContext.bizType)) {
                DXRuntimeContext dXRuntimeContext2 = this.runtimeContext;
                DXAppMonitor.q(dXRuntimeContext2.bizType, dXRuntimeContext2.getDxTemplateItem(), "AsyncRender", "Pre_Render_3.0_Crash", e.V3_PRE_RENDER_CRASH, vx.a(th));
            }
            vx.b(th);
            this.isFailed = true;
            if (this.callback != null) {
                c00.o(new Runnable() {
                    /* class com.taobao.android.dinamicx.DXPreRenderWorkTask.AnonymousClass3 */

                    public void run() {
                        DXPreRenderWorkTask.this.callback.onRenderFailed(DXPreRenderWorkTask.this.runtimeContext, th);
                    }
                });
            }
        }
    }

    public DXPreRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, ft ftVar, DXAsyncRenderCallback<xz<DXRootView>> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, ftVar);
        this.callback = dXAsyncRenderCallback;
    }
}
