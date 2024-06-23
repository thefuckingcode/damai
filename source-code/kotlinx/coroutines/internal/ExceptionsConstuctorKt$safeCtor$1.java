package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "e", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> $block;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(Function1<? super Throwable, ? extends Throwable> function1) {
        super(1);
        this.$block = function1;
    }

    @Nullable
    public final Throwable invoke(@NotNull Throwable th) {
        Object obj;
        Function1<Throwable, Throwable> function1 = this.$block;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(function1.invoke(th));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th2));
        }
        if (Result.m919isFailureimpl(obj)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
