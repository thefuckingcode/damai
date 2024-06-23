package io.flutter.view;

import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface TextureRegistry {

    /* compiled from: Taobao */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* compiled from: Taobao */
    public interface OnLowMemoryListener {
        void onLowMemory(int i);
    }

    /* compiled from: Taobao */
    public interface SurfaceTextureEntry {
        long id();

        void release();

        void setOnFrameConsumedListener(@Nullable OnFrameConsumedListener onFrameConsumedListener);

        void setOnLowMemoryListener(@Nullable OnLowMemoryListener onLowMemoryListener);

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i);
}
