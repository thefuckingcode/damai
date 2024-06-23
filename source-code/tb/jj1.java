package tb;

import com.taobao.phenix.builder.ChainBuilders;
import com.taobao.phenix.cache.memory.MemoryCacheProducer;
import com.taobao.phenix.loader.file.b;
import com.taobao.phenix.request.a;
import com.taobao.rxm.produce.Producer;
import com.taobao.rxm.schedule.SchedulerSupplier;
import com.taobao.tcommon.core.Supplier;

/* compiled from: Taobao */
public class jj1 implements Supplier<Producer<so1, a>> {
    private Producer<so1, a> a;
    private Producer<so1, a> b;
    private SchedulerSupplier c;
    private final ChainBuilders d;
    private boolean e = true;

    public jj1(ChainBuilders chainBuilders) {
        cs1.d(chainBuilders, "ChainBuilders cannot be NULL when DrawableChainProducerSupplier constructed");
        this.d = chainBuilders;
    }

    public synchronized void a() {
        if (this.b == null) {
            this.c = this.d.schedulerBuilder().i(this.e).build();
            boolean isGenericTypeCheckEnabled = this.d.isGenericTypeCheckEnabled();
            if (this.e) {
                this.b = rg.b(new MemoryCacheProducer(this.d.memCacheBuilder().build()), isGenericTypeCheckEnabled).c(new h02(b40.class)).c(new z80(this.d.diskCacheBuilder().build(), this.d.diskCacheKVBuilder().build())).c(new com.taobao.phenix.bitmap.a()).c(new com.taobao.phenix.decode.a().consumeOn(this.c.forDecode())).c(new b(this.d.fileLoaderBuilder().build()).produceOn(this.c.forCpuBound())).c(new y80(this.d.diskCacheBuilder().build(), this.d.diskCacheKVBuilder().build())).c(new com.taobao.phenix.loader.network.b(this.d.httpLoaderBuilder().build()).consumeOn(this.c.forNetwork())).a();
            } else {
                this.b = rg.b(new MemoryCacheProducer(this.d.memCacheBuilder().build()), isGenericTypeCheckEnabled).c(new h02(b40.class)).c(new z80(this.d.diskCacheBuilder().build(), this.d.diskCacheKVBuilder().build()).consumeOn(this.c.forIoBound())).c(new com.taobao.phenix.bitmap.a().consumeOn(this.c.forCpuBound())).c(new com.taobao.phenix.decode.a().consumeOn(this.c.forDecode())).c(new b(this.d.fileLoaderBuilder().build()).produceOn(this.c.forIoBound())).c(new y80(this.d.diskCacheBuilder().build(), this.d.diskCacheKVBuilder().build())).c(new com.taobao.phenix.loader.network.b(this.d.httpLoaderBuilder().build()).produceOn(this.c.forNetwork()).consumeOn(this.c.forNetwork())).a();
            }
            this.a = null;
        }
    }

    /* renamed from: b */
    public synchronized Producer<so1, a> get() {
        Producer<so1, a> producer = this.b;
        if (producer != null) {
            return producer;
        }
        if (this.a == null) {
            this.c = new h50(null, 0, 6, 8, 5, 1500, 3, 5, 2, -1, this.e);
            if (this.e) {
                this.a = rg.b(new MemoryCacheProducer(new ej1()), this.d.isGenericTypeCheckEnabled()).c(new h02(b40.class)).c(new com.taobao.phenix.decode.a().consumeOn(this.c.forDecode())).c(new b(new com.taobao.phenix.loader.file.a()).produceOn(this.c.forCpuBound())).c(new com.taobao.phenix.loader.network.b(new com.taobao.phenix.loader.network.a()).consumeOn(this.c.forNetwork())).a();
            } else {
                this.a = rg.b(new MemoryCacheProducer(new ej1()), this.d.isGenericTypeCheckEnabled()).c(new h02(b40.class)).c(new com.taobao.phenix.decode.a().consumeOn(this.c.forDecode())).c(new b(new com.taobao.phenix.loader.file.a()).produceOn(this.c.forIoBound())).c(new com.taobao.phenix.loader.network.b(new com.taobao.phenix.loader.network.a()).produceOn(this.c.forNetwork()).consumeOn(this.c.forNetwork())).a();
            }
        }
        vr2.i("NormalChain", "use temporary chain producer before Phenix.instance().build() calling", new Object[0]);
        return this.a;
    }

    public SchedulerSupplier c() {
        return this.c;
    }
}
