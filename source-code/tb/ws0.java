package tb;

import java.util.HashMap;

/* compiled from: Taobao */
public class ws0 {
    public static boolean a = false;
    public static boolean b = false;
    public static volatile boolean c = false;
    public static boolean d = false;
    public static String e = "";
    public static int f = 0;
    public static String g = "unknown";
    public static String h = "unknown";
    public static long i = -1;
    public static long j = -1;
    public static long k = -1;
    public static String l = "false";
    public static long m = -1;
    public static long n = -1;
    public static long o = -1;
    public static String p = "background";
    public static a q = new a();
    public static int r = 0;

    /* compiled from: Taobao */
    public static class a {
        HashMap<String, Boolean> a = new HashMap<>();

        public boolean a(String str) {
            Boolean bool = this.a.get(str);
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public void b(String str) {
            if (this.a.get(str) == null) {
                this.a.put(str, Boolean.TRUE);
            } else {
                this.a.put(str, Boolean.FALSE);
            }
        }
    }
}
