package kotlin.reflect.jvm.internal.impl.types;

import kotlin.collections.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.me0;

/* compiled from: Taobao */
final class AbstractTypeConstructor$supertypes$2 extends Lambda implements Function1<Boolean, AbstractTypeConstructor.a> {
    public static final AbstractTypeConstructor$supertypes$2 INSTANCE = new AbstractTypeConstructor$supertypes$2();

    AbstractTypeConstructor$supertypes$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ AbstractTypeConstructor.a invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }

    @NotNull
    public final AbstractTypeConstructor.a invoke(boolean z) {
        return new AbstractTypeConstructor.a(l.e(me0.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES));
    }
}
