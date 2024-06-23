package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.z50;

/* compiled from: Taobao */
final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.this$0 = staticScopeForKotlinEnum;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends SimpleFunctionDescriptor> invoke() {
        return m.j(z50.d(StaticScopeForKotlinEnum.a(this.this$0)), z50.e(StaticScopeForKotlinEnum.a(this.this$0)));
    }
}
