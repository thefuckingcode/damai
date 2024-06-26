package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class w30 extends v30 implements DeclarationDescriptorNonRoot {
    @NotNull
    private final DeclarationDescriptor c;
    @NotNull
    private final SourceElement d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected w30(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull SourceElement sourceElement) {
        super(annotations, og1);
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
        this.c = declarationDescriptor;
        this.d = sourceElement;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (!(i == 4 || i == 5 || i == 6)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 5 || i == 6) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    /* renamed from: c */
    public DeclarationDescriptorWithSource getOriginal() {
        DeclarationDescriptorWithSource declarationDescriptorWithSource = (DeclarationDescriptorWithSource) super.getOriginal();
        if (declarationDescriptorWithSource == null) {
            a(4);
        }
        return declarationDescriptorWithSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.c;
        if (declarationDescriptor == null) {
            a(5);
        }
        return declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.d;
        if (sourceElement == null) {
            a(6);
        }
        return sourceElement;
    }
}
