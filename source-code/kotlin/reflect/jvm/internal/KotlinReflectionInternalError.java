package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinReflectionInternalError;", "Ljava/lang/Error;", "Lkotlin/Error;", "", "message", "<init>", "(Ljava/lang/String;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KotlinReflectionInternalError extends Error {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinReflectionInternalError(@NotNull String str) {
        super(str);
        k21.i(str, "message");
    }
}
