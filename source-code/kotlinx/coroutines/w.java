package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import tb.sn;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class w extends a<ur2> {
    public w(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public boolean handleJobException(@NotNull Throwable th) {
        sn.a(getContext(), th);
        return true;
    }
}
