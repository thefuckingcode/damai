package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import tb.f22;
import tb.oi;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$descriptor$2 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$descriptor$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ClassDescriptor invoke() {
        ClassDescriptor classDescriptor;
        oi oiVar = KClassImpl.this.w();
        f22 a = KClassImpl.this.x().invoke().a();
        if (oiVar.k()) {
            classDescriptor = a.a().b(oiVar);
        } else {
            classDescriptor = FindClassInModuleKt.a(a.b(), oiVar);
        }
        if (classDescriptor != null) {
            return classDescriptor;
        }
        Void unused = KClassImpl.this.B();
        throw null;
    }
}
