package com.youku.gaiax.impl.register.remote;

import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00048\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteVersionUtils;", "", "", "version", "", "safeToLong", "Lcom/alibaba/fastjson/JSONObject;", "getMaxVersion", "getMinVersion", "parseVersion", "(Ljava/lang/String;)Ljava/lang/Long;", "MAX_VALUE", "J", "getMAX_VALUE", "()J", "MIN_VALUE", "getMIN_VALUE", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXRemoteVersionUtils {
    @NotNull
    public static final GaiaXRemoteVersionUtils INSTANCE = new GaiaXRemoteVersionUtils();
    private static final long MAX_VALUE = AbsPerformance.LONG_NIL;
    private static final long MIN_VALUE = 0;

    private GaiaXRemoteVersionUtils() {
    }

    private final long safeToLong(String str) {
        if (str == null) {
            return 0;
        }
        try {
            String obj = StringsKt__StringsKt.T0(str).toString();
            if (obj == null) {
                return 0;
            }
            return Long.parseLong(obj);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final long getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final long getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final long getMaxVersion(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "version");
        if (!(!jSONObject.isEmpty())) {
            return MAX_VALUE;
        }
        String string = jSONObject.getString("maxVersion");
        if (string == null) {
            string = "MAX_VALUE";
        }
        if (k21.d("MAX_VALUE", string)) {
            return MAX_VALUE;
        }
        Long parseVersion = parseVersion(string);
        return parseVersion == null ? MAX_VALUE : parseVersion.longValue();
    }

    public final long getMinVersion(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "version");
        if (!(!jSONObject.isEmpty())) {
            return MIN_VALUE;
        }
        String string = jSONObject.getString("minVersion");
        if (string == null) {
            string = "MIN_VALUE";
        }
        if (k21.d("MIN_VALUE", string)) {
            return MIN_VALUE;
        }
        Long parseVersion = parseVersion(string);
        return parseVersion == null ? MIN_VALUE : parseVersion.longValue();
    }

    @Nullable
    public final Long parseVersion(@NotNull String str) {
        k21.i(str, "version");
        try {
            if (str.length() == 0) {
                return null;
            }
            List list = StringsKt__StringsKt.z0(str, new String[]{"."}, false, 0, 6, null);
            if (!list.isEmpty()) {
                if (list.size() >= 3) {
                    return Long.valueOf((Math.min(safeToLong(list.size() > 0 ? (String) list.get(0) : null), 9999L) * 1000000000000L) + 10000000000000000L + (Math.min(safeToLong(1 < list.size() ? (String) list.get(1) : null), 9999L) * 100000000) + (Math.min(safeToLong(2 < list.size() ? (String) list.get(2) : null), 9999L) * 10000) + Math.min(safeToLong(3 < list.size() ? (String) list.get(3) : null), 9999L));
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
