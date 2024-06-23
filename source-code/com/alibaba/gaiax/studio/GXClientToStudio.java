package com.alibaba.gaiax.studio;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXSocket;
import io.flutter.wpkbridge.WPKFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jl1;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class GXClientToStudio {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "[GaiaX][GXStudio]";
    @NotNull
    private static final Lazy<GXClientToStudio> i = kotlin.b.b(GXClientToStudio$Companion$instance$2.INSTANCE);
    @Nullable
    private Context a;
    @Nullable
    private GXSocketToStudioListener b;
    @Nullable
    private GXSocket c;
    @Nullable
    private String d;
    @Nullable
    private String e;
    @NotNull
    private String f = "auto";
    private boolean g;
    @NotNull
    private final GXSocket.GXSocketListener h = new b(this);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/studio/GXClientToStudio$GXSocketToStudioListener;", "", "", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "Ltb/ur2;", "onAddData", "onUpdate", "GaiaXAndroidClientToStudio_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXSocketToStudioListener {
        void onAddData(@NotNull String str, @NotNull JSONObject jSONObject);

        void onUpdate(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final GXClientToStudio a() {
            return (GXClientToStudio) GXClientToStudio.i.getValue();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements GXSocket.GXSocketListener {
        final /* synthetic */ GXClientToStudio a;

        b(GXClientToStudio gXClientToStudio) {
            this.a = gXClientToStudio;
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onSocketConnected() {
            GXClientToStudio gXClientToStudio = this.a;
            gXClientToStudio.r(gXClientToStudio.f);
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onSocketDisconnected() {
            if (this.a.g) {
                this.a.g = false;
                this.a.t();
            }
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioAddData(@NotNull String str, @NotNull JSONObject jSONObject) {
            k21.i(str, "templateId");
            k21.i(jSONObject, "templateData");
            GXSocketToStudioListener k = this.a.k();
            if (k != null) {
                k.onAddData(str, jSONObject);
            }
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioConnected() {
            GXSocket gXSocket;
            Log.d(GXClientToStudio.TAG, k21.r("onStudioConnected() called currentTemplateId = ", this.a.e));
            if (this.a.e != null && (gXSocket = this.a.c) != null) {
                gXSocket.j(this.a.e);
            }
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioUpdate(@NotNull String str, @NotNull JSONObject jSONObject) {
            k21.i(str, "templateId");
            k21.i(jSONObject, "templateJson");
            GXSocketToStudioListener k = this.a.k();
            if (k != null) {
                k.onUpdate(str, jSONObject);
            }
        }
    }

    private final boolean n(Context context) {
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        int length = allNetworkInfo.length - 1;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                NetworkInfo networkInfo = allNetworkInfo[i2];
                if (networkInfo.getType() == 17 && networkInfo.isConnected()) {
                    return true;
                }
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        }
        return false;
    }

    private final String p(String str) {
        try {
            Object[] array = new Regex("&").split(str, 0).toArray(new String[0]);
            if (array != null) {
                Object[] array2 = new Regex("=").split(((String[]) array)[2], 0).toArray(new String[0]);
                if (array2 != null) {
                    return ((String[]) array2)[1];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private final String q(String str) {
        try {
            Object[] array = new Regex("&").split(str, 0).toArray(new String[0]);
            if (array != null) {
                Object[] array2 = new Regex("=").split(((String[]) array)[1], 0).toArray(new String[0]);
                if (array2 != null) {
                    return ((String[]) array2)[1];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void r(String str) {
        GXSocket gXSocket;
        GXSocket gXSocket2 = this.c;
        boolean z = false;
        if (gXSocket2 != null && gXSocket2.h(str)) {
            GXSocket gXSocket3 = this.c;
            if (gXSocket3 != null) {
                gXSocket3.m();
                return;
            }
            return;
        }
        GXSocket gXSocket4 = this.c;
        if (gXSocket4 != null && gXSocket4.g(str)) {
            z = true;
        }
        if (z && (gXSocket = this.c) != null) {
            gXSocket.l();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void t() {
        GXSocket gXSocket = this.c;
        boolean z = false;
        if (gXSocket != null && !gXSocket.e()) {
            z = true;
        }
        if (z) {
            GXSocket gXSocket2 = this.c;
            if (gXSocket2 != null) {
                gXSocket2.n(this.h);
            }
            GXSocket gXSocket3 = this.c;
            if (gXSocket3 != null) {
                gXSocket3.b(this.d);
                return;
            }
            return;
        }
        r(this.f);
    }

    private final void u(String str, String str2, String str3) {
        Log.e(TAG, "tryToConnectGaiaStudio() called with: address = [" + str + "], templateId = [" + ((Object) str2) + "], type = [" + str3 + jl1.ARRAY_END);
        String str4 = this.d;
        this.f = str3;
        this.d = str;
        this.e = str2;
        if (str4 == null || k21.d(str4, str)) {
            t();
            return;
        }
        this.g = true;
        GXSocket gXSocket = this.c;
        if (gXSocket != null) {
            gXSocket.d();
        }
    }

    public final void i(@NotNull Context context, @NotNull JSONObject jSONObject) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(jSONObject, "params");
        if (n(context)) {
            Log.e(TAG, "manualConnect: 请断开手机VPN后重试");
            return;
        }
        Log.e(TAG, "execute() called with: params = [" + jSONObject + jl1.ARRAY_END);
        String string = jSONObject.getString("URL");
        String string2 = jSONObject.getString("TEMPLATE_ID");
        String string3 = jSONObject.getString("TYPE");
        k21.h(string, "targetUrl");
        k21.h(string3, "type");
        u(string, string2, string3);
    }

    @Nullable
    public final Context j() {
        return this.a;
    }

    @Nullable
    public final GXSocketToStudioListener k() {
        return this.b;
    }

    @Nullable
    public final JSONObject l(@Nullable String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String decode = URLDecoder.decode(str, "UTF-8");
                Log.e(TAG, "getParams() called with:  finalUrl = [" + ((Object) decode) + jl1.ARRAY_END);
                Matcher matcher = Pattern.compile("[ws://]+[\\d+.\\d+.\\d+.\\d+]+[:\\d+]*").matcher(decode);
                if (matcher.find()) {
                    String group = matcher.group();
                    k21.h(decode, "finalUrl");
                    String q = q(decode);
                    String p = p(decode);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((Object) "URL", (Object) group);
                    jSONObject.put((Object) "TYPE", (Object) p);
                    jSONObject.put((Object) "TEMPLATE_ID", (Object) q);
                    Log.e(TAG, "getParams() called with:  result = [" + jSONObject + jl1.ARRAY_END);
                    return jSONObject;
                }
                Log.e(TAG, "Can not find web url through regex.");
                return null;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final void m(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context.getApplicationContext();
        if (this.c == null) {
            this.c = new GXSocket();
        }
    }

    public final void o(@NotNull Context context, @NotNull JSONObject jSONObject) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(jSONObject, "params");
        if (n(context)) {
            Log.e(TAG, "manualConnect: 请断开手机VPN后重试");
            return;
        }
        Log.e(TAG, "onlyConnect() called with: params = [" + jSONObject + jl1.ARRAY_END);
        String string = jSONObject.getString("URL");
        String string2 = jSONObject.getString("TYPE");
        k21.h(string, "targetUrl");
        k21.h(string2, "type");
        u(string, null, string2);
    }

    public final void s(@Nullable GXSocketToStudioListener gXSocketToStudioListener) {
        this.b = gXSocketToStudioListener;
    }
}
