package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "T", "Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ g61 $kotlinType;
    final /* synthetic */ KClassImpl$Data$supertypes$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(g61 g61, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        super(0);
        this.$kotlinType = g61;
        this.this$0 = kClassImpl$Data$supertypes$2;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Type invoke() {
        ClassifierDescriptor declarationDescriptor = this.$kotlinType.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> n = wt2.n((ClassDescriptor) declarationDescriptor);
            if (n == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0.this$0 + ": " + declarationDescriptor);
            } else if (k21.d(KClassImpl.this.getJClass().getSuperclass(), n)) {
                Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                k21.h(genericSuperclass, "jClass.genericSuperclass");
                return genericSuperclass;
            } else {
                Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                k21.h(interfaces, "jClass.interfaces");
                int i = ArraysKt___ArraysKt.B(interfaces, n);
                if (i >= 0) {
                    Type type = KClassImpl.this.getJClass().getGenericInterfaces()[i];
                    k21.h(type, "jClass.genericInterfaces[index]");
                    return type;
                }
                throw new KotlinReflectionInternalError("No superclass of " + this.this$0.this$0 + " in Java reflection for " + declarationDescriptor);
            }
        } else {
            throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
        }
    }
}
