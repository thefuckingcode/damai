package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface LocationInfo {
    @NotNull
    String getFilePath();

    @NotNull
    Position getPosition();
}
