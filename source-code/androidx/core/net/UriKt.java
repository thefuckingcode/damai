package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\b\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0005"}, d2 = {"", "Landroid/net/Uri;", "toUri", "Ljava/io/File;", "toFile", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        k21.i(uri, "$this$toFile");
        if (k21.d(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        k21.i(str, "$this$toUri");
        Uri parse = Uri.parse(str);
        k21.h(parse, "Uri.parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        k21.i(file, "$this$toUri");
        Uri fromFile = Uri.fromFile(file);
        k21.h(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
