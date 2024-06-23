package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class i1 {
    @JvmField
    @NotNull
    public static final jh2 EMPTY = new jh2("EMPTY");
    @JvmField
    @NotNull
    public static final jh2 ENQUEUE_FAILED = new jh2("ENQUEUE_FAILED");
    @JvmField
    @NotNull
    public static final jh2 HANDLER_INVOKED = new jh2("ON_CLOSE_HANDLER_INVOKED");
    @JvmField
    @NotNull
    public static final jh2 OFFER_FAILED = new jh2("OFFER_FAILED");
    @JvmField
    @NotNull
    public static final jh2 OFFER_SUCCESS = new jh2("OFFER_SUCCESS");
    @JvmField
    @NotNull
    public static final jh2 POLL_FAILED = new jh2("POLL_FAILED");
    public static final int RECEIVE_RESULT = 1;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;
}
