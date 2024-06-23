package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "V", "Ljava/lang/reflect/Field;", "invoke", "()Ljava/lang/reflect/Field;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KProperty1Impl$delegateField$1 extends Lambda implements Function0<Field> {
    final /* synthetic */ KProperty1Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty1Impl$delegateField$1(KProperty1Impl kProperty1Impl) {
        super(0);
        this.this$0 = kProperty1Impl;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Field invoke() {
        return this.this$0.l();
    }
}
