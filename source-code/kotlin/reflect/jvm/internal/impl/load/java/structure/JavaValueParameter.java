package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.og1;

/* compiled from: Taobao */
public interface JavaValueParameter extends JavaAnnotationOwner {
    @Nullable
    og1 getName();

    @NotNull
    JavaType getType();

    boolean isVararg();
}
