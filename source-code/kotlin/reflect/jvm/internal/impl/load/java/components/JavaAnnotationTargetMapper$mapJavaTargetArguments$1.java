package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.c60;
import tb.g61;
import tb.i31;
import tb.ib2;
import tb.k21;
import tb.me0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends Lambda implements Function1<ModuleDescriptor, g61> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 INSTANCE = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    @NotNull
    public final g61 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
        g61 g61;
        k21.i(moduleDescriptor, "module");
        ValueParameterDescriptor b = c60.b(i31.INSTANCE.d(), moduleDescriptor.getBuiltIns().o(c.a.target));
        if (b == null) {
            g61 = null;
        } else {
            g61 = b.getType();
        }
        if (g61 != null) {
            return g61;
        }
        ib2 j = me0.j("Error: AnnotationTarget[]");
        k21.h(j, "createErrorType(\"Error: AnnotationTarget[]\")");
        return j;
    }
}
