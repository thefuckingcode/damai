package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class e {
    @JvmField
    @NotNull
    public final CoroutineContext a;
    @NotNull
    private final Object[] b;
    @NotNull
    private final ThreadContextElement<Object>[] c;
    private int d;

    public e(@NotNull CoroutineContext coroutineContext, int i) {
        this.a = coroutineContext;
        this.b = new Object[i];
        this.c = new ThreadContextElement[i];
    }

    public final void a(@NotNull ThreadContextElement<?> threadContextElement, @Nullable Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.c;
        this.d = i + 1;
        threadContextElementArr[i] = threadContextElement;
    }

    public final void b(@NotNull CoroutineContext coroutineContext) {
        int length = this.c.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                ThreadContextElement<Object> threadContextElement = this.c[length];
                k21.f(threadContextElement);
                threadContextElement.restoreThreadContext(coroutineContext, this.b[length]);
                if (i >= 0) {
                    length = i;
                } else {
                    return;
                }
            }
        }
    }
}
