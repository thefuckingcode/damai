package kotlin.io;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class FileAlreadyExistsException extends FileSystemException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i, m40 m40) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        k21.i(file, "file");
    }
}
