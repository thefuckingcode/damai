package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hf;
import tb.jl1;
import tb.q30;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class n extends hf {
    @NotNull
    private final Function1<Throwable, ur2> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public n(@NotNull Function1<? super Throwable, ur2> function1) {
        this.a = function1;
    }

    @Override // tb.Cif
    public void a(@Nullable Throwable th) {
        this.a.invoke(th);
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
        return "InvokeOnCancel[" + q30.a(this.a) + '@' + q30.b(this) + jl1.ARRAY_END;
    }
}
