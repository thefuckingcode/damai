package com.taobao.phenix.chain;

import com.taobao.phenix.cache.memory.MemoryCacheProducer;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.loader.file.b;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.d42;
import tb.fc1;
import tb.j22;
import tb.y80;

/* compiled from: Taobao */
public class PhenixProduceListener implements ProducerListener<com.taobao.phenix.request.a> {
    private final IPhenixListener<fc1> a;
    private final ImageDecodingListener b;
    private final com.taobao.phenix.request.a c;
    private ScheduledAction d;
    private Scheduler e;
    private Map<String, Long> f = new ConcurrentHashMap();

    /* compiled from: Taobao */
    public static class a {
        public String a;
        public ImageStatistics.FromType b;

        public a(String str, ImageStatistics.FromType fromType) {
            this.a = str;
            this.b = fromType;
        }
    }

    public PhenixProduceListener(com.taobao.phenix.request.a aVar, IPhenixListener<fc1> iPhenixListener, ImageDecodingListener imageDecodingListener) {
        this.a = iPhenixListener;
        this.c = aVar;
        this.b = imageDecodingListener;
    }

    private void c(Class cls, boolean z, boolean z2) {
        if (this.a != null && !z && !z2 && cls == MemoryCacheProducer.class) {
            Scheduler scheduler = this.e;
            if (scheduler == null || (scheduler.isScheduleMainThread() && j22.b())) {
                this.a.onHappen(new fc1(this.c.P()));
                return;
            }
            if (this.d == null) {
                this.d = new ScheduledAction(3, null, null) {
                    /* class com.taobao.phenix.chain.PhenixProduceListener.AnonymousClass1 */

                    @Override // com.taobao.rxm.schedule.ScheduledAction
                    public void run(Consumer consumer, d42 d42) {
                        fc1 fc1 = new fc1(PhenixProduceListener.this.c.P());
                        fc1.c(PhenixProduceListener.this.c.N());
                        PhenixProduceListener.this.a.onHappen(fc1);
                    }
                };
            }
            this.e.schedule(this.d);
        }
    }

    private a d(Class cls, boolean z) {
        if (cls == MemoryCacheProducer.class) {
            return new a(ImageStatistics.KEY_READ_MEMORY_CACHE, ImageStatistics.FromType.FROM_MEMORY_CACHE);
        }
        if (cls == b.class) {
            return new a(ImageStatistics.KEY_READ_LOCAL_FILE, ImageStatistics.FromType.FROM_LOCAL_FILE);
        }
        if (cls == y80.class) {
            return new a(ImageStatistics.KEY_READ_DISK_CACHE, ImageStatistics.FromType.FROM_DISK_CACHE);
        }
        if (cls == com.taobao.phenix.loader.network.b.class) {
            return new a(z ? "download" : "connect", ImageStatistics.FromType.FROM_NETWORK);
        } else if (cls == com.taobao.phenix.bitmap.a.class) {
            return new a(z ? ImageStatistics.KEY_BITMAP_PROCESS : ImageStatistics.KEY_BITMAP_SCALE, z ? ImageStatistics.FromType.FROM_UNKNOWN : ImageStatistics.FromType.FROM_LARGE_SCALE);
        } else if (cls == com.taobao.phenix.decode.a.class) {
            return new a(ImageStatistics.KEY_BITMAP_DECODE, ImageStatistics.FromType.FROM_UNKNOWN);
        } else {
            return null;
        }
    }

    public Map<String, Long> e() {
        return this.f;
    }

    /* renamed from: f */
    public void onEnterIn(com.taobao.phenix.request.a aVar, Class cls, boolean z, boolean z2) {
        a d2;
        String str;
        if ((!z || z2) && (d2 = d(cls, z)) != null && (str = d2.a) != null) {
            this.f.put(str, Long.valueOf(0 - System.currentTimeMillis()));
            ImageDecodingListener imageDecodingListener = this.b;
            if (imageDecodingListener != null && cls == com.taobao.phenix.decode.a.class) {
                imageDecodingListener.onDecodeStart((long) aVar.d(), aVar.N());
            }
        }
    }

    /* renamed from: g */
    public void onExitOut(com.taobao.phenix.request.a aVar, Class cls, boolean z, boolean z2, boolean z3) {
        a d2;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        c(cls, z, z2);
        if ((!z || z3) && (d2 = d(cls, z)) != null && (str = d2.a) != null) {
            Long l = this.f.get(str);
            if (l != null && l.longValue() < 0) {
                this.f.put(d2.a, Long.valueOf(currentTimeMillis + l.longValue()));
            }
            if (z2 && d2.b != ImageStatistics.FromType.FROM_UNKNOWN) {
                this.c.U().b(d2.b);
            }
            ImageDecodingListener imageDecodingListener = this.b;
            if (imageDecodingListener != null && cls == com.taobao.phenix.decode.a.class) {
                imageDecodingListener.onDecodeFinish((long) aVar.d(), aVar.N());
            }
        }
    }

    public void h(Scheduler scheduler) {
        this.e = scheduler;
    }
}
