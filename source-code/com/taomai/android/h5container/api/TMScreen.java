package com.taomai.android.h5container.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.ScreenCaptureUtil;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.ImageTool;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.utils.FileUtil;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class TMScreen extends WVApiPlugin {
    private static final String TAG = "TMScreen";

    public static long captureByActivity(Activity activity, boolean z, long j, long j2, long j3, boolean z2) throws IOException {
        View decorView = activity.getWindow().getDecorView();
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
        decorView.draw(new Canvas(createBitmap));
        if (createBitmap != null) {
            if (z2) {
                createBitmap = ImageTool.zoomBitmap(createBitmap, j2, j3);
            }
            long saveBitmapToCache = WVUtils.saveBitmapToCache(createBitmap);
            if (!z) {
                return saveBitmapToCache;
            }
            ImageTool.saveImage(activity, createBitmap);
            return saveBitmapToCache;
        }
        throw new RuntimeException("can't get bitmap from the view");
    }

    private static Bitmap getBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public void capture(WVCallBackContext wVCallBackContext, String str) {
        boolean z;
        long j;
        long j2;
        String str2;
        String str3;
        String str4;
        int i;
        long j3;
        WVResult wVResult = new WVResult();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str4 = jSONObject.optString("inAlbum", "false");
                str3 = jSONObject.optString("type", "view");
                long optLong = jSONObject.optLong("maxShortSide", FileUtil.LOCAL_REPORT_FILE_MAX_SIZE);
                long optLong2 = jSONObject.optLong("maxLongSide", FileUtil.LOCAL_REPORT_FILE_MAX_SIZE);
                str2 = jSONObject.optString("disableHardware", "false");
                int optInt = jSONObject.optInt(Constants.Name.QUALITY, 50);
                if (optInt <= 100) {
                    if (optInt >= 0) {
                        i = optInt;
                        z = jSONObject.optBoolean("compress", true);
                        j2 = optLong2;
                        j = optLong;
                    }
                }
                i = 50;
                z = jSONObject.optBoolean("compress", true);
                j2 = optLong2;
                j = optLong;
            } catch (Exception e) {
                wVResult.addData("msg", "param error: [" + e.getMessage() + jl1.ARRAY_END_STR);
                wVCallBackContext.error(wVResult);
                return;
            }
        } else {
            str4 = "";
            str3 = "app";
            str2 = "false";
            j2 = 10240;
            j = 10240;
            i = 50;
            z = true;
        }
        boolean z2 = !"false".equals(str4);
        try {
            if ("true".equals(str2)) {
                ((Activity) this.mContext).getWindow().getDecorView().setLayerType(1, null);
                this.mWebView.getView().setLayerType(1, null);
                if (str3.equals("app")) {
                    j3 = captureByActivity((Activity) this.mContext, z2, (long) i, j2, j, z);
                } else {
                    j3 = capture(this.mWebView.getView(), z2, (long) i, j2, j, z);
                }
                ((Activity) this.mContext).getWindow().getDecorView().setLayerType(2, null);
                this.mWebView.getView().setLayerType(2, null);
            } else if (str3.equals("app")) {
                j3 = ScreenCaptureUtil.captureByActivty((Activity) this.mContext, z2, (long) i, j2, j, z);
            } else {
                j3 = ScreenCaptureUtil.capture(this.mWebView.getView(), z2, (long) i, j2, j, z);
            }
            String virtualPath = WVUtils.getVirtualPath(Long.valueOf(j3));
            wVResult.addData("url", virtualPath);
            wVResult.addData("localPath", WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(virtualPath));
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if ("capture".equals(str)) {
            Context context = this.mContext;
            if (context == null) {
                return true;
            }
            PermissionProposer.buildPermissionTask(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                /* class com.taomai.android.h5container.api.TMScreen.AnonymousClass2 */

                public void run() {
                    TMScreen.this.capture(wVCallBackContext, str2);
                }
            }).setTaskOnPermissionDenied(new Runnable() {
                /* class com.taomai.android.h5container.api.TMScreen.AnonymousClass1 */

                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", "no permission");
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
            return true;
        } else if ("getOrientation".equals(str)) {
            getOrientation(wVCallBackContext, str2);
            return true;
        } else if (!"setOrientation".equals(str)) {
            return false;
        } else {
            setOrientation(wVCallBackContext, str2);
            return true;
        }
    }

    public void getOrientation(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            wVResult.addData("error", "Context must be Activty!");
            wVCallBackContext.error(wVResult);
            return;
        }
        int requestedOrientation = ((Activity) context).getRequestedOrientation();
        wVResult.addData("orientation", requestedOrientation == 0 ? "landscape" : requestedOrientation == 1 ? "portrait" : "unknown");
        wVCallBackContext.success(wVResult);
    }

    public void setOrientation(WVCallBackContext wVCallBackContext, String str) {
        new WVResult();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).optString("orientation", str2);
            } catch (Exception unused) {
                wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
            }
        }
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            WVResult wVResult = new WVResult();
            wVResult.addData("error", "Context must be Activty!");
            wVCallBackContext.error(wVResult);
            return;
        }
        Activity activity = (Activity) context;
        if (str2.equals("landscape") || str2.equals("landscapeRight")) {
            activity.setRequestedOrientation(0);
        } else if (str2.equals("landscapeLeft")) {
            activity.setRequestedOrientation(8);
        } else if (str2.equals("portrait") || str2.equals("default")) {
            activity.setRequestedOrientation(1);
        } else if (str2.equals("portraitUpsideDown")) {
            activity.setRequestedOrientation(9);
        } else if (str2.equals("auto")) {
            activity.setRequestedOrientation(4);
        } else {
            wVCallBackContext.error();
            return;
        }
        wVCallBackContext.success();
    }

    public static long capture(View view, boolean z, long j, long j2, long j3, boolean z2) throws IOException {
        Bitmap bitmapFromView = getBitmapFromView(view);
        if (bitmapFromView != null) {
            long saveBitmapToCache = WVUtils.saveBitmapToCache(z2 ? ImageTool.zoomBitmap(bitmapFromView, j2, j3) : bitmapFromView);
            if (!z) {
                return saveBitmapToCache;
            }
            ImageTool.saveImage(view.getContext(), bitmapFromView);
            return saveBitmapToCache;
        }
        throw new RuntimeException("can't get bitmap from the view");
    }
}
