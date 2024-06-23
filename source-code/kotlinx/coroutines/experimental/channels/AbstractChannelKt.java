package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.internal.Symbol;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\t8\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"CLOSE_RESUMED", "", "ENQUEUE_FAILED", "NULL_VALUE", "OFFER_FAILED", "OFFER_SUCCESS", "POLL_FAILED", "SELECT_STARTED", "SEND_RESUMED", "Lkotlinx/coroutines/experimental/internal/Symbol;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: AbstractChannel.kt */
public final class AbstractChannelKt {
    public static final Object CLOSE_RESUMED = new Symbol("CLOSE_RESUMED");
    public static final Object ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    public static final Object NULL_VALUE = new Symbol("NULL_VALUE");
    public static final Object OFFER_FAILED = new Symbol("OFFER_FAILED");
    public static final Object OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    public static final Object POLL_FAILED = new Symbol("POLL_FAILED");
    public static final Object SELECT_STARTED = new Symbol("SELECT_STARTED");
    public static final Symbol SEND_RESUMED = new Symbol("SEND_RESUMED");
}
