package androidx.core.util;

import android.util.AtomicFile;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b11;
import tb.k21;
import tb.lf1;
import tb.ph;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\bø\u0001\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\r\u0010\u0011\u001a\u00020\t*\u00020\u0000H\b\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "Ltb/ur2;", "block", "tryWrite", "", "array", "writeBytes", "", "text", "Ljava/nio/charset/Charset;", "charset", "writeText", "readBytes", "readText", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull AtomicFile atomicFile) {
        k21.i(atomicFile, "$this$readBytes");
        byte[] readFully = atomicFile.readFully();
        k21.h(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull AtomicFile atomicFile, @NotNull Charset charset) {
        k21.i(atomicFile, "$this$readText");
        k21.i(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        k21.h(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = ph.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull AtomicFile atomicFile, @NotNull Function1<? super FileOutputStream, ur2> function1) {
        k21.i(atomicFile, "$this$tryWrite");
        k21.i(function1, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            k21.h(startWrite, lf1.RESOURCE_STREAM);
            function1.invoke(startWrite);
            b11.b(1);
            atomicFile.finishWrite(startWrite);
            b11.a(1);
        } catch (Throwable th) {
            b11.b(1);
            atomicFile.failWrite(startWrite);
            b11.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull AtomicFile atomicFile, @NotNull byte[] bArr) {
        k21.i(atomicFile, "$this$writeBytes");
        k21.i(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            k21.h(startWrite, lf1.RESOURCE_STREAM);
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull AtomicFile atomicFile, @NotNull String str, @NotNull Charset charset) {
        k21.i(atomicFile, "$this$writeText");
        k21.i(str, "text");
        k21.i(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        k21.h(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = ph.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}
