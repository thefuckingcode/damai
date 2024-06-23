package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oi;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$simpleName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$simpleName$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final String invoke() {
        if (KClassImpl.this.getJClass().isAnonymousClass()) {
            return null;
        }
        oi oiVar = KClassImpl.this.w();
        if (oiVar.k()) {
            KClassImpl.Data data = this.this$0;
            return data.f(KClassImpl.this.getJClass());
        }
        String b = oiVar.j().b();
        k21.h(b, "classId.shortClassName.asString()");
        return b;
    }
}
