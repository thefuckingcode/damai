package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.VsyncWaiter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import tb.km0;
import tb.lm0;
import tb.mm0;
import tb.nm0;
import tb.v;

/* compiled from: Taobao */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {
    public static final int PROMOTE_RENDER_SURFACE_HAS_PLATFORM_VIEW = 3;
    public static final int PROMOTE_RENDER_SURFACE_NO_ENGINE = 1;
    public static final int PROMOTE_RENDER_SURFACE_NO_SURFACE = 2;
    public static final int PROMOTE_RENDER_SURFACE_RENDER_TRANSPARENTLY = 4;
    public static final int PROMOTE_RENDER_SURFACE_SUCCESS = 0;
    private static final boolean REMOVE_SURFACE_VIEW_WHEN_FALLBACK = (Build.VERSION.SDK_INT < 26);
    private static final String TAG = "FlutterView";
    @Nullable
    private AccessibilityBridge accessibilityBridge;
    @Nullable
    private AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    private RenderSurface fallbackRenderSurface;
    @Nullable
    private FlutterEngine flutterEngine;
    @NonNull
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    @Nullable
    private FlutterImageView flutterImageView;
    @Nullable
    private FlutterSurfaceView flutterSurfaceView;
    @Nullable
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    private boolean hasPlatformView;
    private boolean isFlutterUiDisplayed;
    @Nullable
    private KeyboardManager keyboardManager;
    @Nullable
    private LocalizationPlugin localizationPlugin;
    @Nullable
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @Nullable
    private PendingPromoteCallback pendingPromoteCallback;
    @Nullable
    private RenderSurface previousRenderSurface;
    @Nullable
    private RenderSurface renderSurface;
    private boolean renderTransparently;
    @Nullable
    private TextInputPlugin textInputPlugin;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;
    private boolean waitingFallbackDone;

    @VisibleForTesting
    /* compiled from: Taobao */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class PendingPromoteCallback implements FlutterUiDisplayListener {
        private PendingPromoteCallback() {
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiDisplayed() {
            FlutterView.this.pendingPromoteCallback = null;
            if (FlutterView.this.flutterEngine != null) {
                FlutterView.this.promoteRenderSurface();
                FlutterView.this.flutterEngine.getRenderer().removeIsDisplayingFlutterUiListener(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiNoLongerDisplayed() {
        }
    }

    @Deprecated
    /* compiled from: Taobao */
    public enum RenderMode {
        surface,
        texture,
        image
    }

    @Deprecated
    /* compiled from: Taobao */
    public enum TransparencyMode {
        opaque,
        transparent
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(@NonNull Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    private void addPendingPromoteRenderSurface() {
        FlutterEngine flutterEngine2;
        if (this.pendingPromoteCallback == null && (flutterEngine2 = this.flutterEngine) != null && !flutterEngine2.getRenderer().isDisplayingFlutterUi()) {
            FlutterJNI.beginSection("FlutterView.AddPendingPromoteRenderSurface");
            this.pendingPromoteCallback = new PendingPromoteCallback();
            this.flutterEngine.getRenderer().addIsDisplayingFlutterUiListener(this.pendingPromoteCallback);
            FlutterJNI.endSection();
        }
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    @SuppressLint({"PrivateApi"})
    private View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        int i2 = 0;
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        try {
            if (declaredMethod.invoke(view, new Object[0]).equals(Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                    i2++;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
        }
    }

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void init() {
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            addView(this.flutterSurfaceView);
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            addView(this.flutterTextureView);
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            addView(this.flutterImageView);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$fallbackRenderSurface$1(boolean z) {
        FlutterJNI.beginSection("FlutterView.FallbackRenderSurface.Done");
        if (this.waitingFallbackDone) {
            if (z) {
                removePromotedSurfaceView();
            }
            this.waitingFallbackDone = false;
        }
        FlutterJNI.endSection();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$null$2(FlutterSurfaceView flutterSurfaceView2) {
        if (flutterSurfaceView2 != null && flutterSurfaceView2.getParent() == this) {
            FlutterJNI.beginSection("FlutterView.RemovePromotedSurfaceView.Done");
            removeView(flutterSurfaceView2);
            FlutterJNI.endSection();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$promoteRenderSurface$0(FlutterRenderer flutterRenderer) {
        FlutterJNI.beginSection("FlutterView.PromoteRenderSurface.SwapSurface");
        this.fallbackRenderSurface = this.renderSurface;
        FlutterSurfaceView flutterSurfaceView2 = this.flutterSurfaceView;
        this.renderSurface = flutterSurfaceView2;
        flutterRenderer.setPromoteBehavior(flutterSurfaceView2.hasSurface());
        this.fallbackRenderSurface.detachFromRenderer();
        this.flutterSurfaceView.attachToRenderer(flutterRenderer);
        FlutterJNI.endSection();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$removePromotedSurfaceView$3(FlutterSurfaceView flutterSurfaceView2) {
        FlutterJNI.beginSection("FlutterView.RemovePromotedSurfaceView");
        postOnAnimation(new lm0(this, flutterSurfaceView2));
        FlutterJNI.endSection();
    }

    private void removePendingPromoteRenderSurface() {
        if (this.pendingPromoteCallback != null) {
            Log.w(TAG, "FlutterView.removePendingPromoteRenderSurface has pending promote");
            FlutterEngine flutterEngine2 = this.flutterEngine;
            if (flutterEngine2 != null) {
                flutterEngine2.getRenderer().removeIsDisplayingFlutterUiListener(this.pendingPromoteCallback);
            }
            this.pendingPromoteCallback = null;
        }
        FlutterSurfaceView flutterSurfaceView2 = this.flutterSurfaceView;
        if (flutterSurfaceView2 != null) {
            flutterSurfaceView2.cancelPromote();
        }
    }

    private void removePromotedSurfaceView() {
        FlutterSurfaceView flutterSurfaceView2 = this.flutterSurfaceView;
        this.flutterSurfaceView = null;
        postOnAnimation(new km0(this, flutterSurfaceView2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetWillNotDraw(boolean z, boolean z2) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            boolean z3 = false;
            if (!flutterEngine2.getRenderer().isSoftwareRenderingEnabled()) {
                if (!z && !z2) {
                    z3 = true;
                }
                setWillNotDraw(z3);
                return;
            }
            setWillNotDraw(false);
        }
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    private void waitFallbackRenderSurfaceDone() {
        if (this.waitingFallbackDone && this.flutterEngine != null) {
            FlutterJNI.beginSection("FlutterView.WaitFallbackRenderSurfaceDone");
            this.flutterEngine.getRenderer().waitDrawLastLayerTree();
            FlutterJNI.endSection();
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            return flutterImageView2.acquireLatestImage();
        }
        return false;
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener2);
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView2) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView2.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine2) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine2);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine2 == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        this.flutterEngine = flutterEngine2;
        FlutterRenderer renderer = flutterEngine2.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.keyboardManager = new KeyboardManager(this, this.textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine2.getKeyEventChannel())});
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge2 = new AccessibilityBridge(this, flutterEngine2.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge2;
        accessibilityBridge2.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        flutterEngine2.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine2);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
        Trace.endSection();
    }

    public void attachToFlutterEngineForPreRendering(@NonNull FlutterEngine flutterEngine2) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine2 + " for pre-rendering");
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine2 == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        this.flutterEngine = flutterEngine2;
        this.renderSurface.attachToRenderer(flutterEngine2.getRenderer());
        sendUserSettingsToFlutter();
        LocalizationPlugin localizationPlugin2 = this.flutterEngine.getLocalizationPlugin();
        this.localizationPlugin = localizationPlugin2;
        localizationPlugin2.sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        Trace.endSection();
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.autofill(sparseArray);
        }
    }

    public void convertToImageView() {
        fallbackRenderSurfaceForPlatformView(false);
        this.renderSurface.pause();
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null || flutterImageView2.isSurfaceKind()) {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        } else {
            this.flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.previousRenderSurface = this.renderSurface;
        FlutterImageView flutterImageView3 = this.flutterImageView;
        this.renderSurface = flutterImageView3;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView3.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    @NonNull
    @VisibleForTesting
    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void detachFromFlutterEngine() {
        FlutterImageView flutterImageView2;
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
        }
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.keyboardManager.destroy();
        this.androidTouchProcessor.destroy();
        MouseCursorPlugin mouseCursorPlugin2 = this.mouseCursorPlugin;
        if (mouseCursorPlugin2 != null) {
            mouseCursorPlugin2.destroy();
        }
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.renderSurface.detachFromRenderer();
        RenderSurface renderSurface2 = this.previousRenderSurface;
        if (renderSurface2 != null && this.renderSurface == (flutterImageView2 = this.flutterImageView)) {
            this.renderSurface = renderSurface2;
            removeView(flutterImageView2);
        }
        this.flutterImageView = null;
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!isAttachedToFlutterEngine() || !this.keyboardManager.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void fallbackRenderSurface() {
        fallbackRenderSurface(REMOVE_SURFACE_VIEW_WHEN_FALLBACK, true, false);
    }

    public void fallbackRenderSurfaceForPlatformView(boolean z) {
        this.hasPlatformView = true;
        fallbackRenderSurface(true, z, false);
    }

    public void fallbackRenderSurfaceSync() {
        fallbackRenderSurface(REMOVE_SURFACE_VIEW_WHEN_FALLBACK, true, true);
    }

    @SuppressLint({"PrivateApi"})
    public View findViewByAccessibilityIdTraversal(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            return findViewByAccessibilityIdRootedAtCurrentView(i, this);
        }
        Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
        declaredMethod.setAccessible(true);
        try {
            return (View) declaredMethod.invoke(this, Integer.valueOf(i));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.viewPaddingTop = rect.top;
        viewportMetrics2.viewPaddingRight = rect.right;
        viewportMetrics2.viewPaddingBottom = 0;
        viewportMetrics2.viewPaddingLeft = rect.left;
        viewportMetrics2.viewInsetTop = 0;
        viewportMetrics2.viewInsetRight = 0;
        viewportMetrics2.viewInsetBottom = rect.bottom;
        viewportMetrics2.viewInsetLeft = 0;
        Log.v(TAG, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
        sendViewportMetricsToFlutter();
        return true;
    }

    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null || !accessibilityBridge2.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    @Nullable
    @VisibleForTesting
    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    @Override // io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate
    @NonNull
    @RequiresApi(24)
    @TargetApi(24)
    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        return flutterEngine2 != null && flutterEngine2.getRenderer() == this.renderSurface.getAttachedRenderer();
    }

    public boolean isRenderSurfacePromoted() {
        return this.fallbackRenderSurface != null;
    }

    public boolean isSurfaceAvailableForRendering() {
        RenderSurface renderSurface2 = this.renderSurface;
        return renderSurface2 != null && renderSurface2.isSurfaceAvailableForRendering();
    }

    @NonNull
    @SuppressLint({"InlinedApi", "NewApi"})
    @RequiresApi(20)
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i = Build.VERSION.SDK_INT;
        if (i == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
            viewportMetrics2.systemGestureInsetTop = systemGestureInsets.top;
            viewportMetrics2.systemGestureInsetRight = systemGestureInsets.right;
            viewportMetrics2.systemGestureInsetBottom = systemGestureInsets.bottom;
            viewportMetrics2.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean z = true;
        int i2 = 0;
        boolean z2 = (getWindowSystemUiVisibility() & 4) == 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z = false;
        }
        if (i >= 30) {
            if (z) {
                i2 = 0 | WindowInsets.Type.navigationBars();
            }
            if (z2) {
                i2 |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(i2);
            FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
            viewportMetrics3.viewPaddingTop = insets.top;
            viewportMetrics3.viewPaddingRight = insets.right;
            viewportMetrics3.viewPaddingBottom = insets.bottom;
            viewportMetrics3.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
            viewportMetrics4.viewInsetTop = insets2.top;
            viewportMetrics4.viewInsetRight = insets2.right;
            viewportMetrics4.viewInsetBottom = insets2.bottom;
            viewportMetrics4.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
            viewportMetrics5.systemGestureInsetTop = insets3.top;
            viewportMetrics5.systemGestureInsetRight = insets3.right;
            viewportMetrics5.systemGestureInsetBottom = insets3.bottom;
            viewportMetrics5.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
                viewportMetrics6.viewPaddingTop = Math.max(Math.max(viewportMetrics6.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
                viewportMetrics7.viewPaddingRight = Math.max(Math.max(viewportMetrics7.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
                viewportMetrics8.viewPaddingBottom = Math.max(Math.max(viewportMetrics8.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics9 = this.viewportMetrics;
                viewportMetrics9.viewPaddingLeft = Math.max(Math.max(viewportMetrics9.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = calculateShouldZeroSides();
            }
            this.viewportMetrics.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.viewportMetrics.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.viewportMetrics.viewPaddingBottom = (!z || guessBottomKeyboardInset(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.viewportMetrics.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.ViewportMetrics viewportMetrics10 = this.viewportMetrics;
            viewportMetrics10.viewInsetTop = 0;
            viewportMetrics10.viewInsetRight = 0;
            viewportMetrics10.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
        }
    }

    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.onProvideAutofillVirtualStructure(viewStructure, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.width = i;
        viewportMetrics2.height = i2;
        sendViewportMetricsToFlutter();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public int promoteRenderSurface() {
        removePendingPromoteRenderSurface();
        if (this.flutterEngine == null) {
            Log.e(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_NO_ENGINE");
            return 1;
        }
        RenderSurface renderSurface2 = this.renderSurface;
        if (renderSurface2 == null) {
            Log.e(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_NO_SURFACE");
            return 2;
        } else if (this.hasPlatformView) {
            Log.w(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_HAS_PLATFORM_VIEW");
            return 3;
        } else if (this.renderTransparently) {
            Log.w(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_RENDER_TRANSPARENTLY");
            return 4;
        } else if (renderSurface2 == this.flutterSurfaceView) {
            return 0;
        } else {
            if (!renderSurface2.hasContent()) {
                Log.w(TAG, "FlutterView.promoteRenderSurface without content currently");
                addPendingPromoteRenderSurface();
                return 0;
            }
            FlutterJNI.beginSection("FlutterView.PromoteRenderSurface");
            waitFallbackRenderSurfaceDone();
            if (this.flutterSurfaceView == null) {
                FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(getContext());
                this.flutterSurfaceView = flutterSurfaceView2;
                addView(flutterSurfaceView2);
            }
            mm0 mm0 = new mm0(this, this.flutterEngine.getRenderer());
            if (this.flutterSurfaceView.hasSurface()) {
                mm0.run();
            } else {
                this.flutterSurfaceView.initForPromote(mm0);
            }
            FlutterJNI.endSection();
            return 0;
        }
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener2);
    }

    public void revertImageView(@NonNull final Runnable runnable) {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface2 = this.previousRenderSurface;
        if (renderSurface2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.renderSurface = renderSurface2;
        this.previousRenderSurface = null;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 == null) {
            flutterImageView2.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine2.getRenderer();
        if (renderer == null) {
            this.flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass3 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView.this.renderSurface instanceof FlutterImageView) || ((FlutterImageView) FlutterView.this.renderSurface).isSurfaceKind()) {
                    FlutterView.this.flutterImageView.detachFromRenderer();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void sendUserSettingsToFlutter() {
        this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
    }

    public void setupViewportMetrics(FlutterRenderer.ViewportMetrics viewportMetrics2) {
        FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
        viewportMetrics3.width = viewportMetrics2.width;
        viewportMetrics3.height = viewportMetrics2.height;
        viewportMetrics3.viewPaddingTop = viewportMetrics2.viewPaddingTop;
        viewportMetrics3.viewPaddingRight = viewportMetrics2.viewPaddingRight;
        viewportMetrics3.viewPaddingBottom = viewportMetrics2.viewPaddingBottom;
        viewportMetrics3.viewPaddingLeft = viewportMetrics2.viewPaddingLeft;
        viewportMetrics3.viewInsetTop = viewportMetrics2.viewInsetTop;
        viewportMetrics3.viewInsetRight = viewportMetrics2.viewInsetRight;
        viewportMetrics3.viewInsetBottom = viewportMetrics2.viewInsetBottom;
        viewportMetrics3.viewInsetLeft = viewportMetrics2.viewInsetLeft;
        viewportMetrics3.systemGestureInsetTop = viewportMetrics2.systemGestureInsetTop;
        viewportMetrics3.systemGestureInsetRight = viewportMetrics2.systemGestureInsetRight;
        viewportMetrics3.systemGestureInsetBottom = viewportMetrics2.systemGestureInsetBottom;
        viewportMetrics3.systemGestureInsetLeft = viewportMetrics2.systemGestureInsetLeft;
    }

    public void setupViewportSize(int i, int i2) {
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.width = i;
        viewportMetrics2.height = i2;
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        VsyncWaiter.setPreferredRefreshRateAsStartRefreshRate(context);
        RenderMode renderMode2 = RenderMode.image;
        renderMode = (renderMode == renderMode2 || renderMode == RenderMode.texture) ? RenderSurface.Helper.suggestUseImageView() ? renderMode2 : RenderMode.texture : renderMode;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.renderSurface = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.renderSurface = flutterTextureView2;
        } else if (renderMode == renderMode2) {
            FlutterImageView flutterImageView2 = new FlutterImageView(context);
            this.flutterImageView = flutterImageView2;
            this.renderSurface = flutterImageView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    private void fallbackRenderSurface(boolean z, boolean z2, boolean z3) {
        RenderSurface renderSurface2;
        FlutterSurfaceView flutterSurfaceView2;
        removePendingPromoteRenderSurface();
        RenderSurface renderSurface3 = this.renderSurface;
        if (renderSurface3 == null || (renderSurface2 = this.fallbackRenderSurface) == null || renderSurface3 != (flutterSurfaceView2 = this.flutterSurfaceView) || this.waitingFallbackDone) {
            waitFallbackRenderSurfaceDone();
            return;
        }
        this.renderSurface = renderSurface2;
        this.fallbackRenderSurface = null;
        if (this.flutterEngine == null) {
            flutterSurfaceView2.detachFromRenderer();
            return;
        }
        FlutterJNI.beginSection("FlutterView.FallbackRenderSurface");
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.waitingFallbackDone = true;
        renderer.setFallbackBehavior(true, z2, z3, new nm0(this, z));
        this.flutterSurfaceView.hideSurface();
        this.flutterSurfaceView.detachFromRenderer();
        this.renderSurface.attachToRenderer(renderer);
        this.renderSurface.updateAndInvalidate();
        FlutterJNI.endSection();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterSurfaceView flutterSurfaceView2) {
        this(context, (AttributeSet) null, flutterSurfaceView2);
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterTextureView flutterTextureView2) {
        this(context, (AttributeSet) null, flutterTextureView2);
    }

    @TargetApi(19)
    public FlutterView(@NonNull Context context, @NonNull FlutterImageView flutterImageView2) {
        this(context, (AttributeSet) null, flutterImageView2);
    }

    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode, @NonNull TransparencyMode transparencyMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        VsyncWaiter.setPreferredRefreshRateAsStartRefreshRate(context);
        RenderMode renderMode2 = RenderMode.image;
        renderMode = (renderMode == renderMode2 || renderMode == RenderMode.texture) ? RenderSurface.Helper.suggestUseImageView() ? renderMode2 : RenderMode.texture : renderMode;
        TransparencyMode transparencyMode2 = TransparencyMode.transparent;
        boolean z = true;
        this.renderTransparently = transparencyMode == transparencyMode2;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context, transparencyMode != transparencyMode2 ? false : z);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.renderSurface = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.renderSurface = flutterTextureView2;
        } else if (renderMode == renderMode2) {
            FlutterImageView flutterImageView2 = new FlutterImageView(context);
            this.flutterImageView = flutterImageView2;
            this.renderSurface = flutterImageView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterSurfaceView flutterSurfaceView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterSurfaceView = flutterSurfaceView2;
        this.renderSurface = flutterSurfaceView2;
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterTextureView flutterTextureView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        if (!RenderSurface.Helper.suggestUseImageView() || !flutterTextureView2.getClass().isAssignableFrom(FlutterTextureView.class)) {
            this.flutterTextureView = flutterTextureView2;
            this.renderSurface = flutterTextureView2;
        } else {
            FlutterImageView flutterImageView2 = new FlutterImageView(context);
            this.flutterImageView = flutterImageView2;
            this.renderSurface = flutterImageView2;
        }
        init();
    }

    @TargetApi(19)
    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterImageView flutterImageView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass1 */

            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            /* class io.flutter.embedding.android.FlutterView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterImageView = flutterImageView2;
        this.renderSurface = flutterImageView2;
        init();
    }
}
