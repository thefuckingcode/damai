package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.k21;

/* compiled from: Taobao */
final class ReflectJavaClass$innerClassNames$1 extends Lambda implements Function1<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClassNames$1 INSTANCE = new ReflectJavaClass$innerClassNames$1();

    ReflectJavaClass$innerClassNames$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
        return Boolean.valueOf(invoke(cls));
    }

    public final boolean invoke(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        k21.h(simpleName, "it.simpleName");
        return simpleName.length() == 0;
    }
}
