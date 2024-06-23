package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* compiled from: ContractDeserializer.kt */
public final class ContractDeserializer$Companion$DEFAULT$1 implements ContractDeserializer {
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
    public Pair deserializeContractFromFunction(ProtoBuf.Function function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
        Intrinsics.checkParameterIsNotNull(function, "proto");
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "ownerFunction");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(typeDeserializer, "typeDeserializer");
        return null;
    }

    ContractDeserializer$Companion$DEFAULT$1() {
    }
}
