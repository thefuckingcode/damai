package kotlin.reflect.jvm.internal.impl.builtins;

import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;
import tb.oi;

/* JADX WARN: Init of enum UBYTE can be incorrect */
/* JADX WARN: Init of enum USHORT can be incorrect */
/* JADX WARN: Init of enum UINT can be incorrect */
/* JADX WARN: Init of enum ULONG can be incorrect */
/* compiled from: Taobao */
public enum UnsignedType {
    UBYTE(r1),
    USHORT(r2),
    UINT(r4),
    ULONG(r6);
    
    @NotNull
    private final oi arrayClassId;
    @NotNull
    private final oi classId;
    @NotNull
    private final og1 typeName;

    static {
        k21.h(oi.e("kotlin/UByte"), "fromString(\"kotlin/UByte\")");
        k21.h(oi.e("kotlin/UShort"), "fromString(\"kotlin/UShort\")");
        k21.h(oi.e("kotlin/UInt"), "fromString(\"kotlin/UInt\")");
        k21.h(oi.e("kotlin/ULong"), "fromString(\"kotlin/ULong\")");
    }

    private UnsignedType(oi oiVar) {
        this.classId = oiVar;
        og1 j = oiVar.j();
        k21.h(j, "classId.shortClassName");
        this.typeName = j;
        this.arrayClassId = new oi(oiVar.h(), og1.f(k21.r(j.b(), "Array")));
    }

    @NotNull
    public final oi getArrayClassId() {
        return this.arrayClassId;
    }

    @NotNull
    public final oi getClassId() {
        return this.classId;
    }

    @NotNull
    public final og1 getTypeName() {
        return this.typeName;
    }
}
