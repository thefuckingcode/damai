package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.do2;
import tb.i31;
import tb.og1;
import tb.om;

/* compiled from: Taobao */
final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<og1, ? extends om<?>>> {
    final /* synthetic */ JavaRetentionAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        super(0);
        this.this$0 = javaRetentionAnnotationDescriptor;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, tb.om<?>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends om<?>> invoke() {
        Map<og1, om<?>> map;
        om<?> a = JavaAnnotationTargetMapper.INSTANCE.a(this.this$0.a());
        if (a == null) {
            map = null;
        } else {
            map = w.f(do2.a(i31.INSTANCE.c(), a));
        }
        return map != null ? map : x.i();
    }
}
