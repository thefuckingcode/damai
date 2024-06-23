package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import tb.g61;
import tb.k21;
import tb.p51;
import tb.r51;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Ltb/r51;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends r51>> {
    final /* synthetic */ Function0 $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0 function0) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = function0;
    }

    /* Return type fixed from 'java.util.List<tb.r51>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends r51> invoke() {
        r51 r51;
        List<TypeProjection> b = this.this$0.c().b();
        if (b.isEmpty()) {
            return m.g();
        }
        Lazy lazy = b.a(LazyThreadSafetyMode.PUBLICATION, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        ArrayList arrayList = new ArrayList(n.q(b, 10));
        int i = 0;
        for (T t : b) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t2 = t;
            if (t2.isStarProjection()) {
                r51 = r51.Companion.c();
            } else {
                g61 type = t2.getType();
                k21.h(type, "typeProjection.type");
                KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 = null;
                if (this.$computeJavaType != null) {
                    kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 = new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i, this, lazy, null);
                }
                KTypeImpl kTypeImpl = new KTypeImpl(type, kTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1);
                int i3 = p51.$EnumSwitchMapping$0[t2.getProjectionKind().ordinal()];
                if (i3 == 1) {
                    r51 = r51.Companion.d(kTypeImpl);
                } else if (i3 == 2) {
                    r51 = r51.Companion.a(kTypeImpl);
                } else if (i3 == 3) {
                    r51 = r51.Companion.b(kTypeImpl);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(r51);
            i = i2;
        }
        return arrayList;
    }
}
