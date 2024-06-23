package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$declaredFunctions$1 extends Lambda implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$declaredFunctions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        if (this.this$0.u() != null) {
            return (Collection) this.this$0.u().e.invoke(og1);
        }
        ArrayList arrayList = new ArrayList();
        for (JavaMethod javaMethod : ((DeclaredMemberIndex) this.this$0.r().invoke()).findMethodsByName(og1)) {
            JavaMethodDescriptor B = this.this$0.B(javaMethod);
            if (this.this$0.z(B)) {
                this.this$0.p().a().g().recordMethod(javaMethod, B);
                arrayList.add(B);
            }
        }
        this.this$0.h(arrayList, og1);
        return arrayList;
    }
}
