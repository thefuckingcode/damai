package kotlinx.coroutines.experimental.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0010J\u000f\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0002¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\"J$\u0010#\u001a\u0004\u0018\u00018\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0%H\b¢\u0006\u0002\u0010&J\r\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001aJ\u0011\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\rH\u0010J\u0011\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\rH\u0010J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rH\u0002R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0005¨\u0006-"}, d2 = {"Lkotlinx/coroutines/experimental/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "", "", "()V", "a", "", "[Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "size", "", "size$annotations", "addImpl", "", "node", "(Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function0;", "(Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function0;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "removeFirstIf", "predicate", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ThreadSafeHeap.kt */
public final class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private T[] a;
    public volatile int size;

    public static /* synthetic */ void size$annotations() {
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final void clear() {
        synchronized (this) {
            Arrays.fill(this.a, 0, this.size, (Object) null);
            this.size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = this.size > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }

    public final T removeFirstIf(Function1<? super T, Boolean> function1) {
        T t;
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                t = null;
                if (firstImpl != null && function1.invoke(firstImpl).booleanValue()) {
                    t = removeAtImpl(0);
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return t;
    }

    public final void addLast(T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        synchronized (this) {
            addImpl(t);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(T t, Function0<Boolean> function0) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(t, "node");
        Intrinsics.checkParameterIsNotNull(function0, "cond");
        synchronized (this) {
            if (function0.invoke().booleanValue()) {
                addImpl(t);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean remove(T t) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(t, "node");
        synchronized (this) {
            if (t.getIndex() < 0) {
                z = false;
            } else {
                removeAtImpl(t.getIndex());
                z = true;
            }
        }
        return z;
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final T removeAtImpl(int i) {
        if (this.size > 0) {
            T[] tArr = this.a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            this.size--;
            if (i < this.size) {
                swap(i, this.size);
                int i2 = (i - 1) / 2;
                if (i > 0) {
                    Object[] objArr = tArr[i];
                    if (objArr == 0) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) objArr;
                    Object[] objArr2 = tArr[i2];
                    if (objArr2 == 0) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(objArr2) < 0) {
                        swap(i, i2);
                        siftUpFrom(i2);
                    }
                }
                siftDownFrom(i);
            }
            T t = tArr[this.size];
            if (t == null) {
                Intrinsics.throwNpe();
            }
            t.setIndex(-1);
            tArr[this.size] = null;
            return t;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void addImpl(T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        T[] realloc = realloc();
        int i = this.size;
        this.size = i + 1;
        realloc[i] = t;
        t.setIndex(i);
        siftUpFrom(i);
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            if (t == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i];
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(t2) > 0) {
                swap(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 < this.size) {
                T[] tArr = this.a;
                if (tArr == null) {
                    Intrinsics.throwNpe();
                }
                int i3 = i2 + 1;
                if (i3 < this.size) {
                    T t = tArr[i3];
                    if (t == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i2];
                    if (t2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(t2) < 0) {
                        i2 = i3;
                    }
                }
                T t3 = tArr[i];
                if (t3 == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable2 = (Comparable) t3;
                T t4 = tArr[i2];
                if (t4 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable2.compareTo(t4) > 0) {
                    swap(i, i2);
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        } else if (this.size < tArr.length) {
            return tArr;
        } else {
            Object[] copyOf = Arrays.copyOf(tArr, this.size * 2);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr3;
            return tArr3;
        }
    }

    private final void swap(int i, int i2) {
        T[] tArr = this.a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        T t = tArr[i2];
        if (t == null) {
            Intrinsics.throwNpe();
        }
        T t2 = tArr[i];
        if (t2 == null) {
            Intrinsics.throwNpe();
        }
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }
}
