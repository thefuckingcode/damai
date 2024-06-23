package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: ChainedMemberScope.kt */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion(null);
    private final String debugName;
    private final List<MemberScope> scopes;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChainedMemberScope(String str, List<? extends MemberScope> list) {
        Intrinsics.checkParameterIsNotNull(str, "debugName");
        Intrinsics.checkParameterIsNotNull(list, "scopes");
        this.debugName = str;
        this.scopes = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope memberScope : this.scopes) {
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, lookupLocation);
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

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt.emptySet();
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, lookupLocation));
        }
        return collection != null ? collection : SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt.emptySet();
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, lookupLocation));
        }
        return collection != null ? collection : SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(descriptorKindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt.emptySet();
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        return collection != null ? collection : SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.scopes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, it.next().getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.scopes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, it.next().getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.debugName;
    }

    /* compiled from: ChainedMemberScope.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope create(String str, List<? extends MemberScope> list) {
            Intrinsics.checkParameterIsNotNull(str, "debugName");
            Intrinsics.checkParameterIsNotNull(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope.Empty.INSTANCE;
            }
            if (size != 1) {
                return new ChainedMemberScope(str, list);
            }
            return (MemberScope) CollectionsKt.single((List) list);
        }
    }
}
