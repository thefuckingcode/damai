package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
    final /* synthetic */ GivenFunctionsMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        super(0);
        this.this$0 = givenFunctionsMemberScope;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends DeclarationDescriptor> invoke() {
        List<FunctionDescriptor> b = this.this$0.b();
        return CollectionsKt___CollectionsKt.k0(b, GivenFunctionsMemberScope.a(this.this$0, b));
    }
}
