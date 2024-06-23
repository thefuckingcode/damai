package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.i61;

/* compiled from: Taobao */
public interface TypeProjection extends TypeArgumentMarker {
    @NotNull
    Variance getProjectionKind();

    @NotNull
    g61 getType();

    boolean isStarProjection();

    @NotNull
    TypeProjection refine(@NotNull i61 i61);
}
