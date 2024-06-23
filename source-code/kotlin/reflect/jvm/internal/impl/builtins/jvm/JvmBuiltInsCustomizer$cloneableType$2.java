package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.ib2;

/* compiled from: Taobao */
final class JvmBuiltInsCustomizer$cloneableType$2 extends Lambda implements Function0<ib2> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$cloneableType$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ib2 invoke() {
        return FindClassInModuleKt.c(this.this$0.n().a(), JvmBuiltInClassDescriptorFactory.Companion.a(), new NotFoundClasses(this.$storageManager, this.this$0.n().a())).getDefaultType();
    }
}
