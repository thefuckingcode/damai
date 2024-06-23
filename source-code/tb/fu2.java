package tb;

import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class fu2 {
    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
