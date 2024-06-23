package tb;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "ByteStreamsKt")
/* compiled from: Taobao */
public final class wd {
    public static final long a(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, int i) {
        k21.i(inputStream, "<this>");
        k21.i(outputStream, "out");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += (long) read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(inputStream, outputStream, i);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] c(@NotNull InputStream inputStream) {
        k21.i(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k21.h(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
