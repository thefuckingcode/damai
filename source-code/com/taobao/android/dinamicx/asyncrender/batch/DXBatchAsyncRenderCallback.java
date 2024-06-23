package com.taobao.android.dinamicx.asyncrender.batch;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.List;

/* compiled from: Taobao */
public interface DXBatchAsyncRenderCallback {
    void onRenderComplete(@NonNull List<DXRuntimeContext> list, @NonNull List<DXRuntimeContext> list2);
}
