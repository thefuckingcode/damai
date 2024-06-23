package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class wi extends r52 {
    @NotNull
    public static final wi INSTANCE = new wi();

    private wi() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    private static final void b(ClassDescriptor classDescriptor, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope memberScope, boolean z) {
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.a.a(memberScope, b60.CLASSIFIERS, null, 2, null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (f60.z(classDescriptor2, classDescriptor)) {
                    linkedHashSet.add(declarationDescriptor);
                }
                if (z) {
                    MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                    k21.h(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    b(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z);
                }
            }
        }
    }

    @NotNull
    public Collection<ClassDescriptor> a(@NotNull ClassDescriptor classDescriptor, boolean z) {
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor declarationDescriptor2;
        k21.i(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return m.g();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z) {
            declarationDescriptor = classDescriptor.getContainingDeclaration();
        } else {
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.m(classDescriptor).iterator();
            while (true) {
                if (!it.hasNext()) {
                    declarationDescriptor2 = null;
                    break;
                }
                declarationDescriptor2 = it.next();
                if (declarationDescriptor2 instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            declarationDescriptor = declarationDescriptor2;
        }
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            b(classDescriptor, linkedHashSet, ((PackageFragmentDescriptor) declarationDescriptor).getMemberScope(), z);
        }
        MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        k21.h(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        b(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }
}
