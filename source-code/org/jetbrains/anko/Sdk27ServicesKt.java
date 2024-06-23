package org.jetbrains.anko;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.usage.NetworkStatsManager;
import android.app.usage.StorageStatsManager;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothManager;
import android.companion.CompanionDeviceManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.ShortcutManager;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.midi.MidiManager;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.HardwarePropertiesManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.health.SystemHealthManager;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000®\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010!\u001a\u00020\"*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010%\u001a\u00020&*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0015\u0010)\u001a\u00020**\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010-\u001a\u00020.*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0015\u00101\u001a\u000202*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b3\u00104\"\u0015\u00105\u001a\u000206*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0015\u00109\u001a\u00020:*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b;\u0010<\"\u0015\u0010=\u001a\u00020>*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b?\u0010@\"\u0015\u0010A\u001a\u00020B*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bC\u0010D\"\u0015\u0010E\u001a\u00020F*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bG\u0010H\"\u0015\u0010I\u001a\u00020J*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bK\u0010L\"\u0015\u0010M\u001a\u00020N*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bO\u0010P\"\u0015\u0010Q\u001a\u00020R*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0015\u0010U\u001a\u00020V*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bW\u0010X\"\u0015\u0010Y\u001a\u00020Z*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\\\"\u0015\u0010]\u001a\u00020^*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b_\u0010`\"\u0015\u0010a\u001a\u00020b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bc\u0010d\"\u0015\u0010e\u001a\u00020f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bg\u0010h\"\u0015\u0010i\u001a\u00020j*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bk\u0010l\"\u0015\u0010m\u001a\u00020n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bo\u0010p\"\u0015\u0010q\u001a\u00020r*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bs\u0010t\"\u0015\u0010u\u001a\u00020v*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bw\u0010x\"\u0015\u0010y\u001a\u00020z*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b{\u0010|\"\u0016\u0010}\u001a\u00020~*\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00030\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0001\u0010 \u0001\"\u0019\u0010¡\u0001\u001a\u00030¢\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0019\u0010¥\u0001\u001a\u00030¦\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0019\u0010©\u0001\u001a\u00030ª\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0019\u0010­\u0001\u001a\u00030®\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0019\u0010±\u0001\u001a\u00030²\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001\"\u0019\u0010µ\u0001\u001a\u00030¶\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0019\u0010¹\u0001\u001a\u00030º\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0019\u0010½\u0001\u001a\u00030¾\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0019\u0010Á\u0001\u001a\u00030Â\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0019\u0010Å\u0001\u001a\u00030Æ\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0019\u0010É\u0001\u001a\u00030Ê\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0019\u0010Í\u0001\u001a\u00030Î\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0019\u0010Ñ\u0001\u001a\u00030Ò\u0001*\u00020\u00028F¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001¨\u0006Õ\u0001"}, d2 = {"accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "Landroid/content/Context;", "getAccessibilityManager", "(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;", "accountManager", "Landroid/accounts/AccountManager;", "getAccountManager", "(Landroid/content/Context;)Landroid/accounts/AccountManager;", "activityManager", "Landroid/app/ActivityManager;", "getActivityManager", "(Landroid/content/Context;)Landroid/app/ActivityManager;", "alarmManager", "Landroid/app/AlarmManager;", "getAlarmManager", "(Landroid/content/Context;)Landroid/app/AlarmManager;", "appOpsManager", "Landroid/app/AppOpsManager;", "getAppOpsManager", "(Landroid/content/Context;)Landroid/app/AppOpsManager;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "(Landroid/content/Context;)Landroid/media/AudioManager;", "batteryManager", "Landroid/os/BatteryManager;", "getBatteryManager", "(Landroid/content/Context;)Landroid/os/BatteryManager;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getBluetoothManager", "(Landroid/content/Context;)Landroid/bluetooth/BluetoothManager;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager", "(Landroid/content/Context;)Landroid/hardware/camera2/CameraManager;", "captioningManager", "Landroid/view/accessibility/CaptioningManager;", "getCaptioningManager", "(Landroid/content/Context;)Landroid/view/accessibility/CaptioningManager;", "carrierConfigManager", "Landroid/telephony/CarrierConfigManager;", "getCarrierConfigManager", "(Landroid/content/Context;)Landroid/telephony/CarrierConfigManager;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "(Landroid/content/Context;)Landroid/content/ClipboardManager;", "companionDeviceManager", "Landroid/companion/CompanionDeviceManager;", "getCompanionDeviceManager", "(Landroid/content/Context;)Landroid/companion/CompanionDeviceManager;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "consumerIrManager", "Landroid/hardware/ConsumerIrManager;", "getConsumerIrManager", "(Landroid/content/Context;)Landroid/hardware/ConsumerIrManager;", "devicePolicyManager", "Landroid/app/admin/DevicePolicyManager;", "getDevicePolicyManager", "(Landroid/content/Context;)Landroid/app/admin/DevicePolicyManager;", "displayManager", "Landroid/hardware/display/DisplayManager;", "getDisplayManager", "(Landroid/content/Context;)Landroid/hardware/display/DisplayManager;", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "(Landroid/content/Context;)Landroid/app/DownloadManager;", "fingerprintManager", "Landroid/hardware/fingerprint/FingerprintManager;", "getFingerprintManager", "(Landroid/content/Context;)Landroid/hardware/fingerprint/FingerprintManager;", "hardwarePropertiesManager", "Landroid/os/HardwarePropertiesManager;", "getHardwarePropertiesManager", "(Landroid/content/Context;)Landroid/os/HardwarePropertiesManager;", "inputManager", "Landroid/hardware/input/InputManager;", "getInputManager", "(Landroid/content/Context;)Landroid/hardware/input/InputManager;", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getInputMethodManager", "(Landroid/content/Context;)Landroid/view/inputmethod/InputMethodManager;", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "(Landroid/content/Context;)Landroid/app/KeyguardManager;", "locationManager", "Landroid/location/LocationManager;", "getLocationManager", "(Landroid/content/Context;)Landroid/location/LocationManager;", "mediaProjectionManager", "Landroid/media/projection/MediaProjectionManager;", "getMediaProjectionManager", "(Landroid/content/Context;)Landroid/media/projection/MediaProjectionManager;", "mediaSessionManager", "Landroid/media/session/MediaSessionManager;", "getMediaSessionManager", "(Landroid/content/Context;)Landroid/media/session/MediaSessionManager;", "midiManager", "Landroid/media/midi/MidiManager;", "getMidiManager", "(Landroid/content/Context;)Landroid/media/midi/MidiManager;", "networkStatsManager", "Landroid/app/usage/NetworkStatsManager;", "getNetworkStatsManager", "(Landroid/content/Context;)Landroid/app/usage/NetworkStatsManager;", "nfcManager", "Landroid/nfc/NfcManager;", "getNfcManager", "(Landroid/content/Context;)Landroid/nfc/NfcManager;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "(Landroid/content/Context;)Landroid/app/NotificationManager;", "nsdManager", "Landroid/net/nsd/NsdManager;", "getNsdManager", "(Landroid/content/Context;)Landroid/net/nsd/NsdManager;", "powerManager", "Landroid/os/PowerManager;", "getPowerManager", "(Landroid/content/Context;)Landroid/os/PowerManager;", "printManager", "Landroid/print/PrintManager;", "getPrintManager", "(Landroid/content/Context;)Landroid/print/PrintManager;", "restrictionsManager", "Landroid/content/RestrictionsManager;", "getRestrictionsManager", "(Landroid/content/Context;)Landroid/content/RestrictionsManager;", "searchManager", "Landroid/app/SearchManager;", "getSearchManager", "(Landroid/content/Context;)Landroid/app/SearchManager;", "sensorManager", "Landroid/hardware/SensorManager;", "getSensorManager", "(Landroid/content/Context;)Landroid/hardware/SensorManager;", "shortcutManager", "Landroid/content/pm/ShortcutManager;", "getShortcutManager", "(Landroid/content/Context;)Landroid/content/pm/ShortcutManager;", "storageManager", "Landroid/os/storage/StorageManager;", "getStorageManager", "(Landroid/content/Context;)Landroid/os/storage/StorageManager;", "storageStatsManager", "Landroid/app/usage/StorageStatsManager;", "getStorageStatsManager", "(Landroid/content/Context;)Landroid/app/usage/StorageStatsManager;", "systemHealthManager", "Landroid/os/health/SystemHealthManager;", "getSystemHealthManager", "(Landroid/content/Context;)Landroid/os/health/SystemHealthManager;", "telecomManager", "Landroid/telecom/TelecomManager;", "getTelecomManager", "(Landroid/content/Context;)Landroid/telecom/TelecomManager;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "getTelephonyManager", "(Landroid/content/Context;)Landroid/telephony/TelephonyManager;", "textClassificationManager", "Landroid/view/textclassifier/TextClassificationManager;", "getTextClassificationManager", "(Landroid/content/Context;)Landroid/view/textclassifier/TextClassificationManager;", "tvInputManager", "Landroid/media/tv/TvInputManager;", "getTvInputManager", "(Landroid/content/Context;)Landroid/media/tv/TvInputManager;", "uiModeManager", "Landroid/app/UiModeManager;", "getUiModeManager", "(Landroid/content/Context;)Landroid/app/UiModeManager;", "usageStatsManager", "Landroid/app/usage/UsageStatsManager;", "getUsageStatsManager", "(Landroid/content/Context;)Landroid/app/usage/UsageStatsManager;", "usbManager", "Landroid/hardware/usb/UsbManager;", "getUsbManager", "(Landroid/content/Context;)Landroid/hardware/usb/UsbManager;", "userManager", "Landroid/os/UserManager;", "getUserManager", "(Landroid/content/Context;)Landroid/os/UserManager;", "wallpaperManager", "Landroid/app/WallpaperManager;", "getWallpaperManager", "(Landroid/content/Context;)Landroid/app/WallpaperManager;", "wifiAwareManager", "Landroid/net/wifi/aware/WifiAwareManager;", "getWifiAwareManager", "(Landroid/content/Context;)Landroid/net/wifi/aware/WifiAwareManager;", "wifiManager", "Landroid/net/wifi/WifiManager;", "getWifiManager", "(Landroid/content/Context;)Landroid/net/wifi/WifiManager;", "wifiP2pManager", "Landroid/net/wifi/p2p/WifiP2pManager;", "getWifiP2pManager", "(Landroid/content/Context;)Landroid/net/wifi/p2p/WifiP2pManager;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "(Landroid/content/Context;)Landroid/view/WindowManager;", "anko-sdk27_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Services.kt */
public final class Sdk27ServicesKt {
    public static final AccessibilityManager getAccessibilityManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("accessibility");
        if (systemService != null) {
            return (AccessibilityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    public static final AccountManager getAccountManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("account");
        if (systemService != null) {
            return (AccountManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.accounts.AccountManager");
    }

    public static final ActivityManager getActivityManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return (ActivityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static final AlarmManager getAlarmManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            return (AlarmManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    public static final AppOpsManager getAppOpsManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("appops");
        if (systemService != null) {
            return (AppOpsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.AppOpsManager");
    }

    public static final AudioManager getAudioManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("audio");
        if (systemService != null) {
            return (AudioManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
    }

    public static final BatteryManager getBatteryManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("batterymanager");
        if (systemService != null) {
            return (BatteryManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.BatteryManager");
    }

    public static final BluetoothManager getBluetoothManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("bluetooth");
        if (systemService != null) {
            return (BluetoothManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    public static final CameraManager getCameraManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("camera");
        if (systemService != null) {
            return (CameraManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    public static final CaptioningManager getCaptioningManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("captioning");
        if (systemService != null) {
            return (CaptioningManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.accessibility.CaptioningManager");
    }

    public static final CarrierConfigManager getCarrierConfigManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("carrier_config");
        if (systemService != null) {
            return (CarrierConfigManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.CarrierConfigManager");
    }

    public static final ClipboardManager getClipboardManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            return (ClipboardManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public static final CompanionDeviceManager getCompanionDeviceManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("companiondevice");
        if (systemService != null) {
            return (CompanionDeviceManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.companion.CompanionDeviceManager");
    }

    public static final ConnectivityManager getConnectivityManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return (ConnectivityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static final ConsumerIrManager getConsumerIrManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("consumer_ir");
        if (systemService != null) {
            return (ConsumerIrManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.ConsumerIrManager");
    }

    public static final DevicePolicyManager getDevicePolicyManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("device_policy");
        if (systemService != null) {
            return (DevicePolicyManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
    }

    public static final DisplayManager getDisplayManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("display");
        if (systemService != null) {
            return (DisplayManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.display.DisplayManager");
    }

    public static final DownloadManager getDownloadManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("download");
        if (systemService != null) {
            return (DownloadManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
    }

    public static final FingerprintManager getFingerprintManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("fingerprint");
        if (systemService != null) {
            return (FingerprintManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager");
    }

    public static final HardwarePropertiesManager getHardwarePropertiesManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("hardware_properties");
        if (systemService != null) {
            return (HardwarePropertiesManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.HardwarePropertiesManager");
    }

    public static final InputManager getInputManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("input");
        if (systemService != null) {
            return (InputManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.input.InputManager");
    }

    public static final InputMethodManager getInputMethodManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            return (InputMethodManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final KeyguardManager getKeyguardManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null) {
            return (KeyguardManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.KeyguardManager");
    }

    public static final LocationManager getLocationManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("location");
        if (systemService != null) {
            return (LocationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public static final MediaProjectionManager getMediaProjectionManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("media_projection");
        if (systemService != null) {
            return (MediaProjectionManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
    }

    public static final MediaSessionManager getMediaSessionManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("media_session");
        if (systemService != null) {
            return (MediaSessionManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.session.MediaSessionManager");
    }

    public static final MidiManager getMidiManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("midi");
        if (systemService != null) {
            return (MidiManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.midi.MidiManager");
    }

    public static final NetworkStatsManager getNetworkStatsManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("netstats");
        if (systemService != null) {
            return (NetworkStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.NetworkStatsManager");
    }

    public static final NfcManager getNfcManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("nfc");
        if (systemService != null) {
            return (NfcManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.nfc.NfcManager");
    }

    public static final NotificationManager getNotificationManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            return (NotificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    public static final NsdManager getNsdManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("servicediscovery");
        if (systemService != null) {
            return (NsdManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.nsd.NsdManager");
    }

    public static final PowerManager getPowerManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("power");
        if (systemService != null) {
            return (PowerManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.PowerManager");
    }

    public static final PrintManager getPrintManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("print");
        if (systemService != null) {
            return (PrintManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.print.PrintManager");
    }

    public static final RestrictionsManager getRestrictionsManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("restrictions");
        if (systemService != null) {
            return (RestrictionsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.RestrictionsManager");
    }

    public static final SearchManager getSearchManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("search");
        if (systemService != null) {
            return (SearchManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.SearchManager");
    }

    public static final SensorManager getSensorManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            return (SensorManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public static final ShortcutManager getShortcutManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("shortcut");
        if (systemService != null) {
            return (ShortcutManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
    }

    public static final StorageManager getStorageManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("storage");
        if (systemService != null) {
            return (StorageManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.storage.StorageManager");
    }

    public static final StorageStatsManager getStorageStatsManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("storagestats");
        if (systemService != null) {
            return (StorageStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.StorageStatsManager");
    }

    public static final SystemHealthManager getSystemHealthManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("systemhealth");
        if (systemService != null) {
            return (SystemHealthManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.health.SystemHealthManager");
    }

    public static final TelecomManager getTelecomManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("telecom");
        if (systemService != null) {
            return (TelecomManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telecom.TelecomManager");
    }

    public static final TelephonyManager getTelephonyManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("phone");
        if (systemService != null) {
            return (TelephonyManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final TextClassificationManager getTextClassificationManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("textclassification");
        if (systemService != null) {
            return (TextClassificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.textclassifier.TextClassificationManager");
    }

    public static final TvInputManager getTvInputManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("tv_input");
        if (systemService != null) {
            return (TvInputManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.tv.TvInputManager");
    }

    public static final UiModeManager getUiModeManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("uimode");
        if (systemService != null) {
            return (UiModeManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.UiModeManager");
    }

    public static final UsageStatsManager getUsageStatsManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("usagestats");
        if (systemService != null) {
            return (UsageStatsManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.usage.UsageStatsManager");
    }

    public static final UsbManager getUsbManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("usb");
        if (systemService != null) {
            return (UsbManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.usb.UsbManager");
    }

    public static final UserManager getUserManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("user");
        if (systemService != null) {
            return (UserManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.UserManager");
    }

    public static final WallpaperManager getWallpaperManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("wallpaper");
        if (systemService != null) {
            return (WallpaperManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.WallpaperManager");
    }

    public static final WifiAwareManager getWifiAwareManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("wifiaware");
        if (systemService != null) {
            return (WifiAwareManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.aware.WifiAwareManager");
    }

    public static final WifiManager getWifiManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("wifi");
        if (systemService != null) {
            return (WifiManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    public static final WifiP2pManager getWifiP2pManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("wifip2p");
        if (systemService != null) {
            return (WifiP2pManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
    }

    public static final WindowManager getWindowManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
