package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

public class Flags {
    public static final FlagField<ProtoBuf.Class.Kind> CLASS_KIND;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE;
    public static final BooleanFlagField HAS_ANNOTATIONS;
    public static final BooleanFlagField HAS_CONSTANT;
    public static final BooleanFlagField HAS_GETTER;
    public static final BooleanFlagField HAS_SETTER;
    public static final BooleanFlagField IS_CONST;
    public static final BooleanFlagField IS_CROSSINLINE;
    public static final BooleanFlagField IS_DATA;
    public static final BooleanFlagField IS_DELEGATED;
    public static final BooleanFlagField IS_EXPECT_CLASS;
    public static final BooleanFlagField IS_EXPECT_FUNCTION;
    public static final BooleanFlagField IS_EXPECT_PROPERTY;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR;
    public static final BooleanFlagField IS_EXTERNAL_CLASS;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY;
    public static final BooleanFlagField IS_INFIX;
    public static final BooleanFlagField IS_INLINE;
    public static final BooleanFlagField IS_INLINE_ACCESSOR;
    public static final BooleanFlagField IS_INLINE_CLASS;
    public static final BooleanFlagField IS_INNER;
    public static final BooleanFlagField IS_LATEINIT;
    public static final BooleanFlagField IS_NEGATED;
    public static final BooleanFlagField IS_NOINLINE;
    public static final BooleanFlagField IS_NOT_DEFAULT;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE;
    public static final BooleanFlagField IS_OPERATOR;
    public static final BooleanFlagField IS_SECONDARY;
    public static final BooleanFlagField IS_SUSPEND;
    public static final BooleanFlagField IS_TAILREC;
    public static final BooleanFlagField IS_UNSIGNED = FlagField.booleanFirst();
    public static final BooleanFlagField IS_VAR;
    public static final FlagField<ProtoBuf.MemberKind> MEMBER_KIND;
    public static final FlagField<ProtoBuf.Modality> MODALITY;
    public static final BooleanFlagField SUSPEND_TYPE = FlagField.booleanFirst();
    public static final FlagField<ProtoBuf.Visibility> VISIBILITY;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            if (i == 2) {
                objArr[0] = "kind";
            } else if (i != 5) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 9) {
                            if (i != 11) {
                                objArr[0] = "visibility";
                            }
                        }
                    }
                }
                objArr[0] = "memberKind";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
            switch (i) {
                case 3:
                    objArr[2] = "getConstructorFlags";
                    break;
                case 4:
                case 5:
                case 6:
                    objArr[2] = "getFunctionFlags";
                    break;
                case 7:
                case 8:
                case 9:
                    objArr[2] = "getPropertyFlags";
                    break;
                case 10:
                case 11:
                    objArr[2] = "getAccessorFlags";
                    break;
                default:
                    objArr[2] = "getClassFlags";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "modality";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        BooleanFlagField booleanFirst = FlagField.booleanFirst();
        HAS_ANNOTATIONS = booleanFirst;
        FlagField<ProtoBuf.Visibility> after = FlagField.after(booleanFirst, ProtoBuf.Visibility.values());
        VISIBILITY = after;
        FlagField<ProtoBuf.Modality> after2 = FlagField.after(after, ProtoBuf.Modality.values());
        MODALITY = after2;
        FlagField<ProtoBuf.Class.Kind> after3 = FlagField.after(after2, ProtoBuf.Class.Kind.values());
        CLASS_KIND = after3;
        BooleanFlagField booleanAfter = FlagField.booleanAfter(after3);
        IS_INNER = booleanAfter;
        BooleanFlagField booleanAfter2 = FlagField.booleanAfter(booleanAfter);
        IS_DATA = booleanAfter2;
        BooleanFlagField booleanAfter3 = FlagField.booleanAfter(booleanAfter2);
        IS_EXTERNAL_CLASS = booleanAfter3;
        BooleanFlagField booleanAfter4 = FlagField.booleanAfter(booleanAfter3);
        IS_EXPECT_CLASS = booleanAfter4;
        IS_INLINE_CLASS = FlagField.booleanAfter(booleanAfter4);
        IS_SECONDARY = FlagField.booleanAfter(after);
        FlagField<ProtoBuf.MemberKind> after4 = FlagField.after(after2, ProtoBuf.MemberKind.values());
        MEMBER_KIND = after4;
        BooleanFlagField booleanAfter5 = FlagField.booleanAfter(after4);
        IS_OPERATOR = booleanAfter5;
        BooleanFlagField booleanAfter6 = FlagField.booleanAfter(booleanAfter5);
        IS_INFIX = booleanAfter6;
        BooleanFlagField booleanAfter7 = FlagField.booleanAfter(booleanAfter6);
        IS_INLINE = booleanAfter7;
        BooleanFlagField booleanAfter8 = FlagField.booleanAfter(booleanAfter7);
        IS_TAILREC = booleanAfter8;
        BooleanFlagField booleanAfter9 = FlagField.booleanAfter(booleanAfter8);
        IS_EXTERNAL_FUNCTION = booleanAfter9;
        BooleanFlagField booleanAfter10 = FlagField.booleanAfter(booleanAfter9);
        IS_SUSPEND = booleanAfter10;
        IS_EXPECT_FUNCTION = FlagField.booleanAfter(booleanAfter10);
        BooleanFlagField booleanAfter11 = FlagField.booleanAfter(after4);
        IS_VAR = booleanAfter11;
        BooleanFlagField booleanAfter12 = FlagField.booleanAfter(booleanAfter11);
        HAS_GETTER = booleanAfter12;
        BooleanFlagField booleanAfter13 = FlagField.booleanAfter(booleanAfter12);
        HAS_SETTER = booleanAfter13;
        BooleanFlagField booleanAfter14 = FlagField.booleanAfter(booleanAfter13);
        IS_CONST = booleanAfter14;
        BooleanFlagField booleanAfter15 = FlagField.booleanAfter(booleanAfter14);
        IS_LATEINIT = booleanAfter15;
        BooleanFlagField booleanAfter16 = FlagField.booleanAfter(booleanAfter15);
        HAS_CONSTANT = booleanAfter16;
        BooleanFlagField booleanAfter17 = FlagField.booleanAfter(booleanAfter16);
        IS_EXTERNAL_PROPERTY = booleanAfter17;
        BooleanFlagField booleanAfter18 = FlagField.booleanAfter(booleanAfter17);
        IS_DELEGATED = booleanAfter18;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(booleanAfter18);
        BooleanFlagField booleanAfter19 = FlagField.booleanAfter(booleanFirst);
        DECLARES_DEFAULT_VALUE = booleanAfter19;
        BooleanFlagField booleanAfter20 = FlagField.booleanAfter(booleanAfter19);
        IS_CROSSINLINE = booleanAfter20;
        IS_NOINLINE = FlagField.booleanAfter(booleanAfter20);
        BooleanFlagField booleanAfter21 = FlagField.booleanAfter(after2);
        IS_NOT_DEFAULT = booleanAfter21;
        BooleanFlagField booleanAfter22 = FlagField.booleanAfter(booleanAfter21);
        IS_EXTERNAL_ACCESSOR = booleanAfter22;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(booleanAfter22);
        BooleanFlagField booleanFirst2 = FlagField.booleanFirst();
        IS_NEGATED = booleanFirst2;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(booleanFirst2);
    }

    public static int getAccessorFlags(boolean z, ProtoBuf.Visibility visibility, ProtoBuf.Modality modality, boolean z2, boolean z3, boolean z4) {
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (modality == null) {
            $$$reportNull$$$0(11);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | MODALITY.toFlags(modality) | VISIBILITY.toFlags(visibility) | IS_NOT_DEFAULT.toFlags(Boolean.valueOf(z2)) | IS_EXTERNAL_ACCESSOR.toFlags(Boolean.valueOf(z3)) | IS_INLINE_ACCESSOR.toFlags(Boolean.valueOf(z4));
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        public abstract E get(int i);

        public abstract int toFlags(E e);

        public static <E extends Internal.EnumLite> FlagField<E> after(FlagField<?> flagField, E[] eArr) {
            return new EnumLiteFlagField(flagField.offset + flagField.bitWidth, eArr);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> flagField) {
            return new BooleanFlagField(flagField.offset + flagField.bitWidth);
        }

        private FlagField(int i, int i2) {
            this.offset = i;
            this.bitWidth = i2;
        }
    }

    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        public BooleanFlagField(int i) {
            super(i, 1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int i) {
            boolean z = true;
            if ((i & (1 << this.offset)) == 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (valueOf == null) {
                $$$reportNull$$$0(0);
            }
            return valueOf;
        }

        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.offset;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public EnumLiteFlagField(int i, E[] eArr) {
            super(i, bitWidth(eArr));
            this.values = eArr;
        }

        private static <E> int bitWidth(E[] eArr) {
            if (eArr == null) {
                $$$reportNull$$$0(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int i) {
            int i2 = (i & (((1 << this.bitWidth) - 1) << this.offset)) >> this.offset;
            E[] eArr = this.values;
            for (E e : eArr) {
                if (e.getNumber() == i2) {
                    return e;
                }
            }
            return null;
        }

        public int toFlags(E e) {
            return e.getNumber() << this.offset;
        }
    }
}
