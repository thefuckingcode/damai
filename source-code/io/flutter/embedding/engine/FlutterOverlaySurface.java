package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
/* compiled from: Taobao */
public class FlutterOverlaySurface {
    private final int id;
    @NonNull
    private final Surface surface;

    public FlutterOverlaySurface(int i, @NonNull Surface surface2) {
        this.id = i;
        this.surface = surface2;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
