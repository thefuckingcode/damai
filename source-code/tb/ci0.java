package tb;

import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ci0 extends bi0 {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        tb.dj.a(r0, r1);
     */
    public static void a(@NotNull File file, @NotNull byte[] bArr) {
        k21.i(file, "<this>");
        k21.i(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        ur2 ur2 = ur2.INSTANCE;
        dj.a(fileOutputStream, null);
    }
}
