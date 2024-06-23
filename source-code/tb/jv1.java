package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jv1 {
    @Nullable
    public static final ProtoBuf$Type a(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull ap2 ap2) {
        k21.i(protoBuf$Type, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Type.hasAbbreviatedType()) {
            return protoBuf$Type.getAbbreviatedType();
        }
        if (protoBuf$Type.hasAbbreviatedTypeId()) {
            return ap2.a(protoBuf$Type.getAbbreviatedTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type b(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias, @NotNull ap2 ap2) {
        k21.i(protoBuf$TypeAlias, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$TypeAlias.hasExpandedType()) {
            ProtoBuf$Type expandedType = protoBuf$TypeAlias.getExpandedType();
            k21.h(expandedType, "expandedType");
            return expandedType;
        } else if (protoBuf$TypeAlias.hasExpandedTypeId()) {
            return ap2.a(protoBuf$TypeAlias.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }

    @Nullable
    public static final ProtoBuf$Type c(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull ap2 ap2) {
        k21.i(protoBuf$Type, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Type.hasFlexibleUpperBound()) {
            return protoBuf$Type.getFlexibleUpperBound();
        }
        if (protoBuf$Type.hasFlexibleUpperBoundId()) {
            return ap2.a(protoBuf$Type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean d(@NotNull ProtoBuf$Function protoBuf$Function) {
        k21.i(protoBuf$Function, "<this>");
        return protoBuf$Function.hasReceiverType() || protoBuf$Function.hasReceiverTypeId();
    }

    public static final boolean e(@NotNull ProtoBuf$Property protoBuf$Property) {
        k21.i(protoBuf$Property, "<this>");
        return protoBuf$Property.hasReceiverType() || protoBuf$Property.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf$Type f(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull ap2 ap2) {
        k21.i(protoBuf$Type, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Type.hasOuterType()) {
            return protoBuf$Type.getOuterType();
        }
        if (protoBuf$Type.hasOuterTypeId()) {
            return ap2.a(protoBuf$Type.getOuterTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf$Type g(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull ap2 ap2) {
        k21.i(protoBuf$Function, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Function.hasReceiverType()) {
            return protoBuf$Function.getReceiverType();
        }
        if (protoBuf$Function.hasReceiverTypeId()) {
            return ap2.a(protoBuf$Function.getReceiverTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf$Type h(@NotNull ProtoBuf$Property protoBuf$Property, @NotNull ap2 ap2) {
        k21.i(protoBuf$Property, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Property.hasReceiverType()) {
            return protoBuf$Property.getReceiverType();
        }
        if (protoBuf$Property.hasReceiverTypeId()) {
            return ap2.a(protoBuf$Property.getReceiverTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type i(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull ap2 ap2) {
        k21.i(protoBuf$Function, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Function.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Function.getReturnType();
            k21.h(returnType, "returnType");
            return returnType;
        } else if (protoBuf$Function.hasReturnTypeId()) {
            return ap2.a(protoBuf$Function.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    @NotNull
    public static final ProtoBuf$Type j(@NotNull ProtoBuf$Property protoBuf$Property, @NotNull ap2 ap2) {
        k21.i(protoBuf$Property, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$Property.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Property.getReturnType();
            k21.h(returnType, "returnType");
            return returnType;
        } else if (protoBuf$Property.hasReturnTypeId()) {
            return ap2.a(protoBuf$Property.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf$Type> k(@NotNull ProtoBuf$Class protoBuf$Class, @NotNull ap2 ap2) {
        k21.i(protoBuf$Class, "<this>");
        k21.i(ap2, "typeTable");
        List<ProtoBuf$Type> supertypeList = protoBuf$Class.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = protoBuf$Class.getSupertypeIdList();
            k21.h(supertypeIdList, "supertypeIdList");
            supertypeList = new ArrayList<>(n.q(supertypeIdList, 10));
            for (T t : supertypeIdList) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                supertypeList.add(ap2.a(t.intValue()));
            }
        }
        return supertypeList;
    }

    @Nullable
    public static final ProtoBuf$Type l(@NotNull ProtoBuf$Type.Argument argument, @NotNull ap2 ap2) {
        k21.i(argument, "<this>");
        k21.i(ap2, "typeTable");
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return ap2.a(argument.getTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type m(@NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter, @NotNull ap2 ap2) {
        k21.i(protoBuf$ValueParameter, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$ValueParameter.hasType()) {
            ProtoBuf$Type type = protoBuf$ValueParameter.getType();
            k21.h(type, "type");
            return type;
        } else if (protoBuf$ValueParameter.hasTypeId()) {
            return ap2.a(protoBuf$ValueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    @NotNull
    public static final ProtoBuf$Type n(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias, @NotNull ap2 ap2) {
        k21.i(protoBuf$TypeAlias, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$TypeAlias.hasUnderlyingType()) {
            ProtoBuf$Type underlyingType = protoBuf$TypeAlias.getUnderlyingType();
            k21.h(underlyingType, "underlyingType");
            return underlyingType;
        } else if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
            return ap2.a(protoBuf$TypeAlias.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf$Type> o(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull ap2 ap2) {
        k21.i(protoBuf$TypeParameter, "<this>");
        k21.i(ap2, "typeTable");
        List<ProtoBuf$Type> upperBoundList = protoBuf$TypeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = protoBuf$TypeParameter.getUpperBoundIdList();
            k21.h(upperBoundIdList, "upperBoundIdList");
            upperBoundList = new ArrayList<>(n.q(upperBoundIdList, 10));
            for (T t : upperBoundIdList) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                upperBoundList.add(ap2.a(t.intValue()));
            }
        }
        return upperBoundList;
    }

    @Nullable
    public static final ProtoBuf$Type p(@NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter, @NotNull ap2 ap2) {
        k21.i(protoBuf$ValueParameter, "<this>");
        k21.i(ap2, "typeTable");
        if (protoBuf$ValueParameter.hasVarargElementType()) {
            return protoBuf$ValueParameter.getVarargElementType();
        }
        if (protoBuf$ValueParameter.hasVarargElementTypeId()) {
            return ap2.a(protoBuf$ValueParameter.getVarargElementTypeId());
        }
        return null;
    }
}
