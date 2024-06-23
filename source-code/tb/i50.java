package tb;

import com.taobao.orange.OConstant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class i50 implements SimpleLock {
    @NotNull
    private final Lock a;

    public i50(@NotNull Lock lock) {
        k21.i(lock, OConstant.DIMEN_FILE_LOCK);
        this.a = lock;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Lock a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        this.a.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        this.a.unlock();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i50(Lock lock, int i, m40 m40) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
