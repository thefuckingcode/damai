package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$notConsideredDeprecation$2 extends Lambda implements Function0<Annotations> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsSettings$notConsideredDeprecation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        super(0);
        this.this$0 = jvmBuiltInsSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Annotations invoke() {
        return Annotations.Companion.create(CollectionsKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation$default(this.this$0.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
    }
}
