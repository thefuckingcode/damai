package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public interface CoroutineStackFrame {
    @Nullable
    CoroutineStackFrame getCallerFrame();

    @Nullable
    StackTraceElement getStackTraceElement();
}
