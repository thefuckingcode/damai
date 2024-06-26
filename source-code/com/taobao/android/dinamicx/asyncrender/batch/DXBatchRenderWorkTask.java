package com.taobao.android.dinamicx.asyncrender.batch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import com.taobao.android.dinamicx.h;
import com.taobao.android.dinamicx.template.download.DXPriorityRunnable;
import java.util.ArrayList;
import java.util.List;
import tb.c00;
import tb.ft;

/* compiled from: Taobao */
public abstract class DXBatchRenderWorkTask<T> implements DXAsyncRenderCallback<T>, Runnable {
    protected DXBatchAsyncRenderCallback callback;
    protected ft controlEventCenter;
    protected h dxPipelineCacheManager;
    protected boolean isBatch;
    protected DXRenderOptions renderOptions;
    protected List<DXBaseRenderWorkTask> renderTasks;
    protected List<DXRuntimeContext> runtimeContexts;
    protected DXTemplateManager templateManager;

    public DXBatchRenderWorkTask(DXTemplateManager dXTemplateManager, h hVar, ft ftVar, @Nullable DXRenderOptions dXRenderOptions, @NonNull List<DXRuntimeContext> list, @Nullable DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
        this.templateManager = dXTemplateManager;
        this.dxPipelineCacheManager = hVar;
        this.controlEventCenter = ftVar;
        this.renderOptions = initRenderOptions(dXRenderOptions);
        this.runtimeContexts = list;
        this.callback = dXBatchAsyncRenderCallback;
        this.isBatch = z;
    }

    private void callbackResult() {
        if (this.callback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (DXBaseRenderWorkTask dXBaseRenderWorkTask : this.renderTasks) {
                if (dXBaseRenderWorkTask.isDone || this.renderOptions.i()) {
                    arrayList.add(dXBaseRenderWorkTask.runtimeContext);
                } else if (dXBaseRenderWorkTask.isFailed) {
                    arrayList2.add(dXBaseRenderWorkTask.runtimeContext);
                }
            }
            this.callback.onRenderComplete(arrayList, arrayList2);
        }
    }

    private boolean checkOptions() {
        return this.renderOptions.e() == 1 || this.renderOptions.e() == 2;
    }

    public static DXRenderOptions preRenderOptions() {
        return DXRenderOptions.DEFAULT_PRERENDER_OPTIONS;
    }

    public static DXRenderOptions prefetchOptions() {
        return new DXRenderOptions.b().r(1).s(4).k();
    }

    private void tryCallbackResult() {
        if (isDone()) {
            callbackResult();
        }
    }

    public void cancel() {
        this.renderOptions.k(true);
    }

    /* access modifiers changed from: protected */
    public List<DXBaseRenderWorkTask> createRenderTasks() {
        return onCreateRenderTask(this.renderOptions);
    }

    /* access modifiers changed from: protected */
    public DXAsyncRenderCallback<T> getAsyncRenderCallback() {
        if (!this.isBatch || this.callback == null) {
            return null;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public DXRenderOptions initRenderOptions(@Nullable DXRenderOptions dXRenderOptions) {
        DXRenderOptions.b prefetchOptionBuilder = prefetchOptionBuilder();
        if (dXRenderOptions != null) {
            prefetchOptionBuilder.l(dXRenderOptions.a()).s(dXRenderOptions.f()).m(dXRenderOptions.b()).u(dXRenderOptions.h()).p(dXRenderOptions.c()).q(dXRenderOptions.d()).t(dXRenderOptions.g()).o(dXRenderOptions.j()).r(dXRenderOptions.e());
        }
        return prefetchOptionBuilder.k();
    }

    public boolean isDone() {
        List<DXBaseRenderWorkTask> list = this.renderTasks;
        if (list == null) {
            return false;
        }
        for (DXBaseRenderWorkTask dXBaseRenderWorkTask : list) {
            if (!(dXBaseRenderWorkTask.isDone || dXBaseRenderWorkTask.isFailed || this.renderOptions.i())) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract List<DXBaseRenderWorkTask> onCreateRenderTask(DXRenderOptions dXRenderOptions);

    @Override // com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback
    public void onRenderFailed(DXRuntimeContext dXRuntimeContext, Throwable th) {
        tryCallbackResult();
    }

    @Override // com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback
    public void onRenderSuccess(T t) {
        tryCallbackResult();
    }

    /* access modifiers changed from: protected */
    public DXRenderOptions.b prefetchOptionBuilder() {
        return new DXRenderOptions.b().r(1).s(4);
    }

    public void run() {
        for (DXBaseRenderWorkTask dXBaseRenderWorkTask : this.renderTasks) {
            if (this.renderOptions.i()) {
                break;
            }
            dXBaseRenderWorkTask.run();
        }
        callbackResult();
    }

    /* access modifiers changed from: protected */
    public void runRenderTask(Runnable runnable) {
        if (this.renderOptions.e() == 1) {
            c00.i(new DXPriorityRunnable(2, runnable));
        } else if (this.renderOptions.e() == 2) {
            c00.h(new DXPriorityRunnable(2, runnable));
        }
    }

    public void runTasks() {
        if (checkOptions()) {
            List<DXBaseRenderWorkTask> createRenderTasks = createRenderTasks();
            this.renderTasks = createRenderTasks;
            if (!(createRenderTasks == null || createRenderTasks.isEmpty())) {
                if (this.isBatch) {
                    for (DXBaseRenderWorkTask dXBaseRenderWorkTask : this.renderTasks) {
                        runRenderTask(dXBaseRenderWorkTask);
                    }
                    return;
                }
                runRenderTask(this);
            }
        }
    }
}
