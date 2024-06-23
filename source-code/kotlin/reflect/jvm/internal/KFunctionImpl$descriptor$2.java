package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KFunctionImpl$descriptor$2 extends Lambda implements Function0<FunctionDescriptor> {
    final /* synthetic */ String $name;
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        super(0);
        this.this$0 = kFunctionImpl;
        this.$name = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FunctionDescriptor invoke() {
        return this.this$0.g().f(this.$name, this.this$0.i);
    }
}
