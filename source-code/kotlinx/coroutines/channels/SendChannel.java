package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fh;
import tb.sd2;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J-\u0010\u0013\u001a\u00020\u00042#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u000fH'J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u0000H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\r8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", ExifInterface.LONGITUDE_EAST, "", "element", "Ltb/ur2;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltb/fh;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "cause", "", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "offer", "(Ljava/lang/Object;)Z", "isClosedForSend", "()Z", "isClosedForSend$annotations", "()V", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface SendChannel<E> {

    /* compiled from: Taobao */
    public static final class a {
        public static /* synthetic */ boolean a(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean b(@NotNull SendChannel<? super E> sendChannel, E e) {
            Object r0 = sendChannel.m931trySendJP2dKIU(e);
            if (fh.j(r0)) {
                return true;
            }
            Throwable e2 = fh.e(r0);
            if (e2 == null) {
                return false;
            }
            throw sd2.k(e2);
        }
    }

    boolean close(@Nullable Throwable th);

    @NotNull
    SelectClause2<E, SendChannel<E>> getOnSend();

    @ExperimentalCoroutinesApi
    void invokeOnClose(@NotNull Function1<? super Throwable, ur2> function1);

    boolean isClosedForSend();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e);

    @Nullable
    Object send(E e, @NotNull Continuation<? super ur2> continuation);

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    Object m931trySendJP2dKIU(E e);
}
