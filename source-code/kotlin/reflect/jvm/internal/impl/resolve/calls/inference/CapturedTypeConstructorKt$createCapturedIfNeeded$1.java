package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements Function0<g61> {
    final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        super(0);
        this.$this_createCapturedIfNeeded = typeProjection;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final g61 invoke() {
        g61 type = this.$this_createCapturedIfNeeded.getType();
        k21.h(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}
