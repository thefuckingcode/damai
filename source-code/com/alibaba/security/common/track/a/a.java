package com.alibaba.security.common.track.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final String f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final boolean k;
    public LastExitTrackMsg a;
    RPTrack.TrackStrategy b;
    final List<TrackLog> c;
    public com.alibaba.security.common.track.b.a d;
    public final b e;
    private Context l;
    private final ThreadPoolExecutor m;

    /* renamed from: com.alibaba.security.common.track.a.a$a */
    public static final class C0102a {
        private static final a a = new a((byte) 0);

        private C0102a() {
        }
    }

    public static class b extends Handler {
        private final a a;

        public b(a aVar) {
            super(Looper.getMainLooper());
            this.a = aVar;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                this.a.a(false);
            } else if (i == 2) {
                this.a.e.removeCallbacksAndMessages(null);
            }
        }
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    private static RPTrack.TrackStrategy e() {
        return new RPTrack.TrackStrategy.Builder().setTrackCacheSize(10).build();
    }

    private LastExitTrackMsg f() {
        return this.a;
    }

    private void g() {
        this.e.removeCallbacksAndMessages(null);
    }

    private a() {
        this.e = new b(this);
        this.c = new ArrayList();
        this.b = e();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.alibaba.security.common.track.a.a.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-rpTrackManager");
            }
        });
        this.m = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private static a a() {
        return C0102a.a;
    }

    private void b() {
        a(false);
    }

    private void c() {
        if (!this.c.isEmpty()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[this.c.size()]));
            Collections.copy(arrayList, this.c);
            com.alibaba.security.common.track.b.a aVar = this.d;
            if (aVar != null) {
                aVar.a(arrayList);
                this.c.clear();
            }
        }
    }

    private void d() {
        a(true);
        this.e.sendEmptyMessageDelayed(2, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    public final void a(Context context, RPTrack.TrackStrategy trackStrategy) {
        this.l = context;
        if (trackStrategy == null) {
            trackStrategy = e();
        }
        this.b = trackStrategy;
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    public final void b(boolean z) {
        this.e.removeMessages(1);
        if (!z) {
            this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    private void a(com.alibaba.security.common.track.b.a aVar) {
        this.d = aVar;
    }

    public final void a(final TrackLog trackLog) {
        this.m.execute(new Runnable() {
            /* class com.alibaba.security.common.track.a.a.AnonymousClass2 */

            public final void run() {
                a.this.c.add(trackLog);
                if (!a.this.e.hasMessages(1)) {
                    a.this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                }
                if (a.this.c.size() >= a.this.b.getTrackCacheSize()) {
                    a.a(a.this);
                }
            }
        });
    }

    public final void a(final boolean z) {
        if (this.c.isEmpty()) {
            b(z);
        } else {
            this.m.execute(new Runnable() {
                /* class com.alibaba.security.common.track.a.a.AnonymousClass3 */

                public final void run() {
                    a.a(a.this);
                    a.this.b(z);
                }
            });
        }
    }

    private void a(LastExitTrackMsg lastExitTrackMsg) {
        this.a = lastExitTrackMsg;
    }

    static /* synthetic */ void a(a aVar) {
        if (!aVar.c.isEmpty()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[aVar.c.size()]));
            Collections.copy(arrayList, aVar.c);
            com.alibaba.security.common.track.b.a aVar2 = aVar.d;
            if (aVar2 != null) {
                aVar2.a(arrayList);
                aVar.c.clear();
            }
        }
    }
}
