package tb;

/* compiled from: Taobao */
public class jn {
    public static final int FAILED_CLIENT_OBSOLETE = 3;
    public static final int FAILED_NOT_AUTHORIZED = 2;
    public static final int FAILED_UNSUPPORTED = 1;
    public static final int SUCCESS = 0;

    public static final String a(int i) {
        if (i == 0) {
            return "SUCCESS";
        }
        if (i == 1) {
            return "FAILED_UNSUPPORTED";
        }
        if (i == 2) {
            return "FAILED_NOT_AUTHORIZED";
        }
        if (i == 3) {
            return "FAILED_CLIENT_OBSOLETE";
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("[UNKNOWN CONTROLLER INIT RESULT: ");
        sb.append(i);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }
}
