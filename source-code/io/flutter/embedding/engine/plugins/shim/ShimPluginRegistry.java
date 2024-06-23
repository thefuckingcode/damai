package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class ShimPluginRegistry implements PluginRegistry {
    private static final String TAG = "ShimPluginRegistry";
    private final FlutterEngine flutterEngine;
    private final Map<String, Object> pluginMap = new HashMap();
    private final ShimRegistrarAggregate shimRegistrarAggregate;

    /* compiled from: Taobao */
    private static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<ShimRegistrar> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(@NonNull ShimRegistrar shimRegistrar) {
            this.shimRegistrars.add(shimRegistrar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
            if (flutterPluginBinding2 != null) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding2);
            }
            ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
            if (activityPluginBinding2 != null) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            this.flutterPluginBinding = flutterPluginBinding2;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding2);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivity() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivityForConfigChanges() {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onDetachedFromEngine(flutterPluginBinding2);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (ShimRegistrar shimRegistrar : this.shimRegistrars) {
                shimRegistrar.onReattachedToActivityForConfigChanges(activityPluginBinding2);
            }
        }
    }

    public ShimPluginRegistry(@NonNull FlutterEngine flutterEngine2) {
        this.flutterEngine = flutterEngine2;
        ShimRegistrarAggregate shimRegistrarAggregate2 = new ShimRegistrarAggregate();
        this.shimRegistrarAggregate = shimRegistrarAggregate2;
        flutterEngine2.getPlugins().add(shimRegistrarAggregate2);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        return this.pluginMap.containsKey(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        Log.v(TAG, "Creating plugin Registrar for '" + str + "'");
        if (!this.pluginMap.containsKey(str)) {
            this.pluginMap.put(str, null);
            ShimRegistrar shimRegistrar = new ShimRegistrar(str, this.pluginMap);
            this.shimRegistrarAggregate.addPlugin(shimRegistrar);
            return shimRegistrar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        return (T) this.pluginMap.get(str);
    }
}
