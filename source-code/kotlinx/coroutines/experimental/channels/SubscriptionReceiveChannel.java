package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.experimental.channels.ReceiveChannel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "T", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/experimental/internal/Closeable;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
@Deprecated(message = "Deprecated in favour of `ReceiveChannel`", replaceWith = @ReplaceWith(expression = "ReceiveChannel", imports = {}))
/* compiled from: BroadcastChannel.kt */
public interface SubscriptionReceiveChannel<T> extends ReceiveChannel<T>, Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @Deprecated(message = "Use `cancel`", replaceWith = @ReplaceWith(expression = "cancel()", imports = {}))
    void close();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: BroadcastChannel.kt */
    public static final class DefaultImpls {
        @Deprecated(message = "Use `cancel`", replaceWith = @ReplaceWith(expression = "cancel()", imports = {}))
        public static <T> void close(SubscriptionReceiveChannel<? extends T> subscriptionReceiveChannel) {
            ReceiveChannel.DefaultImpls.cancel$default(subscriptionReceiveChannel, null, 1, null);
        }
    }
}
