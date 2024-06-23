package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class TypeIntersectionScope$getContributedFunctions$1 extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedFunctions$1 INSTANCE = new TypeIntersectionScope$getContributedFunctions$1();

    TypeIntersectionScope$getContributedFunctions$1() {
        super(1);
    }

    @NotNull
    public final CallableDescriptor invoke(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }
}
