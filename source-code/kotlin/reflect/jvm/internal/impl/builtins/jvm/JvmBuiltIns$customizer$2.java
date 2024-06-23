package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class JvmBuiltIns$customizer$2 extends Lambda implements Function0<JvmBuiltInsCustomizer> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltIns this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltIns;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final JvmBuiltInsCustomizer invoke() {
        ModuleDescriptorImpl r = this.this$0.r();
        k21.h(r, "builtInsModule");
        StorageManager storageManager = this.$storageManager;
        final JvmBuiltIns jvmBuiltIns = this.this$0;
        return new JvmBuiltInsCustomizer(r, storageManager, new Function0<JvmBuiltIns.a>() {
            /* class kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JvmBuiltIns.a invoke() {
                Function0 M0 = JvmBuiltIns.M0(jvmBuiltIns);
                if (M0 != null) {
                    JvmBuiltIns.a aVar = (JvmBuiltIns.a) M0.invoke();
                    JvmBuiltIns.N0(jvmBuiltIns, null);
                    return aVar;
                }
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }
        });
    }
}
