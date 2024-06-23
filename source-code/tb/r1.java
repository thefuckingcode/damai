package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class r1 extends n2 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull og1 og1, @NotNull Variance variance, boolean z, int i, @NotNull SourceElement sourceElement, @NotNull SupertypeLoopChecker supertypeLoopChecker) {
        super(storageManager, declarationDescriptor, Annotations.Companion.b(), og1, variance, z, i, sourceElement, supertypeLoopChecker);
        if (storageManager == null) {
            a(0);
        }
        if (declarationDescriptor == null) {
            a(1);
        }
        if (og1 == null) {
            a(2);
        }
        if (variance == null) {
            a(3);
        }
        if (sourceElement == null) {
            a(4);
        }
        if (supertypeLoopChecker == null) {
            a(5);
        }
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "variance";
        } else if (i == 4) {
            objArr[0] = "source";
        } else if (i != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // tb.v30
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = isReified() ? "reified " : str;
        if (getVariance() != Variance.INVARIANT) {
            str = getVariance() + " ";
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
