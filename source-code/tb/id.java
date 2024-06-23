package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class id extends y82 {
    @NotNull
    public static final id INSTANCE = new id();

    /* JADX WARNING: Illegal instructions before constructor call */
    private id() {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        c d = c.d();
        ld.a(d);
        ur2 ur2 = ur2.INSTANCE;
        k21.h(d, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        GeneratedMessageLite.c<ProtoBuf$Package, Integer> cVar = ld.packageFqName;
        k21.h(cVar, "packageFqName");
        GeneratedMessageLite.c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> cVar2 = ld.constructorAnnotation;
        k21.h(cVar2, "constructorAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Annotation>> cVar3 = ld.classAnnotation;
        k21.h(cVar3, "classAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Function, List<ProtoBuf$Annotation>> cVar4 = ld.functionAnnotation;
        k21.h(cVar4, "functionAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar5 = ld.propertyAnnotation;
        k21.h(cVar5, "propertyAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar6 = ld.propertyGetterAnnotation;
        k21.h(cVar6, "propertyGetterAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> cVar7 = ld.propertySetterAnnotation;
        k21.h(cVar7, "propertySetterAnnotation");
        GeneratedMessageLite.c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> cVar8 = ld.enumEntryAnnotation;
        k21.h(cVar8, "enumEntryAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> cVar9 = ld.compileTimeValue;
        k21.h(cVar9, "compileTimeValue");
        GeneratedMessageLite.c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> cVar10 = ld.parameterAnnotation;
        k21.h(cVar10, "parameterAnnotation");
        GeneratedMessageLite.c<ProtoBuf$Type, List<ProtoBuf$Annotation>> cVar11 = ld.typeAnnotation;
        k21.h(cVar11, "typeAnnotation");
        GeneratedMessageLite.c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> cVar12 = ld.typeParameterAnnotation;
        k21.h(cVar12, "typeParameterAnnotation");
    }

    private final String o(en0 en0) {
        if (en0.d()) {
            return "default-package";
        }
        String b = en0.g().b();
        k21.h(b, "fqName.shortName().asString()");
        return b;
    }

    @NotNull
    public final String m(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return k21.r(o(en0), ".kotlin_builtins");
    }

    @NotNull
    public final String n(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        StringBuilder sb = new StringBuilder();
        String b = en0.b();
        k21.h(b, "fqName.asString()");
        sb.append(o.E(b, '.', v00.DIR, false, 4, null));
        sb.append(v00.DIR);
        sb.append(m(en0));
        return sb.toString();
    }
}
