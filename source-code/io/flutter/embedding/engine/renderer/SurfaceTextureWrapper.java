package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
/* compiled from: Taobao */
public class SurfaceTextureWrapper {
    private Runnable onFrameConsumed;
    private boolean released;
    private SurfaceTexture surfaceTexture;

    public SurfaceTextureWrapper(@NonNull SurfaceTexture surfaceTexture2) {
        this(surfaceTexture2, null);
    }

    public void attachToGLContext(int i) {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.attachToGLContext(i);
            }
        }
    }

    public void detachFromGLContext() {
        this.surfaceTexture.detachFromGLContext();
    }

    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    public void release() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.release();
                this.released = true;
            }
        }
    }

    @NonNull
    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void updateTexImage() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.updateTexImage();
                Runnable runnable = this.onFrameConsumed;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public SurfaceTextureWrapper(@NonNull SurfaceTexture surfaceTexture2, @Nullable Runnable runnable) {
        this.surfaceTexture = surfaceTexture2;
        this.released = false;
        this.onFrameConsumed = runnable;
    }
}
