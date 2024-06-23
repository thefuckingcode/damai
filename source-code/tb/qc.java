package tb;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "Boxing")
/* compiled from: Taobao */
public final class qc {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Boolean a(boolean z) {
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Integer b(int i) {
        return new Integer(i);
    }
}
