package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import kotlin.collections.m;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;
import tb.ae0;
import tb.bg2;
import tb.c6;
import tb.do2;
import tb.en0;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.w7;

/* compiled from: Taobao */
public final class AnnotationUtilKt {
    @NotNull
    private static final og1 a;
    @NotNull
    private static final og1 b;
    @NotNull
    private static final og1 c;
    @NotNull
    private static final og1 d;
    @NotNull
    private static final og1 e;

    static {
        og1 f = og1.f("message");
        k21.h(f, "identifier(\"message\")");
        a = f;
        og1 f2 = og1.f("replaceWith");
        k21.h(f2, "identifier(\"replaceWith\")");
        b = f2;
        og1 f3 = og1.f("level");
        k21.h(f3, "identifier(\"level\")");
        c = f3;
        og1 f4 = og1.f(DXTraceUtil.TYPE_EXPRESSION_STRING);
        k21.h(f4, "identifier(\"expression\")");
        d = f4;
        og1 f5 = og1.f("imports");
        k21.h(f5, "identifier(\"imports\")");
        e = f5;
    }

    @NotNull
    public static final AnnotationDescriptor a(@NotNull b bVar, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        k21.i(bVar, "<this>");
        k21.i(str, "message");
        k21.i(str2, "replaceWith");
        k21.i(str3, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(bVar, c.a.replaceWith, x.l(do2.a(d, new bg2(str2)), do2.a(e, new w7(m.g(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(bVar)))));
        en0 en0 = c.a.deprecated;
        og1 og1 = c;
        oi m = oi.m(c.a.deprecationLevel);
        k21.h(m, "topLevel(StandardNames.FqNames.deprecationLevel)");
        og1 f = og1.f(str3);
        k21.h(f, "identifier(level)");
        return new BuiltInAnnotationDescriptor(bVar, en0, x.l(do2.a(a, new bg2(str)), do2.a(b, new c6(builtInAnnotationDescriptor)), do2.a(og1, new ae0(m, f))));
    }

    public static /* synthetic */ AnnotationDescriptor b(b bVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return a(bVar, str, str2, str3);
    }
}
