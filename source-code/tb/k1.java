package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class k1 extends AbstractTypeConstructor {
    private int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k1(@NotNull StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
            l(0);
        }
        this.c = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045  */
    private static /* synthetic */ void l(int i) {
        String format;
        String str = (i == 1 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 3 || i == 4) ? 2 : 3)];
        if (i != 1) {
            if (i == 2) {
                objArr[0] = "descriptor";
            } else if (!(i == 3 || i == 4)) {
                objArr[0] = "storageManager";
            }
            if (i != 1) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3 || i == 4) {
                objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
            }
            if (i != 1) {
                if (i == 2) {
                    objArr[2] = "hasMeaningfulFqName";
                } else if (!(i == 3 || i == 4)) {
                    objArr[2] = "<init>";
                }
            }
            format = String.format(str, objArr);
            if (i != 1 || i == 3 || i == 4) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        if (i != 1) {
        }
        if (i != 1) {
        }
        format = String.format(str, objArr);
        if (i != 1) {
        }
        throw new IllegalStateException(format);
    }

    private static boolean m(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (!classDescriptor.getName().equals(classDescriptor2.getName())) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = classDescriptor2.getContainingDeclaration();
        while (containingDeclaration != null && containingDeclaration2 != null) {
            if (containingDeclaration instanceof ModuleDescriptor) {
                return containingDeclaration2 instanceof ModuleDescriptor;
            }
            if (containingDeclaration2 instanceof ModuleDescriptor) {
                return false;
            }
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                if (!(containingDeclaration2 instanceof PackageFragmentDescriptor) || !((PackageFragmentDescriptor) containingDeclaration).getFqName().equals(((PackageFragmentDescriptor) containingDeclaration2).getFqName())) {
                    return false;
                }
                return true;
            } else if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !containingDeclaration.getName().equals(containingDeclaration2.getName())) {
                return false;
            } else {
                containingDeclaration = containingDeclaration.getContainingDeclaration();
                containingDeclaration2 = containingDeclaration2.getContainingDeclaration();
            }
        }
        return true;
    }

    private static boolean o(@NotNull ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor == null) {
            l(2);
        }
        return !me0.r(classifierDescriptor) && !f60.E(classifierDescriptor);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @Nullable
    public g61 d() {
        if (b.B0(n())) {
            return null;
        }
        return getBuiltIns().i();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @NotNull
    public Collection<g61> e(boolean z) {
        DeclarationDescriptor containingDeclaration = n().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                l(3);
            }
            return emptyList;
        }
        ac2 ac2 = new ac2();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        ac2.add(classDescriptor.getDefaultType());
        ClassDescriptor companionObjectDescriptor = classDescriptor.getCompanionObjectDescriptor();
        if (z && companionObjectDescriptor != null) {
            ac2.add(companionObjectDescriptor.getDefaultType());
        }
        return ac2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassDescriptor n = n();
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (!o(n) || ((declarationDescriptor != null && !o(declarationDescriptor)) || !(declarationDescriptor instanceof ClassDescriptor))) {
            return false;
        }
        return m(n, (ClassDescriptor) declarationDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public b getBuiltIns() {
        b g = DescriptorUtilsKt.g(n());
        if (g == null) {
            l(1);
        }
        return g;
    }

    public final int hashCode() {
        int i;
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        ClassDescriptor n = n();
        if (o(n)) {
            i = f60.m(n).hashCode();
        } else {
            i = System.identityHashCode(this);
        }
        this.c = i;
        return i;
    }

    @NotNull
    public abstract ClassDescriptor n();
}
