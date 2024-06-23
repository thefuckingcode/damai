package kotlin.io;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ReadAfterEOFException extends RuntimeException {
    public ReadAfterEOFException(@Nullable String str) {
        super(str);
    }
}
