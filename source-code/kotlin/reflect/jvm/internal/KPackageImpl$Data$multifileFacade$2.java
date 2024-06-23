package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.text.o;
import org.jetbrains.annotations.Nullable;
import tb.v00;
import tb.wy1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", "invoke", "()Ljava/lang/Class;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class KPackageImpl$Data$multifileFacade$2 extends Lambda implements Function0<Class<?>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Class<?> invoke() {
        KotlinClassHeader classHeader;
        wy1 b = KPackageImpl.Data.b(this.this$0);
        String e = (b == null || (classHeader = b.getClassHeader()) == null) ? null : classHeader.e();
        if (e == null) {
            return null;
        }
        if (e.length() > 0) {
            return KPackageImpl.this.getJClass().getClassLoader().loadClass(o.E(e, v00.DIR, '.', false, 4, null));
        }
        return null;
    }
}
