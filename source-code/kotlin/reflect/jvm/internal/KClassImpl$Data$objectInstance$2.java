package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import org.jetbrains.annotations.Nullable;
import tb.xk;
import tb.yk;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "T", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$objectInstance$2 extends Lambda implements Function0<T> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$objectInstance$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final T invoke() {
        Field field;
        ClassDescriptor n = this.this$0.n();
        if (n.getKind() != ClassKind.OBJECT) {
            return null;
        }
        if (!n.isCompanionObject() || yk.a(xk.INSTANCE, n)) {
            field = KClassImpl.this.getJClass().getDeclaredField("INSTANCE");
        } else {
            field = KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(n.getName().b());
        }
        T t = (T) field.get(null);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}
