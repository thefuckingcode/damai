package tb;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sg implements MemberScope {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String a;
    @NotNull
    private final MemberScope[] b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final MemberScope a(@NotNull String str, @NotNull Iterable<? extends MemberScope> iterable) {
            k21.i(str, "debugName");
            k21.i(iterable, "scopes");
            ac2 ac2 = new ac2();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.b.INSTANCE) {
                    if (memberScope instanceof sg) {
                        boolean unused = r.w(ac2, ((sg) memberScope).b);
                    } else {
                        ac2.add(memberScope);
                    }
                }
            }
            return b(str, ac2);
        }

        @NotNull
        public final MemberScope b(@NotNull String str, @NotNull List<? extends MemberScope> list) {
            k21.i(str, "debugName");
            k21.i(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope.b.INSTANCE;
            }
            if (size == 1) {
                return (MemberScope) list.get(0);
            }
            Object[] array = list.toArray(new MemberScope[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new sg(str, (MemberScope[]) array, null);
        }
    }

    private sg(String str, MemberScope[] memberScopeArr) {
        this.a = str;
        this.b = memberScopeArr;
    }

    public /* synthetic */ sg(String str, MemberScope[] memberScopeArr, m40 m40) {
        this(str, memberScopeArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<og1> getClassifierNames() {
        return pc1.a(ArraysKt___ArraysKt.n(this.b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = memberScopeArr[i];
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
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return m.g();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(b60, function1);
        }
        Collection<DeclarationDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = j42.a(collection, memberScope.getContributedDescriptors(b60, function1));
        }
        if (collection == null) {
            return e0.d();
        }
        return collection;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return m.g();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(og1, lookupLocation);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = j42.a(collection, memberScope.getContributedFunctions(og1, lookupLocation));
        }
        if (collection == null) {
            return e0.d();
        }
        return collection;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return m.g();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(og1, lookupLocation);
        }
        Collection<PropertyDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = j42.a(collection, memberScope.getContributedVariables(og1, lookupLocation));
        }
        if (collection == null) {
            return e0.d();
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getFunctionNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            boolean unused = r.v(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getVariableNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            boolean unused = r.v(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        for (MemberScope memberScope : this.b) {
            memberScope.recordLookup(og1, lookupLocation);
        }
    }

    @NotNull
    public String toString() {
        return this.a;
    }
}
