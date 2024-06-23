package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;
import tb.m1;
import tb.m40;

/* compiled from: Taobao */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    @NotNull
    public static final Key Key = new Key(null);

    @ExperimentalStdlibApi
    /* compiled from: Taobao */
    public static final class Key extends m1<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        private Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(m40 m40) {
            this();
        }
    }
}
