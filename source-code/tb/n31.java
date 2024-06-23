package tb;

import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n31 {
    @NotNull
    private final LazyJavaPackageFragmentProvider a;
    @NotNull
    private final JavaResolverCache b;

    public n31(@NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull JavaResolverCache javaResolverCache) {
        k21.i(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        k21.i(javaResolverCache, "javaResolverCache");
        this.a = lazyJavaPackageFragmentProvider;
        this.b = javaResolverCache;
    }

    @NotNull
    public final LazyJavaPackageFragmentProvider a() {
        return this.a;
    }

    @Nullable
    public final ClassDescriptor b(@NotNull JavaClass javaClass) {
        ClassifierDescriptor classifierDescriptor;
        k21.i(javaClass, "javaClass");
        en0 fqName = javaClass.getFqName();
        if (fqName != null && javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
            return this.b.getClassResolvedFromSource(fqName);
        }
        JavaClass outerClass = javaClass.getOuterClass();
        if (outerClass != null) {
            ClassDescriptor b2 = b(outerClass);
            MemberScope unsubstitutedInnerClassesScope = b2 == null ? null : b2.getUnsubstitutedInnerClassesScope();
            if (unsubstitutedInnerClassesScope == null) {
                classifierDescriptor = null;
            } else {
                classifierDescriptor = unsubstitutedInnerClassesScope.getContributedClassifier(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER);
            }
            if (classifierDescriptor instanceof ClassDescriptor) {
                return (ClassDescriptor) classifierDescriptor;
            }
            return null;
        } else if (fqName == null) {
            return null;
        } else {
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.a;
            en0 e = fqName.e();
            k21.h(e, "fqName.parent()");
            LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) k.R(lazyJavaPackageFragmentProvider.getPackageFragments(e));
            if (lazyJavaPackageFragment == null) {
                return null;
            }
            return lazyJavaPackageFragment.f(javaClass);
        }
    }
}
