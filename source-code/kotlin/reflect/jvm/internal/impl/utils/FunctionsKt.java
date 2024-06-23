package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

/* compiled from: Taobao */
public final class FunctionsKt {
    @NotNull
    private static final Function1<Object, Boolean> a = FunctionsKt$ALWAYS_TRUE$1.INSTANCE;
    @NotNull
    private static final Function3<Object, Object, Object, ur2> b = FunctionsKt$DO_NOTHING_3$1.INSTANCE;

    static {
        FunctionsKt$IDENTITY$1 functionsKt$IDENTITY$1 = FunctionsKt$IDENTITY$1.INSTANCE;
        FunctionsKt$ALWAYS_NULL$1 functionsKt$ALWAYS_NULL$1 = FunctionsKt$ALWAYS_NULL$1.INSTANCE;
        FunctionsKt$DO_NOTHING$1 functionsKt$DO_NOTHING$1 = FunctionsKt$DO_NOTHING$1.INSTANCE;
        FunctionsKt$DO_NOTHING_2$1 functionsKt$DO_NOTHING_2$1 = FunctionsKt$DO_NOTHING_2$1.INSTANCE;
    }

    @NotNull
    public static final <T> Function1<T, Boolean> a() {
        return (Function1<T, Boolean>) a;
    }

    @NotNull
    public static final Function3<Object, Object, Object, ur2> b() {
        return b;
    }
}
