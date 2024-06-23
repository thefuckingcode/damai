package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: protoTypeTableUtil.kt */
public final class ProtoTypeTableUtilKt {
    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class r3, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(r3, "$this$supertypes");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        List<ProtoBuf.Type> supertypeList = r3.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList != null) {
            return supertypeList;
        }
        List<Integer> supertypeIdList = r3.getSupertypeIdList();
        Intrinsics.checkExpressionValueIsNotNull(supertypeIdList, "supertypeIdList");
        List<Integer> list = supertypeIdList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            arrayList.add(typeTable.get(t.intValue()));
        }
        return arrayList;
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument argument, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(argument, "$this$type");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return typeTable.get(argument.getTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type type, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$flexibleUpperBound");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasFlexibleUpperBound()) {
            return type.getFlexibleUpperBound();
        }
        if (type.hasFlexibleUpperBoundId()) {
            return typeTable.get(type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter typeParameter, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeParameter, "$this$upperBounds");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        List<ProtoBuf.Type> upperBoundList = typeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList != null) {
            return upperBoundList;
        }
        List<Integer> upperBoundIdList = typeParameter.getUpperBoundIdList();
        Intrinsics.checkExpressionValueIsNotNull(upperBoundIdList, "upperBoundIdList");
        List<Integer> list = upperBoundIdList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            arrayList.add(typeTable.get(t.intValue()));
        }
        return arrayList;
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function function, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(function, "$this$returnType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (function.hasReturnType()) {
            ProtoBuf.Type returnType = function.getReturnType();
            Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
            return returnType;
        } else if (function.hasReturnTypeId()) {
            return typeTable.get(function.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    public static final boolean hasReceiver(ProtoBuf.Function function) {
        Intrinsics.checkParameterIsNotNull(function, "$this$hasReceiver");
        return function.hasReceiverType() || function.hasReceiverTypeId();
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function function, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(function, "$this$receiverType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (function.hasReceiverType()) {
            return function.getReceiverType();
        }
        if (function.hasReceiverTypeId()) {
            return typeTable.get(function.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property property, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(property, "$this$returnType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (property.hasReturnType()) {
            ProtoBuf.Type returnType = property.getReturnType();
            Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
            return returnType;
        } else if (property.hasReturnTypeId()) {
            return typeTable.get(property.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    public static final boolean hasReceiver(ProtoBuf.Property property) {
        Intrinsics.checkParameterIsNotNull(property, "$this$hasReceiver");
        return property.hasReceiverType() || property.hasReceiverTypeId();
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property property, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(property, "$this$receiverType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (property.hasReceiverType()) {
            return property.getReceiverType();
        }
        if (property.hasReceiverTypeId()) {
            return typeTable.get(property.getReceiverTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter valueParameter, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(valueParameter, "$this$type");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (valueParameter.hasType()) {
            ProtoBuf.Type type = valueParameter.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "type");
            return type;
        } else if (valueParameter.hasTypeId()) {
            return typeTable.get(valueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter valueParameter, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(valueParameter, "$this$varargElementType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (valueParameter.hasVarargElementType()) {
            return valueParameter.getVarargElementType();
        }
        if (valueParameter.hasVarargElementTypeId()) {
            return typeTable.get(valueParameter.getVarargElementTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type type, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$outerType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasOuterType()) {
            return type.getOuterType();
        }
        if (type.hasOuterTypeId()) {
            return typeTable.get(type.getOuterTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type type, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(type, "$this$abbreviatedType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (type.hasAbbreviatedType()) {
            return type.getAbbreviatedType();
        }
        if (type.hasAbbreviatedTypeId()) {
            return typeTable.get(type.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias typeAlias, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeAlias, "$this$underlyingType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (typeAlias.hasUnderlyingType()) {
            ProtoBuf.Type underlyingType = typeAlias.getUnderlyingType();
            Intrinsics.checkExpressionValueIsNotNull(underlyingType, "underlyingType");
            return underlyingType;
        } else if (typeAlias.hasUnderlyingTypeId()) {
            return typeTable.get(typeAlias.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias typeAlias, TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(typeAlias, "$this$expandedType");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        if (typeAlias.hasExpandedType()) {
            ProtoBuf.Type expandedType = typeAlias.getExpandedType();
            Intrinsics.checkExpressionValueIsNotNull(expandedType, "expandedType");
            return expandedType;
        } else if (typeAlias.hasExpandedTypeId()) {
            return typeTable.get(typeAlias.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }
}
