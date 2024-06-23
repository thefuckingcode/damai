package io.flutter.embedding.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.UCBuildFlags;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.PlatformViewDisplayListener;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class FlutterEngine {
    private static final String TAG = "FlutterEngine";
    static Map<byte[], ExtendImageDecoder> extendDecoders = new HashMap();
    @NonNull
    private final AccessibilityChannel accessibilityChannel;
    private Context appContext;
    @NonNull
    private final DartExecutor dartExecutor;
    @NonNull
    private final DeferredComponentChannel deferredComponentChannel;
    @NonNull
    private final EngineLifecycleListener engineLifecycleListener;
    @NonNull
    private final Set<EngineLifecycleListener> engineLifecycleListeners;
    @Nullable
    private final FlutterEngineStartupMonitor flutterEngineStartupMonitor;
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final KeyEventChannel keyEventChannel;
    @NonNull
    private final LifecycleChannel lifecycleChannel;
    @NonNull
    private final LocalizationChannel localizationChannel;
    @NonNull
    private final LocalizationPlugin localizationPlugin;
    @NonNull
    private final MouseCursorChannel mouseCursorChannel;
    @NonNull
    private final NavigationChannel navigationChannel;
    @NonNull
    private final PlatformChannel platformChannel;
    private final PlatformViewDisplayListener platformViewDisplayListener;
    @NonNull
    private final PlatformViewsController platformViewsController;
    @NonNull
    private final FlutterEngineConnectionRegistry pluginRegistry;
    @NonNull
    private final FlutterRenderer renderer;
    @NonNull
    private final RestorationChannel restorationChannel;
    private final ScreenObserver screenObserver;
    @NonNull
    private final SettingsChannel settingsChannel;
    @NonNull
    private final SkiaChannel skiaChannel;
    @NonNull
    private final SystemChannel systemChannel;
    @NonNull
    private final TextInputChannel textInputChannel;

    /* compiled from: Taobao */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    /* compiled from: Taobao */
    public static class ExtendImageDecoder {
        public void decodeImageAsync(@NonNull ByteBuffer byteBuffer, String str, @NonNull ExtendImageDecoderResponser extendImageDecoderResponser, boolean z) {
        }

        public void decodeImageSync(@NonNull ByteBuffer byteBuffer, String str, @NonNull ExtendImageDecoderResponser extendImageDecoderResponser, boolean z) {
        }

        public int fallbackAlphaType() {
            return 0;
        }

        public Bitmap fallbackBitmap() {
            return null;
        }

        public long fallbackBitmapDelayMillis() {
            return 2000;
        }

        public boolean fallbackCanCache() {
            return false;
        }

        public boolean fallbackCanRecycle() {
            return false;
        }

        public int fallbackColorType() {
            return 0;
        }

        public long fallbackHeaderDelayMillis() {
            return 200;
        }

        public int fallbackHeight() {
            if (fallbackBitmap() != null) {
                return fallbackBitmap().getHeight();
            }
            return -1;
        }

        public int fallbackWidth() {
            if (fallbackBitmap() != null) {
                return fallbackBitmap().getWidth();
            }
            return -1;
        }

        public boolean preferAsync() {
            return false;
        }

        public boolean preferIgnoreException() {
            return false;
        }

        public boolean preferSync() {
            return false;
        }

        public boolean supportAsync() {
            return false;
        }

        public boolean supportSync() {
            return false;
        }
    }

    /* compiled from: Taobao */
    public static class ExtendImageDecoderHeaderResponser {
        private static final Handler kMainHandler = new Handler(Looper.getMainLooper());
        protected int fallbackAlphaType;
        protected int fallbackColorType;
        protected int fallbackHeight;
        protected int fallbackWidth;
        protected long imageGeneratorAddress;

        public ExtendImageDecoderHeaderResponser(long j, int i, int i2, int i3, int i4) {
            this.imageGeneratorAddress = j;
            this.fallbackWidth = i;
            this.fallbackHeight = i2;
            this.fallbackColorType = i3;
            this.fallbackAlphaType = i4;
        }

        public void fallbackIfNeeded(long j) {
            if (shouldFallback()) {
                if (j == 0) {
                    onFallback();
                } else {
                    kMainHandler.postDelayed(new Runnable() {
                        /* class io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoderHeaderResponser.AnonymousClass1 */

                        public void run() {
                            ExtendImageDecoderHeaderResponser.this.onFallback();
                        }
                    }, j);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFallback() {
            onHeaderReadyFallback();
        }

        public void onHeaderReady(int i, int i2, int i3, int i4) {
            if (this.imageGeneratorAddress != 0) {
                synchronized (this) {
                    long j = this.imageGeneratorAddress;
                    if (j != 0) {
                        FlutterJNI.nativeExtendImageDecoderOnHeaderReady(j, i, i2, i3, i4);
                        this.imageGeneratorAddress = 0;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onHeaderReadyFallback() {
            if (this.imageGeneratorAddress != 0) {
                onHeaderReady(this.fallbackWidth, this.fallbackHeight, this.fallbackColorType, this.fallbackAlphaType);
            }
        }

        /* access modifiers changed from: protected */
        public boolean shouldFallback() {
            return this.imageGeneratorAddress != 0;
        }
    }

    /* compiled from: Taobao */
    static class ExtendImageDecoderPlatform extends ExtendImageDecoder {
        ExtendImageDecoderPlatform() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoder
        public void decodeImageSync(@NonNull ByteBuffer byteBuffer, String str, @NonNull ExtendImageDecoderResponser extendImageDecoderResponser, boolean z) {
            int i;
            int i2;
            Exception e;
            BitmapFactory.Options options;
            Bitmap bitmap;
            int i3 = -1;
            Bitmap bitmap2 = null;
            if (Build.VERSION.SDK_INT >= 1) {
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = z;
                    if (str == null || str.isEmpty()) {
                        bitmap = BitmapFactory.decodeStream(new ByteBufferBackedInputStream(byteBuffer), null, options);
                    } else {
                        bitmap = BitmapFactory.decodeFile(str, options);
                    }
                    i2 = options.outWidth;
                } catch (Exception e2) {
                    e = e2;
                    i2 = -1;
                    Log.e(FlutterEngine.TAG, "Failed to decode image", e);
                    i3 = i2;
                    i = -1;
                    extendImageDecoderResponser.onHeaderReady(i3, i, 0, 0);
                    if (z) {
                    }
                }
                try {
                    bitmap2 = bitmap;
                    i = options.outHeight;
                    i3 = i2;
                } catch (Exception e3) {
                    e = e3;
                    Log.e(FlutterEngine.TAG, "Failed to decode image", e);
                    i3 = i2;
                    i = -1;
                    extendImageDecoderResponser.onHeaderReady(i3, i, 0, 0);
                    if (z) {
                    }
                }
                extendImageDecoderResponser.onHeaderReady(i3, i, 0, 0);
                if (z) {
                    extendImageDecoderResponser.onBitmapReady(bitmap2, true, false);
                    return;
                }
                return;
            }
            i = -1;
            extendImageDecoderResponser.onHeaderReady(i3, i, 0, 0);
            if (z) {
            }
        }

        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoder
        public boolean preferIgnoreException() {
            return true;
        }

        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoder
        public boolean preferSync() {
            return true;
        }

        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoder
        public boolean supportSync() {
            return true;
        }
    }

    /* compiled from: Taobao */
    public static class ExtendImageDecoderResponser extends ExtendImageDecoderHeaderResponser {
        protected long callbackAddress;
        protected Bitmap fallbackBitmap;
        protected boolean fallbackCanCache;
        protected boolean fallbackCanRecycle;

        public ExtendImageDecoderResponser(long j, long j2, int i, int i2, int i3, int i4, Bitmap bitmap, boolean z, boolean z2) {
            super(j, i, i2, i3, i4);
            this.callbackAddress = j2;
            this.fallbackBitmap = bitmap;
            this.fallbackCanRecycle = z;
            this.fallbackCanCache = z2;
        }

        public void onBitmapReady(Bitmap bitmap, boolean z, boolean z2) {
            if (this.callbackAddress != 0 || (this.imageGeneratorAddress != 0 && z2)) {
                synchronized (this) {
                    long j = this.callbackAddress;
                    if (j != 0 || (this.imageGeneratorAddress != 0 && z2)) {
                        FlutterJNI.nativeExtendImageDecoderOnBitmapReady(j, this.imageGeneratorAddress, bitmap, z, z2);
                        this.callbackAddress = 0;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onBitmapReadyFallback() {
            if (this.callbackAddress != 0) {
                onBitmapReady(this.fallbackBitmap, this.fallbackCanRecycle, this.fallbackCanCache);
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoderHeaderResponser
        public void onFallback() {
            onHeaderReadyFallback();
            onBitmapReadyFallback();
        }

        /* access modifiers changed from: protected */
        @Override // io.flutter.embedding.engine.FlutterEngine.ExtendImageDecoderHeaderResponser
        public boolean shouldFallback() {
            return this.callbackAddress != 0 || super.shouldFallback();
        }
    }

    /* compiled from: Taobao */
    public class ScreenObserver extends BroadcastReceiver {
        public ScreenObserver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                FlutterEngine.this.getSystemChannel().sendApplicationDidEnterBackground();
            }
        }
    }

    /* compiled from: Taobao */
    public class SkiaChannel {
        private static final String TAG = "SkiaChannel";
        @NonNull
        public final BasicMessageChannel<Object> channel;

        public SkiaChannel(@NonNull DartExecutor dartExecutor) {
            this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/skia", JSONMessageCodec.INSTANCE);
        }

        public void addExtImageDecoder(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 == null) {
                    str2 = "";
                }
                Log.v(TAG, "Sending Ext heif decoder path to Flutter.");
                HashMap hashMap = new HashMap(3);
                hashMap.put("method", "Skia.addExtImageDecoder");
                hashMap.put("args", str + ":" + str2);
                this.channel.send(hashMap);
            }
        }
    }

    public FlutterEngine(@NonNull Context context) {
        this(context, null);
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative(false);
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    public static ExtendImageDecoder findExtendImageDecoder(@NonNull ByteBuffer byteBuffer) {
        try {
            if (extendDecoders.isEmpty()) {
                return null;
            }
            ExtendImageDecoder extendImageDecoder = null;
            for (Map.Entry<byte[], ExtendImageDecoder> entry : extendDecoders.entrySet()) {
                byte[] key = entry.getKey();
                if (key.length == 0) {
                    extendImageDecoder = entry.getValue();
                } else {
                    int length = key.length;
                    byte[] bArr = new byte[length];
                    try {
                        byteBuffer.get(bArr, 0, length);
                        byteBuffer.rewind();
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    ExtendImageDecoder value = (bArr == null || !Arrays.equals(key, bArr)) ? null : entry.getValue();
                    if (value != null) {
                        return value;
                    }
                }
            }
            return extendImageDecoder;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAionFrameworkVersion() {
        return UCBuildFlags.AION_FRAMEWORK_VERSION;
    }

    public static String getBuildTimestamp() {
        return UCBuildFlags.BUILD_TIMESTAMP;
    }

    public static String getEngineVersion() {
        return UCBuildFlags.FLUTTER_ENGINE_VERSION;
    }

    public static String getUCEngineVersion() {
        return UCBuildFlags.UC_ENGINE_VERSION;
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    public static void setExtendImageDecoder(@NonNull byte[] bArr, @NonNull ExtendImageDecoder extendImageDecoder) {
        extendDecoders.put(bArr, extendImageDecoder);
    }

    public void addEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.add(engineLifecycleListener2);
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        Context context = this.appContext;
        if (context != null) {
            context.unregisterReceiver(this.screenObserver);
            this.appContext = null;
        }
        for (EngineLifecycleListener engineLifecycleListener2 : this.engineLifecycleListeners) {
            engineLifecycleListener2.onEngineWillDestroy();
        }
        this.renderer.removePlatformViewDisplayListener(this.platformViewDisplayListener);
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.setDeferredComponentManager(null);
        this.flutterJNI.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.deferredComponentChannel.setDeferredComponentManager(null);
        }
    }

    @NonNull
    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    @NonNull
    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    @NonNull
    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.deferredComponentChannel;
    }

    @NonNull
    public KeyEventChannel getKeyEventChannel() {
        return this.keyEventChannel;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    @NonNull
    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    @NonNull
    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    @NonNull
    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    @NonNull
    public SkiaChannel getSkiaChannel() {
        return this.skiaChannel;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.remove(engineLifecycleListener2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FlutterEngine spawn(@NonNull Context context, @NonNull DartExecutor.DartEntrypoint dartEntrypoint) {
        if (isAttachedToJni()) {
            return new FlutterEngine(context, (FlutterLoader) null, this.flutterJNI.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary));
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public void startPreRendering(@NonNull Context context, @NonNull FlutterRenderer.ViewportMetrics viewportMetrics) {
        startPreRendering(context, viewportMetrics, new FlutterView(context, new FlutterImageView(context, viewportMetrics.width, viewportMetrics.height, FlutterImageView.SurfaceKind.preRender)), true);
    }

    /* compiled from: Taobao */
    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (!this.buf.hasRemaining()) {
                return -1;
            }
            return this.buf.get() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.buf.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.buf.remaining());
            this.buf.get(bArr, i, min);
            return min;
        }
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, null, null, strArr, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z) {
        this(context, null, null, strArr, z);
    }

    public void startPreRendering(@NonNull Context context, @NonNull FlutterRenderer.ViewportMetrics viewportMetrics, @NonNull FlutterView flutterView) {
        startPreRendering(context, viewportMetrics, flutterView, false);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z, boolean z2) {
        this(context, null, null, new PlatformViewsController(), strArr, z, z2);
    }

    private void startPreRendering(@NonNull Context context, @NonNull FlutterRenderer.ViewportMetrics viewportMetrics, @NonNull FlutterView flutterView, boolean z) {
        if (viewportMetrics.width <= 0 || viewportMetrics.height <= 0) {
            Log.e(TAG, "Invalid viewport size for pre-rendering: " + viewportMetrics.width + "," + viewportMetrics.height);
        } else if (!flutterView.isSurfaceAvailableForRendering()) {
            Log.e(TAG, "None surface is available for pre-rendering.");
        } else {
            Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
            flutterView.setupViewportMetrics(viewportMetrics);
            if (z) {
                flutterView.attachToFlutterEngineForPreRendering(this);
            } else {
                flutterView.attachToFlutterEngine(this);
            }
            Trace.endSection();
        }
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2) {
        this(context, flutterLoader, flutterJNI2, null, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @NonNull PlatformViewsController platformViewsController2, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, platformViewsController2, strArr, z, false);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @NonNull PlatformViewsController platformViewsController2, @Nullable String[] strArr, boolean z, boolean z2) {
        AssetManager assetManager;
        this.appContext = null;
        this.screenObserver = new ScreenObserver();
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() {
            /* class io.flutter.embedding.engine.FlutterEngine.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener engineLifecycleListener : FlutterEngine.this.engineLifecycleListeners) {
                    engineLifecycleListener.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }
        };
        this.platformViewDisplayListener = new PlatformViewDisplayListener() {
            /* class io.flutter.embedding.engine.FlutterEngine.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.renderer.PlatformViewDisplayListener
            public void onBeginFrame() {
                FlutterEngine.this.getPlatformViewsController().onBeginFrame();
            }

            @Override // io.flutter.embedding.engine.renderer.PlatformViewDisplayListener
            public void onCancelFrame() {
                FlutterEngine.this.getPlatformViewsController().onCancelFrame();
            }

            @Override // io.flutter.embedding.engine.renderer.PlatformViewDisplayListener
            public void onPlatformViewDisplayedUpdated(int i, Rect rect, float f) {
                if (FlutterEngine.this.renderer.getRenderSurface() != null) {
                    FlutterEngine.this.renderer.getRenderSurface().setRenderTransparently(true);
                }
                FlutterEngine.this.getPlatformViewsController().onPlatformViewDisplayedUpdated(i, rect, f);
            }

            @Override // io.flutter.embedding.engine.renderer.PlatformViewDisplayListener
            public void onSubmitFrame() {
                if (FlutterEngine.this.getPlatformViewsController().onSubmitFrame() && FlutterEngine.this.renderer.getRenderSurface() != null) {
                    FlutterEngine.this.renderer.getRenderSurface().updateAndInvalidate();
                }
            }
        };
        long uptimeMillis = SystemClock.uptimeMillis();
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assetManager = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        FlutterJNI provideFlutterJNI = flutterJNI2 == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI2;
        this.flutterJNI = provideFlutterJNI;
        DartExecutor dartExecutor2 = new DartExecutor(provideFlutterJNI, assetManager);
        this.dartExecutor = dartExecutor2;
        dartExecutor2.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(dartExecutor2, provideFlutterJNI);
        DeferredComponentChannel deferredComponentChannel2 = new DeferredComponentChannel(dartExecutor2);
        this.deferredComponentChannel = deferredComponentChannel2;
        this.keyEventChannel = new KeyEventChannel(dartExecutor2);
        this.lifecycleChannel = new LifecycleChannel(dartExecutor2);
        LocalizationChannel localizationChannel2 = new LocalizationChannel(dartExecutor2);
        this.localizationChannel = localizationChannel2;
        this.mouseCursorChannel = new MouseCursorChannel(dartExecutor2);
        this.navigationChannel = new NavigationChannel(dartExecutor2);
        this.platformChannel = new PlatformChannel(dartExecutor2);
        this.restorationChannel = new RestorationChannel(dartExecutor2, z2);
        this.settingsChannel = new SettingsChannel(dartExecutor2);
        this.systemChannel = new SystemChannel(dartExecutor2);
        this.textInputChannel = new TextInputChannel(dartExecutor2);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(deferredComponentChannel2);
        }
        this.skiaChannel = new SkiaChannel(dartExecutor2);
        LocalizationPlugin localizationPlugin2 = new LocalizationPlugin(context, localizationChannel2);
        this.localizationPlugin = localizationPlugin2;
        FlutterLoader flutterLoader2 = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!provideFlutterJNI.isAttached()) {
            flutterLoader2.startInitialization(context.getApplicationContext());
            flutterLoader2.ensureInitializationComplete(context, strArr);
        }
        provideFlutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
        provideFlutterJNI.setPlatformViewsController(platformViewsController2);
        provideFlutterJNI.setLocalizationPlugin(localizationPlugin2);
        provideFlutterJNI.setDeferredComponentManager(instance.deferredComponentManager());
        if (!provideFlutterJNI.isAttached()) {
            attachToJni();
        }
        provideFlutterJNI.warmUpSkSL(assetManager);
        FlutterRenderer flutterRenderer = new FlutterRenderer(provideFlutterJNI);
        this.renderer = flutterRenderer;
        this.platformViewsController = platformViewsController2;
        platformViewsController2.onAttachedToJNI();
        flutterRenderer.addPlatformViewDisplayListener(this.platformViewDisplayListener);
        this.pluginRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader2);
        if (z && flutterLoader2.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        if (applicationContext != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.appContext.registerReceiver(this.screenObserver, intentFilter);
        }
        FlutterEngineStartupMonitor flutterEngineStartupMonitor2 = new FlutterEngineStartupMonitor(uptimeMillis, dartExecutor2, provideFlutterJNI, flutterRenderer);
        this.flutterEngineStartupMonitor = flutterEngineStartupMonitor2;
        flutterEngineStartupMonitor2.onFlutterEngineConstructed();
        Trace.endSection();
        setExtendImageDecoder("".getBytes(), new ExtendImageDecoderPlatform());
    }
}
