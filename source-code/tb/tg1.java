package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class tg1 extends g42 {
    @NotNull
    public static final tg1 INSTANCE = new tg1();

    private tg1() {
    }

    @Override // tb.g42
    public long a() {
        return System.nanoTime();
    }
}
