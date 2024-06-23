package tb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.taobao.android.dinamicx.timer.DXTimerListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class a10 {
    private boolean a = true;
    private a b;
    private List<z00> c;
    private long d;

    /* compiled from: Taobao */
    public static class a extends Handler {
        private WeakReference<a10> a;
        private long b;

        a(a10 a10) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(a10);
        }

        public void a(long j) {
            this.b = j;
        }

        public void handleMessage(Message message) {
            a10 a10 = this.a.get();
            if (a10 != null && !a10.a) {
                a10.e();
                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.b) % a10.d;
                sendMessageDelayed(obtainMessage(1), a10.d - elapsedRealtime);
            }
        }
    }

    public a10(long j) {
        this.d = j;
        this.b = new a(this);
    }

    public final void c() {
        this.a = true;
        this.b.removeMessages(1);
    }

    public final void d() {
        List<z00> list = this.c;
        if (list != null) {
            list.clear();
        }
        c();
    }

    public final void e() {
        List<z00> list = this.c;
        if (list == null || list.size() == 0) {
            c();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (z00 z00 : this.c) {
            int i = (int) ((elapsedRealtime - z00.c) / z00.b);
            if (i >= z00.d + 1) {
                z00.a.onTimerCallback();
                z00.d = i;
            }
        }
    }

    public void f(DXTimerListener dXTimerListener, long j) {
        if (dXTimerListener != null && j > 0) {
            if (this.c == null) {
                this.c = new CopyOnWriteArrayList();
            }
            for (z00 z00 : this.c) {
                if (z00.a == dXTimerListener) {
                    return;
                }
            }
            z00 z002 = new z00();
            z002.a = dXTimerListener;
            long j2 = this.d;
            if (j <= j2) {
                j = j2;
            }
            z002.b = j;
            z002.c = SystemClock.elapsedRealtime();
            this.c.add(z002);
            g();
        }
    }

    public final void g() {
        if (this.a) {
            this.a = false;
            this.b.a(SystemClock.elapsedRealtime());
            a aVar = this.b;
            aVar.sendMessage(aVar.obtainMessage(1));
        }
    }

    public void h(DXTimerListener dXTimerListener) {
        if (dXTimerListener != null) {
            List<z00> list = this.c;
            if (list == null) {
                c();
                return;
            }
            Iterator<z00> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                z00 next = it.next();
                if (next.a == dXTimerListener) {
                    this.c.remove(next);
                    break;
                }
            }
            if (this.c.size() == 0) {
                c();
            }
        }
    }
}
