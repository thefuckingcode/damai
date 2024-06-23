package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: Taobao */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable th) throws Throwable {
        throw th;
    }
}
