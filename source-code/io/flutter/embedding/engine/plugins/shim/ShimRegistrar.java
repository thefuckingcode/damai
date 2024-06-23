package io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
class ShimRegistrar implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar {
    private static final String TAG = "ShimRegistrar";
    private ActivityPluginBinding activityPluginBinding;
    private final Set<PluginRegistry.ActivityResultListener> activityResultListeners = new HashSet();
    private final Map<String, Object> globalRegistrarMap;
    private final Set<PluginRegistry.NewIntentListener> newIntentListeners = new HashSet();
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private final String pluginId;
    private final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners = new HashSet();
    private final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners = new HashSet();
    private final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners = new HashSet();

    public ShimRegistrar(@NonNull String str, @NonNull Map<String, Object> map) {
        this.pluginId = str;
        this.globalRegistrarMap = map;
    }

    private void addExistingListenersToActivityPluginBinding() {
        for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.requestPermissionsResultListeners) {
            this.activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        for (PluginRegistry.ActivityResultListener activityResultListener : this.activityResultListeners) {
            this.activityPluginBinding.addActivityResultListener(activityResultListener);
        }
        for (PluginRegistry.NewIntentListener newIntentListener : this.newIntentListeners) {
            this.activityPluginBinding.addOnNewIntentListener(newIntentListener);
        }
        for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.userLeaveHintListeners) {
            this.activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context activeContext() {
        return this.activityPluginBinding == null ? context() : activity();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Activity activity() {
        ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
        if (activityPluginBinding2 != null) {
            return activityPluginBinding2.getActivity();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
        this.activityResultListeners.add(activityResultListener);
        ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
        if (activityPluginBinding2 != null) {
            activityPluginBinding2.addActivityResultListener(activityResultListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
        this.newIntentListeners.add(newIntentListener);
        ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
        if (activityPluginBinding2 != null) {
            activityPluginBinding2.addOnNewIntentListener(newIntentListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        this.requestPermissionsResultListeners.add(requestPermissionsResultListener);
        ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
        if (activityPluginBinding2 != null) {
            activityPluginBinding2.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
        this.userLeaveHintListeners.add(userLeaveHintListener);
        ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
        if (activityPluginBinding2 != null) {
            activityPluginBinding2.addOnUserLeaveHintListener(userLeaveHintListener);
        }
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    @NonNull
    public PluginRegistry.Registrar addViewDestroyListener(@NonNull PluginRegistry.ViewDestroyListener viewDestroyListener) {
        this.viewDestroyListeners.add(viewDestroyListener);
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context context() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getApplicationContext();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public String lookupKeyForAsset(String str) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public BinaryMessenger messenger() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getBinaryMessenger();
        }
        return null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding2) {
        Log.v(TAG, "Attached to an Activity.");
        this.activityPluginBinding = activityPluginBinding2;
        addExistingListenersToActivityPluginBinding();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.v(TAG, "Attached to FlutterEngine.");
        this.pluginBinding = flutterPluginBinding;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        Log.v(TAG, "Detached from an Activity.");
        this.activityPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        Log.v(TAG, "Detached from an Activity for config changes.");
        this.activityPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.v(TAG, "Detached from FlutterEngine.");
        for (PluginRegistry.ViewDestroyListener viewDestroyListener : this.viewDestroyListeners) {
            viewDestroyListener.onViewDestroy(null);
        }
        this.pluginBinding = null;
        this.activityPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding2) {
        Log.v(TAG, "Reconnected to an Activity after config changes.");
        this.activityPluginBinding = activityPluginBinding2;
        addExistingListenersToActivityPluginBinding();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PlatformViewRegistry platformViewRegistry() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getPlatformViewRegistry();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar publish(Object obj) {
        this.globalRegistrarMap.put(this.pluginId, obj);
        return this;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public TextureRegistry textures() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getTextureRegistry();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public FlutterView view() {
        throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public String lookupKeyForAsset(String str, String str2) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str, str2);
    }
}
