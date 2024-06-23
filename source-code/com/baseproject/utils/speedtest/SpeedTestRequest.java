package com.baseproject.utils.speedtest;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baseproject.utils.speedtest.a;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.i63;
import tb.k63;
import tb.w43;
import tb.y33;

/* compiled from: Taobao */
public class SpeedTestRequest {
    private static final String q = "SpeedTestRequest";
    private volatile boolean a;
    private List<y33> b = Collections.synchronizedList(new LinkedList());
    private Worker[] c;
    private c d;
    private Foreman e;
    private ScheduledExecutorService f;
    private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue<>();
    private long h;
    private long[] i;
    private a.C0148a j;
    private a k;
    private a l;
    private int m;
    private int n;
    private Object o = new Object();
    private volatile i63 p;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class Foreman implements Runnable {
        Foreman() {
        }

        public void run() {
            if (!SpeedTestRequest.this.a) {
                SpeedTestRequest.this.a = true;
                i63 i63 = new i63();
                i63.b = SpeedTestRequest.this.k.b;
                int unused = SpeedTestRequest.this.m;
                int unused2 = SpeedTestRequest.this.n;
                i63.c = "" + SpeedTestRequest.this.k.c;
                String str = SpeedTestRequest.this.k.a;
                i63.d = SpeedTestRequest.this.j.f;
                i63.e = SpeedTestRequest.this.j.a;
                i63.f = SpeedTestRequest.this.j.b;
                i63.g = SpeedTestRequest.this.j.d;
                int i = SpeedTestRequest.this.j.e;
                i63.p = SpeedTestRequest.this.j.g;
                i63.i = (y33[]) SpeedTestRequest.this.b.toArray(new y33[SpeedTestRequest.this.b.size()]);
                for (int i2 = 0; i2 < SpeedTestRequest.this.j.e; i2++) {
                    SpeedTestRequest.this.h += SpeedTestRequest.this.i[i2];
                }
                i63.h = ((SpeedTestRequest.this.h / 1000) * 8) / ((long) SpeedTestRequest.this.j.d);
                if (SpeedTestRequest.this.l != null) {
                    SpeedTestRequest.this.l.a(i63);
                }
                SpeedTestRequest.this.j();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class HttpWorker extends Worker {
        public HttpWorker(int i) {
            super(i);
        }

        public void run() {
            int read;
            String str = SpeedTestRequest.q;
            com.youku.b.a.a.a(str, "worker[" + this.index + "] start working for task " + SpeedTestRequest.this.j.f);
            while (!SpeedTestRequest.this.a) {
                HttpURLConnection httpURLConnection = null;
                y33 y33 = new y33();
                try {
                    URL url = new URL(SpeedTestRequest.this.j.a);
                    String host = url.getHost();
                    String a = TextUtils.isEmpty(SpeedTestRequest.this.j.b) ? f.a(host) : SpeedTestRequest.this.j.b;
                    httpURLConnection = (HttpURLConnection) (a.contains(":") ? new URL(SpeedTestRequest.this.j.a).openConnection() : new URL(SpeedTestRequest.this.j.a.replaceFirst(host, a)).openConnection());
                    httpURLConnection.setConnectTimeout(this.mConnectTimeout);
                    httpURLConnection.setReadTimeout(this.mReadTiemout);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    if (url.getProtocol().equals("https")) {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new k63());
                    }
                    httpURLConnection.setRequestProperty(BizTime.HOST, TextUtils.isEmpty(SpeedTestRequest.this.j.c) ? url.getHost() : SpeedTestRequest.this.j.c);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    y33.b = SystemClock.elapsedRealtime() - elapsedRealtime;
                    y33.a = httpURLConnection.getResponseCode();
                    if (!SpeedTestRequest.this.a) {
                        SpeedTestRequest.this.b.add(y33);
                    }
                    String str2 = SpeedTestRequest.q;
                    com.youku.b.a.a.a(str2, "tcp_conn_time:" + y33.b);
                    String str3 = SpeedTestRequest.q;
                    com.youku.b.a.a.a(str3, "status_code:" + y33.a);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    byte[] bArr = new byte[128];
                    while (!SpeedTestRequest.this.a && (read = inputStream.read(bArr)) > 0) {
                        long[] jArr = SpeedTestRequest.this.i;
                        int i = this.index;
                        jArr[i] = jArr[i] + ((long) read);
                    }
                    com.youku.b.a.a.a(SpeedTestRequest.q, "read data complete");
                } catch (IOException e) {
                    y33.a = -99;
                    if (!SpeedTestRequest.this.a && !SpeedTestRequest.this.b.isEmpty()) {
                        SpeedTestRequest.this.b.set(SpeedTestRequest.this.b.size() - 1, y33);
                    }
                    e.printStackTrace();
                    if (0 == 0) {
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
                httpURLConnection.disconnect();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class Worker implements Runnable {
        protected int index;
        protected int mConnectTimeout = 10000;
        protected int mReadTiemout = 10000;

        public Worker() {
        }

        public Worker(int i) {
            this.index = i;
        }
    }

    /* compiled from: Taobao */
    public interface a {
        void a(i63 i63);
    }

    /* compiled from: Taobao */
    class b implements a {
        b() {
        }

        @Override // com.baseproject.utils.speedtest.SpeedTestRequest.a
        public void a(i63 i63) {
            com.youku.b.a.a.a(SpeedTestRequest.q, "sync exec finish normally!");
            SpeedTestRequest.this.p = i63;
            SpeedTestRequest.this.o.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends ThreadPoolExecutor {

        /* compiled from: Taobao */
        class a implements ThreadFactory {
            a(SpeedTestRequest speedTestRequest) {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        }

        public c(SpeedTestRequest speedTestRequest, int i) {
            super(i, i, 0, TimeUnit.SECONDS, speedTestRequest.g, new a(speedTestRequest));
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            com.youku.b.a.a.a(SpeedTestRequest.q, "afterExecute ");
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            String str = SpeedTestRequest.q;
            com.youku.b.a.a.a(str, "beforeExecute " + thread.getName());
        }
    }

    public SpeedTestRequest(Context context, a aVar, a.C0148a aVar2, int i2, int i3) {
        this.k = aVar;
        this.j = aVar2;
        this.b.clear();
        this.f = Executors.newSingleThreadScheduledExecutor();
        this.e = new Foreman();
        this.d = new c(this, aVar2.e);
        int i4 = aVar2.e;
        this.c = new Worker[i4];
        this.i = new long[i4];
        this.m = i2;
        this.n = i3;
    }

    private void o() {
        for (int i2 = 0; i2 < this.c.length; i2++) {
            if (this.j.g == w43.a) {
                AdapterForTLog.loge("SpeedTest", "use quic");
                this.c[i2] = new HttpWorker(i2);
            } else {
                AdapterForTLog.loge("SpeedTest", "use http");
                this.c[i2] = new HttpWorker(i2);
            }
            this.d.execute(this.c[i2]);
        }
    }

    public void d() {
        com.youku.b.a.a.a(q, "exec");
        this.a = false;
        this.h = 0;
        o();
        this.f.schedule(this.e, (long) this.j.d, TimeUnit.SECONDS);
    }

    public void e(a aVar) {
        this.l = aVar;
    }

    public i63 h() {
        this.p = null;
        e(new b());
        d();
        try {
            synchronized (this.o) {
                this.o.wait((long) ((this.j.d * 1000) + 2000));
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.p;
    }

    public void j() {
        this.a = true;
        this.d.shutdown();
        this.f.shutdown();
    }

    public boolean k() {
        return !this.a;
    }
}
