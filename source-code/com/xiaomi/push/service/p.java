package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
public class p {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f983a;

    /* renamed from: a  reason: collision with other field name */
    private final c f984a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* compiled from: Taobao */
    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c extends Thread {
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private a f985a = new a();

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f986a = false;
        private long b = 50;

        /* renamed from: b  reason: collision with other field name */
        private boolean f987b;
        private boolean c;

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static final class a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f988a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f988a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f988a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void b(d dVar) {
                Intent a2;
                b bVar = dVar.f990a;
                int i = bVar.a;
                if (i == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) bVar;
                    if (dVar2.a().f364a != null) {
                        dVar2.a().f364a.f894b = System.currentTimeMillis();
                        dVar2.a().f364a.b = a(dVar);
                    }
                } else if (i == 15 && (a2 = ((XMPushService.i) bVar).a()) != null && "10".equals(a2.getStringExtra("ext_chid"))) {
                    a2.putExtra("enqueue", System.currentTimeMillis());
                    a2.putExtra(GiftNumBean.KEY_NUM, a(dVar));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i].f989a < dVarArr[i2].f989a) {
                        d dVar = dVarArr[i];
                        dVarArr[i] = dVarArr[i2];
                        dVarArr[i2] = dVar;
                        i2 = (i2 - 1) / 2;
                        i = i2;
                    } else {
                        return;
                    }
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3) {
                            d[] dVarArr = this.f988a;
                            if (dVarArr[i4].f989a < dVarArr[i2].f989a) {
                                i2 = i4;
                            }
                        }
                        d[] dVarArr2 = this.f988a;
                        if (dVarArr2[i].f989a >= dVarArr2[i2].f989a) {
                            d dVar = dVarArr2[i];
                            dVarArr2[i] = dVarArr2[i2];
                            dVarArr2[i2] = dVar;
                            i2 = (i2 * 2) + 1;
                            i = i2;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public d a() {
                return this.f988a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m864a() {
                this.f988a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i2].a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i2].f990a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m865a(d dVar) {
                d[] dVarArr = this.f988a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f988a = dVarArr2;
                }
                d[] dVarArr3 = this.f988a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m866a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m867a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f988a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f988a[i].f992a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.b)) {
                    d[] dVarArr = this.f988a;
                    int i3 = i2 - 1;
                    this.b = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[i3] = null;
                    c(i);
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(d dVar) {
            this.f985a.m865a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f987b = true;
            this.f985a.m864a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m863a() {
            return this.f986a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f986a = true;
            r2.f990a.run();
            r10.f986a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a0, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r10.f987b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a4, code lost:
            throw r1;
         */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (!this.f987b) {
                        if (!this.f985a.m866a()) {
                            long a2 = p.a();
                            d a3 = this.f985a.a();
                            synchronized (a3.f991a) {
                                if (a3.f992a) {
                                    this.f985a.b(0);
                                } else {
                                    long j = a3.f989a - a2;
                                    if (j > 0) {
                                        long j2 = this.b;
                                        if (j > j2) {
                                            j = j2;
                                        }
                                        long j3 = j2 + 50;
                                        this.b = j3;
                                        if (j3 > 500) {
                                            this.b = 500;
                                        }
                                        wait(j);
                                    } else {
                                        this.b = 50;
                                        synchronized (a3.f991a) {
                                            int a4 = this.f985a.a().f989a != a3.f989a ? this.f985a.a((a) a3) : 0;
                                            if (a3.f992a) {
                                                a aVar = this.f985a;
                                                aVar.b(aVar.a((a) a3));
                                            } else {
                                                a3.a(a3.f989a);
                                                this.f985a.b(a4);
                                                a3.f989a = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (!this.c) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f989a;

        /* renamed from: a  reason: collision with other field name */
        b f990a;

        /* renamed from: a  reason: collision with other field name */
        final Object f991a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f992a;
        private long b;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            synchronized (this.f991a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f991a) {
                z = !this.f992a && this.f989a > 0;
                this.f992a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        a = j;
        b = j;
    }

    public p() {
        this(false);
    }

    public p(String str) {
        this(str, false);
    }

    public p(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z);
        this.f984a = cVar;
        this.f983a = new a(cVar);
    }

    public p(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (p.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = b;
            if (elapsedRealtime > j2) {
                a += elapsedRealtime - j2;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    private static synchronized long b() {
        long j;
        synchronized (p.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f984a) {
            if (!this.f984a.f987b) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.a = bVar.a;
                    dVar.f990a = bVar;
                    dVar.f989a = a2;
                    this.f984a.a((c) dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m859a() {
        com.xiaomi.channel.commonutils.logger.b.m182a("quit. finalizer:" + this.f983a);
        this.f984a.a();
    }

    public void a(int i) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f984a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m860a() {
        return this.f984a.m863a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m861a(int i) {
        boolean a2;
        synchronized (this.f984a) {
            a2 = this.f984a.f985a.m867a(i);
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m862b() {
        synchronized (this.f984a) {
            this.f984a.f985a.m864a();
        }
    }
}
