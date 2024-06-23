package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class sk2 implements Function1<Throwable, ur2> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(sk2.class, "_state");
    @NotNull
    private volatile /* synthetic */ int _state = 0;
    @NotNull
    private final Job a;
    private final Thread b = Thread.currentThread();
    @Nullable
    private DisposableHandle c;

    public sk2(@NotNull Job job) {
        this.a = job;
    }

    private final Void b(int i) {
        throw new IllegalStateException(k21.r("Illegal state ", Integer.valueOf(i)).toString());
    }

    public final void a() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (d.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.c;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@Nullable Throwable th) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    b(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!d.compareAndSet(this, i, 2));
        this.b.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i;
        this.c = this.a.invokeOnCompletion(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i != 2 && i != 3) {
                    b(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!d.compareAndSet(this, i, 0));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        c(th);
        return ur2.INSTANCE;
    }
}
