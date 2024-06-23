package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ae0;
import tb.do2;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.om;
import tb.w7;

/* compiled from: Taobao */
public final class JavaAnnotationTargetMapper {
    @NotNull
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> a = x.l(do2.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), do2.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), do2.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), do2.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), do2.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), do2.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), do2.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), do2.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), do2.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), do2.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    @NotNull
    private static final Map<String, KotlinRetention> b = x.l(do2.a("RUNTIME", KotlinRetention.RUNTIME), do2.a("CLASS", KotlinRetention.BINARY), do2.a("SOURCE", KotlinRetention.SOURCE));

    private JavaAnnotationTargetMapper() {
    }

    @Nullable
    public final om<?> a(@Nullable JavaAnnotationArgument javaAnnotationArgument) {
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument ? (JavaEnumValueAnnotationArgument) javaAnnotationArgument : null;
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = b;
        og1 entryName = javaEnumValueAnnotationArgument.getEntryName();
        KotlinRetention kotlinRetention = map.get(entryName == null ? null : entryName.b());
        if (kotlinRetention == null) {
            return null;
        }
        oi m = oi.m(c.a.annotationRetention);
        k21.h(m, "topLevel(StandardNames.FqNames.annotationRetention)");
        og1 f = og1.f(kotlinRetention.name());
        k21.h(f, "identifier(retention.name)");
        return new ae0(m, f);
    }

    @NotNull
    public final Set<KotlinTarget> b(@Nullable String str) {
        EnumSet<KotlinTarget> enumSet = a.get(str);
        return enumSet == null ? e0.d() : enumSet;
    }

    @NotNull
    public final om<?> c(@NotNull List<? extends JavaAnnotationArgument> list) {
        k21.i(list, "arguments");
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(t);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument : arrayList) {
            og1 entryName = javaEnumValueAnnotationArgument.getEntryName();
            boolean unused = r.v(arrayList2, b(entryName == null ? null : entryName.b()));
        }
        ArrayList arrayList3 = new ArrayList(n.q(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            oi m = oi.m(c.a.annotationTarget);
            k21.h(m, "topLevel(StandardNames.FqNames.annotationTarget)");
            og1 f = og1.f(kotlinTarget.name());
            k21.h(f, "identifier(kotlinTarget.name)");
            arrayList3.add(new ae0(m, f));
        }
        return new w7(arrayList3, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}
