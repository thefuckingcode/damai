package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class iv1 {

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ProtoBuf$MemberKind.values().length];
            iArr[ProtoBuf$MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf$MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf$MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf$MemberKind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            iArr3[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @NotNull
    public static final h60 a(@NotNull hv1 hv1, @Nullable ProtoBuf$Visibility protoBuf$Visibility) {
        k21.i(hv1, "<this>");
        switch (protoBuf$Visibility == null ? -1 : a.$EnumSwitchMapping$2[protoBuf$Visibility.ordinal()]) {
            case 1:
                h60 h60 = g60.INTERNAL;
                k21.h(h60, "INTERNAL");
                return h60;
            case 2:
                h60 h602 = g60.PRIVATE;
                k21.h(h602, "PRIVATE");
                return h602;
            case 3:
                h60 h603 = g60.PRIVATE_TO_THIS;
                k21.h(h603, "PRIVATE_TO_THIS");
                return h603;
            case 4:
                h60 h604 = g60.PROTECTED;
                k21.h(h604, "PROTECTED");
                return h604;
            case 5:
                h60 h605 = g60.PUBLIC;
                k21.h(h605, "PUBLIC");
                return h605;
            case 6:
                h60 h606 = g60.LOCAL;
                k21.h(h606, "LOCAL");
                return h606;
            default:
                h60 h607 = g60.PRIVATE;
                k21.h(h607, "PRIVATE");
                return h607;
        }
    }

    @NotNull
    public static final CallableMemberDescriptor.Kind b(@NotNull hv1 hv1, @Nullable ProtoBuf$MemberKind protoBuf$MemberKind) {
        k21.i(hv1, "<this>");
        int i = protoBuf$MemberKind == null ? -1 : a.$EnumSwitchMapping$0[protoBuf$MemberKind.ordinal()];
        if (i == 1) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        if (i == 2) {
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        if (i == 3) {
            return CallableMemberDescriptor.Kind.DELEGATION;
        }
        if (i != 4) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    }
}
