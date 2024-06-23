package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
/* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends FunctionReference implements Function2<g61, g61, Boolean> {
    TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(TypeIntersector typeIntersector) {
        super(2, typeIntersector);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final KDeclarationContainer getOwner() {
        return dz1.b(TypeIntersector.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(g61 g61, g61 g612) {
        return Boolean.valueOf(invoke(g61, g612));
    }

    public final boolean invoke(@NotNull g61 g61, @NotNull g61 g612) {
        k21.i(g61, "p0");
        k21.i(g612, "p1");
        return TypeIntersector.a((TypeIntersector) this.receiver, g61, g612);
    }
}
