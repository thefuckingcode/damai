package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.e0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import tb.b60;
import tb.dz1;
import tb.j42;
import tb.k21;
import tb.mu2;
import tb.og1;
import tb.pc1;
import tb.te2;
import tb.x61;

public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] e = {dz1.i(new PropertyReference1Impl(dz1.b(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    private final x61 a;
    private final LazyJavaPackageFragment b;
    private final LazyJavaPackageScope c;
    private final NotNullLazyValue d;

    public JvmPackageScope(x61 x61, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        k21.i(x61, c.a);
        k21.i(javaPackage, "jPackage");
        k21.i(lazyJavaPackageFragment, "packageFragment");
        this.a = x61;
        this.b = lazyJavaPackageFragment;
        this.c = new LazyJavaPackageScope(x61, javaPackage, lazyJavaPackageFragment);
        this.d = x61.e().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    private final MemberScope[] d() {
        return (MemberScope[]) te2.a(this.d, this, e[0]);
    }

    public final LazyJavaPackageScope c() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getClassifierNames() {
        Set<og1> a2 = pc1.a(ArraysKt___ArraysKt.n(d()));
        if (a2 == null) {
            return null;
        }
        a2.addAll(c().getClassifierNames());
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        ClassDescriptor I = this.c.getContributedClassifier(og1, lookupLocation);
        if (I != null) {
            return I;
        }
        MemberScope[] d2 = d();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = d2.length;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(og1, lookupLocation);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(b60 b60, Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(b60, function1);
        int length = d2.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            contributedDescriptors = j42.a(contributedDescriptors, memberScope.getContributedDescriptors(b60, function1));
        }
        return contributedDescriptors == null ? e0.d() : contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(og1, lookupLocation);
        int length = d2.length;
        int i = 0;
        Collection collection = contributedFunctions;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            collection = j42.a(collection, memberScope.getContributedFunctions(og1, lookupLocation));
        }
        return collection == null ? e0.d() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] d2 = d();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(og1, lookupLocation);
        int length = d2.length;
        int i = 0;
        Collection collection = contributedVariables;
        while (i < length) {
            MemberScope memberScope = d2[i];
            i++;
            collection = j42.a(collection, memberScope.getContributedVariables(og1, lookupLocation));
        }
        return collection == null ? e0.d() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getFunctionNames() {
        MemberScope[] d2 = d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : d2) {
            boolean unused = r.v(linkedHashSet, memberScope.getFunctionNames());
        }
        linkedHashSet.addAll(c().getFunctionNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getVariableNames() {
        MemberScope[] d2 = d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : d2) {
            boolean unused = r.v(linkedHashSet, memberScope.getVariableNames());
        }
        linkedHashSet.addAll(c().getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        mu2.b(this.a.a().k(), lookupLocation, this.b, og1);
    }
}
