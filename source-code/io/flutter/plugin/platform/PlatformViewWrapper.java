package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.util.ViewUtils;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
@TargetApi(23)
/* compiled from: Taobao */
public class PlatformViewWrapper extends FrameLayout {
    private static final String TAG = "PlatformViewWrapper";
    @Nullable
    @VisibleForTesting
    ViewTreeObserver.OnGlobalFocusChangeListener activeFocusListener;
    private int bufferHeight;
    private int bufferWidth;
    private int left;
    private final TextureRegistry.OnFrameConsumedListener listener;
    private final TextureRegistry.OnLowMemoryListener lowMemoryListener;
    private final AtomicLong pendingFramesCount;
    private int prevLeft;
    private int prevTop;
    private boolean shouldRecreateSurfaceForLowMemory;
    private Surface surface;
    @Nullable
    private TextureRegistry.SurfaceTextureEntry textureEntry;
    private int top;
    private AndroidTouchProcessor touchProcessor;
    private SurfaceTexture tx;

    public PlatformViewWrapper(@NonNull Context context) {
        super(context);
        this.pendingFramesCount = new AtomicLong(0);
        this.listener = new TextureRegistry.OnFrameConsumedListener() {
            /* class io.flutter.plugin.platform.PlatformViewWrapper.AnonymousClass1 */

            @Override // io.flutter.view.TextureRegistry.OnFrameConsumedListener
            public void onFrameConsumed() {
                if (Build.VERSION.SDK_INT == 29) {
                    PlatformViewWrapper.this.pendingFramesCount.decrementAndGet();
                }
            }
        };
        this.shouldRecreateSurfaceForLowMemory = false;
        this.lowMemoryListener = new TextureRegistry.OnLowMemoryListener() {
            /* class io.flutter.plugin.platform.PlatformViewWrapper.AnonymousClass2 */

            @Override // io.flutter.view.TextureRegistry.OnLowMemoryListener
            public void onLowMemory(int i) {
                if (i == 80 && Build.VERSION.SDK_INT >= 29) {
                    PlatformViewWrapper.this.shouldRecreateSurfaceForLowMemory = true;
                }
            }
        };
        setWillNotDraw(false);
    }

    private void onFrameProduced() {
        if (Build.VERSION.SDK_INT == 29) {
            this.pendingFramesCount.incrementAndGet();
        }
    }

    private void recreateSurfaceIfNeeded() {
        if (this.shouldRecreateSurfaceForLowMemory) {
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
            }
            this.surface = createSurface(this.tx);
            this.shouldRecreateSurfaceForLowMemory = false;
        }
    }

    private boolean shouldDrawToSurfaceNow() {
        if (Build.VERSION.SDK_INT != 29 || this.pendingFramesCount.get() <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @VisibleForTesting
    public Surface createSurface(@NonNull SurfaceTexture surfaceTexture) {
        return new Surface(surfaceTexture);
    }

    @SuppressLint({"NewApi"})
    public void draw(Canvas canvas) {
        Surface surface2 = this.surface;
        if (surface2 == null || !surface2.isValid()) {
            Log.e(TAG, "Invalid surface. The platform view cannot be displayed.");
            return;
        }
        SurfaceTexture surfaceTexture = this.tx;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            Log.e(TAG, "Invalid texture. The platform view cannot be displayed.");
        } else if (!shouldDrawToSurfaceNow()) {
            invalidate();
        } else {
            recreateSurfaceIfNeeded();
            Canvas lockHardwareCanvas = this.surface.lockHardwareCanvas();
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    lockHardwareCanvas.drawColor(0, BlendMode.CLEAR);
                } else {
                    lockHardwareCanvas.drawColor(0);
                }
                super.draw(lockHardwareCanvas);
                onFrameProduced();
            } finally {
                this.surface.unlockCanvasAndPost(lockHardwareCanvas);
            }
        }
    }

    public int getBufferHeight() {
        return this.bufferHeight;
    }

    public int getBufferWidth() {
        return this.bufferWidth;
    }

    @Nullable
    public SurfaceTexture getTexture() {
        return this.tx;
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate(rect);
        return super.invalidateChildInParent(iArr, rect);
    }

    @SuppressLint({"NewApi"})
    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.touchProcessor == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.left;
            this.prevLeft = i;
            int i2 = this.top;
            this.prevTop = i2;
            matrix.postTranslate((float) i, (float) i2);
        } else if (action != 2) {
            matrix.postTranslate((float) this.left, (float) this.top);
        } else {
            matrix.postTranslate((float) this.prevLeft, (float) this.prevTop);
            this.prevLeft = this.left;
            this.prevTop = this.top;
        }
        return this.touchProcessor.onTouchEvent(motionEvent, matrix);
    }

    public void release() {
        this.tx = null;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
    }

    public void setBufferSize(int i, int i2) {
        this.bufferWidth = i;
        this.bufferHeight = i2;
        SurfaceTexture surfaceTexture = this.tx;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    public void setLayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.left = layoutParams.leftMargin;
        this.top = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(@NonNull final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.activeFocusListener == null) {
            AnonymousClass3 r1 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class io.flutter.plugin.platform.PlatformViewWrapper.AnonymousClass3 */

                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    PlatformViewWrapper platformViewWrapper = PlatformViewWrapper.this;
                    onFocusChangeListener.onFocusChange(platformViewWrapper, ViewUtils.childHasFocus(platformViewWrapper));
                }
            };
            this.activeFocusListener = r1;
            viewTreeObserver.addOnGlobalFocusChangeListener(r1);
        }
    }

    @SuppressLint({"NewApi"})
    public void setTexture(@Nullable SurfaceTexture surfaceTexture) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.e(TAG, "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
            return;
        }
        this.tx = surfaceTexture;
        int i3 = this.bufferWidth;
        if (i3 > 0 && (i = this.bufferHeight) > 0) {
            surfaceTexture.setDefaultBufferSize(i3, i);
        }
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        Surface createSurface = createSurface(surfaceTexture);
        this.surface = createSurface;
        Canvas lockHardwareCanvas = createSurface.lockHardwareCanvas();
        if (i2 >= 29) {
            try {
                lockHardwareCanvas.drawColor(0, BlendMode.CLEAR);
            } catch (Throwable th) {
                this.surface.unlockCanvasAndPost(lockHardwareCanvas);
                throw th;
            }
        } else {
            lockHardwareCanvas.drawColor(0);
        }
        onFrameProduced();
        this.surface.unlockCanvasAndPost(lockHardwareCanvas);
    }

    public void setTouchProcessor(@Nullable AndroidTouchProcessor androidTouchProcessor) {
        this.touchProcessor = androidTouchProcessor;
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.activeFocusListener) != null) {
            this.activeFocusListener = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public PlatformViewWrapper(@NonNull Context context, @NonNull TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        this(context);
        this.textureEntry = surfaceTextureEntry;
        surfaceTextureEntry.setOnFrameConsumedListener(this.listener);
        surfaceTextureEntry.setOnLowMemoryListener(this.lowMemoryListener);
        setTexture(surfaceTextureEntry.surfaceTexture());
    }
}
