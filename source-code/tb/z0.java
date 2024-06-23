package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.a.b;

/* compiled from: Taobao */
public abstract class z0 implements b<vy0> {
    public abstract void a(@Nullable vy0 vy0);

    public abstract void b(@NonNull vy0 vy0);

    /* renamed from: c */
    public void result(@Nullable vy0 vy0) {
        if (vy0 == null || !vy0.a) {
            a(vy0);
        } else {
            b(vy0);
        }
    }
}
