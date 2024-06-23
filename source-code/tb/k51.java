package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.j51;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k51 implements JvmTypeFactory<j51> {
    @NotNull
    public static final k51 INSTANCE = new k51();

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private k51() {
    }

    @NotNull
    /* renamed from: a */
    public j51 boxType(@NotNull j51 j51) {
        k21.i(j51, "possiblyPrimitiveType");
        if (!(j51 instanceof j51.d)) {
            return j51;
        }
        j51.d dVar = (j51.d) j51;
        if (dVar.i() == null) {
            return j51;
        }
        String f = a51.c(dVar.i().getWrapperFqName()).f();
        k21.h(f, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(f);
    }

    @NotNull
    /* renamed from: b */
    public j51 createFromString(@NotNull String str) {
        JvmPrimitiveType jvmPrimitiveType;
        j51 cVar;
        k21.i(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new j51.d(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new j51.d(null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            k21.h(substring, "(this as java.lang.String).substring(startIndex)");
            cVar = new j51.a(createFromString(substring));
        } else {
            if (charAt == 'L') {
                boolean z = StringsKt__StringsKt.V(str, d80.TokenSEM, false, 2, null);
            }
            String substring2 = str.substring(1, str.length() - 1);
            k21.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new j51.c(substring2);
        }
        return cVar;
    }

    @NotNull
    /* renamed from: c */
    public j51.c createObjectType(@NotNull String str) {
        k21.i(str, "internalName");
        return new j51.c(str);
    }

    @NotNull
    /* renamed from: d */
    public j51 createPrimitiveType(@NotNull PrimitiveType primitiveType) {
        k21.i(primitiveType, "primitiveType");
        switch (a.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return j51.Companion.a();
            case 2:
                return j51.Companion.c();
            case 3:
                return j51.Companion.b();
            case 4:
                return j51.Companion.h();
            case 5:
                return j51.Companion.f();
            case 6:
                return j51.Companion.e();
            case 7:
                return j51.Companion.g();
            case 8:
                return j51.Companion.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    /* renamed from: e */
    public j51 getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    @NotNull
    /* renamed from: f */
    public String toString(@NotNull j51 j51) {
        String desc;
        k21.i(j51, "type");
        if (j51 instanceof j51.a) {
            return k21.r(jl1.ARRAY_START_STR, toString(((j51.a) j51).i()));
        }
        if (j51 instanceof j51.d) {
            JvmPrimitiveType i = ((j51.d) j51).i();
            if (i == null || (desc = i.getDesc()) == null) {
                return "V";
            }
            return desc;
        } else if (j51 instanceof j51.c) {
            return u91.LEVEL_L + ((j51.c) j51).i() + d80.TokenSEM;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
