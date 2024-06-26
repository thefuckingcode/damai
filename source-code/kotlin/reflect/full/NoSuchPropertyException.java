package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;
import tb.m40;

@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/full/NoSuchPropertyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "<init>", "(Ljava/lang/Exception;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class NoSuchPropertyException extends Exception {
    public NoSuchPropertyException() {
        this(null, 1, null);
    }

    public NoSuchPropertyException(@Nullable Exception exc) {
        super(exc);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoSuchPropertyException(Exception exc, int i, m40 m40) {
        this((i & 1) != 0 ? null : exc);
    }
}
