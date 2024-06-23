package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.io.FileNotFoundException;
import java.util.List;

/* compiled from: Taobao */
public class PlatformPlugin {
    public static final int DEFAULT_SYSTEM_UI = 1280;
    private static final String TAG = "PlatformPlugin";
    private final Activity activity;
    private PlatformChannel.SystemChromeStyle currentTheme;
    private int mEnabledOverlays;
    @VisibleForTesting
    final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    private final PlatformChannel platformChannel;
    private final PlatformPluginDelegate platformPluginDelegate;

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$3  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
        static {
            int[] iArr = new int[PlatformChannel.Brightness.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness = iArr;
            try {
                iArr[PlatformChannel.Brightness.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[PlatformChannel.Brightness.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PlatformChannel.SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            iArr2[PlatformChannel.SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[PlatformChannel.HapticFeedbackType.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType = iArr3;
            iArr3[PlatformChannel.HapticFeedbackType.STANDARD.ordinal()] = 1;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.LIGHT_IMPACT.ordinal()] = 2;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.MEDIUM_IMPACT.ordinal()] = 3;
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.HEAVY_IMPACT.ordinal()] = 4;
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    public interface PlatformPluginDelegate {
        boolean popSystemNavigator();
    }

    public PlatformPlugin(Activity activity2, PlatformChannel platformChannel2) {
        this(activity2, platformChannel2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean clipboardHasStrings() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.activity.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        ClipboardManager clipboardManager = (ClipboardManager) this.activity.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
            if (primaryClip == null) {
                return null;
            }
            if (clipboardContentFormat != null) {
                if (clipboardContentFormat != PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
                    return null;
                }
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getUri() != null) {
                this.activity.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
            }
            return itemAt.coerceToText(this.activity);
        } catch (SecurityException e) {
            Log.w(TAG, "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
            return null;
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void playSystemSound(PlatformChannel.SoundType soundType) {
        if (soundType == PlatformChannel.SoundType.CLICK) {
            this.activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void popSystemNavigator() {
        PlatformPluginDelegate platformPluginDelegate2 = this.platformPluginDelegate;
        if (platformPluginDelegate2 == null || !platformPluginDelegate2.popSystemNavigator()) {
            Activity activity2 = this.activity;
            if (activity2 instanceof OnBackPressedDispatcherOwner) {
                ((OnBackPressedDispatcherOwner) activity2).getOnBackPressedDispatcher().onBackPressed();
            } else {
                activity2.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void restoreSystemChromeSystemUIOverlays() {
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setClipboardData(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 28 && i > 21) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
            }
            if (i >= 28) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, 0, appSwitcherDescription.color));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromeChangeListener() {
        this.activity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* class io.flutter.plugin.platform.PlatformPlugin.AnonymousClass2 */

            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    PlatformPlugin.this.platformChannel.systemChromeChanged(false);
                } else {
                    PlatformPlugin.this.platformChannel.systemChromeChanged(true);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromeEnabledSystemUIMode(PlatformChannel.SystemUiMode systemUiMode) {
        int i = 1798;
        if (systemUiMode != PlatformChannel.SystemUiMode.LEAN_BACK || Build.VERSION.SDK_INT < 16) {
            if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE && Build.VERSION.SDK_INT >= 19) {
                i = 3846;
            } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE_STICKY && Build.VERSION.SDK_INT >= 19) {
                i = 5894;
            } else if (systemUiMode == PlatformChannel.SystemUiMode.EDGE_TO_EDGE && Build.VERSION.SDK_INT >= 16) {
                i = 1792;
            }
        }
        this.mEnabledOverlays = i;
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & -513 & -3;
            }
        }
        this.mEnabledOverlays = i;
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromePreferredOrientations(int i) {
        this.activity.setRequestedOrientation(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Window window = this.activity.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            PlatformChannel.Brightness brightness = systemChromeStyle.statusBarIconBrightness;
            if (brightness != null) {
                int i2 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness.ordinal()];
                if (i2 == 1) {
                    systemUiVisibility |= 8192;
                } else if (i2 == 2) {
                    systemUiVisibility &= -8193;
                }
            }
            Integer num = systemChromeStyle.statusBarColor;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        boolean z = systemChromeStyle.systemStatusBarContrastEnforced;
        if (!z && i >= 29) {
            window.setStatusBarContrastEnforced(z);
        }
        if (i >= 26) {
            PlatformChannel.Brightness brightness2 = systemChromeStyle.systemNavigationBarIconBrightness;
            if (brightness2 != null) {
                int i3 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness2.ordinal()];
                if (i3 == 1) {
                    systemUiVisibility |= 16;
                } else if (i3 == 2) {
                    systemUiVisibility &= -17;
                }
            }
            Integer num2 = systemChromeStyle.systemNavigationBarColor;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        if (systemChromeStyle.systemNavigationBarDividerColor != null && i >= 28) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(134217728);
            window.setNavigationBarDividerColor(systemChromeStyle.systemNavigationBarDividerColor.intValue());
        }
        boolean z2 = systemChromeStyle.systemNavigationBarContrastEnforced;
        if (!z2 && i >= 29) {
            window.setNavigationBarContrastEnforced(z2);
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.currentTheme = systemChromeStyle;
    }

    public void destroy() {
        this.platformChannel.setPlatformMessageHandler(null);
    }

    public void updateSystemUiOverlays() {
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
        if (systemChromeStyle != null) {
            setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        View decorView = this.activity.getWindow().getDecorView();
        int i = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[hapticFeedbackType.ordinal()];
        if (i == 1) {
            decorView.performHapticFeedback(0);
        } else if (i == 2) {
            decorView.performHapticFeedback(1);
        } else if (i == 3) {
            decorView.performHapticFeedback(3);
        } else if (i != 4) {
            if (i == 5 && Build.VERSION.SDK_INT >= 21) {
                decorView.performHapticFeedback(4);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            decorView.performHapticFeedback(6);
        }
    }

    public PlatformPlugin(Activity activity2, PlatformChannel platformChannel2, PlatformPluginDelegate platformPluginDelegate2) {
        AnonymousClass1 r0 = new PlatformChannel.PlatformMessageHandler() {
            /* class io.flutter.plugin.platform.PlatformPlugin.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public boolean clipboardHasStrings() {
                return PlatformPlugin.this.clipboardHasStrings();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                return PlatformPlugin.this.getClipboardData(clipboardContentFormat);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
                PlatformPlugin.this.playSystemSound(soundType);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void popSystemNavigator() {
                PlatformPlugin.this.popSystemNavigator();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void restoreSystemUiOverlays() {
                PlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
                PlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(appSwitcherDescription);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setClipboardData(@NonNull String str) {
                PlatformPlugin.this.setClipboardData(str);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setPreferredOrientations(int i) {
                PlatformPlugin.this.setSystemChromePreferredOrientations(i);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemUiChangeListener() {
                PlatformPlugin.this.setSystemChromeChangeListener();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
                PlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> list) {
                PlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(list);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void showSystemUiMode(@NonNull PlatformChannel.SystemUiMode systemUiMode) {
                PlatformPlugin.this.setSystemChromeEnabledSystemUIMode(systemUiMode);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                PlatformPlugin.this.vibrateHapticFeedback(hapticFeedbackType);
            }
        };
        this.mPlatformMessageHandler = r0;
        this.activity = activity2;
        this.platformChannel = platformChannel2;
        platformChannel2.setPlatformMessageHandler(r0);
        this.platformPluginDelegate = platformPluginDelegate2;
        this.mEnabledOverlays = 1280;
    }
}
