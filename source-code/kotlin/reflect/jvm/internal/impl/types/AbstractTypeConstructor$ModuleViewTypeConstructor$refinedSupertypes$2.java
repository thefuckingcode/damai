package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.j61;

/* compiled from: Taobao */
final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 extends Lambda implements Function0<List<? extends g61>> {
    final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;
    final /* synthetic */ AbstractTypeConstructor this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
        this.this$1 = abstractTypeConstructor;
    }

    /* Return type fixed from 'java.util.List<tb.g61>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends g61> invoke() {
        return j61.b(this.this$0.a, this.this$1.getSupertypes());
    }
}
