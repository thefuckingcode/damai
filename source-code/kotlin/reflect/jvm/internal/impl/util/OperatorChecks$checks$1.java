package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
final class OperatorChecks$checks$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    OperatorChecks$checks$1() {
        super(1);
    }

    @Nullable
    public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Boolean bool;
        k21.i(functionDescriptor, "<this>");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        k21.h(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.d0(valueParameters);
        if (valueParameterDescriptor == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(!DescriptorUtilsKt.a(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
        }
        boolean d = k21.d(bool, Boolean.TRUE);
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        if (!d) {
            return "last parameter should not have a default value or be a vararg";
        }
        return null;
    }
}
