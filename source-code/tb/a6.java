package tb;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class a6 {
    @NotNull
    private static final en0 a = new en0("javax.annotation.meta.TypeQualifierNickname");
    @NotNull
    private static final en0 b = new en0("javax.annotation.meta.TypeQualifier");
    @NotNull
    private static final en0 c = new en0("javax.annotation.meta.TypeQualifierDefault");
    @NotNull
    private static final en0 d = new en0("kotlin.annotations.jvm.UnderMigration");
    @NotNull
    private static final List<AnnotationQualifierApplicabilityType> e;
    @NotNull
    private static final Map<en0, l31> f;
    @NotNull
    private static final Map<en0, l31> g;
    @NotNull
    private static final Set<en0> h = e0.g(v41.f(), v41.e());

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> list = m.j(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        e = list;
        en0 g2 = v41.g();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<en0, l31> map = w.f(do2.a(g2, new l31(new hk1(nullabilityQualifier, false, 2, null), list, false)));
        f = map;
        g = x.o(x.l(do2.a(new en0("javax.annotation.ParametersAreNullableByDefault"), new l31(new hk1(NullabilityQualifier.NULLABLE, false, 2, null), l.e(annotationQualifierApplicabilityType), false, 4, null)), do2.a(new en0("javax.annotation.ParametersAreNonnullByDefault"), new l31(new hk1(nullabilityQualifier, false, 2, null), l.e(annotationQualifierApplicabilityType), false, 4, null))), map);
    }

    @NotNull
    public static final Map<en0, l31> a() {
        return g;
    }

    @NotNull
    public static final Set<en0> b() {
        return h;
    }

    @NotNull
    public static final Map<en0, l31> c() {
        return f;
    }

    @NotNull
    public static final en0 d() {
        return d;
    }

    @NotNull
    public static final en0 e() {
        return c;
    }

    @NotNull
    public static final en0 f() {
        return b;
    }

    @NotNull
    public static final en0 g() {
        return a;
    }
}
