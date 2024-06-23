package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

@Deprecated
/* compiled from: Taobao */
public class FlutterActivity extends Activity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {
    private static final String TAG = "FlutterActivity";
    private final FlutterActivityDelegate delegate;
    private final FlutterActivityEvents eventDelegate;
    private final PluginRegistry pluginRegistry;
    private final FlutterView.Provider viewProvider;

    public FlutterActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public FlutterView createFlutterView(Context context) {
        return null;
    }

    @Override // io.flutter.view.FlutterView.Provider
    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.eventDelegate.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.eventDelegate.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.eventDelegate.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eventDelegate.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.eventDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.eventDelegate.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.eventDelegate.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.eventDelegate.onStop();
        super.onStop();
    }

    public void onTrimMemory(int i) {
        this.eventDelegate.onTrimMemory(i);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    @Override // io.flutter.app.FlutterActivityDelegate.ViewFactory
    public boolean retainFlutterNativeView() {
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public final <T> T valuePublishedByPlugin(String str) {
        return (T) this.pluginRegistry.valuePublishedByPlugin(str);
    }
}
