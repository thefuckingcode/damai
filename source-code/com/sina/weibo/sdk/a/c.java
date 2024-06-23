package com.sina.weibo.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
public abstract class c<Params, Progress, Result> {
    volatile int L = b.U;
    final d<Params, Result> M;
    final FutureTask<Result> N;
    int O = 5;
    Params[] P;
    Handler x = new Handler(Looper.getMainLooper()) {
        /* class com.sina.weibo.sdk.a.c.AnonymousClass1 */

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what == 1) {
                c.a(aVar.S, aVar.T[0]);
                message.obj = null;
            }
        }
    };

    /* renamed from: com.sina.weibo.sdk.a.c$4  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] R;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            int[] iArr = new int[b.m().length];
            R = iArr;
            iArr[b.V - 1] = 1;
            try {
                R[b.W - 1] = 2;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    static class a<Data> {
        final c S;
        final Data[] T;

        a(c cVar, Data... dataArr) {
            this.S = cVar;
            this.T = dataArr;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Taobao */
    public static final class b extends Enum<b> {
        public static final int U = 1;
        public static final int V = 2;
        public static final int W = 3;
        private static final /* synthetic */ int[] X = {1, 2, 3};

        public static int[] m() {
            return (int[]) X.clone();
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.c$c  reason: collision with other inner class name */
    /* compiled from: Taobao */
    abstract class AbstractC0194c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC0194c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    public c() {
        AnonymousClass2 r0 = new d<Params, Result>() {
            /* class com.sina.weibo.sdk.a.c.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public final Result call() {
                Process.setThreadPriority(c.this.O);
                return (Result) c.this.l();
            }
        };
        this.M = r0;
        this.N = new c<Params, Progress, Result>.AbstractC0194c(r0) {
            /* class com.sina.weibo.sdk.a.c.AnonymousClass3 */

            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return 0;
            }

            /* access modifiers changed from: protected */
            public final void done() {
                try {
                    Object obj = get();
                    c cVar = c.this;
                    cVar.x.obtainMessage(1, new a(cVar, obj)).sendToTarget();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (ExecutionException unused2) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (CancellationException unused3) {
                    c.this.x.obtainMessage(3, new a(c.this, null)).sendToTarget();
                } catch (Throwable unused4) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                }
            }
        };
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.onPostExecute(obj);
        cVar.L = b.W;
    }

    /* access modifiers changed from: protected */
    public abstract Result l();

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* compiled from: Taobao */
    static abstract class d<Params, Result> implements Callable<Result> {
        Params[] Y;
        int priority;

        private d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }
}
