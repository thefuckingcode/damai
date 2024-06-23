package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class AbstractTypeConstructor$supertypes$1 extends Lambda implements Function0<AbstractTypeConstructor.a> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final AbstractTypeConstructor.a invoke() {
        return new AbstractTypeConstructor.a(this.this$0.c());
    }
}
