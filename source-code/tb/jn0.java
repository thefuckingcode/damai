package tb;

import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
public class jn0 {
    public static String a(Fragment fragment) {
        return fragment == null ? "" : fragment.getClass().getName();
    }

    public static String b(Fragment fragment) {
        return fragment == null ? "" : fragment.getClass().getSimpleName();
    }
}
