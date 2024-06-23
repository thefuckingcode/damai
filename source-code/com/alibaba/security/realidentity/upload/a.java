package com.alibaba.security.realidentity.upload;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.upload.b.b;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import java.util.HashMap;
import java.util.Map;
import tb.ej2;

/* compiled from: Taobao */
public class a extends com.alibaba.security.realidentity.upload.a.a {
    private static final String c = "a";
    private static final String d = "x-arup-biz-ret";
    private static final String e = "ossBucketName";
    private static final String f = "ossObjectKey";
    private final IUploaderManager g = com.uploader.export.a.a();

    public a(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.upload.b.a
    public final Object a(final UploadFileModel uploadFileModel, final b bVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("arup-directory", uploadFileModel.getDestDir());
        hashMap.put("arup-file-name", uploadFileModel.getRemoteFileName());
        final AnonymousClass1 r1 = new IUploaderTask() {
            /* class com.alibaba.security.realidentity.upload.a.AnonymousClass1 */

            @Override // com.uploader.export.IUploaderTask
            public final String getBizType() {
                return "rp_asset";
            }

            @Override // com.uploader.export.IUploaderTask
            public final String getFilePath() {
                return uploadFileModel.getLocalFilePath();
            }

            @Override // com.uploader.export.IUploaderTask
            public final String getFileType() {
                return uploadFileModel.getFileType();
            }

            @Override // com.uploader.export.IUploaderTask
            public final Map<String, String> getMetaInfo() {
                return hashMap;
            }
        };
        final long a = e.a(uploadFileModel.getLocalFilePath());
        final long currentTimeMillis = System.currentTimeMillis();
        a(r1.getFilePath(), r1.getFileType(), a);
        this.g.uploadAsync(r1, new ITaskListener() {
            /* class com.alibaba.security.realidentity.upload.a.AnonymousClass2 */

            @Override // com.uploader.export.ITaskListener
            public final void onCancel(IUploaderTask iUploaderTask) {
                bVar.a();
            }

            @Override // com.uploader.export.ITaskListener
            public final void onFailure(IUploaderTask iUploaderTask, ej2 ej2) {
                String str = "other error";
                bVar.b(ej2 != null ? ej2.toString() : str);
                a.this.a("oss upload failed", ej2 != null ? ej2.toString() : str, r1.getFilePath());
                a aVar = a.this;
                String filePath = r1.getFilePath();
                String fileType = r1.getFileType();
                String str2 = ej2 != null ? ej2.a : "-1";
                if (ej2 != null) {
                    str = ej2.toString();
                }
                aVar.a(filePath, fileType, null, str2, str, System.currentTimeMillis() - currentTimeMillis, a);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onPause(IUploaderTask iUploaderTask) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onProgress(IUploaderTask iUploaderTask, int i) {
                long j = a;
                bVar.a(((long) (((float) i) / 100.0f)) * j, j);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onResume(IUploaderTask iUploaderTask) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onStart(IUploaderTask iUploaderTask) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult) {
                Map<String, String> result = iTaskResult.getResult();
                String str = null;
                if (result != null && result.containsKey(a.d)) {
                    JSONObject parseObject = JSON.parseObject(result.get(a.d));
                    String string = (parseObject == null || !parseObject.containsKey("ossBucketName")) ? null : parseObject.getString("ossBucketName");
                    String string2 = (parseObject == null || !parseObject.containsKey(a.f)) ? null : parseObject.getString(a.f);
                    if (!(string == null || string2 == null)) {
                        str = "oss://" + string + ":" + string2;
                    }
                }
                if (str == null) {
                    a.this.a(r1.getFilePath(), r1.getFileType(), str, "-1", "remote url is null", System.currentTimeMillis() - currentTimeMillis, a);
                    a.this.a("oss upload failed", "remote url is null", r1.getFilePath());
                    bVar.b("remote url is null");
                    return;
                }
                a.this.a(r1.getFilePath(), r1.getFileType(), str, "0", null, System.currentTimeMillis() - currentTimeMillis, a);
                bVar.a(str);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onWait(IUploaderTask iUploaderTask) {
            }
        }, null);
        return r1;
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3) {
        a(TrackLog.createSdkExceptionLog(str, str2, str3));
    }

    @Override // com.alibaba.security.realidentity.upload.b.a
    public final void a(Object obj) {
        if (obj instanceof IUploaderTask) {
            this.g.cancelAsync((IUploaderTask) obj);
        }
    }
}
