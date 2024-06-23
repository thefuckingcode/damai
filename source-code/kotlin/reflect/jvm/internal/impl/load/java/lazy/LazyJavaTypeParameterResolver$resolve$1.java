package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.z61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements Function1<JavaTypeParameter, z61> {
    final /* synthetic */ LazyJavaTypeParameterResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        super(1);
        this.this$0 = lazyJavaTypeParameterResolver;
    }

    @Nullable
    public final z61 invoke(@NotNull JavaTypeParameter javaTypeParameter) {
        k21.i(javaTypeParameter, "typeParameter");
        Integer num = (Integer) this.this$0.d.get(javaTypeParameter);
        if (num == null) {
            return null;
        }
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.this$0;
        return new z61(ContextKt.h(ContextKt.b(lazyJavaTypeParameterResolver.a, lazyJavaTypeParameterResolver), lazyJavaTypeParameterResolver.b.getAnnotations()), javaTypeParameter, lazyJavaTypeParameterResolver.c + num.intValue(), lazyJavaTypeParameterResolver.b);
    }
}
