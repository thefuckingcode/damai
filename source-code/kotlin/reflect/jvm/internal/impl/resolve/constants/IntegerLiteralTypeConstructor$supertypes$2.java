package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;
import tb.vo2;
import tb.yo2;

/* compiled from: Taobao */
final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements Function0<List<ib2>> {
    final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.this$0 = integerLiteralTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<ib2> invoke() {
        ib2 defaultType = this.this$0.getBuiltIns().x().getDefaultType();
        k21.h(defaultType, "builtIns.comparable.defaultType");
        List<ib2> list = m.m(yo2.f(defaultType, l.e(new vo2(Variance.IN_VARIANCE, IntegerLiteralTypeConstructor.b(this.this$0))), null, 2, null));
        if (!IntegerLiteralTypeConstructor.d(this.this$0)) {
            list.add(this.this$0.getBuiltIns().L());
        }
        return list;
    }
}
