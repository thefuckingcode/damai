package tb;

import com.opensource.svgaplayer.proto.AudioEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class s22 {
    private final int a;
    private final int b;
    @Nullable
    private Integer c;
    @Nullable
    private Integer d;

    public s22(@NotNull AudioEntity audioEntity) {
        k21.j(audioEntity, "audioItem");
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        int i = 0;
        this.a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.b = num2 != null ? num2.intValue() : i;
        Integer num3 = audioEntity.startTime;
        if (num3 != null) {
            num3.intValue();
        }
        Integer num4 = audioEntity.totalTime;
        if (num4 != null) {
            num4.intValue();
        }
    }

    public final int a() {
        return this.b;
    }

    @Nullable
    public final Integer b() {
        return this.d;
    }

    @Nullable
    public final Integer c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final void e(@Nullable Integer num) {
        this.d = num;
    }

    public final void f(@Nullable Integer num) {
        this.c = num;
    }
}
