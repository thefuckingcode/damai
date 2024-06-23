package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.og1;

/* compiled from: Taobao */
final class ReflectJavaClass$innerClassNames$2 extends Lambda implements Function1<Class<?>, og1> {
    public static final ReflectJavaClass$innerClassNames$2 INSTANCE = new ReflectJavaClass$innerClassNames$2();

    ReflectJavaClass$innerClassNames$2() {
        super(1);
    }

    @Nullable
    public final og1 invoke(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        if (!og1.h(simpleName)) {
            simpleName = null;
        }
        if (simpleName == null) {
            return null;
        }
        return og1.f(simpleName);
    }
}
