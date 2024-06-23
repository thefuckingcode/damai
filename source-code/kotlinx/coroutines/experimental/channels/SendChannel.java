package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlinx.coroutines.experimental.selects.SelectClause2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0014\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R$\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\t¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/experimental/channels/SendChannel;", "E", "", "isClosedForSend", "", "()Z", "isFull", "onSend", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "cause", "", "offer", "element", "(Ljava/lang/Object;)Z", "send", "", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Channel.kt */
public interface SendChannel<E> {
    boolean close(Throwable th);

    SelectClause2<E, SendChannel<E>> getOnSend();

    boolean isClosedForSend();

    boolean isFull();

    boolean offer(E e);

    Object send(E e, Continuation<? super Unit> continuation);

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Channel.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
