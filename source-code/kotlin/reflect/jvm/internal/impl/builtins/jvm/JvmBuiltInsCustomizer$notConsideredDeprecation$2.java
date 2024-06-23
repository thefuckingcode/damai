package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JvmBuiltInsCustomizer$notConsideredDeprecation$2 extends Lambda implements Function0<Annotations> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$notConsideredDeprecation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Annotations invoke() {
        return Annotations.Companion.a(l.e(AnnotationUtilKt.b(this.this$0.a.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
    }
}
