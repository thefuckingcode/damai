package tb;

import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ah2 extends i41 {
    public ah2(@Nullable Job job) {
        super(job);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean childCancelled(@NotNull Throwable th) {
        return false;
    }
}
