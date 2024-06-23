package com.youku.arch.v3.data;

import com.youku.arch.v3.io.IRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gl1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H¦\u0002¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/data/IDataSource;", "", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/data/DataLoadCallback;", "callBack", "Ltb/ur2;", gl1.TYPE_OPEN_URL_METHOD_GET, "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface IDataSource {
    void get(@NotNull IRequest iRequest, @Nullable DataLoadCallback dataLoadCallback);
}
