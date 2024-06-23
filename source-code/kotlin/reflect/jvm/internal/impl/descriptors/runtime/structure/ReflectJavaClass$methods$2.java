package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.k21;
import tb.oy1;

/* compiled from: Taobao */
/* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReference implements Function1<Method, oy1> {
    public static final ReflectJavaClass$methods$2 INSTANCE = new ReflectJavaClass$methods$2();

    ReflectJavaClass$methods$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final KDeclarationContainer getOwner() {
        return dz1.b(oy1.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @NotNull
    public final oy1 invoke(@NotNull Method method) {
        k21.i(method, "p0");
        return new oy1(method);
    }
}
