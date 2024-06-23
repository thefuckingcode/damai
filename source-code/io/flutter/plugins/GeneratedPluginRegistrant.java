package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.idlefish.flutterboost.b;
import dev.fluttercommunity.plus.packageinfo.a;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.connectivity.ConnectivityPlugin;
import io.flutter.plugins.deviceinfo.DeviceInfoPlugin;
import io.flutter.plugins.share.SharePlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import tb.ev0;
import tb.rz2;
import tb.ur1;

@Keep
/* compiled from: Taobao */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new ConnectivityPlugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin connectivity, io.flutter.plugins.connectivity.ConnectivityPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add(new DeviceInfoPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin device_info, io.flutter.plugins.deviceinfo.DeviceInfoPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add(new b());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin flutter_boost, com.idlefish.flutterboost.FlutterBoostPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add(new ev0());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin high_available, com.taobao.highavailable.HighAvailablePlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add(new a());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add(new ur1());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin power_image, com.taobao.power_image.PowerImagePlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add(new SharePlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin share, io.flutter.plugins.share.SharePlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add(new UrlLauncherPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin url_launcher, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add(new rz2());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin wpk_uploader, com.uc.flutter.plugins.wpk_uploader.WpkUploaderPlugin", e10);
        }
    }
}
