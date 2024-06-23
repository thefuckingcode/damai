package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b extends Handler {
    private final d a = new d();
    private final int b;
    private final EventBus c;
    private boolean d;

    b(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.b = i;
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, Object obj) {
        c a2 = c.a(gVar, obj);
        synchronized (this) {
            this.a.a(a2);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        boolean z = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                c b2 = this.a.b();
                if (b2 == null) {
                    synchronized (this) {
                        b2 = this.a.b();
                        if (b2 == null) {
                            this.d = z;
                            this.d = z;
                            return;
                        }
                    }
                }
                this.c.e(b2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.b));
            if (sendMessage(obtainMessage())) {
                z = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.d = z;
        }
    }
}
