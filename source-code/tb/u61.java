package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class u61 extends b2 {
    private final ClassDescriptor d;
    private final o01 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u61(@NotNull ClassDescriptor classDescriptor) {
        super(Annotations.Companion.b());
        if (classDescriptor == null) {
            a(0);
        }
        this.d = classDescriptor;
        this.e = new o01(classDescriptor, null);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i == 1 || i == 2)) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = by0.ARG_COPY;
            }
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 2) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.d;
        if (classDescriptor == null) {
            a(2);
        }
        return classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    @NotNull
    public ReceiverValue getValue() {
        o01 o01 = this.e;
        if (o01 == null) {
            a(1);
        }
        return o01;
    }

    @Override // tb.v30
    public String toString() {
        return "class " + this.d.getName() + "::this";
    }
}
