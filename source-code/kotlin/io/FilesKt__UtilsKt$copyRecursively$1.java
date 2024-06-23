package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements Function2 {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    @NotNull
    public final Void invoke(@NotNull File file, @NotNull IOException iOException) {
        k21.i(file, "<anonymous parameter 0>");
        k21.i(iOException, "exception");
        throw iOException;
    }
}
