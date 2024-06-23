package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.g61;

/* compiled from: Taobao */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = NewKotlinTypeChecker.Companion.a();

    /* compiled from: Taobao */
    public interface TypeConstructorEquality {
        boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2);
    }

    boolean equalTypes(@NotNull g61 g61, @NotNull g61 g612);

    boolean isSubtypeOf(@NotNull g61 g61, @NotNull g61 g612);
}
