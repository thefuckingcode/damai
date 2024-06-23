package kotlin.time;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@ExperimentalTime
/* compiled from: Taobao */
public interface TimeSource {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    @NotNull
    TimeMark markNow();
}
