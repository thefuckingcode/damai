package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class FlutterTextureView extends TextureView implements RenderSurface {
    private static final String TAG = "FlutterTextureView";
    private static long idGenerator = 0;
    private static Method sUpdateLayerMethod;
    @Nullable
    private FlutterRenderer flutterRenderer;
    private final long id;
    private boolean isAttachedToFlutterRenderer;
    private boolean isSurfaceAvailableForRendering;
    private long presentSurfaceCount;
    @Nullable
    private Surface renderSurface;
    private final TextureView.SurfaceTextureListener surfaceTextureListener;

    static {
        try {
            Method declaredMethod = TextureView.class.getDeclaredMethod("updateLayer", new Class[0]);
            sUpdateLayerMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public FlutterTextureView(@NonNull Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeSurfaceSize(int i, int i2) {
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
            this.flutterRenderer.surfaceChanged(i, i2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void connectSurfaceToRenderer() {
        if (this.flutterRenderer == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = new Surface(getSurfaceTexture());
        this.renderSurface = surface;
        this.flutterRenderer.startRenderingToSurface(surface);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void disconnectSurfaceFromRenderer() {
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.stopRenderingToSurface();
            Surface surface = this.renderSurface;
            if (surface != null) {
                surface.release();
                this.renderSurface = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }

    private void init() {
        setSurfaceTextureListener(this.surfaceTextureListener);
        FlutterJNI.checkUIThreadPriority();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void waitPresentSurfaceCompleted() {
        FlutterJNI.beginSection("FlutterTextureView.waitPresentSurfaceCompleted-" + this.id);
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.waitPresentSurfaceCompleted();
        }
        FlutterJNI.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer2) {
        Log.v(TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
        }
        this.flutterRenderer = flutterRenderer2;
        flutterRenderer2.attachRenderSurface(this);
        this.isAttachedToFlutterRenderer = true;
        if (this.isSurfaceAvailableForRendering) {
            Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
        FlutterViewOverlay.createOverlay(this, "TV");
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.detachRenderSurface();
            if (getWindowToken() != null) {
                Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            FlutterViewOverlay.removeOverlay();
            return;
        }
        Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean hasContent() {
        return this.isSurfaceAvailableForRendering && this.presentSurfaceCount > 0;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean isPreRenderSurface() {
        return false;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean isSurfaceAvailableForRendering() {
        return this.isSurfaceAvailableForRendering;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void onPresentSurface() {
        FlutterJNI.beginSection("FlutterTextureView.onPresentSurface-" + this.id);
        if (hasContent()) {
            updateAndInvalidate();
        }
        FlutterJNI.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void onPresentSurfaceCompleted() {
        FlutterJNI.beginSection("FlutterTextureView.onPresentSurfaceCompleted-" + this.id);
        if (this.isAttachedToFlutterRenderer && this.isSurfaceAvailableForRendering) {
            this.presentSurfaceCount++;
        }
        FlutterJNI.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void pause() {
        if (this.flutterRenderer != null) {
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w(TAG, "pause() invoked when no FlutterRenderer was attached.");
    }

    public void setOpaque(boolean z) {
        Log.e(TAG, "FlutterTextureView is transparent and can't be set to Opaque");
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void setRenderTransparently(boolean z) {
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void updateAndInvalidate() {
        Method method = sUpdateLayerMethod;
        if (method != null) {
            try {
                method.invoke(this, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            invalidate();
            return;
        }
        boolean isOpaque = isOpaque();
        super.setOpaque(!isOpaque);
        super.setOpaque(isOpaque);
    }

    public FlutterTextureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() {
            /* class io.flutter.embedding.android.FlutterTextureView.AnonymousClass1 */

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureAvailable()");
                FlutterTextureView.this.isSurfaceAvailableForRendering = true;
                if (FlutterTextureView.this.isAttachedToFlutterRenderer) {
                    FlutterTextureView.this.connectSurfaceToRenderer();
                }
            }

            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                FlutterTextureView.this.isSurfaceAvailableForRendering = false;
                FlutterTextureView.this.presentSurfaceCount = 0;
                if (!FlutterTextureView.this.isAttachedToFlutterRenderer) {
                    return true;
                }
                FlutterTextureView.this.disconnectSurfaceFromRenderer();
                return true;
            }

            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i2) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                if (FlutterTextureView.this.isAttachedToFlutterRenderer) {
                    FlutterTextureView.this.changeSurfaceSize(i, i2);
                }
            }

            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
                FlutterViewOverlay.onRenderViewDraw();
                FlutterTextureView.this.waitPresentSurfaceCompleted();
            }
        };
        long j = idGenerator + 1;
        idGenerator = j;
        this.id = j;
        super.setOpaque(false);
        init();
    }
}
