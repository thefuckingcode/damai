package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    @NonNull
    public final MethodChannel channel;
    @NonNull
    @VisibleForTesting
    final MethodChannel.MethodCallHandler parsingMethodCallHandler;
    @Nullable
    private PlatformMessageHandler platformMessageHandler;

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        static {
            int[] iArr = new int[SystemUiMode.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode = iArr;
            try {
                iArr[SystemUiMode.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            iArr2[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            int[] iArr3 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr3;
            iArr3[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
        }
    }

    /* compiled from: Taobao */
    public static class AppSwitcherDescription {
        public final int color;
        @NonNull
        public final String label;

        public AppSwitcherDescription(int i, @NonNull String str) {
            this.color = i;
            this.label = str;
        }
    }

    /* compiled from: Taobao */
    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        @NonNull
        private String encodedName;

        private Brightness(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static Brightness fromValue(@NonNull String str) throws NoSuchFieldException {
            Brightness[] values = values();
            for (Brightness brightness : values) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* compiled from: Taobao */
    public enum ClipboardContentFormat {
        PLAIN_TEXT(IRequestConst.CONTENT_TYPE_TEXT_PLAIN);
        
        @NonNull
        private String encodedName;

        private ClipboardContentFormat(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static ClipboardContentFormat fromValue(@NonNull String str) throws NoSuchFieldException {
            ClipboardContentFormat[] values = values();
            for (ClipboardContentFormat clipboardContentFormat : values) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* compiled from: Taobao */
    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        @NonNull
        private String encodedName;

        private DeviceOrientation(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static DeviceOrientation fromValue(@NonNull String str) throws NoSuchFieldException {
            DeviceOrientation[] values = values();
            for (DeviceOrientation deviceOrientation : values) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    /* compiled from: Taobao */
    public enum HapticFeedbackType {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        @Nullable
        private final String encodedName;

        private HapticFeedbackType(@Nullable String str) {
            this.encodedName = str;
        }

        @NonNull
        static HapticFeedbackType fromValue(@Nullable String str) throws NoSuchFieldException {
            HapticFeedbackType[] values = values();
            for (HapticFeedbackType hapticFeedbackType : values) {
                String str2 = hapticFeedbackType.encodedName;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    /* compiled from: Taobao */
    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setPreferredOrientations(int i);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void showSystemUiMode(@NonNull SystemUiMode systemUiMode);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    /* compiled from: Taobao */
    public enum SoundType {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        
        @NonNull
        private final String encodedName;

        private SoundType(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static SoundType fromValue(@NonNull String str) throws NoSuchFieldException {
            SoundType[] values = values();
            for (SoundType soundType : values) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    /* compiled from: Taobao */
    public static class SystemChromeStyle {
        @Nullable
        public final Integer statusBarColor;
        @Nullable
        public final Brightness statusBarIconBrightness;
        @Nullable
        public final Integer systemNavigationBarColor;
        @Nullable
        public final boolean systemNavigationBarContrastEnforced;
        @Nullable
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;
        @Nullable
        public final boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable boolean z, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3, @Nullable boolean z2) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = z;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = z2;
        }
    }

    /* compiled from: Taobao */
    public enum SystemUiMode {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");
        
        @NonNull
        private String encodedName;

        private SystemUiMode(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static SystemUiMode fromValue(@NonNull String str) throws NoSuchFieldException {
            SystemUiMode[] values = values();
            for (SystemUiMode systemUiMode : values) {
                if (systemUiMode.encodedName.equals(str)) {
                    return systemUiMode;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    /* compiled from: Taobao */
    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        @NonNull
        private String encodedName;

        private SystemUiOverlay(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        static SystemUiOverlay fromValue(@NonNull String str) throws NoSuchFieldException {
            SystemUiOverlay[] values = values();
            for (SystemUiOverlay systemUiOverlay : values) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            /* class io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x012b  */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                ClipboardContentFormat clipboardContentFormat;
                CharSequence clipboardData;
                if (PlatformChannel.this.platformMessageHandler != null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    Log.v(PlatformChannel.TAG, "Received '" + str + "' message.");
                    char c = 65535;
                    try {
                        switch (str.hashCode()) {
                            case -766342101:
                                if (str.equals("SystemNavigator.pop")) {
                                    c = '\t';
                                    break;
                                }
                                break;
                            case -720677196:
                                if (str.equals("Clipboard.setData")) {
                                    c = 11;
                                    break;
                                }
                                break;
                            case -577225884:
                                if (str.equals("SystemChrome.setSystemUIChangeListener")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -548468504:
                                if (str.equals("SystemChrome.setApplicationSwitcherDescription")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -247230243:
                                if (str.equals("HapticFeedback.vibrate")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -215273374:
                                if (str.equals("SystemSound.play")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 241845679:
                                if (str.equals("SystemChrome.restoreSystemUIOverlays")) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case 875995648:
                                if (str.equals("Clipboard.hasStrings")) {
                                    c = '\f';
                                    break;
                                }
                                break;
                            case 1128339786:
                                if (str.equals("SystemChrome.setEnabledSystemUIMode")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 1390477857:
                                if (str.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                    c = '\b';
                                    break;
                                }
                                break;
                            case 1514180520:
                                if (str.equals("Clipboard.getData")) {
                                    c = '\n';
                                    break;
                                }
                                break;
                            case 1674312266:
                                if (str.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 2119655719:
                                if (str.equals("SystemChrome.setPreferredOrientations")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                try {
                                    PlatformChannel.this.platformMessageHandler.playSystemSound(SoundType.fromValue((String) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException e) {
                                    result.error("error", e.getMessage(), null);
                                    return;
                                }
                            case 1:
                                try {
                                    PlatformChannel.this.platformMessageHandler.vibrateHapticFeedback(HapticFeedbackType.fromValue((String) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException e2) {
                                    result.error("error", e2.getMessage(), null);
                                    return;
                                }
                            case 2:
                                try {
                                    PlatformChannel.this.platformMessageHandler.setPreferredOrientations(PlatformChannel.this.decodeOrientations((JSONArray) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e3) {
                                    result.error("error", e3.getMessage(), null);
                                    return;
                                }
                            case 3:
                                try {
                                    PlatformChannel.this.platformMessageHandler.setApplicationSwitcherDescription(PlatformChannel.this.decodeAppSwitcherDescription((JSONObject) obj));
                                    result.success(null);
                                    return;
                                } catch (JSONException e4) {
                                    result.error("error", e4.getMessage(), null);
                                    return;
                                }
                            case 4:
                                try {
                                    PlatformChannel.this.platformMessageHandler.showSystemOverlays(PlatformChannel.this.decodeSystemUiOverlays((JSONArray) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e5) {
                                    result.error("error", e5.getMessage(), null);
                                    return;
                                }
                            case 5:
                                try {
                                    PlatformChannel.this.platformMessageHandler.showSystemUiMode(PlatformChannel.this.decodeSystemUiMode((String) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e6) {
                                    result.error("error", e6.getMessage(), null);
                                    return;
                                }
                            case 6:
                                PlatformChannel.this.platformMessageHandler.setSystemUiChangeListener();
                                result.success(null);
                                return;
                            case 7:
                                PlatformChannel.this.platformMessageHandler.restoreSystemUiOverlays();
                                result.success(null);
                                return;
                            case '\b':
                                try {
                                    PlatformChannel.this.platformMessageHandler.setSystemUiOverlayStyle(PlatformChannel.this.decodeSystemChromeStyle((JSONObject) obj));
                                    result.success(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e7) {
                                    result.error("error", e7.getMessage(), null);
                                    return;
                                }
                            case '\t':
                                PlatformChannel.this.platformMessageHandler.popSystemNavigator();
                                result.success(null);
                                return;
                            case '\n':
                                String str2 = (String) obj;
                                if (str2 != null) {
                                    try {
                                        clipboardContentFormat = ClipboardContentFormat.fromValue(str2);
                                    } catch (NoSuchFieldException unused) {
                                        result.error("error", "No such clipboard content format: " + str2, null);
                                    }
                                    clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(clipboardContentFormat);
                                    if (clipboardData == null) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("text", clipboardData);
                                        result.success(jSONObject);
                                        return;
                                    }
                                    result.success(null);
                                    return;
                                }
                                clipboardContentFormat = null;
                                clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(clipboardContentFormat);
                                if (clipboardData == null) {
                                }
                            case 11:
                                PlatformChannel.this.platformMessageHandler.setClipboardData(((JSONObject) obj).getString("text"));
                                result.success(null);
                                return;
                            case '\f':
                                boolean clipboardHasStrings = PlatformChannel.this.platformMessageHandler.clipboardHasStrings();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("value", clipboardHasStrings);
                                result.success(jSONObject2);
                                return;
                            default:
                                result.notImplemented();
                                return;
                        }
                    } catch (JSONException e8) {
                        result.error("error", "JSON error: " + e8.getMessage(), null);
                    }
                }
            }
        };
        this.parsingMethodCallHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= -16777216;
        }
        return new AppSwitcherDescription(i, jSONObject.getString("label"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[RETURN] */
    private int decodeOrientations(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                z |= true;
            } else if (i2 == 2) {
                z |= true;
            } else if (i2 == 3) {
                z |= true;
            } else if (i2 == 4) {
                z |= true;
            }
            if (!z2) {
                z2 = z;
            }
        }
        if (!z) {
            return -1;
        }
        switch (z) {
            case true:
                return 0;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                if (!z2) {
                    if (z2) {
                        return 9;
                    }
                    if (!z2) {
                        return 1;
                    }
                    return 8;
                }
                return 0;
            case true:
                return 9;
            case true:
                return 12;
            case true:
                return 8;
            case true:
                return 11;
            case true:
                return 2;
            case true:
                return 13;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        Integer num = null;
        Integer valueOf = !jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null;
        Brightness fromValue = !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null;
        boolean z = !jSONObject.isNull("systemStatusBarContrastEnforced") ? jSONObject.getBoolean("systemStatusBarContrastEnforced") : true;
        Integer valueOf2 = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        Brightness fromValue2 = !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        if (!jSONObject.isNull("systemNavigationBarDividerColor")) {
            num = Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor"));
        }
        return new SystemChromeStyle(valueOf, fromValue, z, valueOf2, fromValue2, num, !jSONObject.isNull("systemNavigationBarContrastEnforced") ? jSONObject.getBoolean("systemNavigationBarContrastEnforced") : true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private SystemUiMode decodeSystemUiMode(@NonNull String str) throws JSONException, NoSuchFieldException {
        int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.fromValue(str).ordinal()];
        if (i == 1) {
            return SystemUiMode.LEAN_BACK;
        }
        if (i == 2) {
            return SystemUiMode.IMMERSIVE;
        }
        if (i == 3) {
            return SystemUiMode.IMMERSIVE_STICKY;
        }
        if (i != 4) {
            return SystemUiMode.EDGE_TO_EDGE;
        }
        return SystemUiMode.EDGE_TO_EDGE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i2 == 2) {
                arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler2) {
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void systemChromeChanged(boolean z) {
        Log.v(TAG, "Sending 'systemUIChange' message.");
        this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z)));
    }
}
