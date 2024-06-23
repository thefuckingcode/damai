package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
/* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$3 extends FunctionReference implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
    LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1, lazyJavaClassMemberScope);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public final String getName() {
        return "searchMethodsByNameWithoutBuiltinMagic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final KDeclarationContainer getOwner() {
        return dz1.b(LazyJavaClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, "p0");
        return ((LazyJavaClassMemberScope) this.receiver).A0(og1);
    }
}
