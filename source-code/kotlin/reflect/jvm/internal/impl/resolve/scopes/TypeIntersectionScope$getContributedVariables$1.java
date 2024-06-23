package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class TypeIntersectionScope$getContributedVariables$1 extends Lambda implements Function1<PropertyDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedVariables$1 INSTANCE = new TypeIntersectionScope$getContributedVariables$1();

    TypeIntersectionScope$getContributedVariables$1() {
        super(1);
    }

    @NotNull
    public final CallableDescriptor invoke(@NotNull PropertyDescriptor propertyDescriptor) {
        k21.i(propertyDescriptor, "<this>");
        return propertyDescriptor;
    }
}
