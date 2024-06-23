package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.wt2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class KParameterImpl$type$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ KParameterImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KParameterImpl$type$1(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Type invoke() {
        ParameterDescriptor parameterDescriptor = this.this$0.c();
        if (!(parameterDescriptor instanceof ReceiverParameterDescriptor) || !k21.d(wt2.g(this.this$0.b().i()), parameterDescriptor) || this.this$0.b().i().getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return this.this$0.b().f().getParameterTypes().get(this.this$0.getIndex());
        }
        DeclarationDescriptor containingDeclaration = this.this$0.b().i().getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> n = wt2.n((ClassDescriptor) containingDeclaration);
        if (n != null) {
            return n;
        }
        throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + parameterDescriptor);
    }
}
