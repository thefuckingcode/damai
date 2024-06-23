package tb;

import android.text.TextUtils;
import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.phenix.request.a;
import com.taobao.rxm.consume.Consumer;
import java.util.Map;

/* compiled from: Taobao */
public class z80 extends z9<b40, b40> {
    private DiskCacheKeyValueStore k;

    public z80(DiskCacheSupplier diskCacheSupplier, DiskCacheKeyValueStore diskCacheKeyValueStore) {
        super(0, 2, diskCacheSupplier);
        this.k = diskCacheKeyValueStore;
    }

    private boolean N(a aVar) {
        Map<String, String> H = aVar.H();
        return this.k != null && H != null && !TextUtils.isEmpty(H.get("max-age")) && this.k.isTTLDomain(aVar.N());
    }

    /* renamed from: M */
    public void consumeNewResult(Consumer<b40, a> consumer, boolean z, b40 b40) {
        vr2.n("Phenix", "DiskCache Writer Started.", consumer.getContext());
        consumer.onNewResult(b40, z);
        L(consumer.getContext(), b40.d(), true);
        if (N(consumer.getContext())) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str = consumer.getContext().H().get("max-age");
                if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                    String str2 = consumer.getContext().D() + consumer.getContext().C();
                    long longValue = Long.valueOf(str).longValue();
                    consumer.getContext().U().B = !(this.k.isExpectedTime(longValue) ? this.k.put(str2, longValue) : false);
                    consumer.getContext().U().A = System.currentTimeMillis() - currentTimeMillis;
                }
                vr2.n("Phenix", "DiskCache Writer Put TTL Time", consumer.getContext());
            } catch (Exception e) {
                kg0.c("TTL", "ttl put error=%s", e);
            }
        }
        vr2.n("Phenix", "DiskCache Writer Ended.", consumer.getContext());
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<b40, a> consumer) {
        return false;
    }
}
