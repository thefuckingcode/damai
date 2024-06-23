package com.alibaba.security.biometrics.skin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;
import com.alibaba.security.biometrics.skin.model.BaseSkinData;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.biometrics.skin.model.DialogSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.d.h;
import com.taobao.accs.common.Constants;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class RPSkinManager implements ISkinParse {
    private static final String KEY_GLOBAL = "global";
    private static final String KEY_NATIVE = "native";
    private static final String KEY_WEB = "web";
    private static final String NAME_SKIN = "RPSkin.json";
    private static final String PATH_RES = "Resources";
    private static final String TAG = "RPSkinManager";
    private Context mContext;
    private final Map<String, BaseSkinData> mGlobalDataPools;
    private boolean mIsAssets;
    private final Map<String, BaseSkinData> mNativeGlobalDataPools;
    private final Map<String, Map<String, BaseSkinData>> mNativeSkinDataPools;
    private final RPWebViewMediaCacheManager mRPWebViewMediaCacheManager;
    private String mSkinDir;
    private final Map<String, Map<String, Object>> mWebGlobalSkinDataPools;
    private final Map<String, Map<String, Map<String, Object>>> mWebSkinDataPools;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class HOLDER {
        private static final RPSkinManager SINGLE = new RPSkinManager();

        private HOLDER() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001d A[SYNTHETIC, Splitter:B:15:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0024 A[SYNTHETIC, Splitter:B:22:0x0024] */
    private Bitmap createAssetsBitmap(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            inputStream = this.mContext.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return decodeStream;
            } catch (Exception unused2) {
                if (inputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private Bitmap createFileBitmap(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static RPSkinManager getInstance() {
        return HOLDER.SINGLE;
    }

    private <T extends BaseSkinData> T getSkinData(String str, String str2, String str3, Class<T> cls) {
        Map<String, BaseSkinData> map;
        Map<String, BaseSkinData> map2;
        Map<String, BaseSkinData> map3;
        Map<String, Map<String, BaseSkinData>> map4 = this.mNativeSkinDataPools;
        BaseSkinData baseSkinData = (map4 == null || (map3 = map4.get(mergeKey(str, str2))) == null) ? null : map3.get(str3);
        if (baseSkinData == null && (map2 = this.mNativeGlobalDataPools) != null) {
            baseSkinData = (T) map2.get(str3);
        }
        if (baseSkinData == null && (map = this.mGlobalDataPools) != null) {
            baseSkinData = (T) map.get(str3);
        }
        if (baseSkinData == null) {
            return null;
        }
        try {
            baseSkinData.setKey(str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3);
            return (T) baseSkinData;
        } catch (Exception unused) {
            return null;
        }
    }

    private String mergeKey(String str, String str2) {
        return str + JSMethod.NOT_SET + str2;
    }

    private void parseNativeData(Map<String, BaseSkinData> map, Map.Entry<String, Object> entry) {
        BaseSkinData baseSkinData;
        String key = entry.getKey();
        Object value = entry.getValue();
        if (key.endsWith("Button") || key.endsWith(BaseCellItem.TYPE_BUTTON)) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), ButtonSkinData.class, true);
        } else if (key.endsWith("Text") || key.endsWith("text")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), TextViewSkinData.class, true);
        } else if (key.endsWith("ImageView") || key.endsWith("imageview")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), ImageViewSkinData.class, true);
        } else if (key.endsWith("Dialog") || key.endsWith("dialog")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), DialogSkinData.class, true);
        } else if (key.equalsIgnoreCase("detectAnimation")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), DetectAnimSkinData.class, true);
        } else if (key.endsWith("navigator") || key.endsWith("Navigator")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), NavigatorSkinData.class, true);
        } else if (key.endsWith(Constants.KEY_CONTROL) || key.endsWith("Control")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), ControlSkinData.class, true);
        } else {
            baseSkinData = null;
        }
        if (baseSkinData != null) {
            baseSkinData.parse(this);
            baseSkinData.webConvert(this);
            map.put(key, baseSkinData);
        }
    }

    private void parseWebData(Map<String, Object> map) {
        Map map2;
        Map map3;
        if (!(map == null || !map.containsKey("web") || (map2 = (Map) map.get("web")) == null || (map3 = (Map) h.a(h.a((Object) map2), Map.class, false)) == null)) {
            if (map3.containsKey("global")) {
                for (Map.Entry<String, Object> entry : ((Map) map3.get("global")).entrySet()) {
                    parseWebData(this.mWebGlobalSkinDataPools, entry);
                }
            }
            map3.remove("global");
            for (Map.Entry entry2 : map3.entrySet()) {
                HashMap hashMap = new HashMap();
                this.mWebSkinDataPools.put((String) entry2.getKey(), hashMap);
                for (Map.Entry<String, Object> entry3 : ((Map) entry2.getValue()).entrySet()) {
                    parseWebData(hashMap, entry3);
                }
            }
        }
    }

    @Override // com.alibaba.security.biometrics.skin.interfaces.ISkinParse
    public String convertWebPath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSkinDir);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(PATH_RES);
        sb.append(str2);
        sb.append(str);
        return (String) this.mRPWebViewMediaCacheManager.putSkinImage(this.mContext, sb.toString(), this.mIsAssets).second;
    }

    public String getAllWebSkinData() {
        HashMap hashMap = new HashMap();
        this.mWebSkinDataPools.put("global", this.mWebGlobalSkinDataPools);
        Map<String, Map<String, Map<String, Object>>> map = this.mWebSkinDataPools;
        if (map != null && !map.isEmpty()) {
            hashMap.put("web", this.mWebSkinDataPools);
        }
        Map<String, BaseSkinData> map2 = this.mGlobalDataPools;
        if (map2 != null && !map2.isEmpty()) {
            hashMap.put("global", this.mGlobalDataPools);
        }
        return h.a((Object) hashMap);
    }

    public <T extends BaseSkinData> T getGlobalSkinData(String str, Class<T> cls) {
        Map<String, BaseSkinData> map;
        Map<String, BaseSkinData> map2 = this.mNativeGlobalDataPools;
        BaseSkinData baseSkinData = map2 != null ? map2.get(str) : null;
        if (baseSkinData == null && (map = this.mGlobalDataPools) != null) {
            baseSkinData = map.get(str);
        }
        if (baseSkinData == null) {
            return null;
        }
        try {
            T t = (T) ((BaseSkinData) h.a(h.a(baseSkinData), cls, false));
            t.setKey("global_".concat(String.valueOf(str)));
            return t;
        } catch (Exception unused) {
            a.b();
            return null;
        }
    }

    public <T extends BaseSkinData> T getNativeSkinData(String str, String str2, Class<T> cls) {
        return (T) getSkinData("native", str, str2, cls);
    }

    public void init(Context context, String str, boolean z) {
        Map map;
        Map map2;
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext = context;
        this.mIsAssets = z;
        this.mSkinDir = str;
        String a = e.a(context, str + File.separator + NAME_SKIN, z);
        if (!TextUtils.isEmpty(a)) {
            try {
                JSONObject parseObject = JSON.parseObject(a);
                if (parseObject.containsKey("global")) {
                    for (Map.Entry<String, Object> entry : ((Map) h.a(h.a((Object) ((Map) parseObject.get("global"))), Map.class, false)).entrySet()) {
                        parseNativeData(this.mGlobalDataPools, entry);
                    }
                }
                if (!(!parseObject.containsKey("native") || (map = (Map) parseObject.get("native")) == null || (map2 = (Map) h.a(h.a((Object) map), Map.class, false)) == null)) {
                    if (map2.get("global") != null) {
                        for (Map.Entry<String, Object> entry2 : ((Map) map2.get("global")).entrySet()) {
                            parseNativeData(this.mNativeGlobalDataPools, entry2);
                        }
                    }
                    map2.remove("global");
                    for (Map.Entry entry3 : map2.entrySet()) {
                        HashMap hashMap = new HashMap();
                        this.mNativeSkinDataPools.put(mergeKey("native", (String) entry3.getKey()), hashMap);
                        for (Map.Entry<String, Object> entry4 : ((Map) entry3.getValue()).entrySet()) {
                            parseNativeData(hashMap, entry4);
                        }
                    }
                }
                parseWebData(parseObject);
                a.a(TAG, "init skin consume time： " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception unused) {
                a.b();
                release();
            }
        }
    }

    @Override // com.alibaba.security.biometrics.skin.interfaces.ISkinParse
    public Bitmap parseBitmap(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSkinDir);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(PATH_RES);
        sb.append(str2);
        sb.append(str);
        String sb2 = sb.toString();
        if (this.mIsAssets) {
            return createAssetsBitmap(sb2);
        }
        return createFileBitmap(sb2);
    }

    public void release() {
        Map<String, BaseSkinData> map = this.mGlobalDataPools;
        if (map != null) {
            map.clear();
        }
        Map<String, Map<String, BaseSkinData>> map2 = this.mNativeSkinDataPools;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Map<String, Map<String, Object>>> map3 = this.mWebSkinDataPools;
        if (map3 != null) {
            map3.clear();
        }
        Map<String, BaseSkinData> map4 = this.mNativeGlobalDataPools;
        if (map4 != null) {
            map4.clear();
        }
        Map<String, Map<String, Object>> map5 = this.mWebGlobalSkinDataPools;
        if (map5 != null) {
            map5.clear();
        }
    }

    private RPSkinManager() {
        this.mRPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
        this.mGlobalDataPools = new HashMap();
        this.mNativeSkinDataPools = new HashMap();
        this.mWebSkinDataPools = new HashMap();
        this.mNativeGlobalDataPools = new HashMap();
        this.mWebGlobalSkinDataPools = new HashMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> */
    /* JADX WARN: Multi-variable type inference failed */
    private void parseWebData(Map<String, Map<String, Object>> map, Map.Entry<String, Object> entry) {
        BaseSkinData baseSkinData;
        String key = entry.getKey();
        Object value = entry.getValue();
        if (key.endsWith("Button") || key.endsWith(BaseCellItem.TYPE_BUTTON)) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), ButtonSkinData.class, true);
        } else if (key.endsWith("Text") || key.endsWith("text")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), TextViewSkinData.class, true);
        } else if (key.endsWith("ImageView") || key.endsWith("imageview")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), ImageViewSkinData.class, true);
        } else if (key.endsWith("Dialog") || key.endsWith("dialog")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), DialogSkinData.class, true);
        } else if (key.equalsIgnoreCase("detectAnimation")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), DetectAnimSkinData.class, true);
        } else if (key.endsWith("navigator") || key.endsWith("Navigator")) {
            baseSkinData = (BaseSkinData) h.a(h.a(value), NavigatorSkinData.class, true);
        } else {
            baseSkinData = null;
        }
        if (baseSkinData != null) {
            baseSkinData.webConvert(this);
            map.put(key, h.a(h.a(baseSkinData), Map.class, false));
        } else if (key.endsWith("Container") || key.endsWith("container")) {
            try {
                JSONObject parseObject = JSON.parseObject(h.a(value));
                for (Map.Entry entry2 : parseObject.entrySet()) {
                    if (!((String) entry2.getKey()).endsWith("src")) {
                        if (!((String) entry2.getKey()).endsWith("Src")) {
                            if (((String) entry2.getKey()).endsWith(Constants.Name.BACKGROUND_IMAGE) || ((String) entry2.getKey()).endsWith("BackgroundImage")) {
                                parseObject.put(entry2.getKey(), convertWebPath(entry2.getValue().toString()));
                            }
                        }
                    }
                    parseObject.put(entry2.getKey(), convertWebPath(entry2.getValue().toString()));
                }
                map.put(key, parseObject);
            } catch (Exception unused) {
            }
        }
    }
}
