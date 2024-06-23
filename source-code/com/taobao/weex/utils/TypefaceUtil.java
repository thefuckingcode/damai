package com.taobao.weex.utils;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.vm0;

/* compiled from: Taobao */
public class TypefaceUtil {
    public static final String ACTION_TYPE_FACE_AVAILABLE = "type_face_available";
    public static final String FONT_CACHE_DIR_NAME = "font-family";
    private static final Map<String, FontDO> a = new HashMap();

    public static void applyFontStyle(Paint paint, int i, int i2, String str) {
        int i3;
        Typeface typeface = paint.getTypeface();
        int i4 = 0;
        if (typeface == null) {
            i3 = 0;
        } else {
            i3 = typeface.getStyle();
        }
        if (i2 == 1 || ((i3 & 1) != 0 && i2 == -1)) {
            i4 = 1;
        }
        if (i == 2 || ((2 & i3) != 0 && i == -1)) {
            i4 |= 2;
        }
        if (str != null) {
            typeface = getOrCreateTypeface(str, i4);
        }
        if (typeface != null) {
            paint.setTypeface(Typeface.create(typeface, i4));
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i4));
        }
    }

    private static void d(final String str, final String str2, final String str3) {
        IWXHttpAdapter n = WXSDKManager.v().n();
        if (n == null) {
            WXLogUtils.e("TypefaceUtil", "downloadFontByNetwork() IWXHttpAdapter == null");
            return;
        }
        WXRequest wXRequest = new WXRequest();
        wXRequest.url = str;
        wXRequest.method = "GET";
        n.sendRequest(wXRequest, new IWXHttpAdapter.OnHttpListener() {
            /* class com.taobao.weex.utils.TypefaceUtil.AnonymousClass1 */

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHeadersReceived(int i, Map<String, List<String>> map) {
            }

            /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpFinish(WXResponse wXResponse) {
                int i;
                FontDO fontDO;
                byte[] bArr;
                boolean z = false;
                if (!TextUtils.isEmpty(wXResponse.statusCode)) {
                    try {
                        i = Integer.parseInt(wXResponse.statusCode);
                    } catch (NumberFormatException unused) {
                        WXLogUtils.e("TypefaceUtil", "IWXHttpAdapter onHttpFinish statusCode:" + wXResponse.statusCode);
                    }
                    if (i >= 200 && i <= 299 && (bArr = wXResponse.originalData) != null) {
                        z = WXFileUtils.saveFile(str2, bArr, WXEnvironment.getApplication());
                        if (!z) {
                            z = TypefaceUtil.g(str2, str3, true);
                        } else if (WXEnvironment.isApkDebugable()) {
                            WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork() onHttpFinish success, but save file failed.");
                        }
                    }
                    if (!z && (fontDO = (FontDO) TypefaceUtil.a.get(str3)) != null) {
                        fontDO.setState(3);
                        return;
                    }
                }
                i = 0;
                z = WXFileUtils.saveFile(str2, bArr, WXEnvironment.getApplication());
                if (!z) {
                }
                if (!z) {
                }
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpResponseProgress(int i) {
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpStart() {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork begin url:" + str);
                }
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpUploadProgress(int i) {
            }
        });
    }

    private static String e() {
        return WXEnvironment.getApplication().getCacheDir() + "/" + FONT_CACHE_DIR_NAME;
    }

    private static void f(FontDO fontDO, String str) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(WXEnvironment.getApplication().getAssets(), str);
            if (createFromAsset != null) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("TypefaceUtil", "load asset file success");
                }
                fontDO.setState(2);
                fontDO.setTypeface(createFromAsset);
                return;
            }
            WXLogUtils.e("TypefaceUtil", "Font asset file not found " + fontDO.getUrl());
        } catch (Exception e) {
            WXLogUtils.e("TypefaceUtil", e.toString());
        }
    }

    /* access modifiers changed from: private */
    public static boolean g(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (!new File(str).exists()) {
                    return false;
                }
                Typeface createFromFile = Typeface.createFromFile(str);
                if (createFromFile != null) {
                    final FontDO fontDO = a.get(str2);
                    if (fontDO != null) {
                        fontDO.setState(2);
                        fontDO.setTypeface(createFromFile);
                        fontDO.setFilePath(str);
                        if (WXEnvironment.isApkDebugable()) {
                            WXLogUtils.d("TypefaceUtil", "load local font file success");
                        }
                        if (z) {
                            WXSDKManager.v().G().postOnUiThread(new Runnable() {
                                /* class com.taobao.weex.utils.TypefaceUtil.AnonymousClass2 */

                                public void run() {
                                    TypefaceUtil.h(true, fontDO);
                                }
                            }, 100);
                        } else {
                            h(true, fontDO);
                        }
                        return true;
                    }
                } else {
                    WXLogUtils.e("TypefaceUtil", "load local font file failed, can't create font.");
                }
            } catch (Exception e) {
                WXLogUtils.e("TypefaceUtil", e.toString());
            }
        }
        return false;
    }

    public static FontDO getFontDO(String str) {
        return a.get(str);
    }

    public static Typeface getOrCreateTypeface(String str, int i) {
        FontDO fontDO = a.get(str);
        if (fontDO == null || fontDO.getTypeface() == null) {
            return Typeface.create(str, i);
        }
        return fontDO.getTypeface();
    }

    /* access modifiers changed from: private */
    public static void h(boolean z, FontDO fontDO) {
        if (z) {
            Intent intent = new Intent(ACTION_TYPE_FACE_AVAILABLE);
            intent.putExtra(Constants.Name.FONT_FAMILY, fontDO.getFontFamilyName());
            intent.putExtra("filePath", fontDO.getFilePath());
            intent.putExtra("fontUrl", fontDO.getUrl());
            LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).sendBroadcast(intent);
        }
        vm0 m = WXSDKManager.v().m();
        if (m != null) {
            m.b(fontDO.getFontFamilyName(), fontDO.getUrl(), fontDO.getFilePath());
        }
    }

    public static void loadTypeface(FontDO fontDO, boolean z) {
        if (fontDO != null && fontDO.getTypeface() == null && (fontDO.getState() == 3 || fontDO.getState() == 0)) {
            fontDO.setState(1);
            if (fontDO.getType() == 3) {
                f(fontDO, Uri.parse(fontDO.getUrl()).getPath().substring(1));
            } else if (fontDO.getType() == 1) {
                String url = fontDO.getUrl();
                String fontFamilyName = fontDO.getFontFamilyName();
                String md5 = WXFileUtils.md5(url);
                File file = new File(e());
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = file.getAbsolutePath() + File.separator + md5;
                if (!g(str, fontFamilyName, false)) {
                    d(url, str, fontFamilyName);
                }
            } else if ((fontDO.getType() == 2 || fontDO.getType() == 5) && !g(fontDO.getUrl(), fontDO.getFontFamilyName(), false)) {
                fontDO.setState(3);
            }
        } else if (z) {
            h(false, fontDO);
        }
    }

    public static void putFontDO(FontDO fontDO) {
        if (fontDO != null && !TextUtils.isEmpty(fontDO.getFontFamilyName())) {
            a.put(fontDO.getFontFamilyName(), fontDO);
        }
    }

    public static void registerNativeFont(Map<String, Typeface> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Typeface> entry : map.entrySet()) {
                putFontDO(new FontDO(entry.getKey(), entry.getValue()));
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("TypefaceUtil", "register new typeface: " + entry.getKey());
                }
            }
        }
    }

    public static void removeFontDO(String str) {
        a.remove(str);
    }
}
