package com.taobao.android.dinamicx.asyncrender.batch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXPrefetchTask;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import com.taobao.android.dinamicx.h;
import java.util.ArrayList;
import java.util.List;
import tb.ft;

/* compiled from: Taobao */
public class DXBatchPrefetchWorkTask extends DXBatchRenderWorkTask<Void> {
    public DXBatchPrefetchWorkTask(DXTemplateManager dXTemplateManager, h hVar, ft ftVar, @Nullable DXRenderOptions dXRenderOptions, @NonNull List<DXRuntimeContext> list, @Nullable DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
        super(dXTemplateManager, hVar, ftVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.asyncrender.batch.DXBatchRenderWorkTask
    public List<DXBaseRenderWorkTask> onCreateRenderTask(DXRenderOptions dXRenderOptions) {
        ArrayList arrayList = new ArrayList();
        for (DXRuntimeContext dXRuntimeContext : this.runtimeContexts) {
            arrayList.add(new DXPrefetchTask(dXRuntimeContext, dXRenderOptions, this.templateManager, this.dxPipelineCacheManager, dXRuntimeContext.getEngineContext(), this.controlEventCenter, getAsyncRenderCallback()));
        }
        return arrayList;
    }
}
