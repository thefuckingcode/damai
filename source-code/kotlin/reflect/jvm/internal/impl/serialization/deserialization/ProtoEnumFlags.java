package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: ProtoEnumFlags.kt */
public final class ProtoEnumFlags {
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[ProtoBuf.MemberKind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            int[] iArr3 = new int[ProtoBuf.Modality.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ProtoBuf.Modality.FINAL.ordinal()] = 1;
            iArr3[ProtoBuf.Modality.OPEN.ordinal()] = 2;
            iArr3[ProtoBuf.Modality.ABSTRACT.ordinal()] = 3;
            iArr3[ProtoBuf.Modality.SEALED.ordinal()] = 4;
            int[] iArr4 = new int[Modality.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[Modality.FINAL.ordinal()] = 1;
            iArr4[Modality.OPEN.ordinal()] = 2;
            iArr4[Modality.ABSTRACT.ordinal()] = 3;
            iArr4[Modality.SEALED.ordinal()] = 4;
            int[] iArr5 = new int[ProtoBuf.Visibility.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr5[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr5[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr5[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr5[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr5[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            int[] iArr6 = new int[ProtoBuf.Class.Kind.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[ProtoBuf.Class.Kind.CLASS.ordinal()] = 1;
            iArr6[ProtoBuf.Class.Kind.INTERFACE.ordinal()] = 2;
            iArr6[ProtoBuf.Class.Kind.ENUM_CLASS.ordinal()] = 3;
            iArr6[ProtoBuf.Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            iArr6[ProtoBuf.Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr6[ProtoBuf.Class.Kind.OBJECT.ordinal()] = 6;
            iArr6[ProtoBuf.Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            int[] iArr7 = new int[ClassKind.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[ClassKind.CLASS.ordinal()] = 1;
            iArr7[ClassKind.INTERFACE.ordinal()] = 2;
            iArr7[ClassKind.ENUM_CLASS.ordinal()] = 3;
            iArr7[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            iArr7[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr7[ClassKind.OBJECT.ordinal()] = 6;
            int[] iArr8 = new int[ProtoBuf.TypeParameter.Variance.values().length];
            $EnumSwitchMapping$7 = iArr8;
            iArr8[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            iArr8[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            iArr8[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            int[] iArr9 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            $EnumSwitchMapping$8 = iArr9;
            iArr9[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            iArr9[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            iArr9[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            iArr9[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
        }
    }

    private ProtoEnumFlags() {
    }

    public final CallableMemberDescriptor.Kind memberKind(ProtoBuf.MemberKind memberKind) {
        if (memberKind != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[memberKind.ordinal()];
            if (i == 1) {
                return CallableMemberDescriptor.Kind.DECLARATION;
            }
            if (i == 2) {
                return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
            }
            if (i == 3) {
                return CallableMemberDescriptor.Kind.DELEGATION;
            }
            if (i == 4) {
                return CallableMemberDescriptor.Kind.SYNTHESIZED;
            }
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }

    public final Modality modality(ProtoBuf.Modality modality) {
        if (modality != null) {
            int i = WhenMappings.$EnumSwitchMapping$2[modality.ordinal()];
            if (i == 1) {
                return Modality.FINAL;
            }
            if (i == 2) {
                return Modality.OPEN;
            }
            if (i == 3) {
                return Modality.ABSTRACT;
            }
            if (i == 4) {
                return Modality.SEALED;
            }
        }
        return Modality.FINAL;
    }

    public final Visibility visibility(ProtoBuf.Visibility visibility) {
        Visibility visibility2;
        if (visibility != null) {
            switch (WhenMappings.$EnumSwitchMapping$4[visibility.ordinal()]) {
                case 1:
                    visibility2 = Visibilities.INTERNAL;
                    break;
                case 2:
                    visibility2 = Visibilities.PRIVATE;
                    break;
                case 3:
                    visibility2 = Visibilities.PRIVATE_TO_THIS;
                    break;
                case 4:
                    visibility2 = Visibilities.PROTECTED;
                    break;
                case 5:
                    visibility2 = Visibilities.PUBLIC;
                    break;
                case 6:
                    visibility2 = Visibilities.LOCAL;
                    break;
            }
            Intrinsics.checkExpressionValueIsNotNull(visibility2, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
            return visibility2;
        }
        visibility2 = Visibilities.PRIVATE;
        Intrinsics.checkExpressionValueIsNotNull(visibility2, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
        return visibility2;
    }

    public final ClassKind classKind(ProtoBuf.Class.Kind kind) {
        if (kind != null) {
            switch (WhenMappings.$EnumSwitchMapping$5[kind.ordinal()]) {
                case 1:
                    return ClassKind.CLASS;
                case 2:
                    return ClassKind.INTERFACE;
                case 3:
                    return ClassKind.ENUM_CLASS;
                case 4:
                    return ClassKind.ENUM_ENTRY;
                case 5:
                    return ClassKind.ANNOTATION_CLASS;
                case 6:
                case 7:
                    return ClassKind.OBJECT;
            }
        }
        return ClassKind.CLASS;
    }

    public final Variance variance(ProtoBuf.TypeParameter.Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "variance");
        int i = WhenMappings.$EnumSwitchMapping$7[variance.ordinal()];
        if (i == 1) {
            return Variance.IN_VARIANCE;
        }
        if (i == 2) {
            return Variance.OUT_VARIANCE;
        }
        if (i == 3) {
            return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Variance variance(ProtoBuf.Type.Argument.Projection projection) {
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        int i = WhenMappings.$EnumSwitchMapping$8[projection.ordinal()];
        if (i == 1) {
            return Variance.IN_VARIANCE;
        }
        if (i == 2) {
            return Variance.OUT_VARIANCE;
        }
        if (i == 3) {
            return Variance.INVARIANT;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
    }
}
