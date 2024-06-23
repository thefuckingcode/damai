package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/full/IllegalCallableAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/lang/IllegalAccessException;", "cause", "<init>", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class IllegalCallableAccessException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IllegalCallableAccessException(@NotNull IllegalAccessException illegalAccessException) {
        super(illegalAccessException);
        k21.i(illegalAccessException, "cause");
    }
}
