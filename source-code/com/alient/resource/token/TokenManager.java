package com.alient.resource.token;

import android.content.Context;
import android.net.Uri;
import com.alient.resource.util.ResUtil;
import com.taobao.analysis.StageType;
import com.uc.webview.export.extension.UCCore;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.k21;
import tb.m40;
import tb.ph;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0015R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/alient/resource/token/TokenManager;", "", "", "string", "", "Lcom/alient/resource/token/StrategyTokenJavaBean;", StageType.PARSE, "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/net/Uri;", "uri", "getContentByUri", "", "getResId", "Ljava/io/Closeable;", "closeable", "Ltb/ur2;", "closeQuietly", UCCore.LEGACY_EVENT_INIT, "tokenKey", "getColorToken", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "getDimenToken", "getFontToken", "tokens", "Ljava/util/Map;", "<init>", "()V", "Companion", "oneresource_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TokenManager {
    private static final int BUFFER_SIZE = 8192;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DEV_PHONE = "dev_phone";
    @NotNull
    private static final Lazy instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, TokenManager$Companion$instance$2.INSTANCE);
    private Map<String, ? extends StrategyTokenJavaBean> tokens;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/alient/resource/token/TokenManager$Companion;", "", "Lcom/alient/resource/token/TokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/resource/token/TokenManager;", "instance", "", "BUFFER_SIZE", "I", "", "DEV_PHONE", "Ljava/lang/String;", "<init>", "()V", "oneresource_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TokenManager getInstance() {
            Lazy lazy = TokenManager.instance$delegate;
            Companion companion = TokenManager.Companion;
            return (TokenManager) lazy.getValue();
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    private final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[Catch:{ all -> 0x0082 }] */
    private final String getContentByUri(Context context, Uri uri) {
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        if (k21.d("android.resource", uri.getScheme())) {
            int resId = getResId(context, uri);
            if (resId > 0) {
                inputStream = context.getResources().openRawResource(resId);
                if (inputStream != null) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read > 0) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    k21.h(byteArray, "rawData");
                                    String str = new String(byteArray, ph.UTF_8);
                                    closeQuietly(inputStream);
                                    closeQuietly(byteArrayOutputStream);
                                    closeQuietly(bufferedInputStream);
                                    return str;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                if (AppInfoProviderProxy.isDebuggable()) {
                                    e.printStackTrace();
                                }
                                closeQuietly(inputStream);
                                closeQuietly(byteArrayOutputStream);
                                closeQuietly(bufferedInputStream);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                closeQuietly(inputStream);
                                closeQuietly(byteArrayOutputStream);
                                closeQuietly(bufferedInputStream);
                                throw th;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        if (AppInfoProviderProxy.isDebuggable()) {
                        }
                        closeQuietly(inputStream);
                        closeQuietly(byteArrayOutputStream);
                        closeQuietly(bufferedInputStream);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        closeQuietly(inputStream);
                        closeQuietly(byteArrayOutputStream);
                        closeQuietly(bufferedInputStream);
                        throw th;
                    }
                }
                return null;
            }
        } else {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e4) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e4;
                }
            }
            if (inputStream != null) {
            }
            return null;
        }
        inputStream = null;
        if (inputStream != null) {
        }
        return null;
    }

    private final int getResId(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() != 2) {
            return -1;
        }
        return ResUtil.getIdentifier(context, pathSegments.get(1), pathSegments.get(0));
    }

    private final Map<String, StrategyTokenJavaBean> parse(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                StrategyTokenJavaBean strategyTokenJavaBean = new StrategyTokenJavaBean();
                strategyTokenJavaBean.token = jSONObject.getString("token");
                strategyTokenJavaBean.type = jSONObject.getString("type");
                strategyTokenJavaBean.value = new HashMap<>();
                JSONObject jSONObject2 = jSONObject.getJSONObject("value");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        k21.h(next2, "key2");
                        String string = jSONObject3.getString(next2);
                        k21.h(string, "l3.getString(key2)");
                        hashMap2.put(next2, string);
                    }
                    HashMap<String, HashMap<String, Object>> hashMap3 = strategyTokenJavaBean.value;
                    k21.h(hashMap3, "tokenJavaBean.value");
                    hashMap3.put(next, hashMap2);
                }
                String str2 = strategyTokenJavaBean.token;
                k21.h(str2, "tokenJavaBean.token");
                hashMap.put(str2, strategyTokenJavaBean);
            }
        } catch (JSONException e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
        return hashMap;
    }

    @Nullable
    public final Integer getColorToken(@NotNull Context context, @NotNull String str) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "tokenKey");
        return (Integer) ColorStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final Integer getDimenToken(@NotNull Context context, @NotNull String str) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "tokenKey");
        return (Integer) DimenStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final Integer getFontToken(@NotNull Context context, @NotNull String str) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "tokenKey");
        return (Integer) FontStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    public final void init(@NotNull Context context, @NotNull Uri uri) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(uri, "uri");
        String contentByUri = getContentByUri(context, uri);
        if (contentByUri != null) {
            Map<String, StrategyTokenJavaBean> parse = parse(contentByUri);
            for (StrategyTokenJavaBean strategyTokenJavaBean : parse.values()) {
                String str = strategyTokenJavaBean.type;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1840138807:
                            if (str.equals("foundation-color")) {
                                ColorStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                                break;
                            } else {
                                continue;
                            }
                        case -1839393385:
                            if (str.equals("foundation-dimen")) {
                                DimenStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                                break;
                            } else {
                                continue;
                            }
                        case -1826695567:
                            if (str.equals("foundation-ratio")) {
                                RatioStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                                break;
                            } else {
                                continue;
                            }
                        case 1049108777:
                            if (str.equals("foundation-font")) {
                                FontStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
            ur2 ur2 = ur2.INSTANCE;
            this.tokens = parse;
        }
    }
}
