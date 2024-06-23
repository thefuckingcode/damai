package tb;

/* compiled from: Taobao */
public class y03 {
    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        return "file".equals(a("ro.crypto.type"));
    }
}
