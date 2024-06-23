package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.e0;
import kotlin.collections.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.ni;
import tb.zi;

/* compiled from: Taobao */
final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements Function0<ni> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInClassDescriptorFactory;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ni invoke() {
        ni niVar = new ni((DeclarationDescriptor) JvmBuiltInClassDescriptorFactory.c(this.this$0).invoke(JvmBuiltInClassDescriptorFactory.e(this.this$0)), JvmBuiltInClassDescriptorFactory.b(), Modality.ABSTRACT, ClassKind.INTERFACE, l.e(JvmBuiltInClassDescriptorFactory.e(this.this$0).getBuiltIns().i()), SourceElement.NO_SOURCE, false, this.$storageManager);
        niVar.e(new zi(this.$storageManager, niVar), e0.d(), null);
        return niVar;
    }
}
