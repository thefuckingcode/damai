package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class SubstitutingScope$_allDescriptors$2 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ SubstitutingScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        super(0);
        this.this$0 = substitutingScope;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends DeclarationDescriptor> invoke() {
        SubstitutingScope substitutingScope = this.this$0;
        return SubstitutingScope.b(substitutingScope, ResolutionScope.a.a(SubstitutingScope.a(substitutingScope), null, null, 3, null));
    }
}
