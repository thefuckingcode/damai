package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import tb.b60;
import tb.k21;
import tb.og1;
import tb.qj;
import tb.xo2;

public final class SubstitutingScope implements MemberScope {
    private final MemberScope a;
    private final TypeSubstitutor b;
    private Map<DeclarationDescriptor, DeclarationDescriptor> c;
    private final Lazy d = b.b(new SubstitutingScope$_allDescriptors$2(this));

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        k21.i(memberScope, "workerScope");
        k21.i(typeSubstitutor, "givenSubstitutor");
        this.a = memberScope;
        xo2 j = typeSubstitutor.j();
        k21.h(j, "givenSubstitutor.substitution");
        this.b = CapturedTypeConstructorKt.f(j, false, 1, null).c();
    }

    private final Collection<DeclarationDescriptor> c() {
        return (Collection) this.d.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends D extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: public */
    private final <D extends DeclarationDescriptor> Collection<D> d(Collection<? extends D> collection) {
        if (this.b.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g = qj.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g.add(e((DeclarationDescriptor) it.next()));
        }
        return g;
    }

    private final <D extends DeclarationDescriptor> D e(D d2) {
        if (this.b.k()) {
            return d2;
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.c;
        k21.f(map);
        DeclarationDescriptor declarationDescriptor = map.get(d2);
        if (declarationDescriptor == null) {
            if (d2 instanceof Substitutable) {
                declarationDescriptor = ((Substitutable) d2).substitute(this.b);
                if (declarationDescriptor != null) {
                    map.put(d2, declarationDescriptor);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
                }
            } else {
                throw new IllegalStateException(k21.r("Unknown descriptor in scope: ", d2).toString());
            }
        }
        return (D) declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getClassifierNames() {
        return this.a.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.a.getContributedClassifier(og1, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) e(contributedClassifier);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(b60 b60, Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        return c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return d(this.a.getContributedFunctions(og1, lookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return d(this.a.getContributedVariables(og1, lookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getFunctionNames() {
        return this.a.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<og1> getVariableNames() {
        return this.a.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(og1 og1, LookupLocation lookupLocation) {
        MemberScope.a.a(this, og1, lookupLocation);
    }
}
