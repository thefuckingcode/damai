package tb;

import android.view.View;
import com.taobao.android.dinamic.expressionv2.g;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
public class t70 implements View.OnClickListener, View.OnLongClickListener {
    private x70 a;
    private String b;
    private z70 c;

    public t70(x70 x70, String str, z70 z70) {
        this.a = x70;
        this.b = str;
        this.c = z70;
    }

    public void onClick(View view) {
        long nanoTime = System.nanoTime();
        try {
            this.a.f(view.getTag(c80.SUBDATA));
            g.d(view, this.b, this.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
        } catch (Throwable unused) {
            this.a.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.c.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
        }
    }

    public boolean onLongClick(View view) {
        long nanoTime = System.nanoTime();
        try {
            this.a.f(view.getTag(c80.SUBDATA));
            g.d(view, this.b, this.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
            return true;
        } catch (Throwable unused) {
            this.a.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.c.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
            return true;
        }
    }
}
