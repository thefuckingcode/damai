package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.og1;
import tb.om;

/* compiled from: Taobao */
public abstract class c extends b {
    private final boolean f;
    protected NullableLazyValue<om<?>> g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @Nullable g61 g61, boolean z, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, og1, g61, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (og1 == null) {
            a(2);
        }
        if (sourceElement == null) {
            a(3);
        }
        this.f = z;
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void e(@NotNull NullableLazyValue<om<?>> nullableLazyValue) {
        if (nullableLazyValue == null) {
            a(4);
        }
        this.g = nullableLazyValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    @Nullable
    public om<?> getCompileTimeInitializer() {
        NullableLazyValue<om<?>> nullableLazyValue = this.g;
        if (nullableLazyValue != null) {
            return (om) nullableLazyValue.invoke();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.f;
    }
}
