package kotlin.text;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pb1;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public interface MatchNamedGroupCollection extends MatchGroupCollection {
    @Nullable
    pb1 get(@NotNull String str);
}
