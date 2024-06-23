package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.Typography;

/* compiled from: constantValues.kt */
public final class StringValue extends ConstantValue<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringValue(String str) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        SimpleType stringType = moduleDescriptor.getBuiltIns().getStringType();
        Intrinsics.checkExpressionValueIsNotNull(stringType, "module.builtIns.stringType");
        return stringType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return Typography.quote + ((String) getValue()) + Typography.quote;
    }
}
