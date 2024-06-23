package io.flutter.plugins.deviceinfo;

import android.content.Context;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMethodCodec;

/* compiled from: Taobao */
public class DeviceInfoPlugin implements FlutterPlugin {
    static final String TAG = "DeviceInfoPlugin";
    MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new DeviceInfoPlugin().setupMethodChannel(registrar.messenger(), registrar.context());
    }

    private void setupMethodChannel(BinaryMessenger binaryMessenger, Context context) {
        try {
            Class<?> cls = Class.forName("io.flutter.plugin.common.BinaryMessenger$TaskQueue");
            Object invoke = binaryMessenger.getClass().getMethod("makeBackgroundTaskQueue", new Class[0]).invoke(binaryMessenger, new Object[0]);
            this.channel = (MethodChannel) MethodChannel.class.getConstructor(BinaryMessenger.class, String.class, MethodCodec.class, cls).newInstance(binaryMessenger, "plugins.flutter.io/device_info", StandardMethodCodec.INSTANCE, invoke);
            Log.d(TAG, "Use TaskQueues.");
        } catch (Exception unused) {
            this.channel = new MethodChannel(binaryMessenger, "plugins.flutter.io/device_info");
            Log.d(TAG, "Don't use TaskQueues.");
        }
        this.channel.setMethodCallHandler(new MethodCallHandlerImpl(context.getContentResolver(), context.getPackageManager()));
    }

    private void tearDownChannel() {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupMethodChannel(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        tearDownChannel();
    }
}
