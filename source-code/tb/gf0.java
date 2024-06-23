package tb;

import java.io.File;

public final class gf0 {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }
}
