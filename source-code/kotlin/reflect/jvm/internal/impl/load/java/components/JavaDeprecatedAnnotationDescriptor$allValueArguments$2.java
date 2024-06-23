package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.bg2;
import tb.do2;
import tb.i31;
import tb.og1;

/* compiled from: Taobao */
final class JavaDeprecatedAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<og1, ? extends bg2>> {
    public static final JavaDeprecatedAnnotationDescriptor$allValueArguments$2 INSTANCE = new JavaDeprecatedAnnotationDescriptor$allValueArguments$2();

    JavaDeprecatedAnnotationDescriptor$allValueArguments$2() {
        super(0);
    }

    /* Return type fixed from 'java.util.Map<tb.og1, tb.bg2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends bg2> invoke() {
        return w.f(do2.a(i31.INSTANCE.b(), new bg2("Deprecated in Java")));
    }
}
