package tb;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class xv2 {
    private final int a;
    private final long b;
    @NonNull
    private final WeakReference<View> c;

    public xv2(int i, long j, @NonNull WeakReference<View> weakReference) {
        this.a = i;
        this.b = j;
        this.c = weakReference;
    }

    public long a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    @Nullable
    public View c() {
        return this.c.get();
    }
}
