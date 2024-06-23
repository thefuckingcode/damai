package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.b60;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$allDescriptors$1(LazyJavaScope lazyJavaScope) {
        super(0);
        this.this$0 = lazyJavaScope;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends DeclarationDescriptor> invoke() {
        return this.this$0.f(b60.ALL, MemberScope.Companion.a());
    }
}
