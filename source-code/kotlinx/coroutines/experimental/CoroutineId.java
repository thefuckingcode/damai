package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/CoroutineId;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "toString", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoroutineContext.kt */
public final class CoroutineId extends AbstractCoroutineContextElement {
    public static final Key Key = new Key(null);
    private final long id;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/experimental/CoroutineId$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlinx/coroutines/experimental/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CoroutineContext.kt */
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineId(long j) {
        super(Key);
        this.id = j;
    }

    public final long getId() {
        return this.id;
    }

    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }
}
