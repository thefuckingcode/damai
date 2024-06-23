package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class v30 extends w5 implements DeclarationDescriptor {
    @NotNull
    private final og1 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v30(@NotNull Annotations annotations, @NotNull og1 og1) {
        super(annotations);
        if (annotations == null) {
            a(0);
        }
        if (og1 == null) {
            a(1);
        }
        this.b = og1;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (!(i == 2 || i == 3)) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (!(i == 5 || i == 6)) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i == 2 || i == 3 || i == 5 || i == 6) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static String b(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(4);
        }
        try {
            String str = DescriptorRenderer.DEBUG_TEXT.a(declarationDescriptor) + jl1.ARRAY_START_STR + declarationDescriptor.getClass().getSimpleName() + o70.DINAMIC_PREFIX_AT + Integer.toHexString(System.identityHashCode(declarationDescriptor)) + jl1.ARRAY_END_STR;
            if (str == null) {
                a(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = declarationDescriptor.getClass().getSimpleName() + " " + declarationDescriptor.getName();
            if (str2 == null) {
                a(6);
            }
            return str2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public og1 getName() {
        og1 og1 = this.b;
        if (og1 == null) {
            a(2);
        }
        return og1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
