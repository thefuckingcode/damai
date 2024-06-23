package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.es2;
import tb.i61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class NewCapturedTypeConstructor$refine$1$1 extends Lambda implements Function0<List<? extends es2>> {
    final /* synthetic */ i61 $kotlinTypeRefiner;
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$refine$1$1(NewCapturedTypeConstructor newCapturedTypeConstructor, i61 i61) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
        this.$kotlinTypeRefiner = i61;
    }

    /* Return type fixed from 'java.util.List<tb.es2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends es2> invoke() {
        List<es2> b = this.this$0.getSupertypes();
        i61 i61 = this.$kotlinTypeRefiner;
        ArrayList arrayList = new ArrayList(n.q(b, 10));
        Iterator<T> it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().h(i61));
        }
        return arrayList;
    }
}
