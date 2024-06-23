package tb;

import android.annotation.TargetApi;
import java.util.List;

@TargetApi(11)
/* compiled from: Taobao */
public class gn0 {
    public static sr1 a(List<sr1> list, int i) {
        sr1 sr1;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        sr1 sr12 = new sr1();
        if (i < 0) {
            sr1 = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            sr1 = list.get(list.size() - 1);
        }
        sr12.a = sr1.a + (sr1.b() * i);
        sr12.b = sr1.b;
        sr12.c = sr1.c + (sr1.b() * i);
        sr12.d = sr1.d;
        sr12.e = sr1.e + (sr1.b() * i);
        sr12.f = sr1.f;
        sr12.g = sr1.g + (i * sr1.b());
        sr12.h = sr1.h;
        return sr12;
    }
}
