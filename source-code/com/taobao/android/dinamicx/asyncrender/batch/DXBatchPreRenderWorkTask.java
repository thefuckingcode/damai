package com.taobao.android.dinamicx.asyncrender.batch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXPreRenderWorkTask;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import com.taobao.android.dinamicx.h;
import java.util.ArrayList;
import java.util.List;
import tb.ft;
import tb.xz;

/* compiled from: Taobao */
public class DXBatchPreRenderWorkTask extends DXBatchRenderWorkTask<xz<DXRootView>> {
    public DXBatchPreRenderWorkTask(DXTemplateManager dXTemplateManager, h hVar, ft ftVar, @Nullable DXRenderOptions dXRenderOptions, @NonNull List<DXRuntimeContext> list, @Nullable DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
        super(dXTemplateManager, hVar, ftVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.asyncrender.batch.DXBatchRenderWorkTask
    public List<DXBaseRenderWorkTask> onCreateRenderTask(DXRenderOptions dXRenderOptions) {
        ArrayList arrayList = new ArrayList();
        for (DXRuntimeContext dXRuntimeContext : this.runtimeContexts) {
            arrayList.add(new DXPreRenderWorkTask(dXRuntimeContext, dXRenderOptions, this.templateManager, this.dxPipelineCacheManager, dXRuntimeContext.getEngineContext(), this.controlEventCenter, getAsyncRenderCallback()));
        }
        return arrayList;
    }
}
