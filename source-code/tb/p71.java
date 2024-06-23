package tb;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class p71<E> extends AbstractChannel<E> {
    public p71(@Nullable Function1<? super E, ur2> function1) {
        super(function1);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean L() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean M() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void P(@NotNull Object obj, @NotNull fj<?> fjVar) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                k82 k82 = (k82) obj;
                if (k82 instanceof a.C0288a) {
                    Function1<E, ur2> function1 = this.a;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(function1, ((a.C0288a) k82).d, null);
                    }
                } else {
                    k82.w(fjVar);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementException2 = null;
                    while (true) {
                        int i = size - 1;
                        k82 k822 = (k82) arrayList.get(size);
                        if (k822 instanceof a.C0288a) {
                            Function1<E, ur2> function12 = this.a;
                            undeliveredElementException2 = function12 == null ? null : OnUndeliveredElementKt.c(function12, ((a.C0288a) k822).d, undeliveredElementException2);
                        } else {
                            k822.w(fjVar);
                        }
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                    undeliveredElementException = undeliveredElementException2;
                }
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public final boolean r() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public final boolean s() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object u(E e) {
        ReceiveOrClosed<?> y;
        do {
            Object u = super.u(e);
            jh2 jh2 = i1.OFFER_SUCCESS;
            if (u == jh2) {
                return jh2;
            }
            if (u == i1.OFFER_FAILED) {
                y = y(e);
                if (y == null) {
                    return jh2;
                }
            } else if (u instanceof fj) {
                return u;
            } else {
                throw new IllegalStateException(k21.r("Invalid offerInternal result ", u).toString());
            }
        } while (!(y instanceof fj));
        return y;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object v(E e, @NotNull SelectInstance<?> selectInstance) {
        Object obj;
        while (true) {
            if (K()) {
                obj = super.v(e, selectInstance);
            } else {
                obj = selectInstance.performAtomicTrySelect(e(e));
                if (obj == null) {
                    obj = i1.OFFER_SUCCESS;
                }
            }
            if (obj == e82.d()) {
                return e82.d();
            }
            jh2 jh2 = i1.OFFER_SUCCESS;
            if (obj == jh2) {
                return jh2;
            }
            if (obj != i1.OFFER_FAILED && obj != i8.RETRY_ATOMIC) {
                if (obj instanceof fj) {
                    return obj;
                }
                throw new IllegalStateException(k21.r("Invalid result ", obj).toString());
            }
        }
    }
}
