package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ SimpleFunctionDescriptor $function$inlined;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$function$inlined = simpleFunctionDescriptor;
    }

    public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "accessorName");
        if (Intrinsics.areEqual(this.$function$inlined.getName(), name)) {
            return CollectionsKt.listOf(this.$function$inlined);
        }
        return CollectionsKt.plus(this.this$0.searchMethodsByNameWithoutBuiltinMagic(name), (Iterable) this.this$0.searchMethodsInSupertypesWithoutBuiltinMagic(name));
    }
}
