package tb;

import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.cache.common.CacheEvent;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import java.io.IOException;

/* compiled from: Taobao */
public class g92 implements CacheEvent {
    private CacheKey a;
    private String b;
    private long c;
    private long d;
    private long e;
    private long f;
    private IOException g;
    private CacheEventListener.EvictionReason h;

    public g92 a(CacheKey cacheKey) {
        this.a = cacheKey;
        return this;
    }

    public g92 b(long j) {
        this.d = j;
        return this;
    }

    public g92 c(long j) {
        this.e = j;
        return this;
    }

    public void d(long j) {
        this.f = j;
    }

    public g92 e(CacheEventListener.EvictionReason evictionReason) {
        this.h = evictionReason;
        return this;
    }

    public g92 f(IOException iOException) {
        this.g = iOException;
        return this;
    }

    public g92 g(long j) {
        this.c = j;
        return this;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    @Nullable
    public CacheKey getCacheKey() {
        return this.a;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    public long getCacheLimit() {
        return this.d;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    public long getCacheSize() {
        return this.e;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    public long getElapsed() {
        return this.f;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    @Nullable
    public CacheEventListener.EvictionReason getEvictionReason() {
        return this.h;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    @Nullable
    public IOException getException() {
        return this.g;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    public long getItemSize() {
        return this.c;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheEvent
    @Nullable
    public String getResourceId() {
        return this.b;
    }

    public g92 h(String str) {
        this.b = str;
        return this;
    }
}
