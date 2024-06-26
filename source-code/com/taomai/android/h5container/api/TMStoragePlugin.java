package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.aranger.constant.Constants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lf2;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u0013"}, d2 = {"Lcom/taomai/android/h5container/api/TMStoragePlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", TMStoragePlugin.ACTION_GET_SHARED_DATA, TMStoragePlugin.ACTION_SET_SHARED_DATA, TMStoragePlugin.ACTION_REMOVE_SHARED_DATA, TMStoragePlugin.ACTION_GET_MEMORY_CACHE, TMStoragePlugin.ACTION_SET_MEMORY_CACHE, TMStoragePlugin.ACTION_REMOVE_MEMORY_CACHE, "actionName", "execute", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TMStoragePlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_GET_MEMORY_CACHE = "getMemoryCache";
    @NotNull
    public static final String ACTION_GET_SHARED_DATA = "getSharedData";
    @NotNull
    public static final String ACTION_REMOVE_MEMORY_CACHE = "removeMemoryCache";
    @NotNull
    public static final String ACTION_REMOVE_SHARED_DATA = "removeSharedData";
    @NotNull
    public static final String ACTION_SET_MEMORY_CACHE = "setMemoryCache";
    @NotNull
    public static final String ACTION_SET_SHARED_DATA = "setSharedData";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final HashMap<String, String> dataCache = new HashMap<>();

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final boolean getMemoryCache(String str, WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        JSONArray jSONArray = (str == null || (a2 = lf2.a(str)) == null) ? null : a2.getJSONArray(Constants.PARAM_KEYS);
        if (jSONArray == null) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String str2 = (String) (!(next instanceof String) ? null : next);
            if (str2 != null) {
                jSONObject.put((String) next, (Object) dataCache.get(str2));
            }
        }
        if (wVCallBackContext == null) {
            return true;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        ur2 ur2 = ur2.INSTANCE;
        wVCallBackContext.success(jSONObject2.toJSONString());
        return true;
    }

    private final boolean getSharedData(String str, WVCallBackContext wVCallBackContext) {
        new Thread(new TMStoragePlugin$getSharedData$1(str, wVCallBackContext)).start();
        return true;
    }

    private final boolean removeMemoryCache(String str, WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        JSONArray jSONArray = (str == null || (a2 = lf2.a(str)) == null) ? null : a2.getJSONArray(Constants.PARAM_KEYS);
        if (jSONArray == null) {
            return true;
        }
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!(next instanceof String)) {
                next = null;
            }
            String str2 = (String) next;
            if (str2 != null) {
                dataCache.remove(str2);
            }
        }
        if (wVCallBackContext == null) {
            return true;
        }
        wVCallBackContext.success();
        return true;
    }

    private final boolean removeSharedData(String str, WVCallBackContext wVCallBackContext) {
        new Thread(new TMStoragePlugin$removeSharedData$1(str, wVCallBackContext)).start();
        return true;
    }

    private final boolean setMemoryCache(String str, WVCallBackContext wVCallBackContext) {
        String str2;
        JSONObject a2;
        JSONObject jSONObject = (str == null || (a2 = lf2.a(str)) == null) ? null : a2.getJSONObject("data");
        if (jSONObject != null) {
            for (Map.Entry entry : jSONObject.entrySet()) {
                if (entry.getKey() != null) {
                    AbstractMap abstractMap = dataCache;
                    Object key = entry.getKey();
                    k21.h(key, "it.key");
                    boolean z = entry.getValue() instanceof String;
                    Object value = entry.getValue();
                    if (z) {
                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.String");
                        str2 = (String) value;
                    } else {
                        str2 = JSON.toJSONString(value);
                    }
                    k21.h(str2, "if (it.value is String) …ON.toJSONString(it.value)");
                    abstractMap.put(key, str2);
                }
            }
        }
        if (wVCallBackContext == null) {
            return true;
        }
        wVCallBackContext.success();
        return true;
    }

    private final boolean setSharedData(String str, WVCallBackContext wVCallBackContext) {
        new Thread(new TMStoragePlugin$setSharedData$1(str, wVCallBackContext)).start();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2082533979:
                    if (str.equals(ACTION_GET_SHARED_DATA)) {
                        return getSharedData(str2, wVCallBackContext);
                    }
                    break;
                case -1308402767:
                    if (str.equals(ACTION_SET_SHARED_DATA)) {
                        return setSharedData(str2, wVCallBackContext);
                    }
                    break;
                case -1019628225:
                    if (str.equals(ACTION_SET_MEMORY_CACHE)) {
                        return setMemoryCache(str2, wVCallBackContext);
                    }
                    break;
                case -877989923:
                    if (str.equals(ACTION_REMOVE_MEMORY_CACHE)) {
                        return removeMemoryCache(str2, wVCallBackContext);
                    }
                    break;
                case -749644461:
                    if (str.equals(ACTION_REMOVE_SHARED_DATA)) {
                        return removeSharedData(str2, wVCallBackContext);
                    }
                    break;
                case 752107979:
                    if (str.equals(ACTION_GET_MEMORY_CACHE)) {
                        return getMemoryCache(str2, wVCallBackContext);
                    }
                    break;
            }
        }
        return false;
    }
}
