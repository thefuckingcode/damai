package com.youku.gaiax.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R$\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0015\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/youku/gaiax/impl/utils/PropUtils;", "", "", "name", "key", "defValue", "getStringPreference", "value", "Ltb/ur2;", "setStringPreference", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, UCCore.LEGACY_EVENT_INIT, "", "isProfile", "isLog", "isLaunchLog", "isMonitorLog", AgooConstants.MESSAGE_FLAG, "setLog", "isJSLog", "isRemote", "isTimeLog", "appContext", "Landroid/content/Context;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setRemote", "(Ljava/lang/Boolean;)V", "isTestLog", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PropUtils {
    @NotNull
    public static final PropUtils INSTANCE = new PropUtils();
    @Nullable
    private static Context appContext;
    @Nullable
    private static Boolean isJSLog;
    @Nullable
    private static Boolean isLaunchLog;
    @Nullable
    private static Boolean isLog;
    @Nullable
    private static Boolean isMonitorLog;
    @Nullable
    private static Boolean isProfile;
    @Nullable
    private static Boolean isRemote;
    @Nullable
    private static Boolean isTestLog;

    private PropUtils() {
    }

    private final String getStringPreference(String str, String str2, String str3) {
        try {
            Context context = appContext;
            if (context == null) {
                return "";
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences == null) {
                return "";
            }
            String string = sharedPreferences.getString(str2, str3);
            return string == null ? "" : string;
        } catch (Exception unused) {
            return "";
        }
    }

    private final void setStringPreference(String str, String str2, String str3) {
        try {
            Context context = appContext;
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (edit != null) {
                        SharedPreferences.Editor putString = edit.putString(str2, str3);
                        if (putString != null) {
                            putString.apply();
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void init(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        appContext = context;
    }

    public final boolean isJSLog() {
        if (isJSLog == null) {
            isJSLog = Boolean.valueOf(k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.js.log", "0")));
        }
        Boolean bool = isJSLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isLaunchLog() {
        if (isLaunchLog == null) {
            isLaunchLog = Boolean.valueOf(k21.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log.launch", "0")) || k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.launch", "0")));
        }
        Boolean bool = isLaunchLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isLog() {
        if (isLog == null) {
            isLog = Boolean.valueOf(k21.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log", "0")) || k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.log", "0")));
        }
        Boolean bool = isLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isMonitorLog() {
        if (isMonitorLog == null) {
            isMonitorLog = Boolean.valueOf(k21.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log.monitor", "0")) || k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.monitor", "0")));
        }
        Boolean bool = isMonitorLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isProfile() {
        if (isProfile == null) {
            isProfile = Boolean.valueOf(k21.d(SystemProp.INSTANCE.get("debug.gaiax.profile", "0"), "1"));
        }
        Boolean bool = isProfile;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Nullable
    public final Boolean isRemote() {
        return isRemote;
    }

    public final boolean isTimeLog() {
        if (isTestLog == null) {
            isTestLog = Boolean.valueOf(k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.time", "0")));
        }
        Boolean bool = isTestLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void setLog(@NotNull String str) {
        k21.i(str, AgooConstants.MESSAGE_FLAG);
        isLog = Boolean.valueOf(k21.d(str, "1"));
        setStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log", str);
    }

    public final void setRemote(@Nullable Boolean bool) {
        isRemote = bool;
    }

    /* renamed from: isRemote  reason: collision with other method in class */
    public final boolean m900isRemote() {
        if (isRemote == null) {
            isRemote = Boolean.valueOf(k21.d("1", SystemProp.INSTANCE.get("debug.gaiax.remote", "1")));
        }
        Boolean bool = isRemote;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
