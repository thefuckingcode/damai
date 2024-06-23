package tb;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class j03 extends l1 {
    @NotNull
    public static final a Key = new a(null);
    @JvmField
    public boolean a;

    /* compiled from: Taobao */
    public static final class a implements CoroutineContext.Key<j03> {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public j03() {
        super(Key);
    }
}
