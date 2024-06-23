package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(D)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)D", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 1, 16}, pn = "kotlin.time")
/* compiled from: DurationConversions.kt */
public final class DurationConversionsJDK8Kt {
    private static final double toKotlinDuration(Duration duration) {
        return kotlin.time.Duration.m983plusLRDsOJo(DurationKt.getSeconds(duration.getSeconds()), DurationKt.getNanoseconds(duration.getNano()));
    }

    /* renamed from: toJavaDuration-LRDsOJo  reason: not valid java name */
    private static final Duration m1011toJavaDurationLRDsOJo(double d) {
        Duration ofSeconds = Duration.ofSeconds((long) kotlin.time.Duration.m973getInSecondsimpl(d), (long) kotlin.time.Duration.m975getNanosecondsComponentimpl(d));
        Intrinsics.checkExpressionValueIsNotNull(ofSeconds, "java.time.Duration.ofSec…ds, nanoseconds.toLong())");
        Intrinsics.checkExpressionValueIsNotNull(ofSeconds, "toComponents { seconds, …, nanoseconds.toLong()) }");
        return ofSeconds;
    }
}
