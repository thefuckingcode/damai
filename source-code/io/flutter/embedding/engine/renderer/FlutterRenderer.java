package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
/* compiled from: Taobao */
public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    private Runnable drawLastLayerTreeCallback;
    private long drawLastLayerTreeSurfaceId;
    private boolean drawLastLayerTreeSync;
    private boolean drawLastLayerTreeWhenSwapSurface;
    @NonNull
    private final FlutterJNI flutterJNI;
    @Nullable
    private FlutterRenderingListener flutterRenderingListener;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private boolean isDisplayingFlutterUi = false;
    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    @NonNull
    private final Set<TextureRegistry.OnLowMemoryListener> onLowMemoryListeners;
    private boolean presentingSurface;
    private long presentingSurfaceId;
    @Nullable
    private RenderSurface renderSurface;
    @Nullable
    private Surface surface;
    private boolean useSwapInsteadOfDetachAttach;

    /* compiled from: Taobao */
    public interface FlutterRenderingListener {
        void onStartRenderingToSurface();
    }

    /* compiled from: Taobao */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.OnLowMemoryListener, TextureRegistry.SurfaceTextureEntry {
        private final long id;
        @Nullable
        private TextureRegistry.OnFrameConsumedListener listener;
        @Nullable
        private TextureRegistry.OnLowMemoryListener lowMemoryListener;
        private final Runnable onFrameConsumed;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            /* class io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.AnonymousClass2 */

            public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.flutterJNI.isAttached()) {
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = SurfaceTextureRegistryEntry.this;
                    FlutterRenderer.this.markTextureFrameAvailable(surfaceTextureRegistryEntry.id);
                }
            }
        };
        private boolean released;
        @NonNull
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, @NonNull SurfaceTexture surfaceTexture) {
            AnonymousClass1 r2 = new Runnable() {
                /* class io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.AnonymousClass1 */

                public void run() {
                    if (SurfaceTextureRegistryEntry.this.listener != null) {
                        SurfaceTextureRegistryEntry.this.listener.onFrameConsumed();
                    }
                }
            };
            this.onFrameConsumed = r2;
            this.id = j;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, r2);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        private void removeListener() {
            FlutterRenderer.this.removeOnLowMemoryListener(this);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.OnLowMemoryListener
        public void onLowMemory(int i) {
            TextureRegistry.OnLowMemoryListener onLowMemoryListener = this.lowMemoryListener;
            if (onLowMemoryListener != null) {
                onLowMemoryListener.onLowMemory(i);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (!this.released) {
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
                this.textureWrapper.release();
                FlutterRenderer.this.unregisterTexture(this.id);
                removeListener();
                this.released = true;
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(@Nullable TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            this.listener = onFrameConsumedListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnLowMemoryListener(@Nullable TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
            this.lowMemoryListener = onLowMemoryListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @NonNull
        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    /* compiled from: Taobao */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public int height = 0;
        public int physicalTouchSlop = -1;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingTop = 0;
        public int width = 0;

        /* access modifiers changed from: package-private */
        public boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI2) {
        AnonymousClass1 r0 = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.engine.renderer.FlutterRenderer.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = r0;
        this.onLowMemoryListeners = new CopyOnWriteArraySet();
        this.flutterJNI = flutterJNI2;
        flutterJNI2.addIsDisplayingFlutterUiListener(r0);
        flutterJNI2.setPresentSurfaceCallback(new FlutterJNI.PresentSurfaceCallback() {
            /* class io.flutter.embedding.engine.renderer.FlutterRenderer.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.FlutterJNI.PresentSurfaceCallback
            public void onPresentSurface(long j) {
                FlutterRenderer.this.onPresentSurface(j);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.PresentSurfaceCallback
            public void onPresentSurfaceCompleted(long j) {
                FlutterRenderer.this.onPresentSurfaceCompleted(j);
            }
        });
    }

    private void drawLastLayerTreeDone() {
        Runnable runnable = this.drawLastLayerTreeCallback;
        if (runnable != null) {
            runnable.run();
            this.drawLastLayerTreeCallback = null;
            this.drawLastLayerTreeSurfaceId = 0;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void markTextureFrameAvailable(long j) {
        this.flutterJNI.markTextureFrameAvailable(j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onPresentSurface(long j) {
        this.presentingSurface = true;
        this.presentingSurfaceId = j;
        RenderSurface renderSurface2 = this.renderSurface;
        if (renderSurface2 != null) {
            renderSurface2.onPresentSurface();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onPresentSurfaceCompleted(long j) {
        if (this.presentingSurface) {
            this.presentingSurface = false;
            RenderSurface renderSurface2 = this.renderSurface;
            if (renderSurface2 != null) {
                renderSurface2.onPresentSurfaceCompleted();
            }
            if (j == this.drawLastLayerTreeSurfaceId) {
                drawLastLayerTreeDone();
            }
        }
    }

    private void registerTexture(long j, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        this.flutterJNI.registerTexture(j, surfaceTextureWrapper);
    }

    private void swapSurfaceWithNewSurfaceId(@NonNull Surface surface2, boolean z, boolean z2) {
        FlutterJNI.beginSection("FlutterRenderer.swapSurfaceWithNewSurfaceId");
        this.surface = surface2;
        this.drawLastLayerTreeSurfaceId = this.flutterJNI.onSurfaceWindowChangedWithNewSurfaceId(surface2, z, z2);
        if (!z || z2) {
            drawLastLayerTreeDone();
        }
        FlutterJNI.endSection();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void unregisterTexture(long j) {
        this.flutterJNI.unregisterTexture(j);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener2.onFlutterUiDisplayed();
        }
    }

    public void addOnLowMemoryListener(@NonNull TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
        this.onLowMemoryListeners.add(onLowMemoryListener);
    }

    public void addPlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        this.flutterJNI.addPlatformViewDisplayListener(platformViewDisplayListener);
    }

    public void attachRenderSurface(RenderSurface renderSurface2) {
        RenderSurface renderSurface3 = this.renderSurface;
        if (!(renderSurface3 == null || renderSurface3 == renderSurface2)) {
            renderSurface3.detachFromRenderer();
        }
        this.renderSurface = renderSurface2;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        addOnLowMemoryListener(surfaceTextureRegistryEntry);
        return surfaceTextureRegistryEntry;
    }

    public void destroyPointerDataPacket() {
        this.flutterJNI.destroyPointerDataPacket();
    }

    public void detachRenderSurface() {
        this.renderSurface = null;
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        this.flutterJNI.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }

    public void drawLastLayerTree(boolean z, @Nullable Runnable runnable) {
        if (this.drawLastLayerTreeCallback != null) {
            Log.w(TAG, "FlutterRenderer drawLastLayerTree with last draw not done yet.");
        }
        this.drawLastLayerTreeCallback = runnable;
        this.drawLastLayerTreeSurfaceId = this.flutterJNI.drawLastLayerTree(z);
        if (z) {
            drawLastLayerTreeDone();
        }
    }

    public void enableDebugPreRenderDisplay(boolean z) {
        this.flutterJNI.enableDebugPreRenderDisplay(z);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public RenderSurface getRenderSurface() {
        return this.renderSurface;
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    @Override // io.flutter.view.TextureRegistry
    public void onTrimMemory(int i) {
        for (TextureRegistry.OnLowMemoryListener onLowMemoryListener : this.onLowMemoryListeners) {
            onLowMemoryListener.onLowMemory(i);
        }
    }

    public void registerFlutterRenderingListener(@NonNull FlutterRenderingListener flutterRenderingListener2) {
        this.flutterRenderingListener = flutterRenderingListener2;
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
    }

    public void removeOnLowMemoryListener(@NonNull TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
        this.onLowMemoryListeners.remove(onLowMemoryListener);
    }

    public void removePlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        this.flutterJNI.removePlatformViewDisplayListener(platformViewDisplayListener);
    }

    public void setAccessibilityFeatures(int i) {
        this.flutterJNI.setAccessibilityFeatures(i);
    }

    public void setFallbackBehavior(boolean z, boolean z2, boolean z3, Runnable runnable) {
        this.useSwapInsteadOfDetachAttach = z;
        this.drawLastLayerTreeWhenSwapSurface = z2;
        this.drawLastLayerTreeSync = z3;
        this.drawLastLayerTreeCallback = runnable;
    }

    public void setPromoteBehavior(boolean z) {
        this.useSwapInsteadOfDetachAttach = z;
        this.drawLastLayerTreeWhenSwapSurface = false;
        this.drawLastLayerTreeSync = false;
    }

    public void setSemanticsEnabled(boolean z) {
        this.flutterJNI.setSemanticsEnabled(z);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        if (viewportMetrics.validate()) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.viewPaddingLeft + ", T: " + viewportMetrics.viewPaddingTop + ", R: " + viewportMetrics.viewPaddingRight + ", B: " + viewportMetrics.viewPaddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.viewInsetBottom);
            this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.viewPaddingTop, viewportMetrics.viewPaddingRight, viewportMetrics.viewPaddingBottom, viewportMetrics.viewPaddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop);
        }
    }

    public void startPreRendering() {
        this.flutterJNI.startPreRendering();
    }

    public void startRenderingToSurface(@NonNull Surface surface2) {
        FlutterRenderingListener flutterRenderingListener2;
        if (!this.useSwapInsteadOfDetachAttach || this.surface == null) {
            Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
            RenderSurface renderSurface2 = this.renderSurface;
            if ((renderSurface2 == null || !renderSurface2.isPreRenderSurface()) && (flutterRenderingListener2 = this.flutterRenderingListener) != null) {
                flutterRenderingListener2.onStartRenderingToSurface();
            }
            if (this.surface != null) {
                stopRenderingToSurface();
            }
            this.surface = surface2;
            this.flutterJNI.onSurfaceCreated(surface2);
            Trace.endSection();
            return;
        }
        this.useSwapInsteadOfDetachAttach = false;
        swapSurfaceWithNewSurfaceId(surface2, this.drawLastLayerTreeWhenSwapSurface, this.drawLastLayerTreeSync);
    }

    public void stopRenderingToSurface() {
        if (!this.useSwapInsteadOfDetachAttach || this.surface == null) {
            this.flutterJNI.onSurfaceDestroyed();
            this.surface = null;
            if (this.isDisplayingFlutterUi) {
                this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
            this.isDisplayingFlutterUi = false;
            return;
        }
        this.isDisplayingFlutterUi = false;
    }

    public void surfaceChanged(int i, int i2) {
        if (this.surface == null) {
            Log.e(TAG, "AONE(29109102) => call surfaceChanged() on a detached surface.");
        } else {
            this.flutterJNI.onSurfaceChanged(i, i2);
        }
    }

    public void swapSurface(@NonNull Surface surface2) {
        this.surface = surface2;
        this.flutterJNI.onSurfaceWindowChanged(surface2);
    }

    public void swapSurfaceOrStartRendering(@NonNull Surface surface2) {
        FlutterJNI.beginSection("FlutterRenderer.swapSurfaceOrStartRendering");
        if (this.surface == null) {
            startRenderingToSurface(surface2);
        } else {
            this.surface = surface2;
            this.flutterJNI.onSurfaceWindowChanged(surface2);
        }
        FlutterJNI.endSection();
    }

    public void unRegisterFlutterRenderingListener() {
        this.flutterRenderingListener = null;
    }

    public void waitDrawLastLayerTree() {
        if (this.drawLastLayerTreeSurfaceId > 0) {
            this.flutterJNI.waitDrawLastLayerTree();
            drawLastLayerTreeDone();
        }
    }

    public void waitPresentSurfaceCompleted() {
        if (this.presentingSurface && this.flutterJNI.waitPresentSurfaceCompleted()) {
            onPresentSurfaceCompleted(this.presentingSurfaceId);
        }
        waitDrawLastLayerTree();
    }
}
