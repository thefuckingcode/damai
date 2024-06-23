package tb;

import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bh2 {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return new ah2(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
