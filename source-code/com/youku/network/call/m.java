package com.youku.network.call;

import android.text.TextUtils;
import com.youku.android.antiflow.AntiFlowManagerImpl;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.b;
import com.youku.network.c;
import com.youku.network.d;
import com.youku.network.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.o;
import okhttp3.q;

/* compiled from: Taobao */
public class m extends a {
    private static OkHttpClient e = new OkHttpClient();
    private OkHttpClient f;
    private Call g;
    private o h;
    private a i;
    private d j;
    private IAntiFlowManager k;
    private volatile boolean l = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class a implements Interceptor {
        private int b;
        private int c;

        public a(int i) {
            this.b = i;
        }

        private q a(Interceptor.Chain chain) {
            try {
                return chain.proceed(chain.request());
            } catch (Throwable th) {
                int i = this.c;
                if (i < this.b) {
                    this.c = i + 1;
                    return a(chain);
                } else if (th instanceof IOException) {
                    throw th;
                } else {
                    throw new IOException("error:" + th.getMessage());
                }
            }
        }

        public int a() {
            return this.c;
        }

        @Override // okhttp3.Interceptor
        public q intercept(Interceptor.Chain chain) {
            return a(chain);
        }
    }

    /* access modifiers changed from: private */
    public void a(n nVar) {
        int g2;
        if (com.youku.network.e.a.a() && (g2 = this.c.g() * (this.c.j() + 1)) > 0) {
            e.c().schedule(new OkHttpCall$5(this, nVar), (long) g2, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        Dns r1;
        if (!this.l) {
            try {
                this.k = new AntiFlowManagerImpl(b.a, this.c.e(), this.c.M(), this.c.N());
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                OkHttpClient.b l2 = e.newBuilder().d((long) this.c.f(), timeUnit).k((long) this.c.g(), timeUnit).h(this.c.i()).l(false);
                if (this.c.j() > 0) {
                    a aVar = new a(this.c.j());
                    this.i = aVar;
                    l2.a(aVar);
                }
                if (TextUtils.isEmpty(this.c.c()) || TextUtils.isEmpty(this.c.d())) {
                    com.youku.httpcommunication.a.b("yknetwork_ok", "no config dns");
                    r1 = new Dns() {
                        /* class com.youku.network.call.m.AnonymousClass2 */

                        @Override // okhttp3.Dns
                        public List<InetAddress> lookup(String str) {
                            if (str != null) {
                                try {
                                    return Arrays.asList(InetAddress.getAllByName(str));
                                } catch (Throwable unused) {
                                    throw new UnknownHostException("InetException");
                                }
                            } else {
                                throw new UnknownHostException("hostname == null");
                            }
                        }
                    };
                } else {
                    c cVar = this.c;
                    cVar.d(com.youku.network.f.b.a(cVar.e(), this.c.d()));
                    com.youku.httpcommunication.a.b("yknetwork_ok", "dns config:ip:" + this.c.c() + " host:" + this.c.d());
                    r1 = new Dns() {
                        /* class com.youku.network.call.m.AnonymousClass1 */

                        @Override // okhttp3.Dns
                        public List<InetAddress> lookup(String str) {
                            return Arrays.asList(InetAddress.getAllByName(m.this.c.c()));
                        }
                    };
                }
                l2.f(r1);
                this.f = l2.b();
                com.youku.network.a.e eVar = new com.youku.network.a.e(this.k);
                this.d = eVar;
                this.h = eVar.a(this.c);
                this.j = null;
            } catch (Exception e2) {
                e2.printStackTrace();
                d a2 = d.a();
                this.j = a2;
                a2.a(e2);
                this.j.a(-3006);
            }
            this.l = true;
        }
    }

    @Override // com.youku.network.call.a
    public d a() {
        e();
        d dVar = this.j;
        if (dVar != null) {
            return dVar;
        }
        if (this.k.beforeCall()) {
            d a2 = d.a();
            a2.b(420);
            return a2;
        }
        try {
            Call newCall = this.f.newCall(this.h);
            this.g = newCall;
            return this.d.a(newCall.execute());
        } catch (IOException e2) {
            e2.printStackTrace();
            d a3 = d.a();
            a3.a(e2);
            return com.youku.network.config.b.a(a3, e2, -3005);
        }
    }

    @Override // com.youku.network.call.a
    public void a(com.youku.network.a aVar) {
        e.b().execute(new OkHttpCall$3(this, aVar));
    }

    @Override // com.youku.network.call.a
    public void a(c cVar) {
        this.c = cVar;
    }

    @Override // com.youku.network.call.a
    public void b() {
        Call call = this.g;
        if (call != null) {
            try {
                call.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.youku.network.call.a
    public void b(com.youku.network.a aVar) {
        e.b().execute(new OkHttpCall$4(this, aVar));
    }

    public int d() {
        a aVar = this.i;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }
}
