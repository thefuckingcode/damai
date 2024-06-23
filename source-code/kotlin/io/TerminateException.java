package kotlin.io;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class TerminateException extends FileSystemException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TerminateException(@NotNull File file) {
        super(file, null, null, 6, null);
        k21.i(file, "file");
    }
}
