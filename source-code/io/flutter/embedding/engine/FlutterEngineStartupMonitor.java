package io.flutter.embedding.engine;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.stat.StatsUtil;
import io.flutter.wpkbridge.WPKStatsUtil;

/* compiled from: Taobao */
public class FlutterEngineStartupMonitor implements DartExecutor.DartExecutingListener, FlutterRenderer.FlutterRenderingListener, FlutterUiDisplayListener {
    private static final String TAG = "FlutterEngineStartupMonitor";
    private static final String WPK_BID = "ucfe";
    private static boolean firstTimeExecuteDartEntrypoint = true;
    private static boolean firstTimeFirstFrame = true;
    private static boolean firstTimeFlutterEngineConstruct = true;
    private static boolean firstTimeStartRenderingToSurface = true;
    @NonNull
    private final DartExecutor dartExecutor;
    private final long engineStartupTimestamp;
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final FlutterRenderer flutterRenderer;
    private long startRenderingToSurfaceTimestamp;
    private StatsUtil.startup_perf waStat = new StatsUtil.startup_perf();
    private final boolean wpk_should_sample;

    public FlutterEngineStartupMonitor(long j, @NonNull DartExecutor dartExecutor2, @NonNull FlutterJNI flutterJNI2, @NonNull FlutterRenderer flutterRenderer2) {
        this.engineStartupTimestamp = j;
        this.dartExecutor = dartExecutor2;
        this.flutterJNI = flutterJNI2;
        this.flutterRenderer = flutterRenderer2;
        dartExecutor2.registerDartExecutingListener(this);
        flutterRenderer2.addIsDisplayingFlutterUiListener(this);
        flutterRenderer2.registerFlutterRenderingListener(this);
        this.wpk_should_sample = WPKStatsUtil.shouldSample(WPK_BID, WPKStatsUtil.WPK_CONFIG_STARTUP_SAMPLE_RATE, 50.0d);
    }

    @Override // io.flutter.embedding.engine.dart.DartExecutor.DartExecutingListener
    public void onExecuteDartEntrypoint() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.engineStartupTimestamp;
        Log.i(TAG, "entry-point(ms):" + uptimeMillis + " firstTimeExecuteDartEntrypoint=" + firstTimeExecuteDartEntrypoint);
        if (this.wpk_should_sample) {
            WPKStatsUtil.WPKCustomLogInfo wPKCustomLogInfo = new WPKStatsUtil.WPKCustomLogInfo();
            wPKCustomLogInfo.bid = WPK_BID;
            wPKCustomLogInfo.category = 101;
            wPKCustomLogInfo.msg = "ExecuteDartEntrypoint";
            wPKCustomLogInfo.avgv1 = uptimeMillis;
            boolean z = firstTimeExecuteDartEntrypoint;
            wPKCustomLogInfo.succ = z;
            wPKCustomLogInfo.c1 = z ? "1" : "0";
            WPKStatsUtil.commitCustomRecord(wPKCustomLogInfo, "", "");
        }
        StatsUtil.startup_perf startup_perf = this.waStat;
        startup_perf.ede = uptimeMillis;
        startup_perf.ftede = firstTimeExecuteDartEntrypoint ? 1 : 0;
        firstTimeExecuteDartEntrypoint = false;
        this.dartExecutor.unRegisterDartExecutingListener();
    }

    public void onFlutterEngineConstructed() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.engineStartupTimestamp;
        Log.i(TAG, "startup(ms):" + uptimeMillis + " firstTimeFlutterEngineConstruct=" + firstTimeFlutterEngineConstruct);
        if (this.wpk_should_sample) {
            WPKStatsUtil.WPKCustomLogInfo wPKCustomLogInfo = new WPKStatsUtil.WPKCustomLogInfo();
            wPKCustomLogInfo.bid = WPK_BID;
            wPKCustomLogInfo.category = 100;
            wPKCustomLogInfo.msg = "FlutterEngineConstructed";
            wPKCustomLogInfo.avgv1 = uptimeMillis;
            boolean z = firstTimeFlutterEngineConstruct;
            wPKCustomLogInfo.succ = z;
            wPKCustomLogInfo.c1 = z ? "1" : "0";
            WPKStatsUtil.commitCustomRecord(wPKCustomLogInfo, "", "");
        }
        StatsUtil.startup_perf startup_perf = this.waStat;
        startup_perf.fec = uptimeMillis;
        startup_perf.ftfec = firstTimeFlutterEngineConstruct ? 1 : 0;
        firstTimeFlutterEngineConstruct = false;
    }

    @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
    public void onFlutterUiDisplayed() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.startRenderingToSurfaceTimestamp;
        String currentRouteName = this.flutterJNI.getCurrentRouteName();
        Log.i(TAG, "first-frame(ms):" + uptimeMillis + " firstTimeFirstFrame=" + firstTimeFirstFrame + " routeName=" + currentRouteName);
        if (this.wpk_should_sample) {
            WPKStatsUtil.WPKCustomLogInfo wPKCustomLogInfo = new WPKStatsUtil.WPKCustomLogInfo();
            wPKCustomLogInfo.url = currentRouteName;
            wPKCustomLogInfo.bid = WPK_BID;
            wPKCustomLogInfo.category = 102;
            wPKCustomLogInfo.msg = "FirstFrame";
            wPKCustomLogInfo.avgv1 = uptimeMillis;
            boolean z = firstTimeFirstFrame;
            wPKCustomLogInfo.succ = z;
            wPKCustomLogInfo.c1 = z ? "1" : "0";
            WPKStatsUtil.commitCustomRecord(wPKCustomLogInfo, "", "");
        }
        StatsUtil.startup_perf startup_perf = this.waStat;
        startup_perf.ff = uptimeMillis;
        startup_perf.ftff = firstTimeFirstFrame ? 1 : 0;
        startup_perf.route = currentRouteName;
        startup_perf.commit();
        firstTimeFirstFrame = false;
        this.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
    }

    @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
    public void onFlutterUiNoLongerDisplayed() {
    }

    @Override // io.flutter.embedding.engine.renderer.FlutterRenderer.FlutterRenderingListener
    public void onStartRenderingToSurface() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.startRenderingToSurfaceTimestamp = uptimeMillis;
        long j = uptimeMillis - this.engineStartupTimestamp;
        Log.i(TAG, "surface(ms):" + j + " firstTimeStartRenderingToSurface=" + firstTimeStartRenderingToSurface);
        if (this.wpk_should_sample) {
            WPKStatsUtil.WPKCustomLogInfo wPKCustomLogInfo = new WPKStatsUtil.WPKCustomLogInfo();
            wPKCustomLogInfo.bid = WPK_BID;
            wPKCustomLogInfo.category = 104;
            wPKCustomLogInfo.msg = "StartRenderingToSurface";
            wPKCustomLogInfo.avgv1 = j;
            boolean z = firstTimeStartRenderingToSurface;
            wPKCustomLogInfo.succ = z;
            wPKCustomLogInfo.c1 = z ? "1" : "0";
            WPKStatsUtil.commitCustomRecord(wPKCustomLogInfo, "", "");
        }
        StatsUtil.startup_perf startup_perf = this.waStat;
        startup_perf.sr = j;
        startup_perf.ftsr = firstTimeStartRenderingToSurface ? 1 : 0;
        firstTimeStartRenderingToSurface = false;
        this.flutterRenderer.unRegisterFlutterRenderingListener();
    }
}
