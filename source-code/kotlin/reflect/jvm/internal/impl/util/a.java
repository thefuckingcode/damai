package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
final class a implements Check {
    @NotNull
    public static final a INSTANCE = new a();
    @NotNull
    private static final String a = "second parameter must be of type KProperty<*> or its supertype";

    private a() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.b bVar = ReflectionTypes.Companion;
        k21.h(valueParameterDescriptor, "secondParameter");
        g61 a2 = bVar.a(DescriptorUtilsKt.l(valueParameterDescriptor));
        if (a2 == null) {
            return false;
        }
        g61 type = valueParameterDescriptor.getType();
        k21.h(type, "secondParameter.type");
        return TypeUtilsKt.g(a2, TypeUtilsKt.j(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.a.a(this, functionDescriptor);
    }
}
