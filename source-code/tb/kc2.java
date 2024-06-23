package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
public class kc2 {
    @Nullable
    public static hc2 a(pc2 pc2) {
        File b = rh0.b(pc2);
        if (b == null) {
            return null;
        }
        return new hc2(pc2.b(), b.getAbsolutePath(), pc2.a(), pc2.c());
    }

    @NonNull
    public static lc2 b(sc2 sc2, String str) {
        List<pc2> b = sc2.b();
        lc2 lc2 = new lc2(sc2.d(), str);
        if (b != null) {
            for (pc2 pc2 : b) {
                lc2.a(a(pc2));
            }
        }
        return lc2;
    }

    @NonNull
    public static pc2 c(String str, String str2, long j, int i) {
        return new pc2(str, i, str2, j);
    }
}
