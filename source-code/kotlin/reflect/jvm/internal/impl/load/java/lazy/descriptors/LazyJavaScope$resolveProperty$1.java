package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.Nullable;
import tb.bv1;
import tb.om;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$resolveProperty$1 extends Lambda implements Function0<om<?>> {
    final /* synthetic */ JavaField $field;
    final /* synthetic */ bv1 $propertyDescriptor;
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, JavaField javaField, bv1 bv1) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = javaField;
        this.$propertyDescriptor = bv1;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final om<?> invoke() {
        return this.this$0.p().a().f().getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
