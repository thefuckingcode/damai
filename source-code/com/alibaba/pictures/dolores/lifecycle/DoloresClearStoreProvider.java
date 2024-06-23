package com.alibaba.pictures.dolores.lifecycle;

import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.wa0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/dolores/lifecycle/DoloresClearStoreProvider;", "Ljava/io/Closeable;", "Ltb/wa0;", "getDoloresClearStore", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface DoloresClearStoreProvider extends Closeable {
    @NotNull
    wa0 getDoloresClearStore();
}
