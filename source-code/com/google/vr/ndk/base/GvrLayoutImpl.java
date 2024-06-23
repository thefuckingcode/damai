package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.app.Presentation;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.EglReadyListener;
import com.google.vr.cardboard.ScanlineRacingRenderer;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.fg1;
import tb.hn;
import tb.i90;
import tb.uc0;
import tb.vk2;
import tb.vw2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class GvrLayoutImpl extends FrameLayout {
    private static final int ASYNC_REPROJECTION_FLAGS_UNKNOWN = -1;
    private static final boolean DEBUG = false;
    private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
    private static final int SHOW_RENDERING_VIEWS_DELAY_FOR_FADE = 50;
    private static final String TAG = "GvrLayoutImpl";
    private static PresentationFactory sOptionalPresentationFactory;
    private int asyncReprojectionFlags;
    private boolean autoFadeEnabled;
    private CardboardEmulator cardboardEmulator;
    private SdkDaydreamTouchListener daydreamTouchListener;
    private DaydreamUtilsWrapper daydreamUtils;
    private DisplaySynchronizer displaySynchronizer;
    private uc0 eglFactory;
    private EglReadyListener eglReadyListener;
    private ExtensionManager extensionManager;
    private FadeOverlayView fadeOverlayView;
    private FrameFlushWorkaround frameFlushWorkaround;
    private GvrApi gvrApi;
    private boolean isResumed;
    private PresentationHelper presentationHelper;
    private FrameLayout presentationLayout;
    private View presentationView;
    private ScanlineRacingRenderer scanlineRacingRenderer;
    private AsyncReprojectionSurfaceView scanlineRacingView;
    private ScreenOnManager screenOnManager;
    private final Runnable showRenderingViewsRunnable;
    private boolean stereoModeEnabled;
    private GvrUiLayoutImpl uiLayout;
    private ExternalSurface videoSurface;
    private VrCoreSdkClient vrCoreSdkClient;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class AsyncReprojectionSurfaceView extends GvrSurfaceView {
        private ScanlineRacingRenderer scanlineRacingRenderer;

        AsyncReprojectionSurfaceView(Context context) {
            super(context);
        }

        public void setRenderer(ScanlineRacingRenderer scanlineRacingRenderer2) {
            this.scanlineRacingRenderer = scanlineRacingRenderer2;
            super.setRenderer((GLSurfaceView.Renderer) scanlineRacingRenderer2);
        }

        @Override // com.google.vr.ndk.base.GvrSurfaceView
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (!isDetachedFromWindow() && this.scanlineRacingRenderer != null) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                queueEvent(new Runnable() {
                    /* class com.google.vr.ndk.base.GvrLayoutImpl.AsyncReprojectionSurfaceView.AnonymousClass1 */

                    public void run() {
                        AsyncReprojectionSurfaceView.this.scanlineRacingRenderer.b();
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    Log.e(GvrLayoutImpl.TAG, "Interrupted during surface destroyed: ", e);
                }
            }
            super.surfaceDestroyed(surfaceHolder);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class FrameFlushWorkaround implements Choreographer.FrameCallback {
        private final Choreographer choreographer = Choreographer.getInstance();
        private int framesRemaining;

        public void doFrame(long j) {
            int i = this.framesRemaining - 1;
            this.framesRemaining = i;
            if (i > 0) {
                this.choreographer.postFrameCallback(this);
            }
        }

        public void onResume() {
            if (this.framesRemaining > 0) {
                this.choreographer.removeFrameCallback(this);
            }
            this.framesRemaining = 5;
            this.choreographer.postFrameCallback(this);
        }
    }

    /* compiled from: Taobao */
    static class NullExtensionManager implements ExtensionManager {
        private NullExtensionManager() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void initialize(ViewGroup viewGroup, GvrApi gvrApi) {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void onPause() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void onResume() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void reportTelemetry(IVrCoreLoggingService iVrCoreLoggingService) {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void shutdown() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface PresentationFactory {
        Presentation create(Context context, Display display);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class PresentationHelper implements DisplayManager.DisplayListener {
        private final Context context;
        private final DisplayManager displayManager;
        private final DisplaySynchronizer displaySynchronizer;
        private String externalDisplayName;
        private final RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(-1, -1);
        private final List<PresentationListener> listeners;
        private final FrameLayout originalParent;
        private Presentation presentation;
        private final View view;

        PresentationHelper(Context context2, FrameLayout frameLayout, View view2, DisplaySynchronizer displaySynchronizer2, String str) {
            this.context = context2;
            this.originalParent = frameLayout;
            this.view = view2;
            this.displaySynchronizer = displaySynchronizer2;
            this.externalDisplayName = str;
            this.displayManager = (DisplayManager) context2.getSystemService("display");
            this.listeners = new ArrayList();
        }

        private static void detachViewFromParent(View view2) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
        }

        private boolean hasCurrentPresentationExpired() {
            Presentation presentation2 = this.presentation;
            if (presentation2 == null) {
                return false;
            }
            if (!presentation2.isShowing() || !this.presentation.getDisplay().isValid()) {
                return true;
            }
            return false;
        }

        private boolean isValidExternalDisplay(Display display) {
            return display != null && display.isValid() && display.getName().equals(this.externalDisplayName);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        private void setDisplay(Display display) {
            Presentation presentation2;
            Display display2;
            Presentation presentation3;
            Presentation presentation4 = this.presentation;
            Display display3 = presentation4 != null ? presentation4.getDisplay() : null;
            if (hasCurrentPresentationExpired() || !i90.g(display, display3)) {
                Presentation presentation5 = this.presentation;
                if (presentation5 != null) {
                    presentation5.dismiss();
                    this.presentation = null;
                }
                detachViewFromParent(this.view);
                if (display != null) {
                    if (GvrLayoutImpl.sOptionalPresentationFactory != null) {
                        presentation3 = GvrLayoutImpl.sOptionalPresentationFactory.create(this.context, display);
                    } else {
                        presentation3 = new Presentation(this.context, display);
                    }
                    this.presentation = presentation3;
                    presentation3.addContentView(this.view, this.layout);
                    try {
                        this.presentation.show();
                    } catch (WindowManager.InvalidDisplayException e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 57);
                        sb.append("Attaching Cardboard View to the external display failed: ");
                        sb.append(valueOf);
                        Log.e(GvrLayoutImpl.TAG, sb.toString());
                        this.presentation.cancel();
                        this.presentation = null;
                        detachViewFromParent(this.view);
                    }
                    DisplaySynchronizer displaySynchronizer2 = this.displaySynchronizer;
                    presentation2 = this.presentation;
                    if (presentation2 == null) {
                        display2 = presentation2.getDisplay();
                    } else {
                        display2 = i90.b(this.context);
                    }
                    displaySynchronizer2.h(display2);
                    if (presentation5 != null) {
                        for (PresentationListener presentationListener : this.listeners) {
                            presentationListener.onPresentationStopped();
                        }
                    }
                    if (this.presentation == null) {
                        for (PresentationListener presentationListener2 : this.listeners) {
                            presentationListener2.onPresentationStarted(this.presentation.getDisplay());
                        }
                        return;
                    }
                    return;
                }
                this.originalParent.addView(this.view, 0);
                DisplaySynchronizer displaySynchronizer22 = this.displaySynchronizer;
                presentation2 = this.presentation;
                if (presentation2 == null) {
                }
                displaySynchronizer22.h(display2);
                if (presentation5 != null) {
                }
                if (this.presentation == null) {
                }
            }
        }

        public void addListener(PresentationListener presentationListener) {
            if (!this.listeners.contains(presentationListener)) {
                this.listeners.add(presentationListener);
                Presentation presentation2 = this.presentation;
                if (presentation2 != null) {
                    presentationListener.onPresentationStarted(presentation2.getDisplay());
                }
            }
        }

        public boolean isPresenting() {
            Presentation presentation2 = this.presentation;
            return presentation2 != null && presentation2.isShowing();
        }

        public void onDetachedFromWindow() {
            this.displayManager.unregisterDisplayListener(this);
            setDisplay(null);
        }

        public void onDisplayAdded(int i) {
            Display display = this.displayManager.getDisplay(i);
            if (isValidExternalDisplay(display)) {
                setDisplay(display);
            }
        }

        public void onDisplayChanged(int i) {
        }

        public void onDisplayRemoved(int i) {
            Presentation presentation2 = this.presentation;
            if (presentation2 != null && presentation2.getDisplay().getDisplayId() == i) {
                setDisplay(null);
            }
        }

        public void onPause() {
            this.displayManager.unregisterDisplayListener(this);
        }

        public void onResume() {
            String e = i90.e(this.context);
            this.externalDisplayName = e;
            Display display = null;
            if (e == null) {
                setDisplay(null);
                return;
            }
            this.displayManager.registerDisplayListener(this, null);
            Display[] displays = this.displayManager.getDisplays();
            int length = displays.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Display display2 = displays[i];
                if (isValidExternalDisplay(display2)) {
                    display = display2;
                    break;
                }
                i++;
            }
            setDisplay(display);
        }

        public void shutdown() {
            this.displayManager.unregisterDisplayListener(this);
            Presentation presentation2 = this.presentation;
            if (presentation2 != null) {
                presentation2.cancel();
                this.presentation = null;
                for (PresentationListener presentationListener : this.listeners) {
                    presentationListener.onPresentationStopped();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface PresentationListener {
        void onPresentationStarted(Display display);

        void onPresentationStopped();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class ScreenOnManager implements GvrApi.IdleListener {
        private static final long QUIET_PERIOD_AFTER_RESUME_MILLIS = TimeUnit.SECONDS.toMillis(5);
        private boolean isEnabled = true;
        private boolean isIdle;
        private boolean isResumed;
        private long lastResumeTimeMillis;
        private final View parentView;

        public ScreenOnManager(View view) {
            this.parentView = view;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void updateSetScreenOn() {
            this.parentView.setKeepScreenOn(this.isEnabled && this.isResumed && !this.isIdle);
        }

        @Override // com.google.vr.ndk.base.GvrApi.IdleListener
        public void onIdleChanged(final boolean z) {
            vk2.a(new Runnable() {
                /* class com.google.vr.ndk.base.GvrLayoutImpl.ScreenOnManager.AnonymousClass2 */

                public void run() {
                    TraceCompat.beginSection("GvrLayoutImpl.onIdleChanged");
                    try {
                        if (SystemClock.elapsedRealtime() - ScreenOnManager.this.lastResumeTimeMillis < ScreenOnManager.QUIET_PERIOD_AFTER_RESUME_MILLIS) {
                            boolean z = z;
                            StringBuilder sb = new StringBuilder(80);
                            sb.append("Quiet period after onResume() -- ignoring idle status change with isIdle = ");
                            sb.append(z);
                            Log.d(GvrLayoutImpl.TAG, sb.toString());
                            return;
                        }
                        boolean z2 = ScreenOnManager.this.isIdle;
                        boolean z3 = z;
                        if (z2 != z3) {
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Idle status change to isIdle = ");
                            sb2.append(z3);
                            Log.d(GvrLayoutImpl.TAG, sb2.toString());
                        }
                        ScreenOnManager.this.isIdle = z;
                        ScreenOnManager.this.updateSetScreenOn();
                        TraceCompat.endSection();
                    } finally {
                        TraceCompat.endSection();
                    }
                }
            });
        }

        public void onPause() {
            this.isResumed = false;
            updateSetScreenOn();
        }

        public void onResume() {
            this.isResumed = true;
            this.isIdle = false;
            this.lastResumeTimeMillis = SystemClock.elapsedRealtime();
            updateSetScreenOn();
        }

        public void setEnabled(final boolean z) {
            vk2.a(new Runnable() {
                /* class com.google.vr.ndk.base.GvrLayoutImpl.ScreenOnManager.AnonymousClass1 */

                public void run() {
                    boolean z = ScreenOnManager.this.isEnabled;
                    boolean z2 = z;
                    if (z != z2) {
                        ScreenOnManager.this.isEnabled = z2;
                        ScreenOnManager.this.updateSetScreenOn();
                    }
                }
            });
        }
    }

    public GvrLayoutImpl(Context context) {
        this(context, new NullExtensionManager());
    }

    private void addScanlineRacingView() {
        if (this.scanlineRacingView == null) {
            uc0 uc0 = new uc0();
            this.eglFactory = uc0;
            uc0.d(true);
            this.eglFactory.e((this.asyncReprojectionFlags & 1) != 0);
            this.eglFactory.a(2);
            AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = new AsyncReprojectionSurfaceView(getContext());
            this.scanlineRacingView = asyncReprojectionSurfaceView;
            asyncReprojectionSurfaceView.setEGLConfigChooser(new fg1());
            this.scanlineRacingView.setZOrderMediaOverlay(true);
            this.scanlineRacingView.setEGLContextFactory(this.eglFactory);
            this.scanlineRacingView.setEGLWindowSurfaceFactory(this.eglFactory);
            if (isContextSharingEnabled()) {
                this.scanlineRacingView.setEglReadyListener(this.eglReadyListener);
            }
            if (!this.stereoModeEnabled) {
                Log.w(TAG, "Disabling stereo mode with async reprojection enabled may not work properly.");
                this.scanlineRacingView.setVisibility(8);
            }
            if (this.scanlineRacingRenderer == null) {
                this.scanlineRacingRenderer = new ScanlineRacingRenderer(this.gvrApi);
            }
            this.scanlineRacingRenderer.e(this.scanlineRacingView);
            this.scanlineRacingView.setRenderer(this.scanlineRacingRenderer);
            this.scanlineRacingView.setSwapMode(1);
            if (!this.isResumed) {
                this.scanlineRacingView.onPause();
            }
            this.presentationLayout.addView(this.scanlineRacingView, 0);
        }
    }

    private void init(ExtensionManager extensionManager2) {
        DisplaySynchronizer createDefaultDisplaySynchronizer = GvrApi.createDefaultDisplaySynchronizer(getContext());
        initWithInjectedObjects(new GvrApi(getContext(), createDefaultDisplaySynchronizer), createDefaultDisplaySynchronizer, new EglReadyListener(), null, new DaydreamUtilsWrapper(), extensionManager2);
    }

    private void initWithInjectedObjects(GvrApi gvrApi2, DisplaySynchronizer displaySynchronizer2, EglReadyListener eglReadyListener2, FadeOverlayView fadeOverlayView2, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager2) {
        this.gvrApi = gvrApi2;
        if (isContextSharingEnabled()) {
            gvrApi2.requestContextSharing(eglReadyListener2);
        }
        AnonymousClass2 r0 = new Runnable() {
            /* class com.google.vr.ndk.base.GvrLayoutImpl.AnonymousClass2 */

            public void run() {
                if (GvrLayoutImpl.this.vrCoreSdkClient != null) {
                    GvrLayoutImpl.this.vrCoreSdkClient.onExitingFromVr();
                }
            }
        };
        this.daydreamUtils = daydreamUtilsWrapper;
        this.presentationLayout = new FrameLayout(getContext());
        this.uiLayout = new GvrUiLayoutImpl(getContext(), r0);
        this.displaySynchronizer = displaySynchronizer2;
        this.eglReadyListener = eglReadyListener2;
        this.presentationHelper = tryCreatePresentationHelper();
        this.frameFlushWorkaround = new FrameFlushWorkaround();
        boolean z = false;
        addView(this.presentationLayout, 0);
        addView(this.uiLayout.getRoot(), 1);
        updateUiLayout();
        boolean isDaydreamPhone = daydreamUtilsWrapper.isDaydreamPhone(getContext());
        if (isDaydreamPhone) {
            this.daydreamTouchListener = createDaydreamTouchListener();
            this.uiLayout.getRoot().setOnTouchListener(this.daydreamTouchListener);
        }
        int componentDaydreamCompatibility = daydreamUtilsWrapper.getComponentDaydreamCompatibility(getContext());
        boolean z2 = componentDaydreamCompatibility != 1;
        boolean z3 = componentDaydreamCompatibility == 3;
        if (isDaydreamPhone || z3) {
            z = true;
        }
        if (z) {
            if (z2) {
                if (getContext() instanceof vw2) {
                    this.autoFadeEnabled = ((vw2) getContext()).a();
                }
                if (fadeOverlayView2 == null) {
                    fadeOverlayView2 = new FadeOverlayView(getContext(), this.autoFadeEnabled);
                }
                this.fadeOverlayView = fadeOverlayView2;
                addView(fadeOverlayView2, 2);
            }
            this.vrCoreSdkClient = createVrCoreSdkClient(getContext(), gvrApi2, daydreamUtilsWrapper, this.fadeOverlayView);
        }
        this.screenOnManager = new ScreenOnManager(this);
        if (isDeviceDetectionEnabled()) {
            gvrApi2.setIdleListener(this.screenOnManager);
        }
        this.extensionManager = extensionManager2;
        if (extensionManager2 != null) {
            extensionManager2.initialize(this, gvrApi2);
        }
    }

    private boolean isContextSharingEnabled() {
        Long l;
        GvrApi gvrApi2 = this.gvrApi;
        if (gvrApi2 != null) {
            Vr$VREvent.SdkConfigurationParams.AsyncReprojectionConfig asyncReprojectionConfig = gvrApi2.getSdkConfigurationParams().asyncReprojectionConfig;
            if (asyncReprojectionConfig == null || (l = asyncReprojectionConfig.flags) == null || (l.longValue() & 16) == 0) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("GvrApi must be ready before isContextSharingEnabled is called");
    }

    private boolean isDeviceDetectionEnabled() {
        if (this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection == null) {
            return false;
        }
        return this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection.booleanValue();
    }

    static void setPresentationFactory(PresentationFactory presentationFactory) {
        sOptionalPresentationFactory = presentationFactory;
    }

    private PresentationHelper tryCreatePresentationHelper() {
        if (Build.VERSION.SDK_INT <= 16) {
            return null;
        }
        String e = i90.e(getContext());
        if (e != null) {
            return new PresentationHelper(getContext(), this, this.presentationLayout, this.displaySynchronizer, e);
        }
        Log.e(TAG, "HDMI display name could not be found, disabling external presentation support");
        return null;
    }

    private void updateFadeVisibility() {
        FadeOverlayView fadeOverlayView2 = this.fadeOverlayView;
        if (fadeOverlayView2 != null) {
            if (this.autoFadeEnabled) {
                boolean z = getWindowVisibility() == 0;
                if (z && this.isResumed) {
                    this.fadeOverlayView.onVisible();
                    removeCallbacks(this.showRenderingViewsRunnable);
                    postDelayed(this.showRenderingViewsRunnable, 50);
                } else if (!z && !this.isResumed) {
                    this.fadeOverlayView.onInvisible();
                    updateRenderingViewsVisibility(4);
                    removeCallbacks(this.showRenderingViewsRunnable);
                }
            } else if (this.isResumed) {
                fadeOverlayView2.onVisible();
            } else {
                fadeOverlayView2.onInvisible();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateRenderingViewsVisibility(int i) {
        View view = this.presentationView;
        if (view != null) {
            view.setVisibility(this.stereoModeEnabled ? i : 0);
        }
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            if (!this.stereoModeEnabled) {
                i = 8;
            }
            asyncReprojectionSurfaceView.setVisibility(i);
        }
    }

    private void updateUiLayout() {
        boolean z = true;
        if (this.gvrApi.getViewerType() != 1) {
            z = false;
        }
        this.uiLayout.setDaydreamModeEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public void addPresentationListener(PresentationListener presentationListener) {
        PresentationHelper presentationHelper2 = this.presentationHelper;
        if (presentationHelper2 != null) {
            presentationHelper2.addListener(presentationListener);
        }
    }

    /* access modifiers changed from: package-private */
    public SdkDaydreamTouchListener createDaydreamTouchListener() {
        return new SdkDaydreamTouchListener(this);
    }

    /* access modifiers changed from: protected */
    public VrCoreSdkClient createVrCoreSdkClient(Context context, GvrApi gvrApi2, DaydreamUtilsWrapper daydreamUtilsWrapper, FadeOverlayView fadeOverlayView2) {
        return new VrCoreSdkClient(context, gvrApi2, hn.b(context), daydreamUtilsWrapper, new Runnable() {
            /* class com.google.vr.ndk.base.GvrLayoutImpl.AnonymousClass4 */

            public void run() {
                GvrLayoutImpl.this.uiLayout.invokeCloseButtonListener();
            }
        }, fadeOverlayView2);
    }

    public boolean enableAsyncReprojection(int i) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            int i2 = this.asyncReprojectionFlags;
            if (i2 != -1) {
                if ((i2 & i) == i) {
                    StringBuilder sb = new StringBuilder(58);
                    sb.append("Async reprojection already enabled with flags: ");
                    sb.append(i2);
                    Log.d(TAG, sb.toString());
                    return true;
                }
                throw new UnsupportedOperationException("Async reprojection flags cannot be added once initialized.");
            } else if (this.scanlineRacingView != null) {
                return true;
            } else {
                if (!this.daydreamUtils.isDaydreamPhone(getContext())) {
                    return false;
                }
                if (!this.gvrApi.setAsyncReprojectionEnabled(true)) {
                    Log.e(TAG, "Failed to initialize async reprojection, unsupported device.");
                    return false;
                }
                this.asyncReprojectionFlags = i;
                if (!this.gvrApi.usingVrDisplayService()) {
                    addScanlineRacingView();
                }
                return true;
            }
        } else {
            throw new IllegalStateException("Async reprojection may only be enabled from the UI thread");
        }
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("The Cardboard trigger listener must not be null.");
        } else if (this.cardboardEmulator != null) {
            return true;
        } else {
            if (!this.daydreamUtils.isDaydreamPhone(getContext())) {
                return false;
            }
            this.cardboardEmulator = new CardboardEmulator(getContext(), runnable);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public FadeOverlayView getFadeOverlayView() {
        return this.fadeOverlayView;
    }

    public GvrApi getGvrApi() {
        return this.gvrApi;
    }

    public GvrUiLayoutImpl getUiLayoutImpl() {
        return this.uiLayout;
    }

    /* access modifiers changed from: package-private */
    public VrCoreSdkClient getVrCoreSdkClient() {
        return this.vrCoreSdkClient;
    }

    /* access modifiers changed from: package-private */
    public boolean isPresenting() {
        PresentationHelper presentationHelper2;
        return (this.presentationView == null || (presentationHelper2 = this.presentationHelper) == null || !presentationHelper2.isPresenting()) ? false : true;
    }

    public void onBackPressed() {
        this.uiLayout.invokeCloseButtonListener();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.displaySynchronizer.e();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PresentationHelper presentationHelper2 = this.presentationHelper;
        if (presentationHelper2 != null) {
            presentationHelper2.onDetachedFromWindow();
        }
    }

    public void onPause() {
        VrCoreSdkClient vrCoreSdkClient2;
        if (!(this.extensionManager == null || (vrCoreSdkClient2 = this.vrCoreSdkClient) == null || vrCoreSdkClient2.getLoggingService() == null)) {
            this.extensionManager.reportTelemetry(this.vrCoreSdkClient.getLoggingService());
        }
        this.gvrApi.pause();
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            asyncReprojectionSurfaceView.queueEvent(new Runnable() {
                /* class com.google.vr.ndk.base.GvrLayoutImpl.AnonymousClass3 */

                public void run() {
                    GvrLayoutImpl.this.scanlineRacingRenderer.c();
                }
            });
            this.scanlineRacingView.onPause();
        }
        PresentationHelper presentationHelper2 = this.presentationHelper;
        if (presentationHelper2 != null) {
            presentationHelper2.onPause();
        }
        this.displaySynchronizer.f();
        VrCoreSdkClient vrCoreSdkClient3 = this.vrCoreSdkClient;
        if (vrCoreSdkClient3 != null) {
            vrCoreSdkClient3.onPause();
        }
        CardboardEmulator cardboardEmulator2 = this.cardboardEmulator;
        if (cardboardEmulator2 != null) {
            cardboardEmulator2.onPause();
        }
        ExtensionManager extensionManager2 = this.extensionManager;
        if (extensionManager2 != null) {
            extensionManager2.onPause();
        }
        this.screenOnManager.onPause();
        this.isResumed = false;
        updateFadeVisibility();
    }

    public void onResume() {
        this.gvrApi.resume();
        SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
        if (sdkDaydreamTouchListener != null) {
            sdkDaydreamTouchListener.refreshViewerProfile();
        }
        this.displaySynchronizer.g();
        PresentationHelper presentationHelper2 = this.presentationHelper;
        if (presentationHelper2 != null) {
            presentationHelper2.onResume();
        }
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            asyncReprojectionSurfaceView.onResume();
        }
        VrCoreSdkClient vrCoreSdkClient2 = this.vrCoreSdkClient;
        if (vrCoreSdkClient2 != null) {
            vrCoreSdkClient2.onResume();
        }
        if (this.cardboardEmulator != null && this.gvrApi.getViewerType() == 1) {
            this.cardboardEmulator.onResume();
        }
        ExtensionManager extensionManager2 = this.extensionManager;
        if (extensionManager2 != null) {
            extensionManager2.onResume();
        }
        this.screenOnManager.onResume();
        this.frameFlushWorkaround.onResume();
        this.isResumed = true;
        updateFadeVisibility();
        updateUiLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.presentationView == null || !isPresenting() || !this.presentationView.dispatchTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        updateFadeVisibility();
    }

    public void setPresentationView(View view) {
        View view2 = this.presentationView;
        if (view2 != null) {
            this.presentationLayout.removeView(view2);
        }
        this.presentationLayout.addView(view, 0);
        this.presentationView = view;
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        VrCoreSdkClient vrCoreSdkClient2 = this.vrCoreSdkClient;
        if (vrCoreSdkClient2 != null) {
            vrCoreSdkClient2.setReentryIntent(pendingIntent);
        }
    }

    public void setStereoModeEnabled(boolean z) {
        if (this.stereoModeEnabled != z) {
            this.stereoModeEnabled = z;
            this.uiLayout.setEnabled(z);
            VrCoreSdkClient vrCoreSdkClient2 = this.vrCoreSdkClient;
            if (vrCoreSdkClient2 != null) {
                vrCoreSdkClient2.setEnabled(z);
            }
            FadeOverlayView fadeOverlayView2 = this.fadeOverlayView;
            if (fadeOverlayView2 != null) {
                fadeOverlayView2.setEnabled(z);
            }
            SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
            if (sdkDaydreamTouchListener != null) {
                sdkDaydreamTouchListener.setEnabled(z);
            }
            this.screenOnManager.setEnabled(z);
            updateRenderingViewsVisibility(0);
        }
    }

    public void shutdown() {
        this.displaySynchronizer.i();
        SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
        if (sdkDaydreamTouchListener != null) {
            sdkDaydreamTouchListener.shutdown();
        }
        removeView(this.presentationLayout);
        removeView(this.uiLayout.getRoot());
        this.scanlineRacingRenderer = null;
        ExternalSurface externalSurface = this.videoSurface;
        if (externalSurface != null) {
            externalSurface.shutdown();
            this.videoSurface = null;
        }
        this.scanlineRacingView = null;
        this.presentationView = null;
        PresentationHelper presentationHelper2 = this.presentationHelper;
        if (presentationHelper2 != null) {
            presentationHelper2.shutdown();
            this.presentationHelper = null;
        }
        VrCoreSdkClient vrCoreSdkClient2 = this.vrCoreSdkClient;
        if (vrCoreSdkClient2 != null) {
            vrCoreSdkClient2.onPause();
            this.vrCoreSdkClient = null;
        }
        CardboardEmulator cardboardEmulator2 = this.cardboardEmulator;
        if (cardboardEmulator2 != null) {
            cardboardEmulator2.onPause();
            this.cardboardEmulator = null;
        }
        ExtensionManager extensionManager2 = this.extensionManager;
        if (extensionManager2 != null) {
            extensionManager2.shutdown();
            this.extensionManager = null;
        }
        GvrApi gvrApi2 = this.gvrApi;
        if (gvrApi2 != null) {
            gvrApi2.shutdown();
            this.gvrApi = null;
        }
    }

    public GvrLayoutImpl(Context context, ExtensionManager extensionManager2) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() {
            /* class com.google.vr.ndk.base.GvrLayoutImpl.AnonymousClass1 */

            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        if ((context instanceof vw2) || hn.a(context) != null) {
            init(extensionManager2);
            return;
        }
        throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
    }

    GvrLayoutImpl(Context context, GvrApi gvrApi2, DisplaySynchronizer displaySynchronizer2, EglReadyListener eglReadyListener2, FadeOverlayView fadeOverlayView2, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager2) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() {
            /* class com.google.vr.ndk.base.GvrLayoutImpl.AnonymousClass1 */

            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        initWithInjectedObjects(gvrApi2, displaySynchronizer2, eglReadyListener2, fadeOverlayView2, daydreamUtilsWrapper, extensionManager2);
    }
}
