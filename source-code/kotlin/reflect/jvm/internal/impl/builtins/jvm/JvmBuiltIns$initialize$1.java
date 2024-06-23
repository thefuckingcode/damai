package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JvmBuiltIns$initialize$1 extends Lambda implements Function0<JvmBuiltIns.a> {
    final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    final /* synthetic */ ModuleDescriptor $moduleDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltIns$initialize$1(ModuleDescriptor moduleDescriptor, boolean z) {
        super(0);
        this.$moduleDescriptor = moduleDescriptor;
        this.$isAdditionalBuiltInsFeatureSupported = z;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final JvmBuiltIns.a invoke() {
        return new JvmBuiltIns.a(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
