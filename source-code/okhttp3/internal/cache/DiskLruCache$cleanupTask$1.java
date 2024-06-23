package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Okio;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$cleanupTask$1(DiskLruCache diskLruCache, String str) {
        super(str, false, 2, null);
        this.this$0 = diskLruCache;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        synchronized (this.this$0) {
            if (!(this.this$0.initialized) || this.this$0.getClosed$okhttp()) {
                return -1;
            }
            try {
                this.this$0.trimToSize();
            } catch (IOException unused) {
                this.this$0.mostRecentTrimFailed = true;
            }
            try {
                if (this.this$0.journalRebuildRequired()) {
                    this.this$0.rebuildJournal$okhttp();
                    this.this$0.redundantOpCount = 0;
                }
            } catch (IOException unused2) {
                this.this$0.mostRecentRebuildFailed = true;
                this.this$0.journalWriter = Okio.buffer(Okio.blackhole());
            }
            return -1;
        }
    }
}
