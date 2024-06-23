package com.youku.gaiax.impl.utils;

import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/utils/ConfigUtils;", "", "", "checkRemoteData", "", "GAIAX_CONFIG_SP_NAME_SPACE", "Ljava/lang/String;", "GAIAX_SDK_CONFIG_NAME_SPACE", "<init>", "()V", "CheckConfig", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ConfigUtils {
    @NotNull
    public static final String GAIAX_CONFIG_SP_NAME_SPACE = "gaiax_config";
    @NotNull
    public static final String GAIAX_SDK_CONFIG_NAME_SPACE = "youku_gaiax_config";
    @NotNull
    public static final ConfigUtils INSTANCE = new ConfigUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/youku/gaiax/impl/utils/ConfigUtils$CheckConfig;", "", "", "check", "Ltb/ur2;", "reset", "", "getDefaultValue", "getKey", "getLogName", "orange", "Ljava/lang/Boolean;", "getOrange", "()Ljava/lang/Boolean;", "setOrange", "(Ljava/lang/Boolean;)V", "sp", "getSp", "setSp", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static class CheckConfig {
        @Nullable
        private Boolean orange;
        @Nullable
        private Boolean sp;

        public final boolean check() {
            String str;
            try {
                String str2 = null;
                if (this.orange == null) {
                    IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
                    if (prefs == null) {
                        str = null;
                    } else {
                        str = prefs.getOrangeConfig(ConfigUtils.GAIAX_SDK_CONFIG_NAME_SPACE, getKey(), getDefaultValue());
                    }
                    this.orange = Boolean.valueOf(k21.d("true", str));
                }
                if (this.sp == null) {
                    IProxyPrefs prefs2 = GaiaXProxy.Companion.getInstance().getPrefs();
                    if (prefs2 != null) {
                        str2 = prefs2.getString(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, getKey(), getDefaultValue());
                    }
                    this.sp = Boolean.valueOf(k21.d("true", str2));
                }
                Boolean bool = this.orange;
                if (!(bool == null ? false : bool.booleanValue())) {
                    Boolean bool2 = this.sp;
                    if (bool2 == null ? false : bool2.booleanValue()) {
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @NotNull
        public String getDefaultValue() {
            return "false";
        }

        @NotNull
        public String getKey() {
            return "";
        }

        @NotNull
        public String getLogName() {
            return "";
        }

        @Nullable
        public final Boolean getOrange() {
            return this.orange;
        }

        @Nullable
        public final Boolean getSp() {
            return this.sp;
        }

        public final void reset() {
            this.sp = null;
            this.orange = null;
        }

        public final void setOrange(@Nullable Boolean bool) {
            this.orange = bool;
        }

        public final void setSp(@Nullable Boolean bool) {
            this.sp = bool;
        }
    }

    private ConfigUtils() {
    }

    public final boolean checkRemoteData() {
        return PropUtils.INSTANCE.m900isRemote();
    }
}
