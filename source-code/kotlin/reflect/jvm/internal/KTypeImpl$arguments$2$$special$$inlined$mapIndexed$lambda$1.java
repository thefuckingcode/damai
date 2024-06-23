package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1", "<no name provided>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ int $i;
    final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
    final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined;
    final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i, KTypeImpl$arguments$2 kTypeImpl$arguments$2, Lazy lazy, KProperty kProperty) {
        super(0);
        this.$i = i;
        this.this$0 = kTypeImpl$arguments$2;
        this.$parameterizedTypeArguments$inlined = lazy;
        this.$parameterizedTypeArguments$metadata$inlined = kProperty;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Type invoke() {
        Type javaType = this.this$0.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            k21.h(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.$i == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                k21.h(genericComponentType, "javaType.genericComponentType");
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0.this$0);
        } else if (javaType instanceof ParameterizedType) {
            Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                k21.h(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) e.v(lowerBounds);
                if (type2 != null) {
                    type = type2;
                } else {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    k21.h(upperBounds, "argument.upperBounds");
                    type = (Type) e.u(upperBounds);
                }
            }
            k21.h(type, "if (argument !is Wildcar…ument.upperBounds.first()");
            return type;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0.this$0);
        }
    }
}
