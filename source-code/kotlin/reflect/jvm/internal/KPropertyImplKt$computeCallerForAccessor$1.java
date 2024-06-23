package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "isJvmStaticProperty"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KPropertyImplKt$computeCallerForAccessor$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImplKt$computeCallerForAccessor$1(KPropertyImpl.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return this.$this_computeCallerForAccessor.m().i().getAnnotations().hasAnnotation(wt2.h());
    }
}
