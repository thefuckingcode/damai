package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class e60 {
    @Nullable
    public static final ClassDescriptor a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull en0 en0, @NotNull LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        MemberScope unsubstitutedInnerClassesScope;
        k21.i(moduleDescriptor, "<this>");
        k21.i(en0, "fqName");
        k21.i(lookupLocation, "lookupLocation");
        if (en0.d()) {
            return null;
        }
        en0 e = en0.e();
        k21.h(e, "fqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(e).getMemberScope();
        og1 g = en0.g();
        k21.h(g, "fqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(g, lookupLocation);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        en0 e2 = en0.e();
        k21.h(e2, "fqName.parent()");
        ClassDescriptor a = a(moduleDescriptor, e2, lookupLocation);
        if (a == null || (unsubstitutedInnerClassesScope = a.getUnsubstitutedInnerClassesScope()) == null) {
            classifierDescriptor = null;
        } else {
            og1 g2 = en0.g();
            k21.h(g2, "fqName.shortName()");
            classifierDescriptor = unsubstitutedInnerClassesScope.getContributedClassifier(g2, lookupLocation);
        }
        if (classifierDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptor;
        }
        return null;
    }
}
