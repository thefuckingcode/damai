package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.l;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import tb.do2;
import tb.i31;
import tb.og1;
import tb.om;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<og1, ? extends om<? extends Object>>> {
    final /* synthetic */ JavaTargetAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        super(0);
        this.this$0 = javaTargetAnnotationDescriptor;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, tb.om<java.lang.Object>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends om<? extends Object>> invoke() {
        om<?> omVar;
        JavaAnnotationArgument a = this.this$0.a();
        Map<og1, om<Object>> map = null;
        if (a instanceof JavaArrayAnnotationArgument) {
            omVar = JavaAnnotationTargetMapper.INSTANCE.c(((JavaArrayAnnotationArgument) this.this$0.a()).getElements());
        } else {
            omVar = a instanceof JavaEnumValueAnnotationArgument ? JavaAnnotationTargetMapper.INSTANCE.c(l.e(this.this$0.a())) : null;
        }
        if (omVar != null) {
            map = w.f(do2.a(i31.INSTANCE.d(), omVar));
        }
        return map != null ? map : x.i();
    }
}
