package kotlin.time;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@ExperimentalTime
/* compiled from: Taobao */
public interface TimeMark {
    /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
    long m923elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    TimeMark m924minusLRDsOJo(long j);

    @NotNull
    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    TimeMark m925plusLRDsOJo(long j);
}
