package tb;

import android.view.View;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ew2 {
    private View a;
    private DinamicTemplate b;
    private r70 c;
    private String d;
    private ArrayList<View> e;

    public ew2(String str) {
        this.d = str;
    }

    public ArrayList<View> a() {
        return this.e;
    }

    public r70 b() {
        if (this.c == null) {
            this.c = new r70(this.d);
        }
        return this.c;
    }

    public DinamicTemplate c() {
        return this.b;
    }

    public View d() {
        return this.a;
    }

    public boolean e() {
        r70 r70 = this.c;
        return r70 == null || r70.d();
    }

    public boolean f() {
        r70 r70 = this.c;
        return r70 == null || r70.d();
    }

    public void g(ArrayList<View> arrayList) {
        this.e = arrayList;
    }

    public void h(DinamicTemplate dinamicTemplate) {
        this.b = dinamicTemplate;
    }

    public void i(View view) {
        this.a = view;
    }
}
