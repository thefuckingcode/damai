package kotlin.jvm.functions;

import kotlin.Function;

/* compiled from: Taobao */
public interface Function2<P1, P2, R> extends Function<R> {
    R invoke(P1 p1, P2 p2);
}
