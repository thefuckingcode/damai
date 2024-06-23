package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.og1;
import tb.oi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements Function0<Collection<? extends og1>> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    /* Return type fixed from 'java.util.Collection<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends og1> invoke() {
        Collection<oi> a = this.this$0.d().a();
        ArrayList<oi> arrayList = new ArrayList();
        for (T t : a) {
            T t2 = t;
            if (!t2.l() && !ClassDeserializer.Companion.a().contains(t2)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
        for (oi oiVar : arrayList) {
            arrayList2.add(oiVar.j());
        }
        return arrayList2;
    }
}
