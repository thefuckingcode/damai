package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;

/* compiled from: Taobao */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {
    private static final boolean DEBUG_DRAW = false;
    private static final String TAG = "FlutterSurfaceView";
    private CancelableSwapSurface cancelableSwapSurface;
    @Nullable
    private FlutterRenderer flutterRenderer;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private boolean forPromote;
    private boolean isAttachedToFlutterRenderer;
    private boolean isSurfaceAvailableForRendering;
    private boolean punchingHole;
    private boolean renderTransparently;
    private final SurfaceHolder.Callback surfaceCallback;
    private boolean surfaceHasContent;
    private Runnable swapSurfaceCallback;
    private Region tempTransparentRegion;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CancelableSwapSurface implements Runnable {
        private boolean enable = true;
        @Nullable
        private Runnable swapSurface;

        CancelableSwapSurface(@NonNull Runnable runnable) {
            this.swapSurface = runnable;
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            if (this.enable) {
                this.enable = false;
                this.swapSurface = null;
            }
        }

        public void run() {
            if (this.enable) {
                this.swapSurface.run();
                this.swapSurface = null;
                this.enable = false;
            }
        }
    }

    public FlutterSurfaceView(@NonNull Context context) {
        this(context, null, false);
    }

    private void cancelSwapSurface() {
        CancelableSwapSurface cancelableSwapSurface2 = this.cancelableSwapSurface;
        if (cancelableSwapSurface2 != null) {
            cancelableSwapSurface2.cancel();
            this.cancelableSwapSurface = null;
        }
        this.swapSurfaceCallback = null;
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
        if (this.flutterRenderer == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void disconnectSurfaceFromRenderer() {
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.stopRenderingToSurface();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }

    private void init() {
        if (this.renderTransparently) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.surfaceCallback);
        setAlpha(0.0f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void promoteSwapSurface() {
        FlutterJNI.beginSection("FlutterSurfaceView.promoteSwapSurface");
        if (!this.isAttachedToFlutterRenderer && this.swapSurfaceCallback != null) {
            CancelableSwapSurface cancelableSwapSurface2 = this.cancelableSwapSurface;
            if (cancelableSwapSurface2 != null) {
                cancelableSwapSurface2.cancel();
            }
            CancelableSwapSurface cancelableSwapSurface3 = new CancelableSwapSurface(this.swapSurfaceCallback);
            this.cancelableSwapSurface = cancelableSwapSurface3;
            this.swapSurfaceCallback = null;
            post(cancelableSwapSurface3);
        }
        FlutterJNI.endSection();
    }

    private void setPunchingHole(boolean z) {
        FlutterJNI.beginSection("FlutterSurfaceView.setPunchingHole");
        if (this.punchingHole != z) {
            this.punchingHole = z;
        }
        FlutterJNI.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer2) {
        Log.v(TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        }
        this.flutterRenderer = flutterRenderer2;
        flutterRenderer2.attachRenderSurface(this);
        this.isAttachedToFlutterRenderer = true;
        this.flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (this.isSurfaceAvailableForRendering) {
            Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
        FlutterViewOverlay.createOverlay(this, "SV");
    }

    /* access modifiers changed from: package-private */
    public void cancelPromote() {
        this.swapSurfaceCallback = null;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        cancelSwapSurface();
        FlutterRenderer flutterRenderer2 = this.flutterRenderer;
        if (flutterRenderer2 != null) {
            flutterRenderer2.detachRenderSurface();
            if (getWindowToken() != null) {
                Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            setAlpha(0.0f);
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            FlutterViewOverlay.removeOverlay();
            return;
        }
        Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        FlutterJNI.beginSection("FlutterSurfaceView.dispatchDraw-" + this.punchingHole);
        if (this.punchingHole) {
            super.dispatchDraw(canvas);
        }
        FlutterJNI.endSection();
    }

    public void draw(Canvas canvas) {
        FlutterJNI.beginSection("FlutterSurfaceView.draw-" + this.punchingHole);
        if (this.punchingHole) {
            super.draw(canvas);
        }
        FlutterJNI.endSection();
    }

    public boolean gatherTransparentRegion(Region region) {
        if (!this.punchingHole) {
            return super.gatherTransparentRegion(this.tempTransparentRegion);
        }
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean hasContent() {
        return this.isSurfaceAvailableForRendering && this.surfaceHasContent;
    }

    /* access modifiers changed from: package-private */
    public boolean hasSurface() {
        return this.isSurfaceAvailableForRendering;
    }

    /* access modifiers changed from: package-private */
    public void hideSurface() {
        FlutterJNI.beginSection("FlutterSurfaceView.hideSurface");
        if (this.forPromote) {
            setPunchingHole(false);
            invalidate();
        }
        FlutterJNI.endSection();
    }

    /* access modifiers changed from: package-private */
    public void initForPromote(Runnable runnable) {
        this.swapSurfaceCallback = runnable;
        this.forPromote = true;
        setBackgroundResource(0);
        setPunchingHole(false);
    }

    /* access modifiers changed from: package-private */
    public boolean isForPromote() {
        return this.forPromote;
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
        FlutterViewOverlay.onRenderViewDraw();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void onPresentSurfaceCompleted() {
        this.surfaceHasContent = true;
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

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void setRenderTransparently(boolean z) {
        if (this.renderTransparently != z) {
            this.renderTransparently = z;
            if (z) {
                setZOrderOnTop(true);
                getHolder().setFormat(-2);
            } else {
                setZOrderOnTop(false);
                getHolder().setFormat(-1);
            }
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void showSurface() {
        FlutterJNI.beginSection("FlutterSurfaceView.showSurface");
        if (this.forPromote) {
            setPunchingHole(true);
            invalidate();
        }
        FlutterJNI.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void updateAndInvalidate() {
    }

    public FlutterSurfaceView(@NonNull Context context, boolean z) {
        this(context, null, z);
    }

    public FlutterSurfaceView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceCallback = new SurfaceHolder.Callback() {
            /* class io.flutter.embedding.android.FlutterSurfaceView.AnonymousClass1 */

            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.changeSurfaceSize(i2, i3);
                }
            }

            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = true;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.connectSurfaceToRenderer();
                }
                FlutterSurfaceView.this.promoteSwapSurface();
            }

            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = false;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.disconnectSurfaceFromRenderer();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterSurfaceView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Log.v(FlutterSurfaceView.TAG, "onFlutterUiDisplayed()");
                FlutterSurfaceView.this.setAlpha(1.0f);
                FlutterSurfaceView.this.showSurface();
                if (FlutterSurfaceView.this.flutterRenderer != null) {
                    FlutterSurfaceView.this.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.forPromote = false;
        this.punchingHole = true;
        this.tempTransparentRegion = new Region();
        this.renderTransparently = z;
        init();
    }
}
