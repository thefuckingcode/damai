package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class FunctionsKt$ALWAYS_NULL$1 extends Lambda implements Function1 {
    public static final FunctionsKt$ALWAYS_NULL$1 INSTANCE = new FunctionsKt$ALWAYS_NULL$1();

    FunctionsKt$ALWAYS_NULL$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Void invoke(@Nullable Object obj) {
        return null;
    }
}
