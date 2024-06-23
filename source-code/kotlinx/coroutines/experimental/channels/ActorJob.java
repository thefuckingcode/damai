package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ActorJob;", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "channel", "channel$annotations", "()V", "getChannel", "()Lkotlinx/coroutines/experimental/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
@Deprecated(message = "Use `SendChannel`", replaceWith = @ReplaceWith(expression = "SendChannel", imports = {}))
/* compiled from: Actor.kt */
public interface ActorJob<E> extends SendChannel<E> {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Actor.kt */
    public static final class DefaultImpls {
        @Deprecated(message = "Use SendChannel itself")
        public static /* synthetic */ void channel$annotations() {
        }
    }

    SendChannel<E> getChannel();
}
