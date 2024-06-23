package tb;

import android.util.Log;

/* compiled from: Taobao */
public class e10 {
    private int a;

    public int a() {
        return this.a;
    }

    public boolean b(String str, int i, ys ysVar) {
        boolean z;
        if (!ysVar.j(i)) {
            z = false;
            Log.e("UiCodeLoader_TMTEST", "seekBy error:" + i);
        } else {
            z = true;
        }
        this.a = ysVar.c();
        return z;
    }
}
