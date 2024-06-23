package com.taobao.android.tlog.uploader;

import android.content.Context;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.LogUploader;
import com.taobao.tao.log.upload.UploaderInfo;
import com.taobao.tao.log.upload.UploaderParam;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import com.uploader.export.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import tb.ej2;
import tb.ws2;
import tb.zs2;

/* compiled from: Taobao */
public class TLogUploader implements LogUploader {
    private static final String TAG = "TLogUploader.arup";
    private static final String UT_TLOG_ARUP_CANCEL = "ut_tlog_arup_cancel";
    private static final String UT_TLOG_ARUP_ERR = "ut_tlog_arup_err";
    private static final String UT_TLOG_ARUP_REQUEST = "ut_tlog_arup_request";
    private static final String UT_TLOG_ARUP_START = "ut_tlog_arup_start";
    private static final String UT_TLOG_ARUP_SUCCESS = "ut_tlog_arup_success";
    private IUploaderTask mTask;
    private IUploaderManager mUploadManager;
    private Map<String, Object> metaInfo;

    /* compiled from: Taobao */
    class TaskListenerImp implements ITaskListener {
        FileUploadListener listener;

        TaskListenerImp(FileUploadListener fileUploadListener) {
            this.listener = fileUploadListener;
        }

        @Override // com.uploader.export.ITaskListener
        public void onCancel(IUploaderTask iUploaderTask) {
            HashMap hashMap = new HashMap();
            hashMap.put("fileName", iUploaderTask.getFilePath());
            if (iUploaderTask instanceof UploadTask) {
                UploadTask uploadTask = (UploadTask) iUploaderTask;
                hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, uploadTask.getSessionID());
                hashMap.put(TLogEventConst.PARAM_TASK_ID, uploadTask.getSessionID());
                hashMap.put(TLogEventConst.PARAM_FILE_SIZE, uploadTask.getFileSize());
            }
            TLogEventHelper.event("ut_tlog_arup_cancel", hashMap);
            FileUploadListener fileUploadListener = this.listener;
            if (fileUploadListener != null) {
                fileUploadListener.onError("cancel", "1", "the upload task is canceled!");
            }
        }

        @Override // com.uploader.export.ITaskListener
        public void onFailure(IUploaderTask iUploaderTask, ej2 ej2) {
            File file = new File(iUploaderTask.getFilePath());
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", String.format("%s,%s", ej2.a, ej2.b));
            hashMap.put("errMsg", ej2.c);
            hashMap.put("fileName", file.getAbsolutePath());
            if (file.exists()) {
                hashMap.put(TLogEventConst.PARAM_FILE_SIZE, String.valueOf(file.length()));
            } else {
                hashMap.put(TLogEventConst.PARAM_FILE_SIZE, "-1");
            }
            if (iUploaderTask instanceof UploadTask) {
                UploadTask uploadTask = (UploadTask) iUploaderTask;
                hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, uploadTask.getSessionID());
                hashMap.put(TLogEventConst.PARAM_TASK_ID, uploadTask.getSessionID());
            }
            TLogEventHelper.event("ut_tlog_arup_err", hashMap);
            FileUploadListener fileUploadListener = this.listener;
            if (fileUploadListener != null) {
                fileUploadListener.onError(ej2.a, ej2.b, ej2.c);
            }
        }

        @Override // com.uploader.export.ITaskListener
        public void onPause(IUploaderTask iUploaderTask) {
            Log.d(TLogUploader.TAG, "upload onPause");
        }

        @Override // com.uploader.export.ITaskListener
        public void onProgress(IUploaderTask iUploaderTask, int i) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onResume(IUploaderTask iUploaderTask) {
            Log.d(TLogUploader.TAG, "upload onResume");
        }

        @Override // com.uploader.export.ITaskListener
        public void onStart(IUploaderTask iUploaderTask) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult) {
            HashMap hashMap = new HashMap();
            hashMap.put("fileName", new File(iUploaderTask.getFilePath()).getName());
            if (iUploaderTask instanceof UploadTask) {
                UploadTask uploadTask = (UploadTask) iUploaderTask;
                hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, uploadTask.getSessionID());
                hashMap.put(TLogEventConst.PARAM_TASK_ID, uploadTask.getSessionID());
                hashMap.put(TLogEventConst.PARAM_FILE_SIZE, uploadTask.getFileSize());
            }
            TLogEventHelper.event("ut_tlog_arup_success", hashMap);
            FileUploadListener fileUploadListener = this.listener;
            if (fileUploadListener != null) {
                fileUploadListener.onSucessed(iUploaderTask.getFilePath(), iTaskResult.getFileUrl());
            }
        }

        @Override // com.uploader.export.ITaskListener
        public void onWait(IUploaderTask iUploaderTask) {
            Log.d(TLogUploader.TAG, "upload onWait");
        }
    }

    /* compiled from: Taobao */
    class UploadTask implements IUploaderTask {
        public String bizType;
        public String filePath;
        public String fileSize = "";
        public String fileType;
        public Map<String, String> metaInfo;
        public String sessionID = "";

        UploadTask() {
        }

        @Override // com.uploader.export.IUploaderTask
        public String getBizType() {
            return this.bizType;
        }

        @Override // com.uploader.export.IUploaderTask
        public String getFilePath() {
            return this.filePath;
        }

        public String getFileSize() {
            return this.fileSize;
        }

        @Override // com.uploader.export.IUploaderTask
        public String getFileType() {
            return this.fileType;
        }

        @Override // com.uploader.export.IUploaderTask
        public Map<String, String> getMetaInfo() {
            return this.metaInfo;
        }

        public String getSessionID() {
            return this.sessionID;
        }
    }

    @Override // com.taobao.tao.log.upload.LogUploader
    public void cancel() {
        IUploaderManager iUploaderManager;
        IUploaderTask iUploaderTask = this.mTask;
        if (iUploaderTask != null && (iUploaderManager = this.mUploadManager) != null) {
            iUploaderManager.cancelAsync(iUploaderTask);
        }
    }

    @Override // com.taobao.tao.log.upload.LogUploader
    public UploaderInfo getUploadInfo() {
        UploaderInfo uploaderInfo = new UploaderInfo();
        uploaderInfo.type = TLogConstant.TOKEN_TYPE_ARUP;
        return uploaderInfo;
    }

    @Override // com.taobao.tao.log.upload.LogUploader
    public void setMetaInfo(Map<String, Object> map) {
        this.metaInfo = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.tao.log.upload.LogUploader
    public void startUpload(UploaderParam uploaderParam, String str, FileUploadListener fileUploadListener) {
        String str2;
        String str3;
        Exception e;
        File file = new File(str);
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", file.getName());
        hashMap.put(TLogEventConst.PARAM_FILE_SIZE, String.valueOf(file.length()));
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, uploaderParam.sessionId);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, uploaderParam.sessionId);
        TLogEventHelper.event("ut_tlog_arup_request", hashMap);
        Map<String, String> map = uploaderParam.params;
        if (map == null) {
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "服务端下发的参数为空(upload param)");
            ErrorCode errorCode = ErrorCode.DATA_EMPTY;
            TLogEventHelper.errorEvent("ut_tlog_arup_err", errorCode.getValue(), "UploaderParam is null", hashMap);
            if (fileUploadListener != null) {
                fileUploadListener.onError(errorCode.getValue(), "", "UploaderParam is null");
                return;
            }
            return;
        }
        Context context = uploaderParam.context;
        final String str4 = uploaderParam.appVersion;
        final String str5 = uploaderParam.appKey;
        String str6 = map.get("arupBizType");
        String str7 = uploaderParam.params.get("ossObjectKey");
        if (str6 == null || str7 == null) {
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "服务端下发的arupBizType或者ossObjectKey有一个为空，终止上传");
            ErrorCode errorCode2 = ErrorCode.DATA_EMPTY;
            TLogEventHelper.errorEvent("ut_tlog_arup_err", errorCode2.getValue(), "BizType os ObjectKey is null", hashMap);
            if (fileUploadListener != null) {
                fileUploadListener.onError(errorCode2.getValue(), "", "BizType os ObjectKey is null");
                return;
            }
            return;
        }
        IUploaderManager a = a.a();
        this.mUploadManager = a;
        if (!a.isInitialized()) {
            this.mUploadManager.initialize(context, new ws2(context, new zs2(context) {
                /* class com.taobao.android.tlog.uploader.TLogUploader.AnonymousClass1 */

                @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
                public String getAppKey() {
                    return str5;
                }

                @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
                public String getAppVersion() {
                    return str4;
                }

                @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
                public int getEnvironment() {
                    return 0;
                }
            }));
        }
        UploadTask uploadTask = new UploadTask();
        uploadTask.sessionID = uploaderParam.sessionId;
        uploadTask.bizType = str6;
        uploadTask.fileType = ".log";
        if (uploadTask.metaInfo == null) {
            uploadTask.metaInfo = new HashMap();
        }
        if (this.metaInfo != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("action", JSON.toJSON(this.metaInfo).toString());
            uploadTask.metaInfo.putAll(hashMap2);
        }
        uploadTask.metaInfo.put("arupBizType", str6);
        uploadTask.metaInfo.put("ossObjectKey", str7);
        File file2 = new File(uploaderParam.logFilePathTmp);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            File copyFile = TLogFileUtils.copyFile(file, new File(file2, file.getName()));
            if (copyFile == null || !copyFile.exists()) {
                Log.e(TAG, "File copy error!!");
                uploadTask.filePath = str;
                uploadTask.fileSize = String.valueOf(file.length());
            } else {
                Log.d(TAG, String.format("Copy to %s, length=%d", copyFile.getAbsolutePath(), Long.valueOf(copyFile.length())));
                uploadTask.filePath = copyFile.getAbsolutePath();
                uploadTask.fileSize = String.valueOf(copyFile.length());
            }
            this.mTask = uploadTask;
            hashMap.put(TLogEventConst.PARAM_FILE_SIZE, uploadTask.fileSize);
            TLogEventHelper.event("ut_tlog_arup_start", hashMap);
            TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
            String str8 = TLogStage.MSG_LOG_UPLOAD;
            tLogMonitor.stageInfo(str8, TAG, "开始调用arup接口异步上传文件，文件路径为：" + uploadTask.filePath);
            if (!this.mUploadManager.uploadAsync(this.mTask, new TaskListenerImp(fileUploadListener), null)) {
                ErrorCode errorCode3 = ErrorCode.NET_ERROR;
                str2 = "ut_tlog_arup_err";
                try {
                    TLogEventHelper.errorEvent(str2, errorCode3.getValue(), "have not init", hashMap);
                    if (fileUploadListener != null) {
                        str3 = "";
                        try {
                            fileUploadListener.onError(errorCode3.getValue(), str3, "call uploadAsync error");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    str3 = "";
                    Log.e(TAG, "Exception: " + e.toString());
                    e.printStackTrace();
                    TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, e);
                    ErrorCode errorCode4 = ErrorCode.CODE_EXC;
                    TLogEventHelper.errorEvent(str2, errorCode4.getValue(), e.getMessage(), hashMap);
                    if (fileUploadListener == null) {
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            str3 = "";
            str2 = "ut_tlog_arup_err";
            Log.e(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, e);
            ErrorCode errorCode42 = ErrorCode.CODE_EXC;
            TLogEventHelper.errorEvent(str2, errorCode42.getValue(), e.getMessage(), hashMap);
            if (fileUploadListener == null) {
                fileUploadListener.onError(errorCode42.getValue(), str3, e.getMessage());
            }
        }
    }
}
