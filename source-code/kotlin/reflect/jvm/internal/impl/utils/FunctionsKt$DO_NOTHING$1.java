package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
final class FunctionsKt$DO_NOTHING$1 extends Lambda implements Function1<Object, ur2> {
    public static final FunctionsKt$DO_NOTHING$1 INSTANCE = new FunctionsKt$DO_NOTHING$1();

    FunctionsKt$DO_NOTHING$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(@Nullable Object obj) {
    }
}
