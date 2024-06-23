package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i61;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class KotlinTypeFactory$simpleType$1 extends Lambda implements Function1<i61, ib2> {
    final /* synthetic */ Annotations $annotations;
    final /* synthetic */ List<TypeProjection> $arguments;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ boolean $nullable;
    final /* synthetic */ KotlinTypeFactory this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinTypeFactory$simpleType$1(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z) {
        super(1);
        this.this$0 = kotlinTypeFactory;
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$annotations = annotations;
        this.$nullable = z;
    }

    @Nullable
    public final ib2 invoke(@NotNull i61 i61) {
        k21.i(i61, "refiner");
        KotlinTypeFactory.a aVar = this.this$0.f(this.$constructor, i61, this.$arguments);
        if (aVar == null) {
            return null;
        }
        ib2 a = aVar.a();
        if (a != null) {
            return a;
        }
        Annotations annotations = this.$annotations;
        TypeConstructor b = aVar.b();
        k21.f(b);
        return KotlinTypeFactory.h(annotations, b, this.$arguments, this.$nullable, i61);
    }
}
