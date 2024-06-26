package com.taomai.android.h5container.api;

import android.content.Context;
import android.net.NetworkInfo;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Lcom/taomai/android/h5container/api/TMNetworkPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", TMNetworkPlugin.ACTION_NETWORK, "actionName", "execute", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "getNetworkInfo", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TMNetworkPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_NETWORK = "getNetworkType";
    @NotNull
    public static final String BRIDGE_NAME = "TMNetWork";
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final boolean getNetworkType(String str, WVCallBackContext wVCallBackContext) {
        String networkType = getNetworkType();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "err_msg", (Object) ("network_type:" + networkType));
        jSONObject.put((Object) "networkType", (Object) networkType);
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        jSONObject.put((Object) "networkInfo", (Object) getNetworkInfo(context));
        jSONObject.put((Object) "networkAvailable", (Object) Boolean.valueOf(!k21.d("fail", networkType)));
        if (wVCallBackContext != null) {
            wVCallBackContext.success(jSONObject.toJSONString());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null && str.hashCode() == 1714085202 && str.equals(ACTION_NETWORK)) {
            return getNetworkType(str2, wVCallBackContext);
        }
        return false;
    }

    @Nullable
    public final String getNetworkInfo(@NotNull Context context) {
        NetworkInfo networkInfo;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            Object systemService = GlobalConfig.context.getSystemService("connectivity");
            if (systemService != null) {
                networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) systemService);
                if (networkInfo == null) {
                    return "NotReachable";
                }
                int type = networkInfo.getType();
                if (type == 1 || type == 9) {
                    return "WIFI";
                }
                int subtype = networkInfo.getSubtype();
                if (subtype != 18) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 13:
                            return "4G";
                        default:
                            return "UNKNOWN";
                    }
                }
                return "3G";
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Throwable th) {
            th.printStackTrace();
            networkInfo = null;
        }
    }

    private final String getNetworkType() {
        Object systemService = GlobalConfig.context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) systemService);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (networkInfo == null) {
            return "fail";
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 9) ? "wifi" : "wwan";
    }
}
