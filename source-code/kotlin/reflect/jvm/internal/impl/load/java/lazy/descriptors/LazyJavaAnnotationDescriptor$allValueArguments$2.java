package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import tb.do2;
import tb.og1;
import tb.om;
import tb.u41;

/* compiled from: Taobao */
final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<og1, ? extends om<?>>> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, tb.om<?>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends om<?>> invoke() {
        Collection<JavaAnnotationArgument> arguments = LazyJavaAnnotationDescriptor.c(this.this$0).getArguments();
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (T t : arguments) {
            og1 name = t.getName();
            if (name == null) {
                name = u41.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            om d = LazyJavaAnnotationDescriptor.d(lazyJavaAnnotationDescriptor, t);
            Pair a = d == null ? null : do2.a(name, d);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return x.r(arrayList);
    }
}
