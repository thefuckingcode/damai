package tb;

import kotlin.SinceKotlin;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class kc0 {
    @SinceKotlin(version = "1.5")
    public static final long a(long j, @NotNull DurationUnit durationUnit, @NotNull DurationUnit durationUnit2) {
        k21.i(durationUnit, "sourceUnit");
        k21.i(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j, durationUnit.getTimeUnit$kotlin_stdlib());
    }
}
