package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* compiled from: Taobao */
public class UninitializedMessageException extends RuntimeException {
    private final List<String> missingFields = null;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
