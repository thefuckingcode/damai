package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;
import tb.y31;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JavaTypeResolver$computeArguments$1$erasedUpperBound$1 extends Lambda implements Function0<g61> {
    final /* synthetic */ y31 $attr;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ TypeParameterDescriptor $parameter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeResolver$computeArguments$1$erasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor, y31 y31, TypeConstructor typeConstructor) {
        super(0);
        this.$parameter = typeParameterDescriptor;
        this.$attr = y31;
        this.$constructor = typeConstructor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final g61 invoke() {
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        k21.h(typeParameterDescriptor, "parameter");
        TypeParameterDescriptor e = this.$attr.e();
        final TypeConstructor typeConstructor = this.$constructor;
        return JavaTypeResolverKt.b(typeParameterDescriptor, e, new Function0<g61>() {
            /* class kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$1$erasedUpperBound$1.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g61 invoke() {
                ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
                k21.f(declarationDescriptor);
                ib2 defaultType = declarationDescriptor.getDefaultType();
                k21.h(defaultType, "constructor.declarationDescriptor!!.defaultType");
                return TypeUtilsKt.m(defaultType);
            }
        });
    }
}
