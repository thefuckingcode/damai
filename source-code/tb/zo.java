package tb;

import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class zo extends x30<KCallableImpl<?>, ur2> {
    private final KDeclarationContainerImpl a;

    public zo(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl) {
        k21.i(kDeclarationContainerImpl, "container");
        this.a = kDeclarationContainerImpl;
    }

    @NotNull
    /* renamed from: c */
    public KCallableImpl<?> visitFunctionDescriptor(@NotNull FunctionDescriptor functionDescriptor, @NotNull ur2 ur2) {
        k21.i(functionDescriptor, "descriptor");
        k21.i(ur2, "data");
        return new KFunctionImpl(this.a, functionDescriptor);
    }

    @NotNull
    /* renamed from: d */
    public KCallableImpl<?> visitPropertyDescriptor(@NotNull PropertyDescriptor propertyDescriptor, @NotNull ur2 ur2) {
        k21.i(propertyDescriptor, "descriptor");
        k21.i(ur2, "data");
        int i = 0;
        int i2 = propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0;
        if (propertyDescriptor.getExtensionReceiverParameter() != null) {
            i = 1;
        }
        int i3 = i2 + i;
        if (propertyDescriptor.isVar()) {
            if (i3 == 0) {
                return new KMutableProperty0Impl(this.a, propertyDescriptor);
            }
            if (i3 == 1) {
                return new KMutableProperty1Impl(this.a, propertyDescriptor);
            }
            if (i3 == 2) {
                return new KMutableProperty2Impl(this.a, propertyDescriptor);
            }
        } else if (i3 == 0) {
            return new KProperty0Impl(this.a, propertyDescriptor);
        } else {
            if (i3 == 1) {
                return new KProperty1Impl(this.a, propertyDescriptor);
            }
            if (i3 == 2) {
                return new KProperty2Impl(this.a, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }
}
