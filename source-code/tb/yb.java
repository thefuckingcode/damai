package tb;

import android.os.Build;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.bitmap.BitmapPool;
import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.cache.LruCache;

/* compiled from: Taobao */
public class yb implements Builder<BitmapPool> {
    private BitmapPool a;
    private Integer b;
    private boolean c;

    /* renamed from: a */
    public synchronized BitmapPool build() {
        BitmapPool bitmapPool;
        if (Pexode.j()) {
            return null;
        }
        if (this.c && (bitmapPool = this.a) != null) {
            return bitmapPool;
        }
        this.c = true;
        BitmapPool bitmapPool2 = this.a;
        if (bitmapPool2 == null) {
            LruCache<String, me> c2 = tp1.o().memCacheBuilder().c();
            if (Build.VERSION.SDK_INT >= 19 && (c2 instanceof BitmapPool)) {
                BitmapPool bitmapPool3 = (BitmapPool) c2;
                this.a = bitmapPool3;
                Integer num = this.b;
                bitmapPool3.maxPoolSize(num != null ? num.intValue() : c2.maxSize() / 4);
            }
        } else {
            Integer num2 = this.b;
            if (num2 != null) {
                bitmapPool2.maxPoolSize(num2.intValue());
            }
        }
        return this.a;
    }

    /* renamed from: b */
    public yb with(BitmapPool bitmapPool) {
        cs1.e(!this.c, "BitmapPoolBuilder has been built, not allow with() now");
        this.a = bitmapPool;
        return this;
    }
}
