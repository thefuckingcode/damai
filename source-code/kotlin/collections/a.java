package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class a<T> implements Iterator<T>, KMappedMarker {
    @NotNull
    private State a = State.NotReady;
    @Nullable
    private T b;

    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public /* synthetic */ class C0264a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean d() {
        this.a = State.Failed;
        a();
        return this.a == State.Ready;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final void b() {
        this.a = State.Done;
    }

    /* access modifiers changed from: protected */
    public final void c(T t) {
        this.b = t;
        this.a = State.Ready;
    }

    public boolean hasNext() {
        State state = this.a;
        if (state != State.Failed) {
            int i = C0264a.$EnumSwitchMapping$0[state.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i != 2) {
                return d();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = State.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
