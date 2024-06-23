package tb;

import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.poplayer.trigger.view.TrackingService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ar0 {
    @NotNull
    private final GXIExpression a;

    public ar0(@NotNull GXIExpression gXIExpression) {
        k21.i(gXIExpression, TrackingService.OPER_TRACK);
        this.a = gXIExpression;
    }

    @NotNull
    public final GXIExpression a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ar0) && k21.d(this.a, ((ar0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXTrackBinding(track=" + this.a + ')';
    }
}
