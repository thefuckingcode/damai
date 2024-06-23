package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.iy1;
import tb.k21;

/* compiled from: Taobao */
/* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReference implements Function1<Constructor<?>, iy1> {
    public static final ReflectJavaClass$constructors$2 INSTANCE = new ReflectJavaClass$constructors$2();

    ReflectJavaClass$constructors$2() {
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
        return dz1.b(iy1.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @NotNull
    public final iy1 invoke(@NotNull Constructor<?> constructor) {
        k21.i(constructor, "p0");
        return new iy1(constructor);
    }
}
