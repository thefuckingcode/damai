package com.youku.arch.v3.io;

import com.youku.arch.v3.core.Constants;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/io/RequestBuilder;", "Ljava/io/Serializable;", "", "", "", Constants.CONFIG, "Lcom/youku/arch/v3/io/IRequest;", "build", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface RequestBuilder extends Serializable {
    @Nullable
    IRequest build(@NotNull Map<String, ? extends Object> map);
}
