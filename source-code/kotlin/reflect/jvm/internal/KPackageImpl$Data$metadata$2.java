package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import org.jetbrains.annotations.Nullable;
import tb.e51;
import tb.f51;
import tb.i51;
import tb.wy1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Triple;", "Ltb/f51;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Ltb/e51;", "invoke", "()Lkotlin/Triple;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class KPackageImpl$Data$metadata$2 extends Lambda implements Function0<Triple<? extends f51, ? extends ProtoBuf$Package, ? extends e51>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$Data$metadata$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'kotlin.Triple<tb.f51, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, tb.e51>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Triple<? extends f51, ? extends ProtoBuf$Package, ? extends e51> invoke() {
        KotlinClassHeader classHeader;
        wy1 b = KPackageImpl.Data.b(this.this$0);
        if (b == null || (classHeader = b.getClassHeader()) == null) {
            return null;
        }
        String[] a = classHeader.a();
        String[] g = classHeader.g();
        if (a == null || g == null) {
            return null;
        }
        Pair<f51, ProtoBuf$Package> m = i51.m(a, g);
        return new Triple<>(m.component1(), m.component2(), classHeader.d());
    }
}
