package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jq0 {
    @Nullable
    private nq0 a;
    @Nullable
    private nq0 b;
    @Nullable
    private nq0 c;
    @Nullable
    private nq0 d;

    public jq0(@Nullable nq0 nq0, @Nullable nq0 nq02, @Nullable nq0 nq03, @Nullable nq0 nq04) {
        this.a = nq0;
        this.b = nq02;
        this.c = nq03;
        this.d = nq04;
    }

    private final float[] j() {
        float[] fArr = new float[8];
        nq0 nq0 = this.a;
        float f = 0.0f;
        float c2 = nq0 == null ? 0.0f : nq0.c();
        nq0 nq02 = this.b;
        float c3 = nq02 == null ? 0.0f : nq02.c();
        nq0 nq03 = this.c;
        float c4 = nq03 == null ? 0.0f : nq03.c();
        nq0 nq04 = this.d;
        if (nq04 != null) {
            f = nq04.c();
        }
        fArr[0] = c2;
        fArr[1] = c2;
        fArr[2] = c3;
        fArr[3] = c3;
        fArr[4] = f;
        fArr[5] = f;
        fArr[6] = c4;
        fArr[7] = c4;
        return fArr;
    }

    @Nullable
    public final nq0 a() {
        return this.c;
    }

    @Nullable
    public final nq0 b() {
        return this.d;
    }

    @Nullable
    public final nq0 c() {
        return this.a;
    }

    @Nullable
    public final nq0 d() {
        return this.b;
    }

    @NotNull
    public final float[] e() {
        return j();
    }

    public final void f(@Nullable nq0 nq0) {
        this.c = nq0;
    }

    public final void g(@Nullable nq0 nq0) {
        this.d = nq0;
    }

    public final void h(@Nullable nq0 nq0) {
        this.a = nq0;
    }

    public final void i(@Nullable nq0 nq0) {
        this.b = nq0;
    }
}
