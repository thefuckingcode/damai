package tb;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ep0 extends br0 {
    @Nullable
    private Float a;

    public ep0() {
    }

    @Override // tb.br0
    @Nullable
    public Object a() {
        return this.a;
    }

    public ep0(float f) {
        this();
        this.a = Float.valueOf(f);
    }
}
