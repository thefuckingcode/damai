package android.taobao.windvane.extra.jsbridge;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.upload.UploadFileConnection;
import android.taobao.windvane.extra.upload.UploadFileData;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.jsbridge.api.WVUploadService;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import com.amap.api.maps.model.MyLocationStyle;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.export.a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.ej2;

/* compiled from: Taobao */
public class TBUploadService extends WVUploadService implements Handler.Callback {
    private static final String LAST_PIC = "\"isLastPic\":\"true\"";
    private static final String MUTI_SELECTION = "\"mutipleSelection\":\"1\"";
    private static final int NOTIFY_ERROR = 2003;
    private static final int NOTIFY_FINISH = 2002;
    private static final int NOTIFY_START = 2001;
    private static final String TAG = "TBUploadService";
    private WVCallBackContext mCallback;
    private Handler mHandler;

    public TBUploadService() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doMtopUpload(final WVCamera.UploadParams uploadParams) {
        try {
            final File createTempFile = File.createTempFile("windvane", "." + MimeTypeEnum.JPG.getSuffix(), WVCacheManager.getInstance().getTempDir(true));
            if (!FileManager.copy(new File(uploadParams.filePath), createTempFile)) {
                WVResult wVResult = new WVResult();
                wVResult.addData(MyLocationStyle.ERROR_INFO, "Failed to copy file!");
                this.mCallback.error(wVResult);
                return;
            }
            final WVResult wVResult2 = new WVResult();
            try {
                a.a().uploadAsync(new IUploaderTask() {
                    /* class android.taobao.windvane.extra.jsbridge.TBUploadService.AnonymousClass3 */

                    @Override // com.uploader.export.IUploaderTask
                    public String getBizType() {
                        return uploadParams.bizCode;
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public String getFilePath() {
                        return createTempFile.getAbsolutePath();
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public String getFileType() {
                        return ".jpg";
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public Map<String, String> getMetaInfo() {
                        if (uploadParams.extraInfo == null) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = uploadParams.extraInfo.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, uploadParams.extraInfo.optString(next));
                        }
                        return hashMap;
                    }
                }, new ITaskListener() {
                    /* class android.taobao.windvane.extra.jsbridge.TBUploadService.AnonymousClass4 */

                    @Override // com.uploader.export.ITaskListener
                    public void onCancel(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onFailure(IUploaderTask iUploaderTask, ej2 ej2) {
                        wVResult2.addData("subCode", ej2.b);
                        wVResult2.addData("errorCode", ej2.a);
                        wVResult2.addData("errorMsg", ej2.c);
                        wVResult2.addData("localPath", uploadParams.filePath);
                        Message.obtain(TBUploadService.this.mHandler, 2003, wVResult2).sendToTarget();
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onPause(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onProgress(IUploaderTask iUploaderTask, int i) {
                        String valueOf = String.valueOf(i);
                        TaoLog.e(TBUploadService.TAG, "uploadFile onProgress " + valueOf);
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onResume(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onStart(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult) {
                        Bitmap readZoomImage;
                        wVResult2.setSuccess();
                        wVResult2.addData("url", uploadParams.localUrl);
                        wVResult2.addData("localPath", uploadParams.filePath);
                        String fileUrl = iTaskResult.getFileUrl();
                        wVResult2.addData("resourceURL", fileUrl);
                        wVResult2.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                        wVResult2.addData("mutipleSelection", uploadParams.mutipleSelection);
                        WVCamera.UploadParams uploadParams = uploadParams;
                        if (uploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(uploadParams.filePath, 1024)) != null) {
                            wVResult2.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
                        }
                        int lastIndexOf = fileUrl.lastIndexOf("/") + 1;
                        if (lastIndexOf != 0) {
                            wVResult2.addData("tfsKey", fileUrl.substring(lastIndexOf));
                        }
                        WVCamera.UploadParams uploadParams2 = uploadParams;
                        if (uploadParams2.isLastPic) {
                            wVResult2.addData("images", uploadParams2.images);
                        }
                        Message.obtain(TBUploadService.this.mHandler, 2002, wVResult2).sendToTarget();
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onWait(IUploaderTask iUploaderTask) {
                    }
                }, this.mHandler);
                TaoLog.i(TAG, "do aus upload " + uploadParams.filePath);
            } catch (Throwable th) {
                TaoLog.e(TAG, "mtop sdk not exist." + th.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doNormalUpload(final WVCamera.UploadParams uploadParams) {
        WVThreadPool.getInstance().execute(new UploadFileConnection(uploadParams.filePath, MimeTypeEnum.JPG.getSuffix(), new HttpConnectListener<UploadFileData>() {
            /* class android.taobao.windvane.extra.jsbridge.TBUploadService.AnonymousClass2 */

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(TBUploadService.TAG, "upload file error. code: " + i + ";msg: " + str);
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("errorCode", Integer.valueOf(i));
                wVResult.addData("errorMsg", str);
                wVResult.addData("localPath", uploadParams.filePath);
                wVResult.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                wVResult.addData("mutipleSelection", uploadParams.mutipleSelection);
                Message obtain = Message.obtain();
                obtain.what = 2003;
                obtain.obj = wVResult;
                TBUploadService.this.mHandler.sendMessage(obtain);
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onStart() {
                TBUploadService.this.mHandler.sendEmptyMessage(2001);
            }

            public void onFinish(UploadFileData uploadFileData, int i) {
                Bitmap readZoomImage;
                if (uploadFileData != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 2002;
                    WVResult wVResult = new WVResult();
                    wVResult.setSuccess();
                    WVCamera.UploadParams uploadParams = uploadParams;
                    if (uploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(uploadParams.filePath, 1024)) != null) {
                        wVResult.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
                    }
                    wVResult.addData("url", uploadParams.localUrl);
                    wVResult.addData("localPath", uploadParams.filePath);
                    wVResult.addData("resourceURL", uploadFileData.resourceUri);
                    wVResult.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                    wVResult.addData("mutipleSelection", uploadParams.mutipleSelection);
                    wVResult.addData("tfsKey", uploadFileData.tfsKey);
                    WVCamera.UploadParams uploadParams2 = uploadParams;
                    if (uploadParams2.isLastPic) {
                        wVResult.addData("images", uploadParams2.images);
                    }
                    obtain.obj = wVResult;
                    TBUploadService.this.mHandler.sendMessage(obtain);
                }
            }
        }));
    }

    @Override // android.taobao.windvane.jsbridge.api.WVUploadService
    public void doUpload(final WVCamera.UploadParams uploadParams, WVCallBackContext wVCallBackContext) {
        if (uploadParams == null) {
            TaoLog.d(TAG, "UploadParams is null.");
            wVCallBackContext.error(new WVResult());
            return;
        }
        this.mCallback = wVCallBackContext;
        try {
            String url = wVCallBackContext.getWebview().getUrl();
            AppMonitorUtil.commitOffMonitor(url, "TBUploadService bizCode:" + uploadParams.bizCode, uploadParams.v);
        } catch (Throwable unused) {
        }
        if ("2.0".equals(uploadParams.v)) {
            WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
            if (wVIAdapter != null) {
                wVIAdapter.getLoginInfo(null);
            }
            WVThreadPool.getInstance().execute(new Runnable() {
                /* class android.taobao.windvane.extra.jsbridge.TBUploadService.AnonymousClass1 */

                public void run() {
                    TBUploadService.this.doMtopUpload(uploadParams);
                }
            });
            return;
        }
        doNormalUpload(uploadParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d9 A[Catch:{ JSONException -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f1  */
    public boolean handleMessage(Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONException e;
        switch (message.what) {
            case 2001:
                TaoLog.d(TAG, "start upload file ...");
                this.mCallback.fireEvent("WVPhoto.Event.prepareUploadPhotoSuccess", "{}");
                return true;
            case 2002:
                if (message.obj == null) {
                    return true;
                }
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(TAG, "upload file success, retString: " + ((WVResult) message.obj).toJsonString());
                }
                String jsonString = ((WVResult) message.obj).toJsonString();
                String str5 = null;
                try {
                    JSONObject jSONObject2 = new JSONObject(jsonString);
                    jSONArray = jSONObject2.optJSONArray("images");
                    try {
                        str4 = jSONObject2.optString("url");
                        try {
                            str3 = jSONObject2.optString("resourceURL");
                        } catch (JSONException e2) {
                            e = e2;
                            str3 = null;
                            str2 = str3;
                            str = str2;
                            e.printStackTrace();
                            jSONObject = new JSONObject();
                            jSONObject.put("url", str4);
                            jSONObject.put("resourceURL", str3);
                            jSONObject.put("localPath", str2);
                            jSONObject.put("tfsKey", str);
                            if (str5 != null) {
                            }
                            if (!jsonString.contains(MUTI_SELECTION)) {
                            }
                            FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                            return true;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str4 = null;
                        str3 = str4;
                        str2 = str3;
                        str = str2;
                        e.printStackTrace();
                        jSONObject = new JSONObject();
                        jSONObject.put("url", str4);
                        jSONObject.put("resourceURL", str3);
                        jSONObject.put("localPath", str2);
                        jSONObject.put("tfsKey", str);
                        if (str5 != null) {
                        }
                        if (!jsonString.contains(MUTI_SELECTION)) {
                        }
                        FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                        return true;
                    }
                    try {
                        str2 = jSONObject2.optString("localPath");
                        try {
                            str = jSONObject2.optString("tfsKey");
                            try {
                                if (jSONObject2.has("base64Data")) {
                                    str5 = jSONObject2.optString("base64Data");
                                }
                            } catch (JSONException e4) {
                                e = e4;
                                e.printStackTrace();
                                jSONObject = new JSONObject();
                                jSONObject.put("url", str4);
                                jSONObject.put("resourceURL", str3);
                                jSONObject.put("localPath", str2);
                                jSONObject.put("tfsKey", str);
                                if (str5 != null) {
                                }
                                if (!jsonString.contains(MUTI_SELECTION)) {
                                }
                                FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                                return true;
                            }
                        } catch (JSONException e5) {
                            e = e5;
                            str = null;
                            e.printStackTrace();
                            jSONObject = new JSONObject();
                            jSONObject.put("url", str4);
                            jSONObject.put("resourceURL", str3);
                            jSONObject.put("localPath", str2);
                            jSONObject.put("tfsKey", str);
                            if (str5 != null) {
                            }
                            if (!jsonString.contains(MUTI_SELECTION)) {
                            }
                            FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                            return true;
                        }
                    } catch (JSONException e6) {
                        e = e6;
                        str2 = null;
                        str = str2;
                        e.printStackTrace();
                        jSONObject = new JSONObject();
                        jSONObject.put("url", str4);
                        jSONObject.put("resourceURL", str3);
                        jSONObject.put("localPath", str2);
                        jSONObject.put("tfsKey", str);
                        if (str5 != null) {
                        }
                        if (!jsonString.contains(MUTI_SELECTION)) {
                        }
                        FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                        return true;
                    }
                } catch (JSONException e7) {
                    e = e7;
                    jSONArray = null;
                    str4 = null;
                    str3 = str4;
                    str2 = str3;
                    str = str2;
                    e.printStackTrace();
                    jSONObject = new JSONObject();
                    jSONObject.put("url", str4);
                    jSONObject.put("resourceURL", str3);
                    jSONObject.put("localPath", str2);
                    jSONObject.put("tfsKey", str);
                    if (str5 != null) {
                    }
                    if (!jsonString.contains(MUTI_SELECTION)) {
                    }
                    FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                    return true;
                }
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str4);
                    jSONObject.put("resourceURL", str3);
                    jSONObject.put("localPath", str2);
                    jSONObject.put("tfsKey", str);
                    if (str5 != null) {
                        jSONObject.put("base64Data", str5);
                    }
                } catch (JSONException e8) {
                    e8.printStackTrace();
                }
                if (!jsonString.contains(MUTI_SELECTION)) {
                    this.mCallback.success(jSONObject.toString());
                } else {
                    if (jsonString.contains(LAST_PIC)) {
                        if (jSONArray == null) {
                            this.mCallback.success(jSONObject.toString());
                        } else {
                            WVResult wVResult = new WVResult();
                            wVResult.addData("images", jSONArray);
                            this.mCallback.success(wVResult);
                        }
                    }
                    this.mCallback.fireEvent("WVPhoto.Event.uploadPhotoSuccess", jSONObject.toString());
                }
                FileAccesser.deleteFile(WVCacheManager.getInstance().getTempDir(true));
                return true;
            case 2003:
                Object obj = message.obj;
                if (obj != null) {
                    WVResult wVResult2 = (WVResult) obj;
                    String jsonString2 = wVResult2.toJsonString();
                    if (jsonString2.contains(MUTI_SELECTION)) {
                        this.mCallback.fireEvent("WVPhoto.Event.uploadPhotoFailed", jsonString2);
                        if (jsonString2.contains(LAST_PIC)) {
                            this.mCallback.error(wVResult2);
                        }
                    } else {
                        this.mCallback.error(wVResult2);
                    }
                } else {
                    this.mCallback.error();
                }
                return true;
            default:
                return false;
        }
    }
}
