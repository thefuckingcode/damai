package tb;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "TextStreamsKt")
/* compiled from: Taobao */
public final class ek2 {
    public static final long a(@NotNull Reader reader, @NotNull Writer writer, int i) {
        k21.i(reader, "<this>");
        k21.i(writer, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(reader, writer, i);
    }

    @NotNull
    public static final String c(@NotNull Reader reader) {
        k21.i(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        k21.h(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
