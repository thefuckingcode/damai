package tb;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class d2 implements MemberScope {
    @NotNull
    public final MemberScope a() {
        if (b() instanceof d2) {
            return ((d2) b()).a();
        }
        return b();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope b();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<og1> getClassifierNames() {
        return b().getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return b().getContributedClassifier(og1, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        return b().getContributedDescriptors(b60, function1);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return b().getContributedFunctions(og1, lookupLocation);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return b().getContributedVariables(og1, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getFunctionNames() {
        return b().getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getVariableNames() {
        return b().getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        b().recordLookup(og1, lookupLocation);
    }
}
