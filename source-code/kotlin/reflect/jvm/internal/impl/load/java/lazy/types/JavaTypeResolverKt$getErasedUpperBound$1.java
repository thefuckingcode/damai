package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;
import tb.me0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JavaTypeResolverKt$getErasedUpperBound$1 extends Lambda implements Function0<ib2> {
    final /* synthetic */ TypeParameterDescriptor $this_getErasedUpperBound;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeResolverKt$getErasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor) {
        super(0);
        this.$this_getErasedUpperBound = typeParameterDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ib2 invoke() {
        ib2 j = me0.j("Can't compute erased upper bound of type parameter `" + this.$this_getErasedUpperBound + '`');
        k21.h(j, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
        return j;
    }
}
