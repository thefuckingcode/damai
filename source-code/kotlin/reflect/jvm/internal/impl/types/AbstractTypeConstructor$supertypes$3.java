package kotlin.reflect.jvm.internal.impl.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<AbstractTypeConstructor.a, ur2> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(AbstractTypeConstructor.a aVar) {
        invoke(aVar);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull AbstractTypeConstructor.a aVar) {
        k21.i(aVar, "supertypes");
        Collection<g61> findLoopsInSupertypesAndDisconnect = this.this$0.g().findLoopsInSupertypesAndDisconnect(this.this$0, aVar.a(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this.this$0), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this.this$0));
        List<g61> list = null;
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            g61 d = this.this$0.d();
            findLoopsInSupertypesAndDisconnect = d == null ? null : l.e(d);
            if (findLoopsInSupertypesAndDisconnect == null) {
                findLoopsInSupertypesAndDisconnect = m.g();
            }
        }
        if (this.this$0.f()) {
            SupertypeLoopChecker g = this.this$0.g();
            final AbstractTypeConstructor abstractTypeConstructor = this.this$0;
            AnonymousClass2 r4 = new Function1<TypeConstructor, Iterable<? extends g61>>() {
                /* class kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.AnonymousClass2 */

                @NotNull
                public final Iterable<g61> invoke(@NotNull TypeConstructor typeConstructor) {
                    k21.i(typeConstructor, AdvanceSetting.NETWORK_TYPE);
                    return abstractTypeConstructor.b(typeConstructor, true);
                }
            };
            final AbstractTypeConstructor abstractTypeConstructor2 = this.this$0;
            g.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, findLoopsInSupertypesAndDisconnect, r4, new Function1<g61, ur2>() {
                /* class kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ ur2 invoke(g61 g61) {
                    invoke(g61);
                    return ur2.INSTANCE;
                }

                public final void invoke(@NotNull g61 g61) {
                    k21.i(g61, AdvanceSetting.NETWORK_TYPE);
                    abstractTypeConstructor2.j(g61);
                }
            });
        }
        AbstractTypeConstructor abstractTypeConstructor3 = this.this$0;
        if (findLoopsInSupertypesAndDisconnect instanceof List) {
            list = (List) findLoopsInSupertypesAndDisconnect;
        }
        if (list == null) {
            list = CollectionsKt___CollectionsKt.y0(findLoopsInSupertypesAndDisconnect);
        }
        aVar.c(abstractTypeConstructor3.i(list));
    }
}
