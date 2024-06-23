package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: descriptorUtil.kt */
public final class DescriptorUtilKt {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        MemberScope unsubstitutedInnerClassesScope;
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "$this$resolveClassByFqName");
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "lookupLocation");
        ClassDescriptor classDescriptor = null;
        if (fqName.isRoot()) {
            return null;
        }
        FqName parent = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent, "fqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        Intrinsics.checkExpressionValueIsNotNull(shortName, "fqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(shortName, lookupLocation);
        if (!(contributedClassifier instanceof ClassDescriptor)) {
            contributedClassifier = null;
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
        if (classDescriptor2 != null) {
            return classDescriptor2;
        }
        FqName parent2 = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent2, "fqName.parent()");
        ClassDescriptor resolveClassByFqName = resolveClassByFqName(moduleDescriptor, parent2, lookupLocation);
        if (resolveClassByFqName == null || (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
            classifierDescriptor = null;
        } else {
            Name shortName2 = fqName.shortName();
            Intrinsics.checkExpressionValueIsNotNull(shortName2, "fqName.shortName()");
            classifierDescriptor = unsubstitutedInnerClassesScope.getContributedClassifier(shortName2, lookupLocation);
        }
        if (classifierDescriptor instanceof ClassDescriptor) {
            classDescriptor = classifierDescriptor;
        }
        return classDescriptor;
    }
}
