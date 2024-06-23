package kotlin.reflect.jvm.internal.impl.builtins;

import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;
import tb.oi;

/* JADX WARN: Init of enum UBYTEARRAY can be incorrect */
/* JADX WARN: Init of enum USHORTARRAY can be incorrect */
/* JADX WARN: Init of enum UINTARRAY can be incorrect */
/* JADX WARN: Init of enum ULONGARRAY can be incorrect */
/* compiled from: Taobao */
public enum UnsignedArrayType {
    UBYTEARRAY(r1),
    USHORTARRAY(r2),
    UINTARRAY(r4),
    ULONGARRAY(r6);
    
    @NotNull
    private final oi classId;
    @NotNull
    private final og1 typeName;

    static {
        k21.h(oi.e("kotlin/UByteArray"), "fromString(\"kotlin/UByteArray\")");
        k21.h(oi.e("kotlin/UShortArray"), "fromString(\"kotlin/UShortArray\")");
        k21.h(oi.e("kotlin/UIntArray"), "fromString(\"kotlin/UIntArray\")");
        k21.h(oi.e("kotlin/ULongArray"), "fromString(\"kotlin/ULongArray\")");
    }

    private UnsignedArrayType(oi oiVar) {
        this.classId = oiVar;
        og1 j = oiVar.j();
        k21.h(j, "classId.shortClassName");
        this.typeName = j;
    }

    @NotNull
    public final og1 getTypeName() {
        return this.typeName;
    }
}
