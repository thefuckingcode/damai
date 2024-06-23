package com.taomai.android.h5container.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVFileInfo;
import android.taobao.windvane.cache.WVFileInfoParser;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.file.WVFileUtils;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVDeniedRunnable;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.jsbridge.api.WVUploadService;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.taomai.android.h5container.utils.ImageTool;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.e03;

/* compiled from: Taobao */
public class TMCamera extends WVApiPlugin {
    public static final String LOCAL_IMAGE = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=";
    private static final String TAG = "WVCamera";
    public static int maxLength = 1024;
    private static String multiActivityClass;
    private static String uploadServiceClass;
    private long lastAccess = 0;
    private WVCallBackContext mCallback = null;
    private String mLocalPath = null;
    private WVCamera.UploadParams mParams;
    private PopupWindowController mPopupController;
    private String[] mPopupMenuTags = {"拍照", "从相册选择"};
    protected View.OnClickListener popupClickListener = new a();
    private WVUploadService uploadService;
    private boolean useCN = false;

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            TMCamera.this.mPopupController.hide();
            WVResult wVResult = new WVResult();
            if (TMCamera.this.mPopupMenuTags[0].equals(view.getTag())) {
                TMCamera.this.openCamara();
            } else if (TMCamera.this.mPopupMenuTags[1].equals(view.getTag())) {
                TMCamera.this.chosePhoto();
            } else {
                wVResult.addData("msg", "CANCELED_BY_USER");
                TaoLog.w("WVCamera", "take photo cancel, and callback.");
                TMCamera.this.mCallback.error(wVResult);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void chosePhoto() {
        if (!this.mParams.reducePermission) {
            chosePhotoInternal();
        } else {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                /* class com.taomai.android.h5container.api.TMCamera.AnonymousClass2 */

                public void run() {
                    TMCamera.this.chosePhotoInternal();
                }
            }).setTaskOnPermissionDenied(new WVDeniedRunnable(this.mCallback, com.alibaba.security.realidentity.jsbridge.a.al)).execute();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void chosePhotoInternal() {
        int i;
        Intent intent;
        TaoLog.d("WVCamera", "start to pick photo from system album.");
        if (!"1".equals(this.mParams.mutipleSelection)) {
            intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            i = 4002;
        } else if (!this.mContext.getPackageName().equals("com.taobao.taobao")) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "mutipleSelection only support in taobao!");
            this.mCallback.error(wVResult);
            return;
        } else {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("taobao://go/ImgFileListActivity"));
            intent.putExtra("maxSelect", this.mParams.maxSelect);
            i = 4003;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, i);
                Intent intent2 = new Intent("WVCameraFilter");
                intent2.putExtra("from-webview-id", this.mWebView.hashCode());
                LocalBroadcastManager.getInstance(GlobalConfig.context).sendBroadcast(intent2);
            } catch (Throwable th) {
                th.printStackTrace();
                WVResult wVResult2 = new WVResult();
                wVResult2.setResult("ERROR_STARTACTIVITY");
                wVResult2.addData("msg", "ERROR_STARTACTIVITY");
                this.mCallback.error(wVResult2);
            }
        }
    }

    private WVCamera.UploadParams createUploadParams(WVCamera.UploadParams uploadParams) {
        WVCamera wVCamera = new WVCamera();
        if (uploadParams == null) {
            return new WVCamera.UploadParams();
        }
        return new WVCamera.UploadParams(uploadParams);
    }

    private void initTakePhoto(WVCallBackContext wVCallBackContext, String str) {
        if (this.isAlive) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.lastAccess;
            this.lastAccess = currentTimeMillis;
            if (j < 1000) {
                TaoLog.w("WVCamera", "takePhoto, call this method too frequent,  " + j);
                return;
            }
            this.mCallback = wVCallBackContext;
            this.mParams = new WVCamera.UploadParams();
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mParams.type = jSONObject.optInt("type", 1);
                this.mParams.mode = jSONObject.optString("mode");
                this.mParams.v = jSONObject.optString("v");
                this.mParams.bizCode = jSONObject.optString("bizCode");
                this.mParams.extraData = jSONObject.optString(e03.EXTRA_DATA_DIMEN);
                this.mParams.extraInfo = jSONObject.optJSONObject("extraInfo");
                this.mParams.identifier = jSONObject.optString(WXGestureType.GestureInfo.POINTER_ID);
                this.mParams.maxSelect = jSONObject.optInt("maxSelect");
                this.mParams.mutipleSelection = jSONObject.optString("mutipleSelection");
                this.mParams.needZoom = jSONObject.optBoolean("needZoom", true);
                WVCamera.UploadParams uploadParams = this.mParams;
                uploadParams.isLastPic = true;
                uploadParams.needLogin = jSONObject.optBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN, false);
                this.mParams.needBase64 = jSONObject.optBoolean("needBase64", false);
                this.mParams.reducePermission = jSONObject.optBoolean("reducePermission", GlobalConfig.getInstance().allowReducePermission());
                maxLength = jSONObject.optInt(Constants.Name.MAX_LENGTH, 1024);
                this.useCN = jSONObject.optBoolean("lang", false);
                if (jSONObject.has("localUrl")) {
                    this.mParams.localUrl = jSONObject.optString("localUrl");
                }
            } catch (Exception unused) {
                TaoLog.e("WVCamera", "takePhoto fail, params: " + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult("HY_PARAM_ERR");
                wVResult.addData("msg", "PHOTO_INIT_ERROR ,params:" + str);
                this.mCallback.error(wVResult);
            }
        }
    }

    private boolean isHasCamaraPermission() {
        try {
            Camera.open().release();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openCamara() {
        if (!this.mParams.reducePermission) {
            openCamaraInternal();
        } else {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.CAMERA"}).setTaskOnPermissionGranted(new Runnable() {
                /* class com.taomai.android.h5container.api.TMCamera.AnonymousClass1 */

                public void run() {
                    TMCamera.this.openCamaraInternal();
                }
            }).setTaskOnPermissionDenied(new WVDeniedRunnable(this.mCallback, com.alibaba.security.realidentity.jsbridge.a.al)).execute();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openCamaraInternal() {
        if (isHasCamaraPermission()) {
            TaoLog.d("WVCamera", "start to open system camera.");
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            WVCamera.UploadParams uploadParams = this.mParams;
            uploadParams.localUrl = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + System.currentTimeMillis();
            String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
            if (cacheDir != null) {
                File file = new File(cacheDir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.mLocalPath = cacheDir + File.separator + DigestUtils.md5ToHex(this.mParams.localUrl);
                Uri fileUri = WVFileUtils.getFileUri(this.mContext, new File(this.mLocalPath));
                if (fileUri == null) {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", "image uri is null,check provider auth");
                    wVResult.setResult("CAMERA_OPEN_ERROR");
                    this.mCallback.error(wVResult);
                    return;
                }
                intent.putExtra("output", fileUri);
                intent.putExtra("from", this.mWebView.hashCode());
                Context context = this.mContext;
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, 4001);
                }
                Intent intent2 = new Intent("WVCameraFilter");
                intent2.putExtra("from-webview-id", this.mWebView.hashCode());
                LocalBroadcastManager.getInstance(GlobalConfig.context).sendBroadcast(intent2);
            } else if (this.mCallback != null) {
                WVResult wVResult2 = new WVResult();
                wVResult2.addData("msg", "NO_CACHEDIR");
                wVResult2.setResult("CAMERA_OPEN_ERROR");
                this.mCallback.error(wVResult2);
            }
        } else if (this.mCallback != null) {
            WVResult wVResult3 = new WVResult();
            wVResult3.addData("msg", com.alibaba.security.realidentity.jsbridge.a.al);
            this.mCallback.error(wVResult3);
        }
    }

    public static void registerMultiActivity(Class<? extends Activity> cls) {
        if (cls != null) {
            multiActivityClass = cls.getName();
        }
    }

    public static void registerMultiActivityName(String str) {
        if (str != null) {
            multiActivityClass = str;
        }
    }

    public static void registerUploadService(Class<? extends WVUploadService> cls) {
        if (cls != null) {
            uploadServiceClass = cls.getName();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void takePhotoSuccess(String str, WVCamera.UploadParams uploadParams) {
        Bitmap d;
        Bitmap d2;
        if (uploadParams.type == 1) {
            String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
            if (str == null || cacheDir == null || !str.startsWith(cacheDir)) {
                WVResult wVResult = new WVResult();
                wVResult.setResult("PIC_PATH_ERROR");
                wVResult.addData("msg", "PIC_PATH_ERROR");
                this.mCallback.error(wVResult);
                return;
            }
            uploadParams.filePath = str;
            upload(uploadParams);
            return;
        }
        WVResult wVResult2 = new WVResult();
        wVResult2.setSuccess();
        if (!"1".equals(uploadParams.mutipleSelection)) {
            wVResult2.addData("url", uploadParams.localUrl);
            wVResult2.addData("localPath", str);
            if (uploadParams.needBase64 && (d = ImageTool.d(str, 1024)) != null) {
                wVResult2.addData("base64Data", WVUtils.bitmapToBase64(d));
            }
            TaoLog.d("WVCamera", "url:" + uploadParams.localUrl + " localPath:" + str);
            this.mCallback.success(wVResult2);
        } else if (uploadParams.isLastPic) {
            JSONArray jSONArray = uploadParams.images;
            if (jSONArray == null) {
                wVResult2.addData("url", uploadParams.localUrl);
                wVResult2.addData("localPath", str);
                if (uploadParams.needBase64 && (d2 = ImageTool.d(str, 1024)) != null) {
                    wVResult2.addData("base64Data", WVUtils.bitmapToBase64(d2));
                }
            } else {
                wVResult2.addData("images", jSONArray);
            }
            this.mCallback.success(wVResult2);
        } else {
            return;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVCamera", "pic not upload and call success, retString: " + wVResult2.toJsonString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|19|45|46|(1:62)(2:50|59)) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f9 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    private void zoomPicAndCallback(String str, final String str2, final WVCamera.UploadParams uploadParams) {
        Throwable th;
        final Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4 = null;
        if (this.mParams.needZoom) {
            Uri a2 = Build.VERSION.SDK_INT >= 29 ? ImageTool.a(this.mContext, str) : null;
            int c = ImageTool.c(this.mContext, str, a2);
            Bitmap e = ImageTool.e(this.mContext, str, maxLength, a2);
            if (e != null) {
                try {
                    bitmap = ImageTool.f(ImageTool.h(e, maxLength), c);
                } catch (Exception unused) {
                    bitmap4 = bitmap2;
                    WVResult wVResult = new WVResult();
                    wVResult.addData("reason", "write photo io error.");
                    wVResult.setResult("WRITE_PHOTO_ERROR");
                    this.mCallback.error(wVResult);
                    TaoLog.e("WVCamera", "write photo io error.");
                    if (bitmap4 == null && !bitmap4.isRecycled()) {
                        bitmap4.recycle();
                        return;
                    }
                } catch (Throwable th2) {
                    bitmap4 = bitmap3;
                    th = th2;
                    if (bitmap4 != null && !bitmap4.isRecycled()) {
                        bitmap4.recycle();
                    }
                    throw th;
                }
            } else if (e != null && !e.isRecycled()) {
                e.recycle();
                return;
            } else {
                return;
            }
        } else {
            if (!str2.equals(str)) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.createNewFile();
                }
                File file2 = new File(str);
                if (!file2.exists()) {
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData("msg", "Failed to read file : " + str);
                    wVResult2.setResult("READ_FILE_ERROR");
                    this.mCallback.error(wVResult2);
                    return;
                } else if (!FileManager.copy(file2, file)) {
                    WVResult wVResult3 = new WVResult();
                    wVResult3.addData("msg", "Failed to copy file!");
                    wVResult3.setResult("COPY_FILE_ERROR");
                    this.mCallback.error(wVResult3);
                    return;
                }
            }
            bitmap = null;
        }
        try {
            final WVFileInfo wVFileInfo = new WVFileInfo();
            wVFileInfo.fileName = DigestUtils.md5ToHex(uploadParams.localUrl);
            wVFileInfo.mimeType = "image/jpeg";
            wVFileInfo.expireTime = System.currentTimeMillis() + WVFileInfoParser.DEFAULT_MAX_AGE;
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVCamera", "write pic to file, name: " + wVFileInfo.fileName);
            }
            AsyncTask.execute(new Runnable() {
                /* class com.taomai.android.h5container.api.TMCamera.AnonymousClass4 */

                /* JADX WARNING: Can't wrap try/catch for region: R(7:17|16|19|20|21|(1:25)|(3:27|28|43)(1:45)) */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
                    r0 = th;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                    r4.close();
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC, Splitter:B:27:0x007d] */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x0092 A[SYNTHETIC, Splitter:B:36:0x0092] */
                /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
                public void run() {
                    WVResult wVResult = new WVResult();
                    if (bitmap != null) {
                        WVCacheManager.getInstance().writeToFile(wVFileInfo, new byte[]{0});
                        FileOutputStream fileOutputStream = null;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(WVCacheManager.getInstance().getCacheDir(true), wVFileInfo.fileName));
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                            Bitmap bitmap = bitmap;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            fileOutputStream = fileOutputStream2;
                            TaoLog.e("WVCamera", "fail to create bitmap file");
                            wVResult.addData("msg", "fail to create bitmap file");
                            wVResult.setResult("CREATE_BITMAP_ERROR");
                            TMCamera.this.mCallback.error(wVResult);
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 != null && !bitmap2.isRecycled()) {
                                bitmap.recycle();
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (Exception unused3) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            fileOutputStream = fileOutputStream2;
                            Bitmap bitmap3 = bitmap;
                            bitmap.recycle();
                            if (fileOutputStream != null) {
                            }
                            throw th2;
                        }
                    }
                    TMCamera.this.takePhotoSuccess(str2, uploadParams);
                    wVResult.setSuccess();
                    wVResult.addData("url", uploadParams.localUrl);
                    wVResult.addData("localPath", str2);
                    TaoLog.d("WVCamera", "url:" + uploadParams.localUrl + " localPath:" + str2);
                    TMCamera.this.mCallback.fireEvent("WVPhoto.Event.takePhotoSuccess", wVResult.toJsonString());
                }
            });
        } catch (Exception unused2) {
            bitmap4 = bitmap;
            WVResult wVResult4 = new WVResult();
            wVResult4.addData("reason", "write photo io error.");
            wVResult4.setResult("WRITE_PHOTO_ERROR");
            this.mCallback.error(wVResult4);
            TaoLog.e("WVCamera", "write photo io error.");
            if (bitmap4 == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap4 = bitmap;
            bitmap4.recycle();
            throw th;
        }
    }

    public synchronized void confirmUploadPhoto(WVCallBackContext wVCallBackContext, String str) {
        this.mCallback = wVCallBackContext;
        WVCamera.UploadParams createUploadParams = createUploadParams(null);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(com.alibaba.security.realidentity.jsbridge.a.V);
            createUploadParams.identifier = jSONObject.optString(WXGestureType.GestureInfo.POINTER_ID);
            createUploadParams.v = jSONObject.optString("v");
            createUploadParams.bizCode = jSONObject.optString("bizCode");
            createUploadParams.extraInfo = jSONObject.optJSONObject("extraInfo");
            String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
            if (string == null || cacheDir == null || !string.startsWith(cacheDir)) {
                wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
            } else {
                createUploadParams.filePath = string;
                upload(createUploadParams);
            }
        } catch (Exception e) {
            TaoLog.e("WVCamera", "confirmUploadPhoto fail, params: " + str);
            WVResult wVResult = new WVResult();
            wVResult.setResult("HY_PARAM_ERR");
            wVResult.addData("msg", "PARAM_ERROR :" + e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("takePhoto".equals(str)) {
            try {
                this.isAlive = true;
                takePhoto(wVCallBackContext, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (!"confirmUploadPhoto".equals(str)) {
            return false;
        } else {
            confirmUploadPhoto(wVCallBackContext, str2);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0191, code lost:
        if (r7 == null) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0193, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b1, code lost:
        if (r7 != null) goto L_0x0193;
     */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        Cursor cursor;
        Throwable th;
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVCamera", "takePhoto callback, requestCode: " + i + ";resultCode: " + i2);
        }
        WVResult wVResult = new WVResult();
        switch (i) {
            case 4001:
                if (i2 == -1) {
                    String str = this.mLocalPath;
                    zoomPicAndCallback(str, str, this.mParams);
                    return;
                }
                TaoLog.w("WVCamera", "call takePhoto fail. resultCode: " + i2);
                wVResult.addData("msg", "CANCELED_BY_USER");
                this.mCallback.error(wVResult);
                return;
            case 4002:
                if (i2 != -1 || intent == null) {
                    TaoLog.w("WVCamera", "call pick photo fail. resultCode: " + i2);
                    wVResult.addData("msg", "CANCELED_BY_USER");
                    this.mCallback.error(wVResult);
                    return;
                }
                Uri data = intent.getData();
                String str2 = null;
                if (data != null) {
                    if ("file".equalsIgnoreCase(data.getScheme())) {
                        str2 = data.getPath();
                    } else {
                        String[] strArr = {"_data"};
                        try {
                            cursor = this.mContext.getContentResolver().query(data, strArr, null, null, null);
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        str2 = cursor.getString(cursor.getColumnIndex(strArr[0]));
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        TaoLog.e("WVCamera", "query fail:" + CommonUtils.getStackTrace(th));
                                        break;
                                    } catch (Throwable th3) {
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th3;
                                    }
                                }
                            }
                            TaoLog.e("WVCamera", "pick photo fail, Cursor is empty, imageUri: " + data.toString());
                            break;
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = null;
                            TaoLog.e("WVCamera", "query fail:" + CommonUtils.getStackTrace(th));
                        }
                    }
                }
                if (FileAccesser.exists(str2)) {
                    WVCamera.UploadParams createUploadParams = createUploadParams(this.mParams);
                    createUploadParams.localUrl = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + System.currentTimeMillis();
                    zoomPicAndCallback(str2, WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(createUploadParams.localUrl), createUploadParams);
                    return;
                }
                TaoLog.w("WVCamera", "pick photo fail, picture not exist, picturePath: " + str2);
                return;
            case 4003:
                if (intent == null || intent.getExtras() == null || intent.getExtras().get("fileList") == null) {
                    wVResult.addData("msg", "CANCELED_BY_USER");
                    this.mCallback.error(wVResult);
                    return;
                }
                ArrayList arrayList = (ArrayList) intent.getExtras().get("fileList");
                int size = arrayList.size();
                if (size == 0) {
                    wVResult.addData("msg", "CANCELED_BY_USER");
                    this.mCallback.error(wVResult);
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < size; i3++) {
                    String str3 = (String) arrayList.get(i3);
                    if (FileAccesser.exists(str3)) {
                        WVCamera.UploadParams createUploadParams2 = createUploadParams(this.mParams);
                        createUploadParams2.localUrl = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + System.currentTimeMillis();
                        String str4 = WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(createUploadParams2.localUrl);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", createUploadParams2.localUrl);
                            jSONObject.put("localPath", str4);
                            jSONArray.put(jSONObject);
                            TaoLog.d("WVCamera", "url:" + createUploadParams2.localUrl + " localPath:" + str4);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (i3 == size - 1) {
                            createUploadParams2.images = jSONArray;
                        } else {
                            createUploadParams2.isLastPic = false;
                        }
                        zoomPicAndCallback(str3, str4, createUploadParams2);
                        try {
                            Thread.sleep(100);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        TaoLog.w("WVCamera", "pick photo fail, picture not exist, picturePath: " + str3);
                    }
                }
                return;
            default:
                return;
        }
    }

    public synchronized void takePhoto(WVCallBackContext wVCallBackContext, String str) {
        View peekDecorView;
        initTakePhoto(wVCallBackContext, str);
        Context context = this.mContext;
        if ((context instanceof Activity) && (peekDecorView = ((Activity) context).getWindow().peekDecorView()) != null) {
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
        if ("camera".equals(this.mParams.mode)) {
            openCamara();
        } else if ("photo".equals(this.mParams.mode)) {
            chosePhoto();
        } else {
            try {
                if (!EnvUtil.isCN() && !this.useCN) {
                    String[] strArr = this.mPopupMenuTags;
                    strArr[0] = "Take pictures";
                    strArr[1] = "Select from album";
                }
                if (this.mPopupController == null) {
                    this.mPopupController = new PopupWindowController(this.mContext, this.mWebView.getView(), this.mPopupMenuTags, this.popupClickListener);
                }
                this.mPopupController.show();
            } catch (Exception e) {
                TaoLog.w("WVCamera", e.getMessage());
            }
        }
    }

    public void takePhotoPlus(WVCallBackContext wVCallBackContext, String str, String str2) {
        if (wVCallBackContext == null || str == null || str2 == null) {
            TaoLog.e("WVCamera", "takePhotoPlus fail, params error");
            return;
        }
        initTakePhoto(wVCallBackContext, str2);
        this.mLocalPath = str;
        zoomPicAndCallback(str, str, this.mParams);
    }

    /* access modifiers changed from: protected */
    public void upload(WVCamera.UploadParams uploadParams) {
        String str;
        if (this.uploadService == null && (str = uploadServiceClass) != null) {
            try {
                Class<?> cls = Class.forName(str);
                if (WVUploadService.class.isAssignableFrom(cls)) {
                    WVUploadService wVUploadService = (WVUploadService) cls.newInstance();
                    this.uploadService = wVUploadService;
                    wVUploadService.initialize(this.mContext, this.mWebView);
                }
            } catch (Exception e) {
                TaoLog.e("WVCamera", "create upload service error: " + uploadServiceClass + ". " + e.getMessage());
            }
        }
        WVUploadService wVUploadService2 = this.uploadService;
        if (wVUploadService2 != null) {
            wVUploadService2.doUpload(uploadParams, this.mCallback);
        }
    }
}
