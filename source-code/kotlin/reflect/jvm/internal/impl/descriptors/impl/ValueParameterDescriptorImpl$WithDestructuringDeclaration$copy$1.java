package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1 extends Lambda implements Function0<List<? extends VariableDescriptor>> {
    final /* synthetic */ ValueParameterDescriptorImpl.WithDestructuringDeclaration this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(ValueParameterDescriptorImpl.WithDestructuringDeclaration withDestructuringDeclaration) {
        super(0);
        this.this$0 = withDestructuringDeclaration;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends VariableDescriptor> invoke() {
        return this.this$0.h();
    }
}
