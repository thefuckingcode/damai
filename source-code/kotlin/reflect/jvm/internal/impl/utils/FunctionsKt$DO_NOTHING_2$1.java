package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
final class FunctionsKt$DO_NOTHING_2$1 extends Lambda implements Function2<Object, Object, ur2> {
    public static final FunctionsKt$DO_NOTHING_2$1 INSTANCE = new FunctionsKt$DO_NOTHING_2$1();

    FunctionsKt$DO_NOTHING_2$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final void invoke(@Nullable Object obj, @Nullable Object obj2) {
    }
}
