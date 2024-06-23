package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1(JvmBuiltInsSettings jvmBuiltInsSettings) {
        super(0);
        this.this$0 = jvmBuiltInsSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SimpleType invoke() {
        SimpleType anyType = this.this$0.moduleDescriptor.getBuiltIns().getAnyType();
        Intrinsics.checkExpressionValueIsNotNull(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
