package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    @Nullable
    public final Throwable invoke(@NotNull Throwable th) {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            Object newInstance = this.$constructor$inlined.newInstance(th);
            if (newInstance != null) {
                obj = Result.m913constructorimpl((Throwable) newInstance);
                if (Result.m919isFailureimpl(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th2));
        }
    }
}
