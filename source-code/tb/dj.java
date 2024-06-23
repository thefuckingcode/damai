package tb;

import java.io.Closeable;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "CloseableKt")
/* compiled from: Taobao */
public final class dj {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            if0.a(th, th2);
        }
    }
}
