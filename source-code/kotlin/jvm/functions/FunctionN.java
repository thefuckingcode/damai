package kotlin.jvm.functions;

import kotlin.Function;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.FunctionBase;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public interface FunctionN<R> extends Function<R>, FunctionBase<R> {
    @Override // kotlin.jvm.internal.FunctionBase
    int getArity();

    R invoke(@NotNull Object... objArr);
}
