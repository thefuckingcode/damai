package tb;

/* compiled from: Taobao */
public class mj0 {
    public static boolean a(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            if (!Float.isNaN(f) || !Float.isNaN(f2)) {
                return false;
            }
            return true;
        } else if (Math.abs(f2 - f) < 1.0E-5f) {
            return true;
        } else {
            return false;
        }
    }
}
