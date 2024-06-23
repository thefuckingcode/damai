package kotlinx.coroutines.sync;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hf;
import tb.jl1;
import tb.ur2;

/* compiled from: Taobao */
final class a extends hf {
    @NotNull
    private final d a;
    private final int b;

    public a(@NotNull d dVar, int i) {
        this.a = dVar;
        this.b = i;
    }

    @Override // tb.Cif
    public void a(@Nullable Throwable th) {
        this.a.q(this.b);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        a(th);
        return ur2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.a + AVFSCacheConstants.COMMA_SEP + this.b + jl1.ARRAY_END;
    }
}
