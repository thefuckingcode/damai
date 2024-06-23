package tb;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class bj0 {
    public static final d<ProtoBuf$Class.Kind> CLASS_KIND;
    public static final b DECLARES_DEFAULT_VALUE;
    public static final b HAS_ANNOTATIONS;
    public static final b HAS_CONSTANT;
    public static final b HAS_GETTER;
    public static final b HAS_SETTER;
    public static final b IS_CONST;
    public static final b IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final b IS_CROSSINLINE;
    public static final b IS_DATA;
    public static final b IS_DELEGATED;
    public static final b IS_EXPECT_CLASS;
    public static final b IS_EXPECT_FUNCTION;
    public static final b IS_EXPECT_PROPERTY;
    public static final b IS_EXTERNAL_ACCESSOR;
    public static final b IS_EXTERNAL_CLASS;
    public static final b IS_EXTERNAL_FUNCTION;
    public static final b IS_EXTERNAL_PROPERTY;
    public static final b IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final b IS_FUN_INTERFACE;
    public static final b IS_INFIX;
    public static final b IS_INLINE;
    public static final b IS_INLINE_ACCESSOR;
    public static final b IS_INLINE_CLASS;
    public static final b IS_INNER;
    public static final b IS_LATEINIT;
    public static final b IS_NEGATED;
    public static final b IS_NOINLINE;
    public static final b IS_NOT_DEFAULT;
    public static final b IS_NULL_CHECK_PREDICATE;
    public static final b IS_OPERATOR;
    public static final b IS_SECONDARY;
    public static final b IS_SUSPEND;
    public static final b IS_TAILREC;
    public static final b IS_UNSIGNED = d.c();
    public static final b IS_VAR;
    public static final d<ProtoBuf$MemberKind> MEMBER_KIND;
    public static final d<ProtoBuf$Modality> MODALITY;
    public static final b SUSPEND_TYPE = d.c();
    public static final d<ProtoBuf$Visibility> VISIBILITY;

    /* compiled from: Taobao */
    public static class b extends d<Boolean> {
        public b(int i) {
            super(i, 1);
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", gl1.TYPE_OPEN_URL_METHOD_GET));
        }

        @NotNull
        /* renamed from: g */
        public Boolean d(int i) {
            boolean z = true;
            if ((i & (1 << this.a)) == 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        /* renamed from: h */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c<E extends Internal.EnumLite> extends d<E> {
        private final E[] c;

        public c(int i, E[] eArr) {
            super(i, g(eArr));
            this.c = eArr;
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(@NotNull E[] eArr) {
            if (eArr == null) {
                f(0);
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

        @Nullable
        /* renamed from: h */
        public E d(int i) {
            int i2 = this.a;
            int i3 = (i & (((1 << this.b) - 1) << i2)) >> i2;
            E[] eArr = this.c;
            for (E e : eArr) {
                if (e.getNumber() == i3) {
                    return e;
                }
            }
            return null;
        }

        /* renamed from: i */
        public int e(E e) {
            return e.getNumber() << this.a;
        }
    }

    /* compiled from: Taobao */
    public static abstract class d<E> {
        public final int a;
        public final int b;

        public static <E extends Internal.EnumLite> d<E> a(d<?> dVar, E[] eArr) {
            return new c(dVar.a + dVar.b, eArr);
        }

        public static b b(d<?> dVar) {
            return new b(dVar.a + dVar.b);
        }

        public static b c() {
            return new b(0);
        }

        public abstract E d(int i);

        public abstract int e(E e);

        private d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static {
        b c2 = d.c();
        HAS_ANNOTATIONS = c2;
        d<ProtoBuf$Visibility> a2 = d.a(c2, ProtoBuf$Visibility.values());
        VISIBILITY = a2;
        d<ProtoBuf$Modality> a3 = d.a(a2, ProtoBuf$Modality.values());
        MODALITY = a3;
        d<ProtoBuf$Class.Kind> a4 = d.a(a3, ProtoBuf$Class.Kind.values());
        CLASS_KIND = a4;
        b b2 = d.b(a4);
        IS_INNER = b2;
        b b3 = d.b(b2);
        IS_DATA = b3;
        b b4 = d.b(b3);
        IS_EXTERNAL_CLASS = b4;
        b b5 = d.b(b4);
        IS_EXPECT_CLASS = b5;
        b b6 = d.b(b5);
        IS_INLINE_CLASS = b6;
        IS_FUN_INTERFACE = d.b(b6);
        b b7 = d.b(a2);
        IS_SECONDARY = b7;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = d.b(b7);
        d<ProtoBuf$MemberKind> a5 = d.a(a3, ProtoBuf$MemberKind.values());
        MEMBER_KIND = a5;
        b b8 = d.b(a5);
        IS_OPERATOR = b8;
        b b9 = d.b(b8);
        IS_INFIX = b9;
        b b10 = d.b(b9);
        IS_INLINE = b10;
        b b11 = d.b(b10);
        IS_TAILREC = b11;
        b b12 = d.b(b11);
        IS_EXTERNAL_FUNCTION = b12;
        b b13 = d.b(b12);
        IS_SUSPEND = b13;
        b b14 = d.b(b13);
        IS_EXPECT_FUNCTION = b14;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = d.b(b14);
        b b15 = d.b(a5);
        IS_VAR = b15;
        b b16 = d.b(b15);
        HAS_GETTER = b16;
        b b17 = d.b(b16);
        HAS_SETTER = b17;
        b b18 = d.b(b17);
        IS_CONST = b18;
        b b19 = d.b(b18);
        IS_LATEINIT = b19;
        b b20 = d.b(b19);
        HAS_CONSTANT = b20;
        b b21 = d.b(b20);
        IS_EXTERNAL_PROPERTY = b21;
        b b22 = d.b(b21);
        IS_DELEGATED = b22;
        IS_EXPECT_PROPERTY = d.b(b22);
        b b23 = d.b(c2);
        DECLARES_DEFAULT_VALUE = b23;
        b b24 = d.b(b23);
        IS_CROSSINLINE = b24;
        IS_NOINLINE = d.b(b24);
        b b25 = d.b(a3);
        IS_NOT_DEFAULT = b25;
        b b26 = d.b(b25);
        IS_EXTERNAL_ACCESSOR = b26;
        IS_INLINE_ACCESSOR = d.b(b26);
        b c3 = d.c();
        IS_NEGATED = c3;
        IS_NULL_CHECK_PREDICATE = d.b(c3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    private static /* synthetic */ void a(int i) {
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

    public static int b(boolean z, @NotNull ProtoBuf$Visibility protoBuf$Visibility, @NotNull ProtoBuf$Modality protoBuf$Modality, boolean z2, boolean z3, boolean z4) {
        if (protoBuf$Visibility == null) {
            a(10);
        }
        if (protoBuf$Modality == null) {
            a(11);
        }
        return HAS_ANNOTATIONS.e(Boolean.valueOf(z)) | MODALITY.e(protoBuf$Modality) | VISIBILITY.e(protoBuf$Visibility) | IS_NOT_DEFAULT.e(Boolean.valueOf(z2)) | IS_EXTERNAL_ACCESSOR.e(Boolean.valueOf(z3)) | IS_INLINE_ACCESSOR.e(Boolean.valueOf(z4));
    }
}
