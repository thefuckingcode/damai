package tb;

@Deprecated
/* compiled from: Taobao */
public class no1 {
    public static int a(String str) {
        if (!zf2.g(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
