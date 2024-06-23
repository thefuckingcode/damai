package tb;

/* compiled from: Taobao */
public class lh2 {
    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, str);
        } catch (Exception unused) {
            return "";
        }
    }
}
