package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class c11 extends oc1 {
    @NotNull
    private final MemberScope a;

    public c11(@NotNull MemberScope memberScope) {
        k21.i(memberScope, "workerScope");
        this.a = memberScope;
    }

    @NotNull
    /* renamed from: a */
    public List<ClassifierDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        b60 p = b60.p(b60.Companion.d());
        if (p == null) {
            return m.g();
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.a.getContributedDescriptors(p, function1);
        ArrayList arrayList = new ArrayList();
        for (T t : contributedDescriptors) {
            if (t instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<og1> getClassifierNames() {
        return this.a.getClassifierNames();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.a.getContributedClassifier(og1, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        if (contributedClassifier instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) contributedClassifier;
        }
        return null;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getFunctionNames() {
        return this.a.getFunctionNames();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getVariableNames() {
        return this.a.getVariableNames();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        this.a.recordLookup(og1, lookupLocation);
    }

    @NotNull
    public String toString() {
        return k21.r("Classes from ", this.a);
    }
}
