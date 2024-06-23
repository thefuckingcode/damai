package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1 extends Lambda implements Function1<ModuleDescriptor, g61> {
    final /* synthetic */ b $this_createDeprecatedAnnotation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(b bVar) {
        super(1);
        this.$this_createDeprecatedAnnotation = bVar;
    }

    @NotNull
    public final g61 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 l = moduleDescriptor.getBuiltIns().l(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.V());
        k21.h(l, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
        return l;
    }
}
