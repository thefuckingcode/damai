package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* access modifiers changed from: package-private */
/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver$computeArguments$$inlined$map$lambda$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ JavaTypeAttributes $attr$inlined;
    final /* synthetic */ TypeConstructor $constructor$inlined;
    final /* synthetic */ boolean $isRaw$inlined;
    final /* synthetic */ TypeParameterDescriptor $parameter;
    final /* synthetic */ JavaTypeResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeResolver$computeArguments$$inlined$map$lambda$1(TypeParameterDescriptor typeParameterDescriptor, JavaTypeResolver javaTypeResolver, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor, boolean z) {
        super(0);
        this.$parameter = typeParameterDescriptor;
        this.this$0 = javaTypeResolver;
        this.$attr$inlined = javaTypeAttributes;
        this.$constructor$inlined = typeConstructor;
        this.$isRaw$inlined = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KotlinType invoke() {
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "parameter");
        return JavaTypeResolverKt.getErasedUpperBound(typeParameterDescriptor, this.$attr$inlined.getUpperBoundOfTypeParameter(), new Function0<KotlinType>(this) {
            /* class kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1.AnonymousClass1 */
            final /* synthetic */ JavaTypeResolver$computeArguments$$inlined$map$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KotlinType invoke() {
                ClassifierDescriptor declarationDescriptor = this.this$0.$constructor$inlined.getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "constructor.declarationDescriptor!!");
                SimpleType defaultType = declarationDescriptor.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(defaultType, "constructor.declarationDescriptor!!.defaultType");
                return TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
            }
        });
    }
}
