package com.taobao.login4android.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.utils.FileUtil;
import com.taobao.login4android.constants.LoginEnvType;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.ej2;
import tb.ws2;
import tb.zs2;

/* compiled from: Taobao */
public class UploadTask {
    public static final String TAG = "login.UploadTask";
    static Handler handler;
    private static UploadTask mUploadTask;
    private ResultCallback resultCallback;
    private IUploaderManager uploaderManager;

    /* compiled from: Taobao */
    public interface ResultCallback {
        void onFail(String str);

        void onSuccess(String str);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IUploaderTask {
        final /* synthetic */ String a;

        a(UploadTask uploadTask, String str) {
            this.a = str;
        }

        @Override // com.uploader.export.IUploaderTask
        public String getBizType() {
            return "voice-oss";
        }

        @Override // com.uploader.export.IUploaderTask
        public String getFilePath() {
            return this.a;
        }

        @Override // com.uploader.export.IUploaderTask
        public String getFileType() {
            return FileUtil.getExtensionName(this.a);
        }

        @Override // com.uploader.export.IUploaderTask
        public Map<String, String> getMetaInfo() {
            return new HashMap();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ITaskListener {
        b() {
        }

        @Override // com.uploader.export.ITaskListener
        public void onCancel(IUploaderTask iUploaderTask) {
            TLogAdapter.d(UploadTask.TAG, "onCancel");
            if (UploadTask.this.resultCallback != null) {
                UploadTask.this.resultCallback.onFail("onCancel");
            }
        }

        @Override // com.uploader.export.ITaskListener
        public void onFailure(IUploaderTask iUploaderTask, ej2 ej2) {
            TLogAdapter.d(UploadTask.TAG, "onFailure ");
            if (UploadTask.this.resultCallback != null) {
                ResultCallback resultCallback = UploadTask.this.resultCallback;
                resultCallback.onFail("onFailure " + ej2.c);
            }
        }

        @Override // com.uploader.export.ITaskListener
        public void onPause(IUploaderTask iUploaderTask) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onProgress(IUploaderTask iUploaderTask, int i) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onResume(IUploaderTask iUploaderTask) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onStart(IUploaderTask iUploaderTask) {
        }

        @Override // com.uploader.export.ITaskListener
        public void onSuccess(IUploaderTask iUploaderTask, @Nullable ITaskResult iTaskResult) {
            if (iTaskResult != null) {
                try {
                    String optString = new JSONObject(iTaskResult.getBizResult()).optString("ossObjectKey");
                    if (!TextUtils.isEmpty(optString)) {
                        UploadTask.this.resultCallback.onSuccess(optString);
                        try {
                            FileUtil.deleteFile(new File(iUploaderTask.getFilePath()));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            UploadTask.this.resultCallback.onFail("File Url is null");
        }

        @Override // com.uploader.export.ITaskListener
        public void onWait(IUploaderTask iUploaderTask) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends zs2 {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UploadTask uploadTask, Context context, Context context2) {
            super(context);
            this.a = context2;
        }

        @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
        public String getAppKey() {
            return DataProviderFactory.getDataProvider().getAppkey();
        }

        @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
        public String getAppVersion() {
            try {
                return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "1.0.0";
            }
        }

        @Override // tb.zs2, com.uploader.export.IUploaderEnvironment
        public int getEnvironment() {
            int envType = DataProviderFactory.getDataProvider().getEnvType();
            if (envType == LoginEnvType.PRE.getSdkEnvType()) {
                return 1;
            }
            return envType == LoginEnvType.DEV.getSdkEnvType() ? 2 : 0;
        }
    }

    private UploadTask() {
    }

    public static synchronized UploadTask getInstance() {
        UploadTask uploadTask;
        synchronized (UploadTask.class) {
            if (mUploadTask == null) {
                synchronized (UploadTask.class) {
                    if (mUploadTask == null) {
                        mUploadTask = new UploadTask();
                    }
                }
            }
            uploadTask = mUploadTask;
        }
        return uploadTask;
    }

    private void init(Context context) {
        handler = new Handler(Looper.getMainLooper());
        IUploaderManager a2 = com.uploader.export.a.a();
        this.uploaderManager = a2;
        if (!a2.isInitialized()) {
            c cVar = new c(this, context, context);
            cVar.setEnvironment(0);
            this.uploaderManager.initialize(context, new ws2(context, cVar));
        }
    }

    public void setResultCallback(ResultCallback resultCallback2) {
        this.resultCallback = resultCallback2;
    }

    public boolean uploadAsync(Context context, String str, String str2) {
        if (this.uploaderManager == null) {
            init(context);
        }
        return this.uploaderManager.uploadAsync(new a(this, str), new b(), handler);
    }
}
