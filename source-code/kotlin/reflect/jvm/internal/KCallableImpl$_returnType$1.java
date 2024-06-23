package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KTypeImpl;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KCallableImpl$_returnType$1 extends Lambda implements Function0<KTypeImpl> {
    final /* synthetic */ KCallableImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$_returnType$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KTypeImpl invoke() {
        g61 returnType = this.this$0.i().getReturnType();
        k21.f(returnType);
        k21.h(returnType, "descriptor.returnType!!");
        return new KTypeImpl(returnType, new Function0<Type>(this) {
            /* class kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.AnonymousClass1 */
            final /* synthetic */ KCallableImpl$_returnType$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Type invoke() {
                Type type = this.this$0.this$0.e();
                return type != null ? type : this.this$0.this$0.f().getReturnType();
            }
        });
    }
}
