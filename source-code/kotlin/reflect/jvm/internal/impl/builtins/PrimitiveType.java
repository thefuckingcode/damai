package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.collections.e0;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;
import tb.m40;
import tb.og1;

/* compiled from: Taobao */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    @NotNull
    private final Lazy arrayTypeFqName$delegate;
    @NotNull
    private final og1 arrayTypeName;
    @NotNull
    private final Lazy typeFqName$delegate;
    @NotNull
    private final og1 typeName;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        PrimitiveType primitiveType;
        PrimitiveType primitiveType2;
        PrimitiveType primitiveType3;
        PrimitiveType primitiveType4;
        PrimitiveType primitiveType5;
        PrimitiveType primitiveType6;
        PrimitiveType primitiveType7;
        NUMBER_TYPES = e0.g(primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7);
    }

    private PrimitiveType(String str) {
        og1 f = og1.f(str);
        k21.h(f, "identifier(typeName)");
        this.typeName = f;
        og1 f2 = og1.f(k21.r(str, "Array"));
        k21.h(f2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = f2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = b.a(lazyThreadSafetyMode, new PrimitiveType$typeFqName$2(this));
        this.arrayTypeFqName$delegate = b.a(lazyThreadSafetyMode, new PrimitiveType$arrayTypeFqName$2(this));
    }

    @NotNull
    public final en0 getArrayTypeFqName() {
        return (en0) this.arrayTypeFqName$delegate.getValue();
    }

    @NotNull
    public final og1 getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final en0 getTypeFqName() {
        return (en0) this.typeFqName$delegate.getValue();
    }

    @NotNull
    public final og1 getTypeName() {
        return this.typeName;
    }
}
