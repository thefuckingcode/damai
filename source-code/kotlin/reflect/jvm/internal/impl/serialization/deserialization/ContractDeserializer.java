package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.k21;

/* compiled from: Taobao */
public interface ContractDeserializer {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final ContractDeserializer b = new C0285a();

        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0285a implements ContractDeserializer {
            C0285a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
            @Nullable
            public Pair deserializeContractFromFunction(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull FunctionDescriptor functionDescriptor, @NotNull ap2 ap2, @NotNull TypeDeserializer typeDeserializer) {
                k21.i(protoBuf$Function, "proto");
                k21.i(functionDescriptor, "ownerFunction");
                k21.i(ap2, "typeTable");
                k21.i(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        private a() {
        }

        @NotNull
        public final ContractDeserializer a() {
            return b;
        }
    }

    @Nullable
    Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull FunctionDescriptor functionDescriptor, @NotNull ap2 ap2, @NotNull TypeDeserializer typeDeserializer);
}
