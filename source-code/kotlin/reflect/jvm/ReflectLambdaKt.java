package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.a;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.e51;
import tb.f51;
import tb.i51;
import tb.k21;
import tb.wt2;

/* compiled from: Taobao */
public final class ReflectLambdaKt {
    @Nullable
    public static final <R> KFunction<R> a(@NotNull Function<? extends R> function) {
        k21.i(function, "$this$reflect");
        Metadata metadata = (Metadata) function.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] d1 = metadata.d1();
            boolean z = true;
            if (d1.length == 0) {
                d1 = null;
            }
            if (d1 != null) {
                Pair<f51, ProtoBuf$Function> j = i51.j(d1, metadata.d2());
                f51 component1 = j.component1();
                ProtoBuf$Function component2 = j.component2();
                int[] mv = metadata.mv();
                if ((metadata.xi() & 8) == 0) {
                    z = false;
                }
                e51 e51 = new e51(mv, z);
                Class<?> cls = function.getClass();
                ProtoBuf$TypeTable typeTable = component2.getTypeTable();
                k21.h(typeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) wt2.f(cls, component2, component1, new ap2(typeTable), e51, ReflectLambdaKt$reflect$descriptor$1.INSTANCE);
                if (simpleFunctionDescriptor != null) {
                    return new KFunctionImpl(a.INSTANCE, simpleFunctionDescriptor);
                }
            }
        }
        return null;
    }
}
