package tb;

import java.io.Closeable;

/* compiled from: Taobao */
public class ej {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
