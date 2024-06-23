package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import com.youku.live.livesdk.wkit.component.Constants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.util.ViewUtils;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class FlutterActivityAndFragmentDelegate implements ExclusiveAppComponent<Activity> {
    private static final int FLUTTER_SPLASH_VIEW_FALLBACK_ID = 486947586;
    private static final String FRAMEWORK_RESTORATION_BUNDLE_KEY = "framework";
    private static final String PLUGINS_RESTORATION_BUNDLE_KEY = "plugins";
    private static final String TAG = "FlutterActivityAndFragmentDelegate";
    @Nullable
    @VisibleForTesting
    ViewTreeObserver.OnPreDrawListener activePreDrawListener;
    @Nullable
    private FlutterEngine flutterEngine;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() {
        /* class io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiDisplayed();
            FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed = true;
            FlutterActivityAndFragmentDelegate.this.isFirstFrameRendered = true;
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiNoLongerDisplayed();
            FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed = false;
        }
    };
    @Nullable
    private FlutterView flutterView;
    @NonNull
    private Host host;
    private boolean isFirstFrameRendered;
    private boolean isFlutterEngineFromHost;
    private boolean isFlutterUiDisplayed;
    @Nullable
    private PlatformPlugin platformPlugin;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider, PlatformPlugin.PlatformPluginDelegate {
        @Override // io.flutter.embedding.android.FlutterEngineConfigurator
        void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

        @Override // io.flutter.embedding.android.FlutterEngineConfigurator
        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void detachFromFlutterEngine();

        @Nullable
        Activity getActivity();

        @NonNull
        String getAppBundlePath();

        @Nullable
        String getCachedEngineId();

        @NonNull
        Context getContext();

        @NonNull
        String getDartEntrypointFunctionName();

        @NonNull
        FlutterShellArgs getFlutterShellArgs();

        @Nullable
        String getInitialRoute();

        @NonNull
        Lifecycle getLifecycle();

        @NonNull
        RenderMode getRenderMode();

        @NonNull
        TransparencyMode getTransparencyMode();

        void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView);

        void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView);

        void onFlutterUiDisplayed();

        void onFlutterUiNoLongerDisplayed();

        @Override // io.flutter.embedding.android.FlutterEngineProvider
        @Nullable
        FlutterEngine provideFlutterEngine(@NonNull Context context);

        @Nullable
        PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine);

        @Override // io.flutter.embedding.android.SplashScreenProvider
        @Nullable
        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();

        @Nullable
        boolean shouldHandleDeeplinking();

        boolean shouldRestoreAndSaveState();
    }

    FlutterActivityAndFragmentDelegate(@NonNull Host host2) {
        this.host = host2;
        this.isFirstFrameRendered = false;
    }

    private void delayFirstAndroidViewDraw(final FlutterView flutterView2) {
        if (this.host.getRenderMode() == RenderMode.surface) {
            if (this.activePreDrawListener != null) {
                flutterView2.getViewTreeObserver().removeOnPreDrawListener(this.activePreDrawListener);
            }
            this.activePreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                /* class io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.AnonymousClass2 */

                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed && FlutterActivityAndFragmentDelegate.this.activePreDrawListener != null) {
                        flutterView2.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate.this.activePreDrawListener = null;
                    }
                    return FlutterActivityAndFragmentDelegate.this.isFlutterUiDisplayed;
                }
            };
            flutterView2.getViewTreeObserver().addOnPreDrawListener(this.activePreDrawListener);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    private void doInitialFlutterViewRun() {
        if (this.host.getCachedEngineId() == null && !this.flutterEngine.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.host.getInitialRoute();
            if (initialRoute == null && (initialRoute = maybeGetInitialRouteFromIntent(this.host.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.v(TAG, "Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.host.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.host.getDartEntrypointFunctionName()));
        }
    }

    private void ensureAlive() {
        if (this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String maybeGetInitialRouteFromIntent(Intent intent) {
        Uri data;
        if (!this.host.shouldHandleDeeplinking() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
            return null;
        }
        String path = data.getPath();
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + data.getFragment();
    }

    @Override // io.flutter.embedding.android.ExclusiveAppComponent
    public void detachFromFlutterEngine() {
        if (!this.host.shouldDestroyEngineWithHost()) {
            this.host.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.host + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.flutterEngine;
    }

    /* access modifiers changed from: package-private */
    public boolean isFlutterEngineFromHost() {
        return this.isFlutterEngineFromHost;
    }

    /* access modifiers changed from: package-private */
    public void onActivityResult(int i, int i2, Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.flutterEngine.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.w(TAG, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    public void onAttach(@NonNull Context context) {
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        ensureAlive();
        if (this.flutterEngine == null) {
            setupFlutterEngine();
        }
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.flutterEngine.getActivityControlSurface().attachToActivity(this, this.host.getLifecycle());
        }
        Host host2 = this.host;
        this.platformPlugin = host2.providePlatformPlugin(host2.getActivity(), this.flutterEngine);
        this.host.configureFlutterEngine(this.flutterEngine);
        Trace.endSection();
    }

    /* access modifiers changed from: package-private */
    public void onBackPressed() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onBackPressed() to FlutterEngine.");
            this.flutterEngine.getNavigationChannel().popRoute();
            return;
        }
        Log.w(TAG, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, int i, boolean z) {
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        Log.v(TAG, "Creating FlutterView.");
        ensureAlive();
        boolean z2 = true;
        if (this.host.getRenderMode() == RenderMode.surface) {
            Context context = this.host.getContext();
            if (this.host.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.host.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.flutterView = new FlutterView(this.host.getContext(), flutterSurfaceView);
        } else if (RenderSurface.Helper.suggestUseImageView()) {
            this.flutterView = new FlutterView(this.host.getActivity(), new FlutterImageView(this.host.getActivity()));
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.host.getContext());
            if (this.host.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.host.onFlutterTextureViewCreated(flutterTextureView);
            this.flutterView = new FlutterView(this.host.getContext(), flutterTextureView);
        }
        this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        Log.v(TAG, "Attaching FlutterEngine to FlutterView.");
        this.flutterView.attachToFlutterEngine(this.flutterEngine);
        this.flutterView.setId(i);
        SplashScreen provideSplashScreen = this.host.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.w(TAG, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView flutterSplashView = new FlutterSplashView(this.host.getContext());
            flutterSplashView.setId(ViewUtils.generateViewId(FLUTTER_SPLASH_VIEW_FALLBACK_ID));
            flutterSplashView.displayFlutterViewWithSplash(this.flutterView, provideSplashScreen);
            Trace.endSection();
            return flutterSplashView;
        }
        if (z) {
            delayFirstAndroidViewDraw(this.flutterView);
        }
        Trace.endSection();
        return this.flutterView;
    }

    /* access modifiers changed from: package-private */
    public void onDestroyView() {
        Log.v(TAG, "onDestroyView()");
        ensureAlive();
        if (this.activePreDrawListener != null) {
            this.flutterView.getViewTreeObserver().removeOnPreDrawListener(this.activePreDrawListener);
            this.activePreDrawListener = null;
        }
        this.flutterView.detachFromFlutterEngine();
        this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    }

    /* access modifiers changed from: package-private */
    public void onDetach() {
        Log.v(TAG, "onDetach()");
        ensureAlive();
        this.host.cleanUpFlutterEngine(this.flutterEngine);
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.host.getActivity().isChangingConfigurations()) {
                this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.flutterEngine.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin2 = this.platformPlugin;
        if (platformPlugin2 != null) {
            platformPlugin2.destroy();
            this.platformPlugin = null;
        }
        this.flutterEngine.getLifecycleChannel().appIsDetached();
        if (this.host.shouldDestroyEngineWithHost()) {
            this.flutterEngine.destroy();
            if (this.host.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.host.getCachedEngineId());
            }
            this.flutterEngine = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onLowMemory() {
        Log.v(TAG, "Forwarding onLowMemory() to FlutterEngine.");
        ensureAlive();
        this.flutterEngine.getDartExecutor().notifyLowMemoryWarning();
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        this.flutterEngine.getRenderer().onTrimMemory(80);
    }

    /* access modifiers changed from: package-private */
    public void onNewIntent(@NonNull Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            String maybeGetInitialRouteFromIntent = maybeGetInitialRouteFromIntent(intent);
            if (maybeGetInitialRouteFromIntent != null && !maybeGetInitialRouteFromIntent.isEmpty()) {
                this.flutterEngine.getNavigationChannel().pushRoute(maybeGetInitialRouteFromIntent);
                return;
            }
            return;
        }
        Log.w(TAG, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        Log.v(TAG, "onPause()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    public void onPostResume() {
        Log.v(TAG, "onPostResume()");
        ensureAlive();
        if (this.flutterEngine != null) {
            PlatformPlugin platformPlugin2 = this.platformPlugin;
            if (platformPlugin2 != null) {
                platformPlugin2.updateSystemUiOverlays();
                return;
            }
            return;
        }
        Log.w(TAG, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.w(TAG, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        Bundle bundle2;
        Log.v(TAG, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        ensureAlive();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(PLUGINS_RESTORATION_BUNDLE_KEY);
            bArr = bundle.getByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY);
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.host.shouldRestoreAndSaveState()) {
            this.flutterEngine.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.host.shouldAttachEngineToActivity()) {
            this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        Log.v(TAG, "onResume()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    public void onSaveInstanceState(@Nullable Bundle bundle) {
        Log.v(TAG, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        ensureAlive();
        if (this.host.shouldRestoreAndSaveState()) {
            bundle.putByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY, this.flutterEngine.getRestorationChannel().getRestorationData());
        }
        if (this.host.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.flutterEngine.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(PLUGINS_RESTORATION_BUNDLE_KEY, bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStart() {
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        Log.v(TAG, "onStart()");
        ensureAlive();
        doInitialFlutterViewRun();
        Trace.endSection();
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        Log.v(TAG, "onStop()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    public void onTrimMemory(int i) {
        ensureAlive();
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            boolean z = true;
            if (!this.isFirstFrameRendered ? i < 15 : i < 10) {
                z = false;
            }
            if (z) {
                flutterEngine2.getDartExecutor().notifyLowMemoryWarning();
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
            }
        }
        this.flutterEngine.getRenderer().onTrimMemory(i);
    }

    /* access modifiers changed from: package-private */
    public void onUserLeaveHint() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w(TAG, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    public void release() {
        this.host = null;
        this.flutterEngine = null;
        this.flutterView = null;
        this.platformPlugin = null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setupFlutterEngine() {
        Log.v(TAG, "Setting up FlutterEngine.");
        String cachedEngineId = this.host.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine2 = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.flutterEngine = flutterEngine2;
            this.isFlutterEngineFromHost = true;
            if (flutterEngine2 == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host2 = this.host;
        FlutterEngine provideFlutterEngine = host2.provideFlutterEngine(host2.getContext());
        this.flutterEngine = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.isFlutterEngineFromHost = true;
            return;
        }
        Log.v(TAG, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false, this.host.shouldRestoreAndSaveState());
        this.isFlutterEngineFromHost = false;
    }

    @Override // io.flutter.embedding.android.ExclusiveAppComponent
    @NonNull
    public Activity getAppComponent() {
        Activity activity = this.host.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }
}
