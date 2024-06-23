package tb;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h2;

/* compiled from: Taobao */
public abstract class f2<S extends h2<?>> {
    @Nullable
    private S[] a;
    private int b;
    private int c;
    @Nullable
    private MutableStateFlow<Integer> d;

    /* access modifiers changed from: protected */
    @NotNull
    public final S a() {
        S s;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] f = f();
            if (f == null) {
                f = c(2);
                this.a = f;
            } else if (e() >= f.length) {
                Object[] copyOf = Arrays.copyOf(f, f.length * 2);
                k21.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.a = (S[]) ((h2[]) copyOf);
                f = (S[]) ((h2[]) copyOf);
            }
            int i = this.c;
            do {
                s = f[i];
                if (s == null) {
                    s = b();
                    f[i] = s;
                }
                i++;
                if (i >= f.length) {
                    i = 0;
                }
            } while (!s.a(this));
            this.c = i;
            this.b = e() + 1;
            mutableStateFlow = this.d;
        }
        if (mutableStateFlow != null) {
            l.e(mutableStateFlow, 1);
        }
        return s;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract S b();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract S[] c(int i);

    /* access modifiers changed from: protected */
    public final void d(@NotNull S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i;
        Continuation<Unit>[] b2;
        synchronized (this) {
            this.b = e() - 1;
            mutableStateFlow = this.d;
            i = 0;
            if (e() == 0) {
                this.c = 0;
            }
            b2 = s.b(this);
        }
        int length = b2.length;
        while (i < length) {
            Continuation<Unit> continuation = b2[i];
            i++;
            if (continuation != null) {
                ur2 ur2 = ur2.INSTANCE;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(ur2));
            }
        }
        if (mutableStateFlow != null) {
            l.e(mutableStateFlow, -1);
        }
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final S[] f() {
        return this.a;
    }

    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            mutableStateFlow = this.d;
            if (mutableStateFlow == null) {
                mutableStateFlow = l.a(Integer.valueOf(e()));
                this.d = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }
}
