package com.youku.arch.v3.data;

import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface DataLoadCallback extends Callback {
    void onFilter(@NotNull IResponse iResponse);
}
